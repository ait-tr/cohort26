import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ameba increasing");
//       Необходимо определить, сколько будет амёб через n часов, если первоначально была только одна амёба.
//       Одноклеточная амёба каждые 3 часа делится на 2 такие же амёбы.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input time in hours: ");
        int n = scanner.nextInt();
        n = n / 3; // сколько циклов по 3 часа прошло
        long sum = 1;
        System.out.println("Cycles by 3 hours: " + n);
        // необходимо посчитать сумму 1 + 2 + 4 + 8 + 16 + ... + 2^n
        for (int i = 0; i < n; i++) {
            sum = sum + pow2(i + 1);
//            System.out.println(sum);
        }
        System.out.println("Number of amoebas is: " + sum + " after " + n + " cycles.");
    }
    //__________Methods______________

    // Метод возвращает 2 в степени m
    public static long pow2(int m) {
        long res = 1;
        for (int i = 0; i < m; i++) {
            res = res * 2;
        }
        return res;
    }

    //_________and Methods __________
}