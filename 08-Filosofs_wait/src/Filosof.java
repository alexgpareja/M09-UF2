import java.util.Random;

public class Filosof extends Thread {

    // Propietats
    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private Random random;

    // Constructor
    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.random = new Random();
    }

    // Getters
    public String getNom() {
        return nom;
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
