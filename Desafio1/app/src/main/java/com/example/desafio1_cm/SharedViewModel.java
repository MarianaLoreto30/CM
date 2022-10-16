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

    public ArrayList<Animal> getAnimals() {
        return animals.getValue();
    }

    /*public ArrayList<Animal> getAnimals() {
        return animals;
    }*/

    public Animal getAnimal(int drawable) {
        for (Animal a: animals.getValue())
        {
            if(a.getPicture() == drawable){
                return a;
            }
        }
        return null;
    }

    public Animal getAnimalByPos(int pos) {
        return animals.getValue().get(pos);
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

    public void changeAnimalByPos (int pos, int age, String name){
        Animal a = animals.getValue().get(pos);
        a.setAge(age);
        a.setName(name);
    }
}

