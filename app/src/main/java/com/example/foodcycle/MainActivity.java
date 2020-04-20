package com.example.foodcycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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

        haveFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String haveFoodURL = "https://forms.gle/gW3oY1rgJb9CfPFMA";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(haveFoodURL));
                startActivity(i);
            }
        });


        final Intent startMap = new Intent(this, MapsActivity.class);
        needFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startMap);



                //startfoodSearch.onCreate(savedInstanceState);

                //needFood.setOnEditorActionListener(e );


                //Intent x = new Intent(Intent.);
                //String needFoodURL = "https://forms.gle/bKh9EDXAAGPPXwSS7";
                //Intent i = new Intent(Intent.ACTION_VIEW);
                //i.setData(Uri.parse(needFoodURL));
               // startActivity(i);
                //creates a map that has the locations of all of the people with food saved
                //in it-- will center around the current user's locatio


            }
        });
    }
}
