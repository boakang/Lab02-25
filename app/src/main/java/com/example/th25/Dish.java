package com.example.th25;

public class Dish {
    private String name;
    private int thumbnail;
    private boolean isPromotion;

    public Dish(String name, int thumbnail, boolean isPromotion) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.isPromotion = isPromotion;
    }

    public String getName() { return name; }
    public int getThumbnail() { return thumbnail; }
    public boolean isPromotion() { return isPromotion; }
}

