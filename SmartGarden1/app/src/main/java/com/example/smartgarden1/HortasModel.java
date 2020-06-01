package com.example.smartgarden1;

import android.widget.ImageView;

public class HortasModel {

    private String name;

    public HortasModel (String name){
        this.name=name;
    }

    public HortasModel(){

    }
     public String getName(){
        return name;
     }
     public void setName(String name){
        this.name=name;

     }

}
