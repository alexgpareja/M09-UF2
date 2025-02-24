public class Forquilla {

    // Propietats
    private int numero; // Número de la forquilla
    private int propietari; // ID del filòsof que té la forquilla
    public static final int LLIURE = -1; // Constant que indica que la forquilla està lliure

    // Constructor
    public Forquilla(int numero) {
        this.numero = numero;
        this.propietari = LLIURE; // Inicialment, la forquilla està lliure
    }

    // Mètode per agafar la forquilla
    public synchronized boolean agafar(int id) {
        if (propietari == LLIURE) { // Si la forquilla està lliure
            propietari = id; // Assigna la forquilla al filòsof
            return true; // Retorna true per indicar que s'ha agafat amb èxit
        }
        return false; // Retorna false si la forquilla ja està en ús
    }

    // Mètode per deixar la forquilla
    public synchronized boolean deixar(int id) {
        if (propietari == id) { // Si el filòsof que deixa la forquilla és el propietari
            propietari = LLIURE; // Allibera la forquilla
            return true; // Retorna true per indicar que s'ha deixat amb èxit
        }
        return false; // Retorna false si el filòsof no és el propietari
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public int getPropietari() {
        return propietari;
    }
}