package com.example.fooddogapp.adapter;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.fooddogapp.db.DBHelper;
import com.example.fooddogapp.model.CartItem;
import com.example.fooddogapp.R;
import com.example.fooddogapp.ui.CartActivity;

import java.util.List;

public class CartAdapter extends BaseAdapter {
    private List<CartItem> cartItemList;
    private DBHelper dbHelper;

    public CartAdapter(List<CartItem> cartItemList, DBHelper dbHelper) {
        this.cartItemList = cartItemList;
        this.dbHelper = dbHelper;
    }

    @Override
    public int getCount() {
        return cartItemList.size();
    }
    @Override
    public Object getItem(int position) {
        return cartItemList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return cartItemList.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cart_item, parent, false);
        }

        CartItem cartItem = cartItemList.get(position);

        TextView name = convertView.findViewById(R.id.cartItemName);
        TextView price = convertView.findViewById(R.id.cartItemPrice);
        TextView quantity = convertView.findViewById(R.id.cartItemQuantity);
        Button increaseQty = convertView.findViewById(R.id.increaseQtyButton);
        Button decreaseQty = convertView.findViewById(R.id.decreaseQtyButton);

        name.setText(cartItem.getName());
        price.setText("LKR " + cartItem.getPrice());
        quantity.setText(String.valueOf(cartItem.getQuantity()));

        increaseQty.setOnClickListener(v -> {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            updateCartItem(cartItem);
            notifyDataSetChanged();
        });
        decreaseQty.setOnClickListener(v -> {
            if (cartItem.getQuantity() > 1) {
                cartItem.setQuantity(cartItem.getQuantity() - 1);
                updateCartItem(cartItem);
                notifyDataSetChanged();
            }
        });return convertView;
    }

    private void updateCartItem(CartItem cartItem) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("quantity", cartItem.getQuantity());

        db.update("Cart", values, "id = ?", new
                String[]{String.valueOf(cartItem.getId())});
        ((CartActivity) dbHelper.getContext()).calculateTotal();
    }
}
