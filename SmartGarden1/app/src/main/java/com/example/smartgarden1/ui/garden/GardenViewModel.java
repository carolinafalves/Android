package com.example.smartgarden1.ui.garden;

import android.widget.Button;

import androidx.lifecycle.ViewModel;

import com.example.smartgarden1.HortasModel;

import java.util.List;

public class GardenViewModel extends ViewModel {

    public String name;

    public GardenViewModel(){}
    public GardenViewModel(HortasModel hortasModel) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}