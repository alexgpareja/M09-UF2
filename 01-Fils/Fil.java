public class Fil extends Thread {
    private String name;

    public Fil(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(name + " " + i);
            try {
                // Posem el fil en sleep per a que es vagin intercal·lant
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("El fil ha estat interromput.");
            }
        }
        System.out.println("Termina el fil " + name);
    }
}
