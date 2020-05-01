package com.example.foodcycle;

import android.content.Context;
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

import java.util.List;

public class addFoodLocation extends AppCompatActivity {
    Button submit;
    String foodPickupLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent thanksPage = new Intent(this, After_Havefood.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_location);
        submit = findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //finish();
                getNewFoodSource();
                submit.setBackgroundColor(Color.BLACK);
                startActivity(thanksPage);

            }
        });

    }


    public void getNewFoodSource() {
        EditText name =  findViewById(R.id.organizationName);
        String nameContact = name.getText().toString();

        EditText location = findViewById(R.id.food_pickup);
        foodPickupLocation = location.getText().toString();

        EditText extraInfo =  findViewById(R.id.pickupTime);
        String pickupTime = extraInfo.getText().toString();

        if (getLocationFromAddress(this, foodPickupLocation) != null) {
            LatLng foodSource = getLocationFromAddress(this,foodPickupLocation);
            System.out.println(foodSource.toString());
            //MapsActivity.mMap.addMarker(new MarkerOptions().position(foodSource).title(nameContact));
        } else {
            System.out.println("locationNull");
        }
    }

    public LatLng getLocationFromAddress(Context context, String straddress) {
        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = new LatLng(40.1057, -88.2229);

        try {
            address = coder.getFromLocationName(straddress, 5);
            if (address == null) {
                return null;
            }
            System.out.println(address.size());
            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p1;
    }

}

