package com.example.hw2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CidadesFragment extends Fragment {

    ArrayList<Weathercity> listacity;
    RecyclerView recyclerweather;
    ImageButton arrow;

    public CidadesFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_cidades, container, false);
        listacity = new ArrayList<>();
        recyclerweather = vista.findViewById(R.id.listRecyclerView);
        recyclerweather.setLayoutManager(new LinearLayoutManager(getContext()));

        //arrow=vista.findViewById(R.id.goToFrag);
        //arrow.setOnClickListener(new View.OnClickListener() {
          //  @Override
            ////  WeatherFragment weatherFragment = new WeatherFragment();
                //FragmentTransaction transaction=getFragmentManager().beginTransaction();
                //transaction.replace(R.id.frame_container, weatherFragment);
                //transaction.commit();

           // }
        //});

        linearcitys();

        AdaptadorWeather adaptor=new AdaptadorWeather(listacity);
        recyclerweather.setAdapter(adaptor);

        return vista;

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
