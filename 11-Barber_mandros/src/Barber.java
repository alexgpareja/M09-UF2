public class Barber extends Thread {

    // Propietats
    private String name;
    private Barberia barberia;

    // Constructor
    public Barber(String name, Barberia barberia) {
        this.name = name;
        this.barberia = barberia;
    }

    // Getter
    public String getNom() {
        return name;
    }

    // Metodes
    @Override
    public void run() {
        while (true) {
            try {
                Client client = barberia.seguentClient();
                if (client != null) {
                    System.out.println("Li toca al Client " + client.getId());
                    client.tallarseElCabell(client);
                } else {
                    synchronized (barberia.getCondBarber()) {
                        System.out.println("Ningú en espera");
                        System.out.println(getNom() + " dormint");
                        barberia.getCondBarber().wait(); // Espera fins que arribi un client
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
