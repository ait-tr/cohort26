import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Break and Continue examples");

//        Дано n, вводится пользователем с клавиатуры. Написать программу, которая вычисляет
//        сумму S = 2 + 4 + … + n.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number: ");
        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                continue;
            }
            sum = sum + i;
        }
        System.out.println(sum);


/*

//        Пользователь 10 раз вводит целые числа с клавиатуры,
//        при вводе отрицательного числа ввод чисел необходимо прекратить.



        for (int i = 0; i < 10; i++) {
            System.out.println("Input number: ");
            int a = scanner.nextInt();
            if (a < 0) {
                break;
            }
        }


        for (int i = 0; i < 10; i++) {
            if (i == 4) { // условие, при котором
                continue; // пропускаем один проход цикла
            }
            System.out.println(i);
        }

        System.out.println();

        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
            if (i == 5) {
                break; // выброс из цикла на строку, следующую после цикла
            }
        }
        System.out.println("The end of loop");

 */
    }
}