package com.example.fooddogapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fooddogapp.R;


public class CartFragment extends Fragment {

    private Button searchButton;
    private Button treatButton;
    private Button wetButton;
    private Button dryButton;
    private Button puppyButton, HomeButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        searchButton = view.findViewById(R.id.product_search_button);
        treatButton = view.findViewById(R.id.treat_search_button);
        wetButton = view.findViewById(R.id.wet_search_button);
        dryButton = view.findViewById(R.id.dry_search_button);
        puppyButton = view.findViewById(R.id.puppy_search_button);
        HomeButton = view.findViewById(R.id.Home_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });
        treatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                treat();
            }
        });
        wetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wetFood();
            }
        });
        dryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dryFood();
            }
        });
        puppyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puppyFood();
            }
        });
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });
        return view;
    }

    private void search() {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void treat(){
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void wetFood(){
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void dryFood(){
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void puppyFood(){
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void Home() {
        // Clear user session, for example, SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        // Redirect to Main activity
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}