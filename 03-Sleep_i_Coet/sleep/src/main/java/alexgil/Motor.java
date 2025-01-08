package alexgil;

import java.util.Random;

public class Motor extends Thread {

    int potenciaActual = 0;
    int potenciaObjectiu = 0;
    boolean funcionant = true;

    public Motor() {
        super();
    }

    public void setPotencia(int p) {
        potenciaObjectiu = p;
    }

    @Override
    public void run() {

        Random random = new Random();

        while (funcionant) {

            // Incrementa o decrementa la potència segons l'objectiu
            potenciaActual += (potenciaActual < potenciaObjectiu) ? 1 : (potenciaActual > potenciaObjectiu) ? -1 : 0;

            // Mostra l'estat actual del motor
            String accio = (potenciaActual < potenciaObjectiu) ? "Incre."
                    : (potenciaActual > potenciaObjectiu) ? "Decre." : "FerRes";
            System.out.printf("%-4s: %s Objectiu: %d Actual: %d", getName(), accio, potenciaObjectiu, potenciaActual);
        }
    }
}