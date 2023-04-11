import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Max from three numbers");
//        Написать метод, определяющий максимум из трех натуральных чисел.
//        Метод должен быть защищен от ввода отрицательных чисел.

        maxFromABC(4, 10, 1); // вызов метода
        System.out.println();

//        Написать метод, который находит площадь круга для любого заданного радиуса.
//        Метод должен быть защищен от ввода отрицательного числа и выводить
//        результат с точностью до 3-х знаков после десятичного разделителя.

        double s = 0;
        s = circleArea(); // вызов другого метода
        System.out.printf("Circle area is: %.3f", s);

    }
    // __________________Зона методов ___________________________

    // метод ищет максимальное из трех натуральных чисел
    public static void maxFromABC(int a, int b, int c) {
        boolean flag = true;
        if (a <= 0 || b <=0 || c <= 0) {
            // System.out.println("Numbers can't be negative. Method accept positive numbers only.");
            flag = false;
        }
        int max = a;
        if (b > max ) { max = b;}
        if (c > max) {max = c;}
        if (flag) {
            System.out.println("Maximum from a, b, с is: " + max);
        } else {
            System.out.println("Numbers can't be negative. Method accept positive numbers only.");
        }
    }

    // метод запрашивает радиус и находит площадь круга

    public static double circleArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input radius of the circle: ");
        double r = scanner.nextDouble();
        while (r <= 0) {
            System.out.println("Radius can't be negative or 0. Pls, try again.");
            r = scanner.nextDouble();
        }
        double res = Math.PI*r*r;
        return res;
    }

    // __________________Конец методов ___________________________
}