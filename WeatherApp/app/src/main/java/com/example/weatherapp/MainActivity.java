package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Weathercity> listacity;
    RecyclerView recyclerweather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listacity = new ArrayList<>();
        recyclerweather = findViewById(R.id.RecyclerId);
        recyclerweather.setLayoutManager(new LinearLayoutManager(this));

        linearcitys();

        AdaptadorWeather adaptor=new AdaptadorWeather(listacity);
        recyclerweather.setAdapter(adaptor);
    }

    private void linearcitys() {
        listacity.add(new Weathercity("Lisboa", R.drawable.lisboa));
        listacity.add(new Weathercity("Paris", R.drawable.paris));
        listacity.add(new Weathercity("Londres", R.drawable.londres));
        listacity.add(new Weathercity("Roma", R.drawable.roma));
        listacity.add(new Weathercity("Berlim", R.drawable.berlim));
        listacity.add(new Weathercity("Nova Iorque", R.drawable.novaiorque));
        listacity.add(new Weathercity("Tóquio", R.drawable.toquio));
        listacity.add(new Weathercity("Sydney", R.drawable.sydney));
    }
}
