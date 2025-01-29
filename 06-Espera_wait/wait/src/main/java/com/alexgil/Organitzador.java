package com.alexgil;

public class Organitzador {

    public static void main(String[] args) {
        // Crear un esdeveniment amb 5 places màxim
        Esdeveniment esdeveniment = new Esdeveniment(5);

        // Crear i iniciar 10 assistents
        Assistent[] assistents = new Assistent[10];
        for (int i = 0; i < assistents.length; i++) {
            assistents[i] = new Assistent("Assistent-" + (i + 1), esdeveniment);
            assistents[i].start();
        }
    }

}
