package com.example.foodcycle;

import android.os.Bundle;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static GoogleMap mMap;

    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //submit = findViewById(R.id.Submit);
        //final Intent enterFoodLocation = new Intent(this, addFoodLocation.class);
        //submit.setOnClickListener(new View.OnClickListener() {
        // @Override
        //public void onClick(View v) {
        //submit.setBackgroundColor(Color.BLACK);
        //startActivity(thankspage);
        //finish();

        //startActivity(mainPage);
    //}
       // });





    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng southWestCU = new LatLng(40.06032, -88.3436);
        LatLng northEastCU = new LatLng(40.167, -88.14908);
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (width * 0.15);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(southWestCU);
        builder.include(northEastCU);
        LatLngBounds bounds = builder.build();


        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding));

        // Add a marker in Sydney and move the camera

        LatLng stoneCreek = new LatLng(40.085140, -88.208549);
        mMap.addMarker(new MarkerOptions().position(stoneCreek).title("Stone Creek Church")
                .snippet("2502 S Race St, Urbana, IL 61801" + " Fridays 11:00am - 1:00pm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stoneCreek));

        LatLng wesley = new LatLng(40.110210, -88.224780);
        mMap.addMarker(new MarkerOptions().position(wesley).title("Wesley United Methodist Church")
                .snippet("1203 West Green Street Urbana, IL 61801" + " Thursdays 5:00pm - 7:00pm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wesley));

        LatLng dailyBread = new LatLng(40.116930, -88.238470);
        mMap.addMarker(new MarkerOptions().position(dailyBread).title("Daily Bread Soup Kitchen")
                .snippet("116 N 1st St, Champaign, IL 61820" + " Everyday 11:00am - 12:30pm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dailyBread));

        LatLng newmanShares = new LatLng(39.7986, -87.9859);
        mMap.addMarker(new MarkerOptions().position(newmanShares).title("Newman Shares Food Pantry")
                .snippet("604 F. Armory Ave. Champaign, IL 61801" + " 2nd, 3rd, and 4th Wednesday 5pm - 7pm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newmanShares));

        LatLng restorationUrbanMinistries = new LatLng(40.1289,-88.2789);
        mMap.addMarker(new MarkerOptions().position(restorationUrbanMinistries).title("Restoration Urban Ministries")
                .snippet("1213 Parkland Court Champaign, IL 61801" + " Mon, Tues, Thurs, Fri, 10am-1pm "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(restorationUrbanMinistries));

        LatLng salvationArmyFoodPantry = new LatLng(40.141380,-88.23805);
        mMap.addMarker(new MarkerOptions().position(salvationArmyFoodPantry).title("Salvation Army Pantry")
                .snippet("2212 North Market Street Champaign, IL 61824" + " Mon, Wed, Thurs, Fri 9am-4pm/Tues 9am - 5pm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(salvationArmyFoodPantry));

        LatLng emmanualMemorialEpiscopal = new LatLng(40.11634,-88.24550);
        mMap.addMarker(new MarkerOptions().position(emmanualMemorialEpiscopal).title("Emmanual Memorial Episcopal Church")
                .snippet("208 W University Ave Champaign, IL 61824" + " Mon - Fri (9am - 10am)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(emmanualMemorialEpiscopal));


    }

    public void addLocationToMap(LatLng addPoint, String addName) {
        mMap.addMarker(new MarkerOptions().position(addPoint).title(addName));
    }

    public GoogleMap getmMap() {
        return mMap;
    }

}
