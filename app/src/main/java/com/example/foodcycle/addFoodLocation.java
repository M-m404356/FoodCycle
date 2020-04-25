package com.example.foodcycle;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class addFoodLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_location);
        findViewById(R.id.Submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNewFoodSource();
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
                System.out.println("Street Address not valid, please type address within Champaign-Urbana region");

            }

    }
}

