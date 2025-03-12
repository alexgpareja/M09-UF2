public class Client {

    // Propietats
    private int id;

    // Constructor
    public Client(int id) {
        this.id = id;
    }

    // Getter
    public int getId() {
        return id;
    }

    // Metodes
    public void tallarseElCabell(Client client) throws InterruptedException {
        System.out.println("Tallant cabell a client " + client.getId());
        Thread.sleep(900 + (long) (Math.random() * 100)); // Tallar cabell entre 0,9s i 1s
    }
}
