package com.alexgil;

public class Administracio extends Thread {

    // Propietats
    private static final int NUM_POBLACIO_ACTIVA = 50;
    private Treballador[] poblacio_activa;

    // Constructor
    public Administracio() {
        poblacio_activa = new Treballador[NUM_POBLACIO_ACTIVA];

        // Inicialitza els treballadors
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + (i + 1), 25000, 20, 65);
        }
    }

    // Metode principal on els fica en marxa i mostra les estadístiques
    public static void main(String[] args) {

        // Crear i inicialitzar la instància d'Administració
        Administracio administracio = new Administracio();

        // Inicia tots els treballadors
        for (Treballador treballador : administracio.poblacio_activa) {
            treballador.start();
        }

        // Espera que tots els treballadors acabin
        for (Treballador treballador : administracio.poblacio_activa) {
            try {
                treballador.join();
            } catch (InterruptedException e) {
                System.out.println(treballador.getName() + ": Interromput");
            }
        }

        // Mostra els resultats
        for (Treballador treballador : administracio.poblacio_activa) {
            System.out.printf("%s -> edat: %d / total: %.2f%n",
                    treballador.getName(), treballador.getEdat(), treballador.getCobrat());
        }
    }
}
