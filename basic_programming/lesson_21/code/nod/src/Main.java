import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Наибольший общий делитель");
// Алгоритм
//        Шаг 1 - сравниваем данные 2 числа, находим меньшее из них (если есть делители общие, то они <= этому числу)'
//        Шаг 2 - перебираем в цикле числа от 1 до меньшего и проверяем разделилось нацело ли мешьшее из чисел на пареметр цикла
//        Шаг 3 - если большее из чисел разделилось тоже, то это и есть наш НОД
//        24 и 40
//        меньшее 24
//        перебираем числа от 1 до 24 (включительно), 1, 2, 3, 4, 5, ... , 8 , ..., 24
//        Делится ли 24 на одно из этих чисел? Если да, то проверяем, 40 делиться на это же число.

        Scanner scanner = new Scanner(System.in);

        int nod =0;

        System.out.println("Input 1st number: ");
        int a = scanner.nextInt();
        System.out.println("Input 2nd number: ");
        int b = scanner.nextInt();

        int min = min(a, b);
        int max = max(a, b);

        for (int i = 1; i <= min ; i++) {
            if (min % i == 0) {
                if (max % i == 0) {
                    nod = i;
                }
            }
        }

        System.out.println("НОД чисел " + a + ", " + b + " = " + nod);



    }
    public static int min(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }
    public static int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
}