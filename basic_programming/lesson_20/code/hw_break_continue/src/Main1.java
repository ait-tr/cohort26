import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Cube/coin throwing");
            // int n = (int)(Math.random() * (b - a + 1) + a) - случайное натуральное число в интервале [a, b]

        int n = 0;

        for (int i = 0; i < 20; i++) {
            n = (int)(Math.random() * (6 - 1 + 1) + 1);
            System.out.print(n + " | ");
        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            n = (int)(Math.random() * (1 - 0 + 1) + 0);
            System.out.print(n + " | ");
        }

    }
}

