package com.example.fooddogapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fooddogapp.R;
import com.example.fooddogapp.model.DogFood;

import java.util.List;

public class DogFoodAdapter extends ArrayAdapter<DogFood> {
    public DogFoodAdapter(Context context, int resource, List<DogFood> dogFoodList) {
        super(context, resource, dogFoodList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DogFood dogFood = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_cell,
                    parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.itemName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.itemImage);

        textView.setText(dogFood.getName());
        imageView.setImageResource(dogFood.getImage());

        return convertView;
    }
}
