package com.alexgil;

import java.util.Random;

public class Assistent extends Thread {

    private final String nom;
    private final Esdeveniment esdeveniment;
    private final Random rnd;

    // Constructor
    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
        this.rnd = new Random();
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        while (true) { // Bucle infinit
            try {
                boolean ferReserva = rnd.nextInt(2) == 0; // 50% probabilitat de reservar o cancel·lar

                if (ferReserva) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }

                Thread.sleep(rnd.nextInt(1000)); // Espera entre 0 i 1 segon

            } catch (InterruptedException e) {
                System.out.println(nom + " ha estat interromput.");
                break; // Interrompre el fil si cal
            }
        }
    }
}
