package com.company;

public class Sculpture extends Art{
    private String material;

    public Sculpture(String material){
        this.material=material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String viewArt() {
        return "This sculpture was created using "+getMaterial()+" paint";
    }
}
