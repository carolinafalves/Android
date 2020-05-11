package com.example.fragmentosexemplo;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NovoFragment extends Fragment {


    public NovoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // antes de meter o botão a funcionar
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_novo, container, false);


        // depois de ter o botão a funcionar
        // obter a view do fragemtno
        View view = inflater.inflate(R.layout.fragment_novo, container, false);
        //linkar com o componente da view
        Button b = (Button) view.findViewById(R.id.btnFragmento);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //o contexto é obtido de diferente forma
                Toast.makeText(getActivity().getApplicationContext(), // pegar o contexto
                        "Estou no fragmento!!", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
