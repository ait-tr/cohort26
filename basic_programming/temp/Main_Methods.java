import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Methods - examples");
        // вычисление куба числа
        int n = numberInCube(4); // обращаемся (вызываем) метод по имени и передаем ему на вход число
        System.out.println(n); // печатаем результат

        // вычисление факториала числа
        int nFactorial = factorial(4);
        System.out.println(nFactorial);

        // нахождение минимума из 2-х чисел
        int a = 100;
        int b = 300;
        System.out.println(min(a,b)); // вызов метода

        // печать строки N раз
        printStringNTimes("Java is the best language for earn money as programmer!", 5);

        // спрашиваем имя пользователя
        String user;
        user = inputUserName();
        user = nameCorrected(user); // корректируем написание имени
        System.out.println("Hallo, " + user + "!"); // здороваемся

        int num = inputIntPosNumber(); // запрашиваем натуральное число (целое и положительное)
        if (isPrime(num) ) { // вызываем метод для проверки числа на простое оно или нет
            System.out.println(num + " is prime number.");
        } else {
            System.out.println(num + " is NOT prime number.");
        }

        if(letsDoItAgain()) {
            System.out.println("Okay! Lets continue!...");
        } else {
            System.out.println("Chao! ");
        }
    }
    //___________ зона методов _________________
    // метод возвращает куб числа
    public static int numberInCube (int num) {
        return num * num * num;
    }

    // метод возвращает n! - факториал
    public static int factorial(int num) {
        int f = 1;
        for (int i = 1; i <= num; i++) {
            f = f * i;
        }
        return f;
    }

    // метод возвращает минимум из 2-х чисел
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // метод печатает строку n раз
    public static void printStringNTimes (String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }

    // метод спрашивает имя пользователя и не дает оставить его пустым
    public static String inputUserName () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("User name: ");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.println("The name can't be empty. Please, try again!");
            name = scanner.nextLine();
        }
        return name;
    }

    // корректируем имя пользователя
    public static String nameCorrected (String name) {
        char firstLetter = name.toUpperCase().charAt(0); // берем самый первый символ в строке
        String name1 = name.substring(1, name.length()); // берем подстроку без первой буквы
        return firstLetter + name1;
    }
    // метод спрашивает положительное целое число
    public static int inputIntPosNumber () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input positive integer number: ");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.println("The number can't be less or equal 0. Please, try again!");
            n = scanner.nextInt();
        }
        return n;
    }

    public static boolean isPrime(int num) {
        boolean res = true;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                res = false;
            }
        }
        return res;
    }

    public static boolean letsDoItAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Continue? y/n ");
        String choice = scanner.nextLine();
        boolean res = false;
        while (choice.isEmpty()) {
            System.out.println("The choice can't be empty. Please, try again!");
            choice = scanner.nextLine();
        }
        if (choice.equals("y")) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }
    // _______________ конец зоны методов _________
}