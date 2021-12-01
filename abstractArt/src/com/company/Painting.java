package com.company;

public class Painting extends Art{
    private String paintType;

    public Painting(String paintType){
        this.paintType = paintType;
    }

    public String getPaintType() {
        return paintType;
    }

    public void setPaintType(String paintType) {
        this.paintType = paintType;
    }

    @Override
    public String viewArt() {
        return "This painting was created using "+getPaintType()+" paint";
    }
}
