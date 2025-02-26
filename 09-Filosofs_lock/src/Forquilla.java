import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private final int num;
    private final ReentrantLock bloqueig = new ReentrantLock();

    public Forquilla(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void agafar() {
        bloqueig.lock();
    }

    public void deixar() {
        if (bloqueig.isHeldByCurrentThread()) { // Comprovem si el fil actual té el lock
            bloqueig.unlock(); // Allibera la forquilla
        }
    }
}