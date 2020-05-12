package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CidadesFragment cidadesFragment=new CidadesFragment();
        FragmentManager fn=getSupportFragmentManager();
        fn.beginTransaction().add(R.id.frame_container,cidadesFragment).commit();

    }
}
