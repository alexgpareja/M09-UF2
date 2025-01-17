package com.alexgil;

import java.util.Random;

public class Treballador extends Thread {

    // Propietats
    private final float nou_anual_brut;
    private final int edat_inici_treball;
    private final int edat_fi_treball;
    private int edat_actual;
    private float cobrat;

    private final Random rnd;

    // Constructor
    public Treballador(String nom, float nou_anual_brut, int edat_inici_treball, int edat_fi_treball) {
        super(nom);
        this.nou_anual_brut = nou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = edat_inici_treball;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    // Mètodes
    public void cobra() {
        cobrat += nou_anual_brut / 12;
    }

    public void pagaImpostos() {
        double paga = nou_anual_brut / 12;
        cobrat -= (paga * 0.24);
    }

    // Getters
    public int getEdat() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }

    @Override
    public void run() {

        for (edat_actual = edat_inici_treball; edat_actual < edat_fi_treball; edat_actual++) { // ANYS
            for (int j = 0; j < 12; j++) { // MESOS
                try {
                    cobra();
                    // System.out.printf("%s ha cobrat", getName());
                    sleep(10);
                    pagaImpostos();
                    // System.out.printf("%s ha pagat impostos", getName());
                    sleep(10);
                    // System.out.printf("%s -> edat: %d / total: %.2f%n", getName(), edat_actual,
                    // cobrat);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
