package com.example.fooddogapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fooddogapp.R;
import com.example.fooddogapp.model.DogFood;

public class DogFoodDetailActivity extends AppCompatActivity {

    DogFood selectedDogFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dog_food_detail);
        getSelectedDogFood();
        setValues();
    }
    private void setValues() {
        TextView textView = (TextView) findViewById(R.id.dogFoodName);
        ImageView imageView = (ImageView) findViewById(R.id.dogFoodImage);
        TextView textView1 = (TextView) findViewById(R.id.dogFoodDescription);
        textView.setText(selectedDogFood.getName());
        imageView.setImageResource(selectedDogFood.getImage());
        textView1.setText(selectedDogFood.getDescription());
    }
    private void getSelectedDogFood() {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedDogFood = DogFoodActivity.dogFoodList.get(Integer.valueOf(parsedStringID));
    }
}