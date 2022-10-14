package com.example.desafio1_cm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements FragmentChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Animal a1 = new Animal("olaf", R.drawable.frog, 12, "Andre");
        //Animal a2 = new Animal("sven", R.drawable.rhino, 12, "Mariana");
        //Animal a3 = new Animal("elsa", R.drawable.snail, 12, "Pedro");

        ArrayList<Animal> allAnimals = new ArrayList<>();
        allAnimals.add(new Animal("olaf", R.drawable.frog, 12, "Andre"));
        allAnimals.add(new Animal("sven", R.drawable.rhino, 12, "Mariana"));
        allAnimals.add(new Animal("elsa", R.drawable.snail, 12, "Pedro"));

        SharedViewModel model  = new ViewModelProvider(this).get(SharedViewModel.class);
        model.setAnimals(allAnimals);

        //create a fragment object
        fragment_2 f = new fragment_2();
        replaceFragment(f);

        //fragment_2 f = fragment_2.newInstance(0);

    }

    @Override
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FragC, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }
}