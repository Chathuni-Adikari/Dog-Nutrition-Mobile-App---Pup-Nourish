package com.example.fooddogapp.adapter;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddogapp.db.DBHelper;
import com.example.fooddogapp.model.Product;
import com.example.fooddogapp.R;
import com.example.fooddogapp.ui.CartActivity;
import com.example.fooddogapp.db.DBHelper;
import com.example.fooddogapp.model.Product;


import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private List<Product> productList;
    private DBHelper dbHelper;

    public ProductsAdapter(List<Product> productList, DBHelper dbHelper) {
        this.productList = productList;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.name.setText(product.getName());
        holder.price.setText("LKR " + product.getPrice());

        holder.addToCart.setOnClickListener(v -> {
            addToCart(product);
            Toast.makeText(v.getContext(), product.getName() + " added to cart",
                    Toast.LENGTH_SHORT).show();
        });

        holder.viewCart.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CartActivity.class);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    private void addToCart(Product product) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Cart WHERE product_id = ?",
                new String[]{String.valueOf(product.getId())});

        if (cursor.moveToFirst()) {
            int quantity = cursor.getInt(cursor.getColumnIndex("quantity")) + 1;
            ContentValues values = new ContentValues();
            values.put("quantity", quantity);
            db.update("Cart", values, "product_id = ?",
                    new String[]{String.valueOf(product.getId())});
        } else {
            ContentValues values = new ContentValues();
            values.put("product_id", product.getId());
            values.put("quantity", 1);
            db.insert("Cart", null, values);
        }
        cursor.close();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView image;
        Button addToCart, viewCart;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.productImage);
            name = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.productPrice);
            addToCart = itemView.findViewById(R.id.addToCartButton);
            viewCart = itemView.findViewById(R.id.viewCartButton);
        }
    }

}

