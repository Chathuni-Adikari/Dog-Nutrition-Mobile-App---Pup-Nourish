package com.example.fooddogapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fooddogapp.R;

public class HomeFragment extends Fragment {

    private Button new1Button;
    private Button new2Button;
    private Button new3Button;

    private Button food1Button;
    private Button food2Button;
    private Button food3Button;
    private Button food4Button;

    private ImageView CartView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);

        new1Button = view.findViewById(R.id.new1_search_button);
        new2Button = view.findViewById(R.id.new2_search_button);
        new3Button = view.findViewById(R.id.new3_search_button);

        food1Button =view.findViewById(R.id.dry_search_button);
        food2Button = view.findViewById(R.id.wet_search_button);
        food3Button = view.findViewById(R.id.treat_search_button);
        food4Button = view.findViewById(R.id.premium_search_button);

        CartView = view.findViewById(R.id.home_shopping_cart);

        new1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new1();
            }
        });
        new2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new2();
            }
        });
        new3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new3();
            }
        });
        food1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food1();
            }
        });
        food2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food2();
            }
        });
        food3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food3();
            }
        });
        food4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food4();
            }
        });
        CartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart();
            }
        });


        return view;
    }

    private void new1() {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void new2() {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void new3() {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void food1() {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void food2() {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void food3() {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void food4() {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void Cart() {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}