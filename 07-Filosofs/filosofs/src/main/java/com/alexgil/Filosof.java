package com.alexgil;

import java.util.Random;

public class Filosof extends Thread {

    // Propietats
    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    private Random random;

    // Constructor
    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
        this.random = new Random();
    }

    public void menjar() {
        while (true) {
            // Intenta agafar la forquilla esquerra
            if (!forquillaEsquerra.isEnUs()) {
                forquillaEsquerra.setEnUs(true);
                System.out.printf("%s agafa la forquilla esquerra (%d)%n", getName(), forquillaEsquerra.getNum());

                // Intenta agafar la forquilla dreta
                if (!forquillaDreta.isEnUs()) {
                    forquillaDreta.setEnUs(true);
                    System.out.printf("%s agafa la forquilla dreta (%d)%n", getName(), forquillaDreta.getNum());

                    // Menjar
                    System.out.println(getName() + " menja");
                    try {
                        Thread.sleep(1000 + new Random().nextInt(1000)); // Simula el temps de menjar
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Deixar les forquilles després de menjar
                    forquillaDreta.setEnUs(false);
                    forquillaEsquerra.setEnUs(false);
                    System.out.println(getName() + " ha acabat de menjar");
                    return; // Sortir del bucle quan hagi menjat

                } else {
                    // Si la forquilla dreta està ocupada, deixa la forquilla esquerra i espera
                    System.out.printf("%s deixa l'esquerra (%d) i espera (dreta ocupada)%n",
                            getName(), forquillaEsquerra.getNum());
                    forquillaEsquerra.setEnUs(false);
                }
            }

            // No ha pogut menjar, espera abans de tornar a intentar-ho
            gana++;
            System.out.printf("%s gana=%d%n", getName(), gana);

            try {
                Thread.sleep(500 + new Random().nextInt(500)); // Espera entre 0.5s i 1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: " + nom + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000); // Pensar entre 1s i 2s
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar(); // Pensar
                menjar(); // Intentar menjar
            }
        } catch (InterruptedException e) {
            System.out.println("Filòsof: " + nom + " ha estat interromput.");
            Thread.currentThread().interrupt();
        }
    }

    // Getters i setters
    public String getNom() {
        return nom;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

}
