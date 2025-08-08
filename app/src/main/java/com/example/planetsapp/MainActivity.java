package com.example.planetsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planets> planetsArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1- AdapterView: a ListView
        listView  = findViewById(R.id.listview);

        // 2- Data Source: ArrayList<Planets>
        planetsArrayList = new ArrayList<>();

        Planets planet3 = new Planets("Earth","1 Moon",R.drawable.earth);
        Planets planet1 = new Planets("Mercury","0 Moons",R.drawable.mercury);
        Planets planet2 = new Planets("Venus", "0 Moons", R.drawable.venus);

        Planets planet4 = new Planets("Mars", "2 Moons", R.drawable.mars);
        Planets planet5 = new Planets("Jupiter", "79 Moons", R.drawable.jupiter);
        Planets planet6 = new Planets("Saturn", "83 Moons", R.drawable.saturn);

        Planets planet7 = new Planets("Uranus", "27 Moons", R.drawable.uranus);
        Planets planet8 = new Planets("Neptune", "14 Moons", R.drawable.neptune);

        planetsArrayList.add(planet1);
        planetsArrayList.add(planet2);
        planetsArrayList.add(planet3);
        planetsArrayList.add(planet4);
        planetsArrayList.add(planet5);
        planetsArrayList.add(planet6);
        planetsArrayList.add(planet7);
        planetsArrayList.add(planet8);

        //Adapters :
        adapter = new MyCustomAdapter(planetsArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        //Handling Click Events :
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        "Planet Name: " +adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
                Toast.makeText(
                        MainActivity.this,
                        "Moon Count: " +adapter.getItem(position).getMoonCount(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}