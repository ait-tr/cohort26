import java.util.Scanner;
public class Power3 {
    public static void main(String[] args) {

        int number = 3; // Возводимое в степень число
        int result = 1; // Результат возведения числа 3 в степень
        int power = 1; // Начальный показатель степени

        while( power <= 10 ) { // условие входа в цикл
            result = result * number; // result *= number;
            System.out.println(number + " в степени " + power + " = " + result);
            ++power; // power = power + 1;
        }

    }
}







//       System.out.println("Цифры, из которых состоит число");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input positive number: ");
//        int num = scanner.nextInt();

//    int i = 1;
//        while (num % 10 > 0 ) {
//                int digit = num % 10;
//                System.out.println(i + " цифра числа " + digit);
//                int div = num / 10;
//                num = (num - digit)/10;
//                i++;
//                }