package com.alexgil;

import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {

    private int MAX_PLACES = 10;
    private int placesDisponibles;
    private List<Assistent> assistents;

    // Constructor
    public Esdeveniment(int numPlaces) {
        placesDisponibles = (numPlaces > MAX_PLACES) ? MAX_PLACES : numPlaces;
        assistents = new ArrayList<>();
    }

    // Getter
    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    // Mètode per fer una reserva
    public synchronized void ferReserva(Assistent assistent) {
        while (placesDisponibles == 0) { // Esperar si no hi ha places
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(assistent.getNom() + " ha estat interromput mentre esperava plaça.");
                return;
            }
        }

        assistents.add(assistent);
        placesDisponibles--;
        System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
        notifyAll(); // Notificar que hi ha un canvi d'estat
    }

    // Mètode per cancel·lar una reserva
    public synchronized void cancelaReserva(Assistent assistent) {
        if (assistents.remove(assistent)) {
            placesDisponibles++;
            System.out.println(
                    assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll(); // Avisar als que estaven esperant plaça
        } else {
            System.out.println(assistent.getNom()
                    + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDisponibles);
        }
    }

}
