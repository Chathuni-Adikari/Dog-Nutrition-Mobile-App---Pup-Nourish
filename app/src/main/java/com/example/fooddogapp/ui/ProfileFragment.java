package com.example.fooddogapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fooddogapp.R;
import com.example.fooddogapp.db.DBHelper;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfileFragment extends Fragment {

    private static final int PICK_IMAGE = 1;
    private ImageView itemImageView;
    private EditText emailEditText, usernameEditText, contactEditText, addressEditText;
    private Button uploadImageButton, saveButton, logoutButton, returnButton;
    private Uri imageUri;
    private DBHelper databaseHelper;
    private String userEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity().getIntent().hasExtra("user_email")) {
            userEmail = getActivity().getIntent().getStringExtra("user_email");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        databaseHelper = new DBHelper(getContext());

        itemImageView = view.findViewById(R.id.itemImageView);
        emailEditText = view.findViewById(R.id.profile_email);
        usernameEditText = view.findViewById(R.id.profile_username);
        contactEditText = view.findViewById(R.id.profile_contact);
        addressEditText = view.findViewById(R.id.profile_address);
        uploadImageButton = view.findViewById(R.id.uploadImageButton);
        saveButton = view.findViewById(R.id.profile_save_button);
        logoutButton = view.findViewById(R.id.profile_logout_button);
        returnButton = view.findViewById(R.id.return_button);

        loadUserData();

        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, PICK_IMAGE);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges();
            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnback();
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });return view;
    }

    private void loadUserData() {
        Cursor cursor = databaseHelper.getUserData(userEmail);
        if (cursor.moveToFirst()) {
            int emailIndex = cursor.getColumnIndex("email");
            int usernameIndex = cursor.getColumnIndex("username");
            int contactIndex = cursor.getColumnIndex("contact");
            int addressIndex = cursor.getColumnIndex("address");

            if (emailIndex != -1 && usernameIndex != -1 && contactIndex != -1 && addressIndex != -1) {
                String email = cursor.getString(emailIndex);
                String username = cursor.getString(usernameIndex);
                String contact = cursor.getString(contactIndex);
                String address = cursor.getString(addressIndex);

                emailEditText.setText(email);
                usernameEditText.setText(username);
                contactEditText.setText(contact);
                addressEditText.setText(address);
            }
        }cursor.close();
    }

    private void saveChanges() {
        String username = usernameEditText.getText().toString();
        String contact = contactEditText.getText().toString();
        String address = addressEditText.getText().toString();

        boolean isUpdated = databaseHelper.updateUserData(userEmail, username, contact, address);

        if (isUpdated) {
            Toast.makeText(getContext(), "Changes saved successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Failed to save changes", Toast.LENGTH_SHORT).show();
        }
    }

    private void logout() {
        // Clear user session, for example, SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        // Redirect to login activity
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void returnback() {
        // Redirect to main activity
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void saveProfileImage(Uri imageUri) {
        if (imageUri != null) {
            String imagePath = imageUri.toString();
            // Save imagePath to database using DBHelper
            databaseHelper.updateUserProfileImage(userEmail, imagePath);
        }
    }
}
