package com.company;

public class Gorilla extends Mammal{
    Mammal mammal = new Mammal();

    public String throwSomething(String item){
        mammal.setEnergy(mammal.getEnergy()-5);
        return "The Gorilla tossed a " + item + ". It's energy level dropped to " + mammal.getEnergy();
    }

    public String eatBananas(){
        mammal.setEnergy(mammal.getEnergy()+10);
        return "The Gorilla ate some bananas! Energy increased to " + mammal.getEnergy();
    }

    public String climb(){
        mammal.setEnergy(mammal.getEnergy()-10);
        return "The Gorilla has climbed a tree! Energy level dropped to " + mammal.getEnergy();
    }
}
