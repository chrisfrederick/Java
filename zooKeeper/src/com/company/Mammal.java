package com.company;

public class Mammal {
    private int energy = 100;


    public Mammal(){};

    public void setEnergy(int energy){
        this.energy = energy;
    }

    public int getEnergy(){
        return energy;
    }

    public String displayEnergyLevel(){
         return "Mammal energy is at: "+getEnergy();
    }


}
