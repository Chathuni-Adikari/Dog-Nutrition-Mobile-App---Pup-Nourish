package com.example.fooddogapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;


import com.example.fooddogapp.R;
import com.example.fooddogapp.adapter.DogFoodAdapter;
import com.example.fooddogapp.model.DogFood;

import java.util.ArrayList;

public class DogFoodActivity extends AppCompatActivity {

    public  static ArrayList<DogFood> dogFoodList = new ArrayList<>();
    public ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_food);

        setUpData();
        setUpList();
        setUpOnClickListner();

        // Button to navigate back to MainActivity
        Button buttonBackToMainActivity = findViewById(R.id.button_back_to_main_activity);
        buttonBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DogFoodActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setUpOnClickListner() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DogFood selectDogFood = (DogFood) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DogFoodDetailActivity.class);
                showDetail.putExtra("id", selectDogFood.getId());
                startActivity(showDetail);
            }
        });
    }


    private void setUpList() {
        listView = (ListView) findViewById(R.id.itemListView);

        DogFoodAdapter adapter = new DogFoodAdapter(getApplicationContext(),0,dogFoodList);
        listView.setAdapter(adapter);
    }

    private void setUpData() {

        DogFood dtwo = new DogFood("2",R.drawable.dtwo, "Drools Optimum Performance Adult Dog Dry Food (LKR 1450.00)","Drools Optimum Performance");
        dogFoodList.add(dtwo);
        DogFood done = new DogFood("1", R.drawable.done, "Henlo Chicken And Egg Baked Dry Food (LKR 1200.00)"," Hiii" );
        dogFoodList.add(done);
        DogFood dthree = new DogFood("3",  R.drawable.dthree, "Pedigree Chicken & Milk Puppy Dog Dry Food (LKR 1560.00)",
                "PEDIGREE Chicken & Milk for Puppy – a nutritious and tasty" );
        dogFoodList.add(dthree);
        DogFood dfour = new DogFood("4", R.drawable.dfour, "Pedigree Chicken & Vegetables Dog Dry Food (LKR 1730.00)","");
        dogFoodList.add(dfour);
        DogFood dfive = new DogFood("5", R.drawable.dfive, "Pedigree Chicken & Liver Chunks In Gravy Adult Dog Wet Food (LKR 1430.00)","");
        dogFoodList.add(dfive);

        DogFood wet1 = new DogFood("6", R.drawable.wet1, "Drools Real Chicken & Chicken Liver Chunks In Gravy Adult Dog Wet Food (LKR 1430.00)","");
        dogFoodList.add(wet1);
        DogFood wet2 = new DogFood("7",R.drawable.wet2, "Royal Canin Vaterinary Diet Renal Dog Wet Food (LKR 1430.00)","");
        dogFoodList.add(wet2);
        DogFood wet3 = new DogFood("8",  R.drawable.wet3, "Drools Real Chicken & Chicken Liver Chunks In Gravy Puppy Dog Wet Food (LKR 1430.00)","");
        dogFoodList.add(wet3);
        DogFood wet4 = new DogFood("9", R.drawable.wet4, "Bark Out Loud Immunity Multi Vitamin Chew Sticks For Dogs (LKR 1750.00)","");
        dogFoodList.add(wet4);
        DogFood wet5 = new DogFood("10", R.drawable.wet5, "Drools Absolute Calcium Bones Dog (LKR 2430.00)","");
        dogFoodList.add(wet5);

        DogFood t1 = new DogFood("11",R.drawable.t1, "Pedigree Chicken & Liver Flavour Tasty Jerky Dog Treat (LKR 1890.00)","");
        dogFoodList.add(t1);
        DogFood t2 = new DogFood("12",  R.drawable.t2, "Drools Real Chicken Sausage Dog Treats (LKR 2230.00)","");
        dogFoodList.add(t2);
        DogFood t3 = new DogFood("13", R.drawable.t3, "Signature Gain Zero Real Chicken, Egg & Vegetables Adult Dog (LKR 1750.00)","");
        dogFoodList.add(t3);
        DogFood t4 = new DogFood("14", R.drawable.t4, "Pedigree Chicken & Liver Chunks In Gravy Adult Dog Wet Food (LKR 2430.00)","");
        dogFoodList.add(t4);
        DogFood t5 = new DogFood("15", R.drawable.t5, "Drools Focus Super Premium Adult Dog Dry Food (LKR 1890.00)","");
        dogFoodList.add(t5);

        DogFood p1 = new DogFood("16",R.drawable.p1, "Royal Canin Mini Puppy Dog Dry Food (LKR 2230.00)","");
        dogFoodList.add(p1);
        DogFood p2 = new DogFood("17",  R.drawable.p2, "Henlo Baked DRy Food For Puppies (LKR 2350.00)","");
        dogFoodList.add(p2);
        DogFood p3 = new DogFood("18", R.drawable.p3, "Pedigree Chicken And Milk Puppy Dog Dry Food (LKR 1630.00)","");
        dogFoodList.add(p3);
        DogFood p4 = new DogFood("19", R.drawable.p4, "Royal Canin Mini Starter For Small Breed Dogs & Puppies (LKR 1890.00)","");
        dogFoodList.add(p4);
        DogFood p5 = new DogFood("20", R.drawable.p5, "Pedigree Lamb Flavour Chunks In Gravy Puppy Wet Food (LKR 1730.00)","");
        dogFoodList.add(p5);

        DogFood r1 = new DogFood("21",R.drawable.r1, "Royal Canin Mini Adult (LKR 2350.00)","");
        dogFoodList.add(r1);
        DogFood r2 = new DogFood("22",  R.drawable.r2, "Royal Canin PRO Rottweiler Adult (LKR 1630.00)","");
        dogFoodList.add(r2);
        DogFood r3 = new DogFood("23", R.drawable.r3, "Royal Canin Labrador Puppy (LKR 1890.00)","");
        dogFoodList.add(r3);
        DogFood r4 = new DogFood("24", R.drawable.r4, "Royal Canin Labrador Adult (LKR 1730.00)","");
        dogFoodList.add(r4);
    }
}