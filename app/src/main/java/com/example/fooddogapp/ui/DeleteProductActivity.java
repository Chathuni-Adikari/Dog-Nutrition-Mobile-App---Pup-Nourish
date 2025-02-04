package com.example.fooddogapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fooddogapp.R;
import com.example.fooddogapp.db.DBHelper;

public class DeleteProductActivity extends AppCompatActivity {

    private EditText idEditText;
    private Button deleteProductButton;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);

        idEditText = findViewById(R.id.idEditText);
        deleteProductButton = findViewById(R.id.deleteProductButton);
        dbHelper = new DBHelper(this);
        deleteProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(idEditText.getText().toString());
                boolean success = dbHelper.deleteProduct(id);

                if (success) {
                    Toast.makeText(DeleteProductActivity.this, "Product Deleted Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(DeleteProductActivity.this, "Failed to Delete Product", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
