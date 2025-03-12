import java.util.Random;

public class Fumador implements Runnable {
    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int numFumades;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
        this.numFumades = 0;
    }

    private void compraTabac() throws InterruptedException {
        tabac = estanc.venTabac();
        System.out.println("Fumador " + id + " ha comprat tabac.");
    }

    private void compraPaper() throws InterruptedException {
        paper = estanc.venPaper();
        System.out.println("Fumador " + id + " ha comprat paper.");
    }

    private void compraLlumi() throws InterruptedException {
        llumi = estanc.venLlumi();
        System.out.println("Fumador " + id + " ha comprat llumí.");
    }

    private void fuma() throws InterruptedException {
        if (tabac != null && paper != null && llumi != null) {
            System.out.println("Fumador " + id + " està fumant...");
            Thread.sleep((long) (Math.random() * 500 + 500)); // Fuma entre 0,5 i 1 segon
            tabac = null;
            paper = null;
            llumi = null;
            numFumades++;
        }
    }

    @Override
    public void run() {
        while (numFumades < 3) {
            try {
                compraTabac();
                compraPaper();
                compraLlumi();
                fuma();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Fumador " + id + " ha acabat de fumar.");
    }
}