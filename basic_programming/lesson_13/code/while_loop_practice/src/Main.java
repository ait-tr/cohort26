import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Цифры, из которых состоит число");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input positive number: ");
        int num = scanner.nextInt();



    }
}







//    int i = 1;
//        while (num % 10 > 0 ) {
//                int digit = num % 10;
//                System.out.println(i + " цифра числа " + digit);
//                int div = num / 10;
//                num = (num - digit)/10;
//                i++;
//                }