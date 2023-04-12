import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Example with 'out of range' ");
        int[] myNumbers = {1, 2, 3};

    try {
        System.out.println(myNumbers[3]);
    } catch (Exception e) {
                    System.out.println(e.getMessage() +  "/ Вы обратились к элементу массива, индекс которого больше, чем длина массива.");
            }
    }
}


