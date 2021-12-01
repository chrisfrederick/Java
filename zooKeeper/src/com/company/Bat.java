package com.company;

public class Bat extends Mammal{
    private int energy = 300;


    public int getEnergy(){
        return energy;
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }





    public String fly(){
        setEnergy(getEnergy()-50);
        return "The bat is flying! Fwoop, fwoop, fwoop. Its energy dropped to " + getEnergy();
    }

    public String eatHumans(){
        setEnergy(getEnergy()+25);
        return "The bat ate some Humans! Its energy increased to " + getEnergy();
    }

    public String attackTown(){
        setEnergy(getEnergy()-100);
        return "The Bat is attacking the town! Its energy dropped to " + getEnergy();

    }


}
