public class Barri {
    private Estanc estanc;
    private Fumador[] fumadors;

    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];
        for (int i = 0; i < fumadors.length; i++) {
            fumadors[i] = new Fumador(estanc, i + 1);
        }
    }

    public void iniciarDia() {
        Thread estancThread = new Thread(estanc::run);
        estancThread.start();

        Thread[] fumadorThreads = new Thread[fumadors.length];
        for (int i = 0; i < fumadors.length; i++) {
            fumadorThreads[i] = new Thread(fumadors[i]);
            fumadorThreads[i].start();
        }

        for (Thread thread : fumadorThreads) {
            try {
                thread.join(); // Esperem que tots els fumadors acabin
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        estanc.tancarEstanc();
        try {
            estancThread.join(); // Esperem que l'estanc acabi
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.iniciarDia();
    }
}