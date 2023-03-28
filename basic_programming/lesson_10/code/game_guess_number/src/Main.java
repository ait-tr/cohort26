import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int secretNumber = 8;

        System.out.println("Guess a number. Enter a number  betwwen 0-9");
        int input =scanner.nextInt();

        if ( input == secretNumber){
            System.out.println("You are right");
        } else {
            System.out.print("The number is ");
            if(input<secretNumber) {
                System.out.println("too small");
            }else {
                System.out.println("too big");
            }

        }
    }
}
