public class Principal {
    public static void main(String[] args) {
        System.out.println("Termina thread main");

        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");

        juan.setPriority(1);
        pepe.setPriority(10);

        juan.start();
        pepe.start();
    }
}
