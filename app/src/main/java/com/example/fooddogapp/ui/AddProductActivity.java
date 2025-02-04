package com.example.fooddogapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fooddogapp.R;
import com.example.fooddogapp.db.DBHelper;

public class AddProductActivity extends AppCompatActivity {

    private EditText nameEditText, brandEditText, ageEditText, priceEditText, imageEditText, availabilityEditText;
    private Button addProductButton;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        nameEditText = findViewById(R.id.nameEditText);
        brandEditText = findViewById(R.id.brandEditText);
        ageEditText = findViewById(R.id.ageEditText);
        priceEditText = findViewById(R.id.priceEditText);
        imageEditText = findViewById(R.id.imageEditText);
        availabilityEditText = findViewById(R.id.availabilityEditText);
        addProductButton = findViewById(R.id.addProductButton);

        dbHelper = new DBHelper(this);

        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String brand = brandEditText.getText().toString();
                String age = ageEditText.getText().toString();
                double price = Double.parseDouble(priceEditText.getText().toString());
                String image = imageEditText.getText().toString();
                int availability = Integer.parseInt(availabilityEditText.getText().toString());

                boolean success = dbHelper.insertProduct(name, brand, age, price, image, availability);

                if (success) {
                    Toast.makeText(AddProductActivity.this, "Product Added Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddProductActivity.this, "Failed to Add Product", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
