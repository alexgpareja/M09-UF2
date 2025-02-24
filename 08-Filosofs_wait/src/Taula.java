public class Taula {

    // Propietats
    private Filosof[] comensals;
    private Forquilla[] forquilles;

    // Constructor
    public Taula(int numFilosofs) {
        // Inicialitzar els arrays
        comensals = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        // Crear les forquilles
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        // Crear els filòsofs i assignar les forquilles a cada un
        for (int i = 0; i < numFilosofs; i++) {
            comensals[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    // Mètode per mostrar la taula
    public void showTaula() {
        for (Filosof comensal : comensals) {
            System.out.printf("Filosof-%d → Forquilla esquerra: %d | Forquilla dreta: %d%n",
                    comensal.getIdFilosof(),
                    comensal.getForquillaEsquerra().getNumero(),
                    comensal.getForquillaDreta().getNumero());
        }
    }

    // Mètode per iniciar els fils dels filòsofs
    public void cridarATaula() {
        System.out.println("🍽️ Els filòsofs són cridats a taula!");
        for (Filosof comensal : comensals) {
            comensal.start();
        }
    }

    // Mètode principal
    public static void main(String[] args) {
        Taula taula = new Taula(4); // Crear una taula amb 4 filòsofs
        taula.showTaula(); // Mostrar l'estat inicial de la taula
        taula.cridarATaula(); // Iniciar els fils dels filòsofs
    }
}