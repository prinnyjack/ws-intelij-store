package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
    private InputUtils() {

    }

    public static int readInt(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
                sc.nextLine();
            }
        }
    }

    public static double readDouble(Scanner sc) {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número.");
                sc.nextLine();
            }
        }
    }
}
