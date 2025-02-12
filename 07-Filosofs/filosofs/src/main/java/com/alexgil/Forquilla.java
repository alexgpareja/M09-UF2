package com.alexgil;

public class Forquilla {

    // Propietats
    private final int num;
    private boolean enUs;

    // Constructor per defecte
    public Forquilla(int num) {
        this.num = num;
        enUs = false;
    }

    // Getters i setters
    public int getNum() {
        return num;
    }

    public boolean isEnUs() {
        return enUs;
    }

    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }
}
