package com.example.desafio1_cm;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private SharedViewModel model;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageSlider imageSlider;

    public fragment_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_1.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_1 newInstance(String param1, String param2) {
        fragment_1 fragment = new fragment_1();
        //Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.model = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        ImageSlider imageSlider = (ImageSlider) view.findViewById(R.id.slide);
        ArrayList<SlideModel> slideModels= new ArrayList<SlideModel>();
        Animal a1 = model.getAnimal(R.drawable.frog);
        Animal a2 = model.getAnimal(R.drawable.rhino);
        Animal a3 = model.getAnimal(R.drawable.snail);

        String string_1 = a1.getName() + "\n" + a1.getAge() + "\n" + a1.getOwner();
        String string_2 = a2.getName() + "\n" + a2.getAge() + "\n" + a2.getOwner();
        String string_3 = a3.getName() + "\n" + a3.getAge() + "\n" + a3.getOwner();

        SlideModel first = new SlideModel(a1.getPicture(), string_1, ScaleTypes.FIT);
        SlideModel second = new SlideModel(a2.getPicture(), string_2, ScaleTypes.FIT);
        SlideModel third = new SlideModel(a3.getPicture(), string_3, ScaleTypes.FIT);
        // SlideModel fourth = new SlideModel(a1.getPicture(), string_1, ScaleTypes.FIT);

        slideModels.add(first);
        slideModels.add(second);
        slideModels.add(third);
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        Button edit = (Button) view.findViewById(R.id.edit_animal);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_2 fr = new fragment_2();
                FragmentChangeListener fc = (FragmentChangeListener) getActivity();
                fc.replaceFragment(fr);
            }
        });
        imageSlider.stopSliding();

        return view;
    }
}