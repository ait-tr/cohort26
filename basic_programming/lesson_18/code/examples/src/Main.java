import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
    /*Задан массив целых чисел: 56, 73, 15, -10, 37, -14, 25, 65, 33, 38.
    Найдите максимальный элемент массива и его индекс.*/
        int[] arr = {56, 73, 15, -10, 37, -14, 25, 65, 33, 38};
        Arrays.sort(arr);
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[arr.length - i - 1];
        }
        System.out.println(Arrays.toString(arr1));
    }
}