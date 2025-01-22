package com.alexgil;

import java.util.Random;

public class Soci extends Thread {

    private String nom; // Per identificar als socis

    private final Compte compte;
    private static final float APORTACIO = 10f;
    private static final int ESPERA_MAX = 100;
    private final Random rnd;
    private static final int MAX_ANYS = 10;

    public Soci(String nom) {
        this.nom = nom;
        compte = Compte.getInstance(); // En majuscula perque crida a un metode de CLASE
        this.rnd = new Random();
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        // s’itera al llarg dels anys que van fins a maxAnys
        for (int any = 0; any < MAX_ANYS; any++) {

            // s’itera al llarg dels mesos
            for (int mes = 0; mes < 12; mes++) {

            }
        }
    }

}
