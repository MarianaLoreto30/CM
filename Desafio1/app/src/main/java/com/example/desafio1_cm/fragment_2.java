package com.example.desafio1_cm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_2 extends Fragment{

    private SharedViewModel model;

    private EditText editTextAge;
    private EditText editTextName;
    private int id;
    private FragmentChangeListener fcl;

    public fragment_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment fragment_2.
     */
    public static fragment_2 newInstance(/*int id*/) {
        fragment_2 fragment = new fragment_2();

        //String name = getArguments().getString("ARG_NAME");

        /*Bundle args = new Bundle();
        args.putInt(ARG_AGE, age);
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);*/

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_2, container, false);
        fcl = (MainActivity) inflater.getContext();
        //model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        this.model = new ViewModelProvider(getActivity()).get(SharedViewModel.class);

        Animal a = model.getAnimal(id);

        editTextAge =(EditText) v.findViewById(R.id.editTextNumber);
        editTextAge.setText(""+a.getAge());

        editTextName =(EditText) v.findViewById(R.id.editTextTextPersonName);
        editTextName.setText(a.getName());

        Button voltar = (Button) v.findViewById(R.id.Voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_1 fr = new fragment_1();
                fcl.replaceFragment(fr);
            }
        });

        Button guardar = (Button) v.findViewById(R.id.Guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = Integer.parseInt(editTextAge.getText().toString());
                String name = editTextName.getText().toString();
                model.changeAnimal(id,age,name);

                fragment_1 fr = new fragment_1();
                fcl.replaceFragment(fr);
            }
        });

        return v;
    }
}