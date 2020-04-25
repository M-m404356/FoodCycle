package com.example.foodcycle;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.List;

public class HaveFood extends AppCompatActivity {
    LatLng foodSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.havefood);
    }
}
        /**findViewById(R.id.Submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {
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
         foodSource = new LatLng(latitude, longitude);
         MapsActivity.mMap.addMarker(new MarkerOptions().position(foodSource).title(nameContact));
         }
         } catch(Exception e) {
         System.out.println("Street Address not valid, please type address within Champaign-Urbana region");

         }



         }

         //onTextchanged store new location as the name in associationw itht eh contact information
         //use Geomaps API to turn the stated location into a lat lng opbject
         //add latlng object to the map
         }
         **/
        
