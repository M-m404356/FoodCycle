package com.example.foodcycle;

import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class addFoodLocation extends AppCompatActivity {
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_location);
        submit = findViewById(R.id.Submit);
        Intent thanksPage = new Intent(this, After_Havefood.class);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNewFoodSource();
                submit.setBackgroundColor(Color.BLACK);
                finish();

                startActivity(thanksPage);

            }
        });

    }


    public void getNewFoodSource() {
        EditText name =  findViewById(R.id.contact_name);
        String nameContact = name.getText().toString();

        EditText location = findViewById(R.id.food_pickup);
        String foodPickuplocation = location.getText().toString();

        EditText extraInfo =  findViewById(R.id.pickupTime);
        String pickupTime = extraInfo.getText().toString();


        //if (name.length() == 0 || location.length() == 0) {
           // final Intent thankspage = new Intent(this, After_Havefood.class);
           // startActivity(thankspage);
            //finish();
        //}

        try {
            List<Address> foodsources = new Geocoder(this).getFromLocationName(foodPickuplocation, 1);
            double latitude = foodsources.get(0).getLatitude();
            double longitude = foodsources.get(0).getLongitude();
            LatLng foodSource = new LatLng(latitude, longitude);
            MapsActivity.mMap.addMarker(new MarkerOptions().position(foodSource).title(nameContact).snippet(pickupTime));
        } catch (Exception e) {
            //e.printStackTrace();
            //startActivity(mainPage);
        }
    }

}

