package com.example.fooddogapp.ui;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fooddogapp.R;
import com.example.fooddogapp.adapter.ProductAdapter;
import com.example.fooddogapp.adapter.ProductsAdapter;
import com.example.fooddogapp.db.DBHelper;
import com.example.fooddogapp.model.Product;

import java.util.List;

public class ViewProductsActivity extends AppCompatActivity {

    private ListView productsListView;
    private DBHelper dbHelper;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        productsListView = findViewById(R.id.productsListView);
        dbHelper = new DBHelper(this);

        List<Product> productList = dbHelper.getAllProducts();

        if (productList != null && !productList.isEmpty()) {
            productAdapter = new ProductAdapter(this, productList);
            productsListView.setAdapter(productAdapter);
        } else {
            Toast.makeText(this, "No products available", Toast.LENGTH_SHORT).show();
        }
    }
}
