package alexgil;

import java.util.Random;

public class Motor extends Thread {

    int potenciaActual;
    int potenciaObjectiu;
    int id;

    public Motor(int id) {
        super("Motor " + id); // Assigna un nom al fil
        this.id = id;
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            if (potenciaActual != potenciaObjectiu) {
                potenciaActual += (potenciaActual < potenciaObjectiu) ? 1 : -1;
                String accio = (potenciaActual < potenciaObjectiu) ? "Incre." : "Decre.";
                System.out.printf("%-8s: %s Objectiu: %d Actual: %d%n", getName(), accio, potenciaObjectiu,
                        potenciaActual);
            }

            try {
                // Retard aleatori entre 0 i 2 segons
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(getName() + ": Error " + e.getMessage());
            }

            if (potenciaObjectiu == 0 && potenciaActual == 0) {
                System.out.printf("%-8s: Parat. Objectiu: %d Actual: %d%n", getName(), potenciaObjectiu,
                        potenciaActual);
                break; // Atura el fil quan la potència arriba a 0
            }

            // Pausa de 100 ms si la potència està estabilitzada
            if (potenciaActual == potenciaObjectiu) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(getName() + ": Error " + e.getMessage());
                }
            }
        }
    }
}
