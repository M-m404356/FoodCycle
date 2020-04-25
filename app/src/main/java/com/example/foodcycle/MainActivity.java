package com.example.foodcycle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {
    private Button haveFood;
    private Bundle savedInstanceState;
    private GoogleMap areamap;

    private Button needFood;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        haveFood = findViewById(R.id.haveFood);
        needFood = findViewById(R.id.needFood);

        final Intent enterFoodLocation = new Intent(this, HaveFood.class);
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
