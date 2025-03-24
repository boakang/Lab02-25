package com.example.th25;

public class Dish {
    private String name;
    private int img;
    private boolean isPromotion;

    public Dish(String name, int img, boolean isPromotion) {
        this.name = name;
        this.img = img;
        this.isPromotion = isPromotion;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public boolean isPromotion() {
        return isPromotion;
    }
}
