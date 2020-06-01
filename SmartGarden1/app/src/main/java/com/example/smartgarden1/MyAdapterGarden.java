package com.example.smartgarden1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgarden1.databinding.HortasBinding;
import com.example.smartgarden1.ui.garden.GardenFragment;
import com.example.smartgarden1.ui.garden.GardenViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterGarden extends RecyclerView.Adapter<MyAdapterGarden.MyAdapter>{

    List<GardenViewModel> data;
    Context context;
    private LayoutInflater inflater;

    public MyAdapterGarden(List<GardenViewModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater==null) {
            inflater=LayoutInflater.from(parent.getContext());
        }
        HortasBinding hortasBinding = HortasBinding.inflate(inflater, parent, false);
        return new MyAdapter(hortasBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, int position) {
        holder.bind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {

        private HortasBinding  hortasBinding;

        public MyAdapter(HortasBinding hortasBinding) {
            super(hortasBinding.getRoot());
            this.hortasBinding=hortasBinding;
        }

        public void bind(GardenViewModel gardenViewModel) {
            this.hortasBinding.setViewModel(gardenViewModel);
        }

        public HortasBinding getHortasBinding () {
            return hortasBinding;
        }
    }
}
