package com.example.fooddogapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fooddogapp.R;
import com.example.fooddogapp.model.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    public ProductAdapter(Context context, List<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product, parent, false);
        }

        Product product = getItem(position);

        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView brandTextView = convertView.findViewById(R.id.brandTextView);
        TextView ageTextView = convertView.findViewById(R.id.ageTextView);
        TextView priceTextView = convertView.findViewById(R.id.priceTextView);
        TextView imageTextView = convertView.findViewById(R.id.imageTextView);
        TextView availabilityTextView = convertView.findViewById(R.id.availabilityTextView);

        nameTextView.setText("Name: " + product.getName());
        brandTextView.setText("Brand: " + product.getBrand());
        ageTextView.setText("Age Group: " + product.getAge());
        priceTextView.setText("Price: LKR" + product.getPrice());
        imageTextView.setText("Image URL: " + product.getImage());
        availabilityTextView.setText("Availability: " + product.getAvailability());

        return convertView;
    }
}
