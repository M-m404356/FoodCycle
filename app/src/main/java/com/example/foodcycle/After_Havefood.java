package com.example.foodcycle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class After_Havefood extends AppCompatActivity  implements RecyclerViewAdapter.ItemClickListener {
    Button goHome;

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after__havefood);

        ArrayList<String> foodPlaces = new ArrayList<>();
        foodPlaces.add("Stone Creek Church: 2502 S Race St, Urbana, IL 61801; Fridays 11:00am - 1:00pm");
        foodPlaces.add("Wesley United Methodist Church: 1203 West Green Street Urbana, IL 61801; Thursdays 5:00pm - 7:00pm");
        foodPlaces.add("Daily Bread Soup Kitchen: 116 N 1st St, Champaign, IL 61820; Everyday 11:00am - 12:30pm");
        foodPlaces.add("St. John's Catholic Newman Center: 604 E Armory Ave, Champaign, IL 61820; Every 2nd, 3rd & 4th Wednesday 5pm-7pm");
        foodPlaces.add("Restoration Urban Ministries: 1213 Parkland Court, Champaign, IL 61821; Mondays, Tuesdays, Thursdays, and Fridays 10am-1pm");
        foodPlaces.add("Salvation Army Pantry: 2212 North Market Street, Champaign, IL 61824; Mondays, Wednesdays, Thursdays, Fridays 9am-4pm / Tuesdays 9 am – 5 pm");
        foodPlaces.add("Emmanuel Memorial Episcopal: 208 W University Ave, Champaign, IL 61820; Monday-Friday 9am-10am");


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.foodPlaces);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, foodPlaces);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        /**
        goHome = findViewById(R.id.goHome);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent returnHome = new Intent("android.intent.action.MAIN");
;               startActivity(returnHome);
            }
        });
         */

    }

    @Override
    public void onItemClick(View view, int position) {
    }
}
