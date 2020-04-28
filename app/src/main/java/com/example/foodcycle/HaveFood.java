package com.example.foodcycle;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class HaveFood extends AppCompatActivity {
    LatLng foodSource;
    private double westBoundary;
    private double eastBoundary;
    private double northBoundary;
    private double southBoundary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.havefood);
        Button submit = findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                getNewFoodSource();
            }
        });
        westBoundary = -88.304951;
        eastBoundary = -88.162320;
        southBoundary = 40.069607;
        northBoundary = 40.150936;
    }


    public void getNewFoodSource() {
        EditText name = (EditText) findViewById(R.id.organizationName);
        String nameContact = name.getText().toString();

        EditText location = (EditText) findViewById(R.id.food_pickup);
        String foodPickuplocation = location.getText().toString();

        try {
            List<Address> foodsources = new Geocoder(this).getFromLocationName(foodPickuplocation, 1);
            if (foodsources.size() > 0) {
                double latitude = foodsources.get(0).getLatitude();
                double longitude = foodsources.get(0).getLongitude();
                if ((latitude >= southBoundary && latitude <= northBoundary) && (longitude >= westBoundary && longitude <= eastBoundary)) {
                    foodSource = new LatLng(latitude, longitude);
                    MapsActivity.mMap.addMarker(new MarkerOptions().position(foodSource).title(nameContact)
                            .snippet(foodPickuplocation));
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Street Address not valid, please type address within Champaign-Urbana region")
                            .setView(View.VISIBLE);
                    builder.setOnDismissListener(unused -> finish());
                    builder.create().show();
                }

            }
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Street Address not valid, please type address within Champaign-Urbana region")
                    .setView(View.VISIBLE);
            builder.setOnDismissListener(unused -> finish());
            builder.create().show();

        }


    }

    //onTextchanged store new location as the name in associationw itht eh contact information
    //use Geomaps API to turn the stated location into a lat lng opbject
    //add latlng object to the map
}


