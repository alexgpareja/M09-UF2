package alexgil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Coet {
    public static Motor[] motors = new Motor[4];

    public static void main(String[] args) {

        // Crear motors
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }

        // Iniciar els motors una vegada
        arranca();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                int p = Integer.parseInt(reader.readLine());

                if (p < 0 || p > 10) {
                    System.out.println("Error: La potència ha d'estar entre 0 i 10.");
                    continue;
                }

                passaAPotencia(p);
                System.out.printf("Passant a potencia: %d\n", p);

                if (p == 0) {
                    System.out.println("Simulació acabada.");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Si us plau, introdueix un nombre vàlid.");
            }
        }
    }

    public static void passaAPotencia(int p) {
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public static void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }
}
