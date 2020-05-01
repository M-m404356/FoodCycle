package com.example.foodcycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity{
    private Button needfoodList;

    private Button needFoodMap;

    private Button foodForm;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        needfoodList = findViewById(R.id.needFoodList);
        needFoodMap = findViewById(R.id.needFoodMap);
        foodForm = findViewById(R.id.foodForm);

        final Intent enterFoodLocation = new Intent(this, After_Havefood.class);
        needfoodList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(enterFoodLocation);

            }
        });


        final Intent startMap = new Intent(this, MapsActivity.class);
        needFoodMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startMap);

            }
        });

        foodForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://forms.gle/HtceQxTzxa5jzBto7";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }


        });




    }

}

