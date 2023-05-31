import java.util.Scanner;

public class Main {

    /*
    Задача 1.
Напишите программу, которая читает строку с клавиатуры, и выводит её длину, первый и последний символы.

Задача 2. (*)
Даны строки разной длины (длина - четное число), необходимо вернуть ее два средних знака.
Например, если дана строка "string"  результат будет "ri", для строки "code" результат "od",
для "Practice" результат "ct".

Задача 3. (*)
Напишите программу, которая читает строку, определяет левый индекс и правый индекс
и выводит получившуюся в результате substring с левым и правым индексом.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        String string = scanner.nextLine();

        /*
         Задача 1.
Напишите программу, которая читает строку с клавиатуры, и выводит её длину, первый и последний символы.
         */
        System.out.println("String length = "+string.length());
        System.out.println("String first symbol is = "+string.charAt(0));
        System.out.println("String last symbol is = "+string.charAt(string.length()-1));

        /*
        Задача 2. (*)
Даны строки разной длины (длина - четное число), необходимо вернуть ее два средних знака.
Например, если дана строка "string"  результат будет "ri", для строки "code" результат "od",
для "Practice" результат "ct".
         */
        // 0 1 2 3 4 5 6 7
        // P r a c t i c e      length =8/2 =4     t -> length/2    c -> length/2 -1 =3

        //0 1 2 3
        //C o d e   length =4/2 = 2     d -> length/2     o-> length/2 -1

        int length = string.length()/2;

        int middle =string.length()/2;
        int middle1 = string.length()/2 -1;

        System.out.println("String middle is "+string.substring(length - 1,length+1));

        /*
        Задача 3. (*)
Напишите программу, которая читает строку, определяет левый индекс и правый индекс
и выводит получившуюся в результате substring с левым и правым индексом.
         */
    int number = 5;
    String five =String.valueOf(number);

    String left = String.valueOf(string.charAt(0));
    String right = String.valueOf(string.charAt(string.length()-1));
        System.out.println("first+last symbols are "+left + right);

        //primitive types:
        /*
        byte 8bit
        short 16bit
        int 32bit
        long 64bit
        float 32bit
        double 64 bit
        char 16bit
        boolean 1 bit
         */
      //  boolean принимает два значения true and false
        boolean b = false;
        System.out.println("b is "+b);
        b = true;
        System.out.println("b is "+b);
        b=false;
        boolean comp =9>8;
        System.out.println("9>8 is "+comp);
        if(b) {
            System.out.println("This is executed");
        }
        comp =9<8;
        System.out.println("9<8 is "+comp);

        //Relational operators

        // == "Equal to" проверяет равенство операндов и результат будет true  если они равны и false  если нет
        int x = 3;
        int y = 4;
        boolean result =  2 == 3;
        System.out.println(result);

        // != "Not equal to" не равен.  Проверяет неравенство и возвращает true  если операнды не равны
        result = 2 != 3;
        System.out.println(result);

        // > greater than больше чем
        result = 3>2;
        // < less than меньше чем
        result= 2<3;

        // >= Greater than or equal to  больше равно
        result= 3>=2;

        //<= Less than or equal to-  меньше равно
        result = 2<=4;

        System.out.println("2>2 is "+(2>2));
        System.out.println("2>=2 is "+(2>=2));

     //   int t =0;
     //  var a;
      // a = "Wertz"
      //  String tString =t;

        int d;
        var a = 12;
      //  a = 13.0;
        int var = 23;

        var k =var;



        d=45;

        String str = "Java";
        str = "JavaScript";



    }
}