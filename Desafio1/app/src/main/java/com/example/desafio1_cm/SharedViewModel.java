package com.example.desafio1_cm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Animal>> animals = new MutableLiveData<ArrayList<Animal>>();
    //private final ArrayList<Animal> animals = new ArrayList<>();

    public void setAnimals(ArrayList<Animal> allAnimals) {
        animals.setValue(allAnimals);
        //animals.addAll(allAnimals);
    }

    public LiveData getAnimals() {
        return animals;
    }

    /*public ArrayList<Animal> getAnimals() {
        return animals;
    }*/

    public Animal getAnimal(int drawable) {
        if(animals.getValue()==null){
            System.out.println(":)");
            return null;
        }
        for (Animal a: animals.getValue())
        {
            if(a.getPicture() == drawable){
                return a;
            }
        }
        return null;
    }

    public void changeAnimal(int drawable, int age, String name){
        for (Animal a: animals.getValue())
        {
            if(a.getPicture() == drawable){
                a.setAge(age);
                a.setName(name);
            }
        }
    }
}

