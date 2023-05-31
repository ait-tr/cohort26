import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = 1;
        Scanner scanner = new Scanner(System.in);

        //     System.out.println("Enter a number ");
        //     int x = scanner.nextInt();

        //     System.out.println("Enter another number ");
        //     int y = scanner.nextInt();

        //    System.out.println("x divided by y is "+x/y +" and the remainder is "+x%y);

     /*   System.out.println("Введите делимое и делитель целые числа в одну строку через пробел");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println("Число "+num1+" разделить на число "+num2+" получается частное "+num1/num2+" и в остатке "+num1%num2);
    */

        String odin = "1";
        String dva = "2";
        System.out.println(odin + dva);

        //   int age =23;
        //  имя переменной не может содержать специальные символы : @ # ( ) / ?
        /*
        svsgdthfzjgjmj
        <scsdvdbgn
        rtzhjmm
         */
        int age_er;
        int age1;
        int Age;// переменные принято называть с маленькой буквы. Поэтому так не правильно

     /*   String personname;
        String person_name;
        String personName;

      */

        String str = "and";
        String result = "Мой любимый фильм " + str + "'Трасса 60'";
        System.out.println(result);

        System.out.println(1 + 2);
        int a1 = 2;
        int b1 = 3;
        System.out.println(a1 + b1);

        a1 = 10;
        int sum = 3 + 5;
        sum = a1 + b1;

        System.out.println("one plus two is " + (1 + 2));
        System.out.println(1 + 2 + " one plus two is " + (1 + 2));

        // Data Types in Java  Типы данных в Джава
        /*
        Primitive Data Types
        целочисленные типы
        byte
        short
        int
        long
         */
        byte num;
        num = 113;

        short num1 = 30000;

        long numL = 1234567677889L;

        float numF = 19.2F;
        double numD = -456775433.93333333333333333333333333333333333333333333333333333;

        int y = 2;
        char ch = 'A';
        String str1 = "A#";
        System.out.println(ch);
        char cell = '#';

        boolean b = false;
        boolean bool = true;

        // Арифметические операторы : +,-,*,/,%
        int sum1 = 1 * 2;

        int number = 10;
        int number2 = 3;
        System.out.println("number/number2= " + number / number2);

        System.out.println("number%number2= " + number % number2);

        double res = number / number2;
        System.out.println("res is = " + res);

        double res1 = 10.0 / 3;
        System.out.println(res1 * 3);


    }


}
