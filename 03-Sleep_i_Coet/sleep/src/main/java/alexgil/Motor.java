package alexgil;

import java.util.Random;

public class Motor extends Thread {

    int potenciaActual;
    int potenciaObjectiu;
    int id;
    boolean funcionant;

    public Motor(int id) {
        super();
        this.id = id;
        potenciaActual = 0;
        potenciaObjectiu = 0;
        funcionant = true;
    }

    public int getPotenciaActual() {
        return potenciaActual;
    }

    public void setPotenciaActual(int potenciaActual) {
        this.potenciaActual = potenciaActual;
    }

    public int getPotenciaObjectiu() {
        return potenciaObjectiu;
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (funcionant) {

            if (potenciaActual != potenciaObjectiu) {

                potenciaActual += (potenciaActual < potenciaObjectiu) ? 1 : -1;

                String accio = (potenciaActual < potenciaObjectiu) ? "Incre."
                        : (potenciaActual > potenciaObjectiu) ? "Decre." : "FerRes";

                System.out.printf("%-4s: %s Objectiu: %d Actual: %d%n", getName(), accio, potenciaObjectiu,
                        potenciaActual);
            }

            try {
                // Retard aleatori entre 0 i 2 segons
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(getName() + ": Error " + e.getMessage());
            }

            if (potenciaActual == 0 && potenciaObjectiu == 0) {
                funcionant = false;
                System.out.printf("%-4s: Parat. Objectiu: %d Actual: %d%n", getName(), potenciaObjectiu,
                        potenciaActual);
            }
        }
    }
}