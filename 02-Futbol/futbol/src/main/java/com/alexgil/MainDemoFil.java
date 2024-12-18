package com.alexgil;

public class MainDemoFil {
    public static void main(String[] args) {
        // Captura del fil actual
        Thread filActual = Thread.currentThread();

        // Mostra informació del fil
        System.out.println("MainDemoFil.main:");
        System.out.println("Prioritat -> " + filActual.getPriority());
        System.out.println("Nom -> " + filActual.getName());
        System.out.println("toString() -> " + filActual.toString());
    }
}
