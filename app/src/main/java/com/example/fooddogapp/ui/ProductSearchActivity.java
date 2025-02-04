package com.example.fooddogapp.ui;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddogapp.R;
import com.example.fooddogapp.adapter.ProductsAdapter;
import com.example.fooddogapp.databinding.ActivityProductSearchBinding;
import com.example.fooddogapp.db.DBHelper;
import com.example.fooddogapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    ActivityProductSearchBinding binding;

    private RecyclerView recyclerView;
    private ProductsAdapter adapter;
    private List<Product> productList;

    private Spinner brandSpinner, ageSpinner;
    private String selectedBrand = "All", selectedAge = "All";

    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductSearchBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_product_search);
        setContentView(binding.getRoot());
        dbHelper = new DBHelper(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        brandSpinner = findViewById(R.id.brandSpinner);
        ageSpinner = findViewById(R.id.ageSpinner);

        setupSpinners();
        loadProducts();
        loadProducts("");

        binding.searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                loadProducts(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        binding.cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart();
            }
        });
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        brandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBrand = brandSpinner.getSelectedItem().toString();
                loadProducts();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedAge = ageSpinner.getSelectedItem().toString();
                loadProducts();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    private void cart() {
        Intent intent = new Intent(getApplicationContext(), CartActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void back() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void setupSpinners() {
        // Example data, replace with actual data from the database
        String[] brands = {"All Brands", "Henlo", "Drools", "Pedigree", "Royal Canin", "Bark Out Loud", "Signature"};
        String[] ages = {"All Ages", "Puppy", "Adult"};

        ArrayAdapter<String> brandAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brands);
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(brandAdapter);

        ArrayAdapter<String> ageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ages);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);
    }
    private void loadProducts() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        productList = new ArrayList<>();

        String selection = "";
        List<String> selectionArgs = new ArrayList<>();

        if (!selectedBrand.equals("All Brands")) {
            selection += "brand = ?";
            selectionArgs.add(selectedBrand);
        }

        if (!selectedAge.equals("All Ages")) {
            if (!selection.isEmpty()) selection += " AND ";
            selection += "age = ?";
            selectionArgs.add(selectedAge);
        }

        Cursor cursor = db.query("Products", null,
                selection.isEmpty() ? null : selection,
                selectionArgs.isEmpty() ? null : selectionArgs.toArray(new String[0]),
                null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String brand = cursor.getString(cursor.getColumnIndex("brand"));
                String age = cursor.getString(cursor.getColumnIndex("age"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                int availability = cursor.getInt(cursor.getColumnIndex("availability"));

                productList.add(new Product(id, name, brand, age, price, image, availability));
            } while (cursor.moveToNext());
        }
        cursor.close();

        adapter = new ProductsAdapter(productList, dbHelper);
        recyclerView.setAdapter(adapter);
    }

    private void loadProducts(String searchQuery) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        productList = new ArrayList<>();
        Cursor cursor;

        if (searchQuery.isEmpty()) {
            cursor = db.rawQuery("SELECT * FROM Products", null);
        } else {
            cursor = db.rawQuery("SELECT * FROM Products WHERE name LIKE ?", new String[]{"%" + searchQuery + "%"});
        }

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String brand = cursor.getString(cursor.getColumnIndex("brand"));
                String age = cursor.getString(cursor.getColumnIndex("age"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                int availability = cursor.getInt(cursor.getColumnIndex("availability"));

                productList.add(new Product(id, name, brand, age, price, image, availability));
            } while (cursor.moveToNext());
        }

        cursor.close();
        adapter = new ProductsAdapter(productList, dbHelper);
        recyclerView.setAdapter(adapter);
    }

}