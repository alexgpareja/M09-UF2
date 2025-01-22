package com.alexgil;

public class Compte extends Thread {

    private static Compte instancia; // Instància única (Singleton)
    private static float saldo;

    // Constructor privat per evitar que es creïn múltiples instàncies
    private Compte() {
        this.saldo = 0.0f; // Inicialització del saldo
    }

    // Mètode per obtenir la instància única del compte
    public static Compte getInstance() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    // Getters i setters
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        Compte.saldo = saldo;
    }

}