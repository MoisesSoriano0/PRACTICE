package com.example.admin.junglechallenge.Test.Jungle;

public abstract class Animal {

    int energy = 100;
//    String sound;
//    String eatFood;
//    String Sleep;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void makeSound(String sound) {
        energy -= 3;
    }

    public void eatFood(String eatFood) {
        this.energy += 5;
    }

    public void sleep(String sleep) {
        this.energy += 10;
    }
}
