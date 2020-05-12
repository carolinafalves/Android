package com.example.hw2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdaptadorWeather extends RecyclerView.Adapter<AdaptadorWeather.ViewHolderWeather> {

    ArrayList<Weathercity> listaCity;

    public AdaptadorWeather(ArrayList<Weathercity> listaCity) {
        this.listaCity = listaCity;
    }

    @Override
    public ViewHolderWeather onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderWeather(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderWeather holder, int position){
        holder.city.setText(listaCity.get(position).getName());
        holder.foto.setImageResource(listaCity.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaCity.size();
    }

    public class ViewHolderWeather extends RecyclerView.ViewHolder {

        TextView city;
        ImageView foto;
        ImageButton arrow;

        public ViewHolderWeather(View itemView) {
            super(itemView);
            city= (TextView) itemView.findViewById(R.id.idName);
            foto= (ImageView) itemView.findViewById(R.id.idImage);
            arrow = (ImageButton) itemView.findViewById(R.id.goToFrag);
        }
    }
}
