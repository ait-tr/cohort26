import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Methods - example with array");

        int[] numbers = {46, 13, 13, -100, 67, -4, 20, 56, -10, -350};
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println();

        // мы хотим найти индекс минимального элемента массива
        int indexMinElement = indexOfMin(numbers);
        System.out.println("Index of min element is: " + indexMinElement);
        System.out.println("Min element: " + numbers[indexMinElement]);

    }
    // ___________ methods ________________

    //метод находит индекс минимального элемента в массиве
    public static int indexOfMin(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }


    // ___________ end of methods ________________
}