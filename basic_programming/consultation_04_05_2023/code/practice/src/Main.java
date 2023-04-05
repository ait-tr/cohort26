import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Массивы");

        int[] myArray = new int[20]; // длина массива 20 (кол-во его элементов), а их идексы стартуют с 0
        // и идут до 19

        int i = 0;

        // заполнение массива
        while (i < 20 ) {
            myArray[i] = 100 + i;
            i++; // i := i + 1 - было в старых языках
        }

        // печать массива
        for (int j = 0; j < myArray.length; j++) {
            System.out.println(myArray[j]);
        }

        // System.out.println(myArray);

    }
}