import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {

    // Propietats
    private Queue<Client> salaEspera;
    private int maxCadires;
    private Object condBarber;
    private static Barberia instance;

    // Constructor
    private Barberia(int maxCadires) {
        this.maxCadires = maxCadires;
        this.condBarber = new Object();
        this.salaEspera = new LinkedList<Client>();
    }

    // Getter
    public Object getCondBarber() {
        return condBarber;
    }

    // Per tenir una instancia unica de la barberia
    public static Barberia getInstance(int maxCadires) {
        if (instance == null) {
            instance = new Barberia(maxCadires);
        }
        return instance;
    }

    public Client seguentClient() {
        synchronized (salaEspera) {
            return salaEspera
                    .poll(); // Torna el primer client de la cua o null si no n'hi ha
        }
    }

    public void entrarClient(Client client) {
        synchronized (salaEspera) {
            if (salaEspera
                    .size() < maxCadires) {
                salaEspera
                        .add(client);
                System.out.println("Client " + client.getId() + " en espera");
                synchronized (condBarber) {
                    condBarber.notify(); // Desperta al barber
                }
            } else {
                System.out.println("No queden cadires, client " + client.getId() + " se'n va");
            }
        }
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            Client client = new Client(i);
            entrarClient(client);
            try {
                Thread.sleep(500); // Espera 0,5 segons entre clients
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            Thread.sleep(10000); // Espera 10 segons
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (int i = 11; i <= 20; i++) {
            Client client = new Client(i);
            entrarClient(client);
            try {
                Thread.sleep(500); // Espera 0,5 segons entre clients
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Main
    public static void main(String[] args) {
        Barberia barberia = Barberia.getInstance(3); // Crear una barberia amb 3 cadires
        Barber barber = new Barber("Barber Pepe", barberia);

        Thread barberThread = new Thread(barber);
        Thread barberiaThread = new Thread(barberia);

        barberThread.start();
        barberiaThread.start();
    }
}
