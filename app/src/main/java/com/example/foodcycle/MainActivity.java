package com.example.foodcycle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button haveFood;

    private Button needFood;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        haveFood = findViewById(R.id.haveFood);
        needFood = findViewById(R.id.needFood);

        final Intent enterFoodLocation = new Intent(this, addFoodLocation.class);
        haveFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                haveFood.setBackgroundColor(Color.BLUE);
                startActivity(enterFoodLocation);
            }
        });


        final Intent startMap = new Intent(this, MapsActivity.class);
        needFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                needFood.setBackgroundColor(Color.BLUE);
                startActivity(startMap);

            }
        });

    }

}

