package com.alexgil;

import java.util.Random;

public class Soci extends Thread {

    private String nomSoci; // Per identificar als socis

    private static Compte COMPTE;
    private static final float APORTACIO = 10f;
    private static final int ESPERA_MAX = 100;
    private final Random rnd;
    private static final int MAX_ANYS = 10;

    public Soci(String nomSoci) {
        this.nomSoci = nomSoci;
        COMPTE = Compte.getInstance(); // En majuscula perque crida a un metode de CLASE
        this.rnd = new Random();
    }

    public Compte getCompte() {
        return COMPTE;
    }

    public String getNomSoci() {
        return nomSoci;
    }

    @Override
    public void run() {
        // s’itera al llarg dels anys que van fins a maxAnys
        for (int any = 0; any < MAX_ANYS; any++) {

            // s’itera al llarg dels mesos
            for (int mes = 0; mes < 12; mes++) {
                // als mesos parells suma 10, als imparells resta 10
                COMPTE.setSaldo((mes % 2 == 0) ? COMPTE.getSaldo() + APORTACIO : COMPTE.getSaldo() - APORTACIO);

                try {
                    Thread.sleep(rnd.nextInt(ESPERA_MAX)); // Temps aleatori, de 0 a ESPERA MAX
                } catch (InterruptedException e) {
                    System.err.println("Error en el metode run del soci: " + getNomSoci());
                }
            }
        }
    }

}
