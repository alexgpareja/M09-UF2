package com.alexgil;

public class Futbolista extends Thread {

    // Propietats
    private int ngols = 0;
    private int ntirades = 0;

    // Constants
    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    // Constructor: només usa super per assignar el nom del jugador
    public Futbolista(String nom) {
        super(nom);
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public static void main(String[] args) {
        String[] nomsJugadors = {
                "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
                "Lewandoski", "Bellingham", "Arnau", "Aspas", "Messi", "Mbappé"
        };

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];

        System.out.println("Inici dels xuts --------------------");

        // Crear i iniciar fils
        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(nomsJugadors[i]);
            jugadors[i].start();
        }

        // Esperar a que acabin
        for (int i = 0; i < NUM_JUGADORS; i++) {
            try {
                jugadors[i].join();
            } catch (InterruptedException e) {
                System.err.println("Error esperant al fil: " + e.getMessage());
            }
        }

        System.out.println("Fi dels xuts -----------------------");

        // Mostrar estadístiques
        System.out.println("--- Estadístiques ------");
        for (int i = 0; i < NUM_JUGADORS; i++) {
            System.out.println(jugadors[i].getName() + " -> " + jugadors[i].getNgols() + " gols");
        }
    }
}
