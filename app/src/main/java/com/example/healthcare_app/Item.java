package com.example.healthcare;

public class Item {
    private String name;
    private String speciality;
    private int imageResId;

    public Item(String name, String speciality, int imageResId) {
        this.name = name;
        this.speciality = speciality;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public int getImageResId() {
        return imageResId;
    }
}
