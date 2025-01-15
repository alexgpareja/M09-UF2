package alexgil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coet {
    public static Motor[] motors = new Motor[4];

    public static void main(String[] args) throws IOException {

        // Crear motors
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Primer cas aka especial
        System.out.println("Potencia inicial: ");
        int p = Integer.parseInt(reader.readLine());

        passaAPotencia(p);
        System.out.printf("Passant a potència: %d%n", p);

        arranca(); // Una unica vegada

        while (true) {
            try {
                if (p < 0 || p > 10) {
                    System.out.println("Error: La potència ha d'estar entre 0 i 10.");
                    continue;
                }

                passaAPotencia(p);
                System.out.printf("Passant a potència: %d%n", p);

                if (p == 0) {
                    break;
                }

                p = Integer.parseInt(reader.readLine()); // En qualsevol moment pot demanar una potencia objectiu
                                                         // nova

            } catch (Exception e) {
                System.out.println(": Error en el coet: " + e.getMessage());
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
