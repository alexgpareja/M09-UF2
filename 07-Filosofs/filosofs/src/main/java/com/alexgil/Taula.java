package com.alexgil;

import java.util.ArrayList;

public class Taula {

    // Propietats
    private Filosof[] comensals;
    private Forquilla[] forquilles;

    // Constructor
    public Taula(int numFilosofs) {

        // Crear forquilles
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        // Crear els filosofs
        for (int i = 0; i < numFilosofs; i++) {
            comensals[i] = new Filosof();
        }
    }

    // Mètode per mostrar la taula i la relació filòsofs - forquilles
    public void showTaula() {

    }

    // Mètode per iniciar el sopar
    public void cridarAtaula() {

    }

    // Mètode principal
    public static void main(String[] args) {
        Taula taula = new Taula(4); // Crear una taula amb 4 filòsofs
        taula.showTaula();
        taula.cridarAtaula();
    }
}
