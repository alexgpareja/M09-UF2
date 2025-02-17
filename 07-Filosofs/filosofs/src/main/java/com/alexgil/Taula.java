package com.alexgil;

public class Taula {

    // Propietats
    private Filosof[] comensals;
    private Forquilla[] forquilles;

    // Constructor
    public Taula(int numFilosofs) {

        // Inicialitzar els arrays
        forquilles = new Forquilla[numFilosofs];
        comensals = new Filosof[numFilosofs];

        // Crear forquilles
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        // Creem els filòsofs i assignem les forquilles
        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs]; // La forquilla dreta és la següent (o la 0 si és
                                                                 // l'últim)
            comensals[i] = new Filosof("fil" + i, esquerra, dreta);
        }
    }

    // Mètode per mostrar la taula i la relació filòsofs - forquilles
    public void showTaula() {
        for (Filosof comensal : comensals) {
            System.out
                    .println("Comensal: " + comensal.getName() + " esq: " + comensal.getForquillaEsquerra().getNum()
                            + " dret: " + comensal.getForquillaDreta().getNum());
        }
    }

    // Mètode per iniciar el sopar
    public void cridarAtaula() {
        for (Filosof comensal : comensals) {
            comensal.start();
        }
    }

    // Mètode principal
    public static void main(String[] args) {
        Taula taula = new Taula(4); // Crear una taula amb 4 filòsofs
        taula.showTaula();
        taula.cridarAtaula();
    }
}
