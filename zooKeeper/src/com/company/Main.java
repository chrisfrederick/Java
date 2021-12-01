package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Mammal mammal = new Mammal();
        Gorilla gorilla = new Gorilla();
        Bat bat = new Bat();

        System.out.println(gorilla.throwSomething("baby"));
        System.out.println(gorilla.throwSomething("car"));
        System.out.println(gorilla.throwSomething("bike"));
        System.out.println(gorilla.eatBananas());
        System.out.println(gorilla.eatBananas());
        System.out.println(gorilla.climb());


        System.out.println(bat.attackTown());
        System.out.println(bat.attackTown());
        System.out.println(bat.attackTown());
        System.out.println(bat.eatHumans());
        System.out.println(bat.eatHumans());
        System.out.println(bat.fly());
        System.out.println(bat.fly());

    }
}
