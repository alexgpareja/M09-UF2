import java.util.Random;

public class Filosof extends Thread {
    private final String nom;
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;
    private long iniciGana;
    private long fiGana;
    private long gana;
    private Random random;

    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
        this.random = new Random(); // Inicialitzem l'objecte Random
    }

    // Mètode per agafar les forquilles
    public void agafarForquilles() {
        forquillaEsquerra.agafar();
        forquillaDreta.agafar();
        System.out.println(
                nom + " té forquilles esq(" + forquillaEsquerra.getNum() + ") dreta(" + forquillaDreta.getNum() + ")");

    }

    // Mètode per deixar les forquilles
    public void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.println(nom + " deixa les forquilles");

    }

    // Mètode per menjar
    public void menjar() throws InterruptedException {
        agafarForquilles(); // Intenta agafar les forquilles
        calcularGana(); // Calcula el temps de gana
        System.out.println(nom + " menja amb gana " + gana + " segons");
        Thread.sleep(1000 + random.nextInt(1000)); // Temps de menjar entre 1s i 2s
        System.out.println(nom + " ha acabat de menjar");
        resetGana(); // Reseteja el temps de gana
        deixarForquilles(); // Deixa les forquilles
    }

    // Mètode per pensar
    public void pensar() throws InterruptedException {
        iniciGana = System.currentTimeMillis(); // Inicia el comptador de gana
        System.out.println(nom + " està pensant 🤔");
        Thread.sleep(1000 + random.nextInt(1000)); // Temps de pensar entre 1s i 2s
    }

    // Mètode per calcular la gana
    public void calcularGana() {
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000; // Calcula el temps de gana en segons
    }

    // Mètode per resetar la gana
    public void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar(); // El filòsof pensa
                menjar(); // El filòsof menja
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura l'estat d'interrupció
        }
    }
}