import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    private List<Tabac> tabacList;
    private List<Paper> paperList;
    private List<Llumi> llumiList;
    private boolean obert;

    public Estanc() {
        this.tabacList = new ArrayList<>();
        this.paperList = new ArrayList<>();
        this.llumiList = new ArrayList<>();
        this.obert = true;
    }

    public synchronized void nouSubministrament() {
        Random random = new Random();
        int opcio = random.nextInt(3); // Genera un número aleatori entre 0 i 2

        switch (opcio) {
            case 0:
                addTabac(new Tabac("Lucky Strike"));
                break;
            case 1:
                addPaper(new Paper("Raw King Size"));
                break;
            case 2:
                addLlumi(new Llumi("Clipper"));
                break;
        }
        notifyAll(); // Notifiquem als fumadors que hi ha nous recursos
    }

    public synchronized void addTabac(Tabac tabac) {
        tabacList.add(tabac);
        System.out.println("Afegint Tabac");
    }

    public synchronized void addPaper(Paper paper) {
        paperList.add(paper);
        System.out.println("Afegint Paper");
    }

    public synchronized void addLlumi(Llumi llumi) {
        llumiList.add(llumi);
        System.out.println("Afegint Llumí");
    }

    public synchronized Tabac venTabac() throws InterruptedException {
        while (tabacList.isEmpty() && obert) {
            wait(); // Esperem fins que hi hagi tabac disponible
        }
        if (!obert) {
            return null; // Si l'estanc està tancat, no podem vendre res
        }
        return tabacList.remove(0);
    }

    public synchronized Paper venPaper() throws InterruptedException {
        while (paperList.isEmpty() && obert) {
            wait(); // Esperem fins que hi hagi paper disponible
        }
        if (!obert) {
            return null; // Si l'estanc està tancat, no podem vendre res
        }
        return paperList.remove(0);
    }

    public synchronized Llumi venLlumi() throws InterruptedException {
        while (llumiList.isEmpty() && obert) {
            wait(); // Esperem fins que hi hagi llumins disponibles
        }
        if (!obert) {
            return null; // Si l'estanc està tancat, no podem vendre res
        }
        return llumiList.remove(0);
    }

    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll(); // Despertem tots els threads perquè puguin acabar
    }

    public void run() {
        Random random = new Random();
        while (obert) {
            nouSubministrament();
            try {
                Thread.sleep(random.nextInt(1000) + 500); // Esperem entre 0,5 i 1,5 segons
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}