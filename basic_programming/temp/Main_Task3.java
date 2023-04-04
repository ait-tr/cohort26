import java.util.Arrays;
import java.util.Scanner;

public class Main_Task3 {
    public static void main(String[] args) {
        System.out.println("Search element in array");

        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random()*(100 - 10 +1) + 10);
        }

        System.out.println(Arrays.toString(numbers));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number to search in array: ");
        int e = scanner.nextInt();

        boolean isPresent = false;
        int pointer = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (e == numbers[i]) {
                isPresent = true;
                pointer = i;
            }
        }
        if (pointer == -1) {
            System.out.println("Element not presents in array");
        } else {
            System.out.println("Element presents in array on index " + pointer);
        }
    }
}