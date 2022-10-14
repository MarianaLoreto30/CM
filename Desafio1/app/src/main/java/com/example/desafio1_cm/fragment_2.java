package com.example.desafio1_cm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
public class fragment_2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText editText;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_2 newInstance(String param1, String param2) {
        fragment_2 fragment = new fragment_2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2, container, false);

        editText =(EditText) v.findViewById(R.id.editTextNumber);
        int age=0;
        editText.setText(""+age);
        Button voltar = (Button) v.findViewById(R.id.Voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_1 fr = new fragment_1();
                FragmentChangeListener fc = (FragmentChangeListener) getActivity();
                fc.replaceFragment(fr);
            }
        });
        Button guardar = (Button) v.findViewById(R.id.Guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = Integer.parseInt(editText.getText().toString());

                fragment_1 fr = new fragment_1();
                FragmentChangeListener fc = (FragmentChangeListener) getActivity();
                fc.replaceFragment(fr);
            }
        });

        return v;
    }
}