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

    // Getters
    public int getIdFilosof() {
        return id;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    // Mètode menjar
    public void menjar() {
    }

    // Mètode pensar
    public void pensar() {
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }

    
}
