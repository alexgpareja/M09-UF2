package com.alexgil;

public class Associacio {

    private static final int NUM_SOCIS = 1000;
    private Soci socis[];

    public Associacio() {
        socis = new Soci[NUM_SOCIS];

        // Inicialitza els socis
        for (int i = 0; i < NUM_SOCIS; i++) {
            socis[i] = new Soci("Soci " + (i + 1));
        }
    }

    // Mètode per iniciar tots els socis (simula la seva activitat)
    public void iniciaCompteTempsSocis() {
        for (Soci soci : socis) {
            soci.start();
        }
    }

    // Mètode per esperar que tots els socis acabin
    public void esperaPeriodeSocis() {
        for (Soci soci : socis) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                System.err.println("Error en el esperaPeriodeSocis del " + soci.getNomSoci());
            }
        }
    }

    // Mètode per mostrar el balanç final del compte
    public void mostraBalancComptes() {
        System.out.printf("Saldo final del compte: %.2f€%n", Compte.getInstance().getSaldo());
    }

    // Mètode principal
    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }

}
