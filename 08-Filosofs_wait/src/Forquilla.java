public class Forquilla {

    // Propietats
    private int numero; // El numero de la forquilla
    private int propietari; // Quin filòsof la té (o LLIURE si ningú)
    private final int LLIURE = -1;

    // Constructor
    public Forquilla(int numero) {
        this.numero = numero;
        propietari = LLIURE; // Inicialment ningú la té
    }

    // Getters i Setters
    public int getNumero() {
        return numero;
    }

    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }
}
