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

    private void menjar() throws InterruptedException {
        // Intentar agafar les forquilles
        synchronized (forquillaEsquerra) {
            while (forquillaEsquerra.isEnUs()) {
                System.out.println("Filòsof: " + nom + " deixa l'esquerra(" + forquillaEsquerra.getNum()
                        + ") i espera (dreta ocupada)");
                Thread.sleep(random.nextInt(500) + 500); // Esperar entre 0.5s i 1s
            }
            forquillaEsquerra.setEnUs(true);
            System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + forquillaEsquerra.getNum());

            synchronized (forquillaDreta) {
                while (forquillaDreta.isEnUs()) {
                    System.out.println("Filòsof: " + nom + " deixa l'esquerra(" + forquillaEsquerra.getNum()
                            + ") i espera (dreta ocupada)");
                    Thread.sleep(random.nextInt(500) + 500); // Esperar entre 0.5s i 1s
                }
                forquillaDreta.setEnUs(true);
                System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + forquillaDreta.getNum());

                // Menjar
                System.out.println("Filòsof: " + nom + " menja");
                Thread.sleep(random.nextInt(1000) + 1000); // Menjar entre 1s i 2s

                // Deixar les forquilles
                forquillaDreta.setEnUs(false);
            }
            forquillaEsquerra.setEnUs(false);
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
