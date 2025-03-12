import java.util.LinkedList;
import java.util.Queue;

public class Barberia {

    // Propietats
    private Queue<Client> clients;
    private int maxCadires;
    private Object condBarber;
    private static Barberia instance;

    // Constructor
    private Barberia(int maxCadires) {
        this.maxCadires = maxCadires;
        this.condBarber = new Object();
        this.clients = new LinkedList<Client>();
    }

    // Per tenir una instancia unica de la barberia
    public static Barberia getInstance(int maxCadires) {
        if (instance == null) {
            instance = new Barberia(maxCadires);
        }
        return instance;
    }

    public Client seguentClient() {
        synchronized (clients) {
            return clients.poll(); // Torna el primer client de la cua o null si no n'hi ha
        }
    }
}
