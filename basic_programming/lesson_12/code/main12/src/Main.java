import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         Решение квадратного уравнения по коэффициентам квадратного трехчлена а, b и с

         ax^2 +bx +c =0

        D = b^2 -4ac    если  D  больше нуля то корни уравнения вычисляются по формулам:
             x1 = (-b + корень из D) /2a
             x2 = (-b - корень из D)/2a

             если D равен нулю то
             x = -b/2a

             если дискриминант меньше нуля  то решения нет


         */

    /*    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number for a:");
        double a = scanner.nextDouble();

        System.out.println("Enter a number for b:");
        double b = scanner.nextDouble();

        System.out.println("Enter a number for c:");
        double c = scanner.nextDouble();

        double d = b*b - 4*a*c;
        //x1 = (-b + корень из D) /2a
        if (d>0){
            double x1 = (-b - Math.sqrt(d))/(2*a);
            double x2 = (-b + Math.sqrt(d))/(2*a);
            System.out.println("Square roots: x1 = "+x1+", x2 = "+x2);
        } else if (d ==0) {
            double x = -b/2*a;
            System.out.println("Square root is"+x);
        }else{
            System.out.println("No square roots");
        } */

     /*   Scanner scanner = new Scanner(System.in);
        int secretNumber = 7;
        System.out.println("Enter a number between 1-10");
        int answer = scanner.nextInt();

        if (secretNumber == answer) {
            System.out.println("you guessed right!");
        } else {
            System.out.print(" sorry, your number is ");
            if (answer < secretNumber) {
                System.out.println("too small");
            } else {
                System.out.println("too big");
            }
        }*/


        int num = 30;

        if (num < 100) {
            System.out.println("number is less than 100");
            if (num > 50) {
                System.out.println("number is greater than 50");
            }

        }


        int number = 7;

        if (number == 1) {
            System.out.println("number is one");
        } else if (number == 2) {
            System.out.println("number is  two");
        } else if (number == 3) {
            System.out.println("number is  three");
        } else {
            System.out.println("number is not between one and three");
        }

        // SWITCH
     /*
        switch(expression){
        case constant1:
            statement sequence
            break;
        case constant2:
            statement sequence
            break;

         case constant3:
            statement sequence
            break;
            .
            .
            .
            default
                statement
        }
      */

      //  byte i = 0;
      //  short i = 0;

            char a ;
            String str;

        int i = 45;
        int y =2;

        switch (i) {
            case 45:
                System.out.println("i is zero");
                if(y==3){
                 break;}
            case 12:
                System.out.println("i is one");
                break;
            case 8:
                System.out.println("i is two");
            //    break;

            case 3345:
                System.out.println("i is three");
            //    break;

            default:
                System.out.println("i is 4 or more" );
        }

     //   int y = 4;



      char  ch = 'b';

      switch (ch) {

          case 'd':
              System.out.println("Case d");
              break;

          case 'b':
              System.out.println("Case b");
              break;

          case 'x':
              System.out.println("Case x");
              break;

          case 'y':
              System.out.println("Case y");
              break;

          default:
              System.out.println("Default character");
      }


      Scanner scanner = new Scanner(System.in);
        System.out.println("Input number from 1 to 7");
        int dayNumber = scanner.nextInt();

        switch (dayNumber){
            case 1:
                System.out.println("Monday");
             //   break;
            case 2:
                System.out.println("Tuesday");
             //   break;
            case 3:
                System.out.println("Wednesday");
             //   break;
            case 4:
                System.out.println("Thursday");
            //    break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
            //    break;
            case 7:
                System.out.println("Sunday");
                break;

            default:
                System.out.println("Enter a valid number");

        }

        String pizzaType = "AWAii";

        switch (pizzaType.toUpperCase()){

            case "MARGARITA":
                System.out.println("You ordered pizza Margarita");
                break;

            case "HAWAII":
                System.out.println("You ordered pizza Hawaii");
                break;

            case "DIABOLO":
                System.out.println("You ordered pizza Diabolo");

            default:
                System.out.println("Unfortunately we do not have this type of pizza");
        }

        //Ternary operator
        //variable = Condition? Expresion1:Expression2

        int age = 14;
        boolean isAdult = age > 18 ? true : false;

        System.out.println("Can vote? "+isAdult);

        if(age > 18){
            System.out.println("Can vote? true ");
        }
        else{
            System.out.println("Can vote? false");
        }

        int number1 = -100;

      String sign =  (number1>0)?"Positive":"Negative";

      int val1 = 10;
      int val2 = 20;

      int max = val1>val2? val1:val2;


    }
}
