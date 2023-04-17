import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Coins on the table");
//        На столе лежат n монеток. Некоторые из них лежат вверх решкой, а некоторые – гербом.
//        Определите минимальное число монеток, которые нужно перевернуть, чтобы все монетки были повернуты
//        вверх одной и той же стороной.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of coins: ");
        int n = scanner.nextInt();
        ArrayList<Integer> coinsList = new ArrayList<>();
        // задумаем как лежат монеты
        for (int i = 0; i < n; i++) {
            int coin = (int)(Math.random() * (1 - 0 + 1) + 0);
            coinsList.add(i, coin);
        }
        System.out.println(coinsList);
        int tails = 0;
        int eagles = 0;
        // посчитаем колличество решек - нулей
        for (int i = 0; i < coinsList.size(); i++) {
            if (coinsList.get(i) == 0) {
                tails++;
            }
        }
        System.out.println("Tails: " + tails);

        // посчитаем колличество орлов - единиц
        for (int i = 0; i < coinsList.size(); i++) {
            if (coinsList.get(i) == 1) {
                eagles++;
            }
        }
        System.out.println("Eagles: " + eagles);

        int result = min(tails, eagles);

        System.out.println("Minimal number of coins for turnover is: " + result);
    }
    //___________Methods_____________
    // метод находит мимнимальное из двух чисел
    public static int min(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }

    //___________end Methodds________
}