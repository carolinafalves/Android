package com.example.smartgarden1.ui.garden;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgarden1.HortasModel;
import com.example.smartgarden1.MyAdapterGarden;
import com.example.smartgarden1.R;

import java.util.ArrayList;
import java.util.List;

public class GardenFragment extends Fragment {

    private GardenViewModel gardenViewModel;

    RecyclerView hortasRV;
    List<GardenViewModel> data = new ArrayList<>();

    Button btnadd;
    //EditText novahorta;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gardenViewModel =
                ViewModelProviders.of(this).get(GardenViewModel.class);
        View root = inflater.inflate(R.layout.fragment_garden, container, false);
        hortasRV = root.findViewById(R.id.hortasRV);
        hortasRV.setLayoutManager(new LinearLayoutManager(getContext()));
        GardenViewModel gardenViewModel = new GardenViewModel();
        gardenViewModel.name = "HORTA 1";
        data.add(gardenViewModel);

        //GardenViewModel gardenViewModelA = new GardenViewModel();
        //gardenViewModelA.name = "HORTA 2";
        //data.add(gardenViewModelA);
        MyAdapterGarden myAdapterGarden = new MyAdapterGarden(data, getContext());
        hortasRV.setAdapter(myAdapterGarden);

        //btnadd = root.findViewById(R.id.btnadd);
        //novahorta = root.findViewById(R.id.hortaName);


        return root;
    }
}
