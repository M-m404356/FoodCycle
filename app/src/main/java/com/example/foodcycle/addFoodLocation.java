package com.example.foodcycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class addFoodLocation extends AppCompatActivity {
    Button submit;
    //Intent mainPage = new Intent(this,MainActivity.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_location);
        submit = findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNewFoodSource();
                submit.setBackgroundColor(Color.BLACK);
                //startActivity(mainPage);
            }
        });
        }

        public void getNewFoodSource() {
            EditText name = (EditText) findViewById(R.id.contact_name);
            String nameContact = name.getText().toString();

            EditText location = (EditText) findViewById(R.id.food_pickup);
            String foodPickuplocation = location.getText().toString();

            try {
                List<Address> foodsources = new Geocoder(this).getFromLocationName(foodPickuplocation, 1);
                if (foodsources.size() > 0) {
                    double latitude = foodsources.get(0).getLatitude();
                    double longitude = foodsources.get(0).getLongitude();
                    LatLng foodSource = new LatLng(latitude, longitude);
                    MapsActivity.mMap.addMarker(new MarkerOptions().position(foodSource).title(nameContact));
                }
            } catch(Exception e) {
                return;
                //submit.setBackgroundColor(Color.BLACK);
                //startActivity(mainPage);

            }

    }
}

