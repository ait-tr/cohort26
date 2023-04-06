import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Methods - examples");
        /*
        // вычисление числа в кубе
        int n = numberInCube(10);
        System.out.println(n);

        // вычиcление факториала 5! = 1*2*3*4*5 = 120
        int f = factorial(5);
        System.out.println(f);

        // минимум из двух чисел
        int m = min(30, 56);
        System.out.println(m);

        // печать строки n раз
        printStringNTimes("Java is the best language to earn money in programming!", 5);
*/
        // спрашиваем имя пользователя
        String user;
        user = inputUserName();
        user = nameCorrected(user);
        System.out.println("Hello, " + user + "!");

        //запрос у пользователя ввести натуральное число
        int num = inputIntPosNumber();
        System.out.println(num);

        // выясним, это простое число или не простое
        if (isPrime(num)) {
                System.out.println(num  + " is prime number.");
            } else {
            System.out.println(num  + " is NOT prime number.");
            }
        // Продолжить? yes/no
        if (letsDoItAgain()) {
            System.out.println("Great choice! Lets continue...");
        } else {
            System.out.println("Chao!...");
        }

    }

    //___________________ Место для методов ______________________

    // метод для вычисления числа в кубе
    public static int numberInCube(int num){
        // int res = num * num * num; // можно так
        // return res;
        return num*num*num; // можно и так
    }

    // метод вычисления факториала
    public static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    // метод возвращает минимум из 2-х чисел
    public static int min(int a, int b) {
        if (a < b ) {
            return a;
        } else {
            return b;
        }
    }

    // метод печатает строку n раз
    public static void printStringNTimes(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }

    // метод спрашивает имя пользователя и не допускает пустое имя пользователя
    public static String inputUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("User name: ");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.println("The name can't be empty. Please, try again!");
            name = scanner.nextLine();
        }
     return name;
    }

    // метод корректирует имя пользователя
    public static String nameCorrected(String name) {
        char firstLetter = name.toUpperCase().charAt(0);
        String name1 = name.substring(1,name.length());
        return firstLetter + name1;
    }

    // метод запрашивает натуральное число у пользователя
    public static int inputIntPosNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input positive integer number: ");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.println("The number can't be negative or 0. Pls, try again!");
            n = scanner.nextInt();
        }
        return n;
    }

    // метод проверяет простое число или нет
    public static boolean isPrime(int num){
        boolean isPrime = true;
        for (int i = 2; i*i <= num; i++) { // делители меньше квадратного корня из num
            if (num % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    // метод проедлагает продолжить или остановиться
    public static boolean letsDoItAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Continue? y/n ");
        String choice = scanner.nextLine();
        boolean res = false;
        while (choice.isEmpty()) {
            System.out.println("The choice can't be empty. Pls, try again.");
            choice = scanner.nextLine();
        }
        if (choice.equals("y")) {
            res = true;
        } else {
            res = false;
        }
    return res;
    }

    // __________________Конец методов ___________________________
}