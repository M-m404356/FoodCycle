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

public class MainActivity extends AppCompatActivity {
    private Button haveFood;

    private Button needFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        haveFood = findViewById(R.id.haveFood);
        needFood = findViewById(R.id.needFood);

        haveFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                haveFood.setBackgroundColor(Color.BLUE);
                String haveFoodURL = "https://forms.gle/gW3oY1rgJb9CfPFMA";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(haveFoodURL));
                startActivity(i);
            }
        });


        needFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                needFood.setBackgroundColor(Color.BLUE);
                String needFoodURL = "https://forms.gle/bKh9EDXAAGPPXwSS7";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(needFoodURL));
                startActivity(i);
            }
        });
    }
}
