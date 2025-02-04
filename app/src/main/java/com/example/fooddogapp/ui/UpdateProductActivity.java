package com.example.fooddogapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fooddogapp.R;
import com.example.fooddogapp.db.DBHelper;

public class UpdateProductActivity extends AppCompatActivity {

    private EditText idEditText, nameEditText, brandEditText, ageEditText, priceEditText, imageEditText, availabilityEditText;
    private Button updateProductButton;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        idEditText = findViewById(R.id.idEditText);
        nameEditText = findViewById(R.id.nameEditText);
        brandEditText = findViewById(R.id.brandEditText);
        ageEditText = findViewById(R.id.ageEditText);
        priceEditText = findViewById(R.id.priceEditText);
        imageEditText = findViewById(R.id.imageEditText);
        availabilityEditText = findViewById(R.id.availabilityEditText);
        updateProductButton = findViewById(R.id.updateProductButton);

        dbHelper = new DBHelper(this);

        updateProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(idEditText.getText().toString());
                String name = nameEditText.getText().toString();
                String brand = brandEditText.getText().toString();
                String age = ageEditText.getText().toString();
                double price = Double.parseDouble(priceEditText.getText().toString());
                String image = imageEditText.getText().toString();
                int availability = Integer.parseInt(availabilityEditText.getText().toString());

                boolean success = dbHelper.updateProduct(id, name, brand, age, price, image, availability);

                if (success) {
                    Toast.makeText(UpdateProductActivity.this, "Product Updated Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(UpdateProductActivity.this, "Failed to Update Product", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
