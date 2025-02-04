package com.example.fooddogapp.ui;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fooddogapp.adapter.CartAdapter;
import com.example.fooddogapp.db.DBHelper;
import com.example.fooddogapp.model.CartItem;
import com.example.fooddogapp.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private ListView listView;
    private CartAdapter adapter;
    private List<CartItem> cartItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        dbHelper = new DBHelper(this);
        listView = findViewById(R.id.cartListView);

        loadCartItems();
        calculateTotal();
    }
    private void loadCartItems() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cartItemList = new ArrayList<>();

        String query = "SELECT c.id, p.name, p.price, c.quantity FROM Cart c " +
                "JOIN Products p ON c.product_id = p.id";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                int quantity = cursor.getInt(cursor.getColumnIndex("quantity"));

                cartItemList.add(new CartItem(id, name, price, quantity));
            } while (cursor.moveToNext());
        }
        cursor.close();

        adapter = new CartAdapter(cartItemList, dbHelper);
        listView.setAdapter(adapter);
    }

    public void calculateTotal() {
        double total = 0.0;
        for (CartItem item : cartItemList) {
            total += item.getPrice() * item.getQuantity();
        }

        TextView totalTextView = findViewById(R.id.totalTextView);
        totalTextView.setText("Total: LKR " + total);
    }
}