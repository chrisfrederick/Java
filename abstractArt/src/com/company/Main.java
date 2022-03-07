package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Painting painting1 = new Painting("Oil");
        Painting painting2 = new Painting("watercolor");
        Painting painting3 = new Painting("Spray");

        Sculpture sculpture1 = new Sculpture("Stone");
        Sculpture sculpture2 = new Sculpture("Clay");

        System.out.println(painting1.viewArt());
        System.out.println(painting2.viewArt());
        System.out.println(painting3.viewArt());

        System.out.println(sculpture1.viewArt());
        System.out.println(sculpture2.viewArt());
    }
}
