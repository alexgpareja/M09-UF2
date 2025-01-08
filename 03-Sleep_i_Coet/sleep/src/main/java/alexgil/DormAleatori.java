package alexgil;

import java.util.Random;

public class DormAleatori extends Thread {

    // Propietat per guardar el moment de creació
    private long tempsInici;

    // Constructor que inicialitza amb la variable nom
    public DormAleatori(String name) {
        super(name); // Inicialitza amb un nom
        this.tempsInici = System.currentTimeMillis(); // Constancia de quan s'ha creat
    }

    @Override
    public void run() {

        Random random = new Random();

        // En l'execucio repeteix 10 vegades
        for (int i = 0; i < 10; i++) {

            // Interval aleatori
            int interval = random.nextInt(1000);
            
            // Temps actual
            long tempsActual = System.currentTimeMillis() - tempsInici;

            
            // Dorm el fil durant l'interval aleatori
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.err.println("El fil ha estat interromput: " + e.getMessage());
            }
            
            // Mostrar → nom, num_iteració, interval_aleatori, total de temps des de la
            // construcció
            System.out.printf("%-4s(%d) a dormir \t %dms total \t %d\n", getName(), i, interval, tempsActual);
        }
    }

    public static void main(String[] args) {
        // Crear les instàncies
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        // Iniciar els fils
        joan.start();
        pep.start();

        // Mostrar que s'acaba el main
        System.out.println("-- Fi de main -----------");
    }
}
