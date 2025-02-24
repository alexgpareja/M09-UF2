import java.util.Random;

public class Filosof extends Thread {

    // Propietats
    private int id;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private Random random;

    // Constructor
    public Filosof(int id, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.id = id;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.random = new Random();
    }

    // Getters i Setters
    public int getIdFilosof() {
        return id;
    }

    public void setIdFilosof(int id) {
        this.id = id;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }

    // Mètode menjar
    public void menjar() {
        agafarForquilles(); // Intenta agafar les forquilles
        System.out.printf("Filosof-%d està menjant 🍽️%n", id);
        try {
            Thread.sleep(1000 + random.nextInt(1000)); // Simula el temps de menjar (1-2s)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deixarForquilles(); // Deixa les forquilles després de menjar
    }

    // Mètode pensar
    public void pensar() {
        System.out.printf("Filosof-%d està pensant 🤔%n", id);
        try {
            Thread.sleep(1000 + random.nextInt(1000)); // Simula el temps de pensar (1-2s)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) { // Aquest bucle és necessari perquè els filòsofs continuïn pensant i menjant
            pensar();
            menjar();
        }
    }

    // Mètode per agafar una forquilla
    private void agafarForquilla(Forquilla forquilla) {
        synchronized (forquilla) {
            while (!forquilla.agafar(id)) {
                try {
                    forquilla.wait(); // Espera fins que la forquilla estigui disponible
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("Filosof-%d ha agafat la forquilla (%d)%n", id, forquilla.getNumero());
        }
    }

    // Mètode per deixar una forquilla
    private void deixarForquilla(Forquilla forquilla) {
        synchronized (forquilla) {
            forquilla.deixar(id);
            System.out.printf("Filosof-%d ha deixat la forquilla (%d)%n", id, forquilla.getNumero());
            forquilla.notifyAll(); // Notifica als altres filòsofs que la forquilla està disponible
        }
    }

    // Mètode per agafar les dues forquilles
    private void agafarForquilles() {
        agafarForquilla(forquillaEsquerra); // Intenta agafar la forquilla esquerra
        agafarForquilla(forquillaDreta); // Intenta agafar la forquilla dreta
    }

    // Mètode per deixar les dues forquilles
    private void deixarForquilles() {
        deixarForquilla(forquillaEsquerra); // Deixa la forquilla esquerra
        deixarForquilla(forquillaDreta); // Deixa la forquilla dreta
    }
}