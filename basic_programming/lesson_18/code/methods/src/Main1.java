public class Main1 {
    public static void main(String[] args) {
        System.out.println("Methods - example with array");

        int[] numbers = {46, 13, 13, -100, 67, -4, 20, 56, -10, 35};

        int indexMinEl = minArrayIndex(numbers);
        System.out.println("Min of array is: " + numbers[indexMinEl]);

    }
    // ___________ methods ________________
    //метод находит минимальный элемент в массиве
    public static int minArrayIndex(int array[]) {
        int min = array[0];
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    //
    // ___________ end of methods ________________
}