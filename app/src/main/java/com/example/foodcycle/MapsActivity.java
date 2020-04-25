package com.example.foodcycle;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng urbana_champaign = new LatLng(40.11, -88.24);
        mMap.addMarker(new MarkerOptions().position(urbana_champaign).title("Urbana-Champaign"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(urbana_champaign));

        LatLng stoneCreek = new LatLng(40.085140, -88.208549);
        mMap.addMarker(new MarkerOptions().position(stoneCreek).title("Stone Creek Church")
                .snippet("2502 S Race St, Urbana, IL 61801\n" + "Fridays 11:00am - 1:00pm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stoneCreek));

        LatLng wesley = new LatLng(40.110210, -88.224780);
        mMap.addMarker(new MarkerOptions().position(wesley).title("Wesley United Methodist Church")
                .snippet("1203 West Green Street Urbana, IL 61801\n" + "Thursdays 5:00pm - 7:00pm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wesley));

        LatLng dailyBread = new LatLng(40.116930, -88.238470);
        mMap.addMarker(new MarkerOptions().position(dailyBread).title("Daily Bread Soup Kitchen")
                .snippet("116 N 1st St, Champaign, IL 61820\n" + "Everyday 11:00am - 12:30pm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dailyBread));
    }

    public GoogleMap getmMap() {
        return mMap;
    }
}
