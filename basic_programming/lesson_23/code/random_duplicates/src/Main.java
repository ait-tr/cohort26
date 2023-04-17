import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("100 random numbers, remove duplicates");
//        имеется список из 100 случайных чисел в интервале от 1 до 10, необходимо
//        удалить все дубликаты.

        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random()*(10 - 1 + 1) + 1);
         //   System.out.println(numbers[i]);
        }

        System.out.println(Arrays.toString(numbers));

        HashSet<Integer> numbersNoDuplicates = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersNoDuplicates.add(numbers[i]);
        }

        System.out.println(numbersNoDuplicates);
        System.out.println("Number of duplicates: " + (numbers.length - numbersNoDuplicates.size()));

    }
}