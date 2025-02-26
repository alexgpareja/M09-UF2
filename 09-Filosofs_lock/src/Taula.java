public class Taula {
    private final Filosof[] filosofs;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {

        // Inicialitzar els arrays
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        // Crear les forquilles
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        // Crear els filòsofs i assignar les forquilles a cada un
        for (int i = 0; i < numFilosofs; i++) {
            Forquilla forquillaEsquerra = forquilles[i];
            Forquilla forquillaDreta = forquilles[(i + 1) % numFilosofs];
            filosofs[i] = new Filosof("Fil" + i, forquillaEsquerra, forquillaDreta);
        }
    }

    // Mètode per mostrar la taula
    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println("Comensal:" + filosofs[i].getName() + " esq:" + forquilles[i].getNum() + " dret:"
                    + forquilles[(i + 1) % filosofs.length].getNum());
        }
        System.out.println("-----------------------------");
    }

    // Mètode per iniciar els fils dels filòsofs
    public void cridarATaula() {
        for (Filosof filosof : filosofs) {
            filosof.start();
        }
    }

    // Mètode principal
    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}