public class Main {
    public static void main(String[] args) {
        System.out.println("Home work - for loop");
//        Задан массив целых чисел: 56, 73, 15, -10, 37, -14, 25, 65, 33, 38.
//        Найдите максимальный элемент массива и его индекс.
        int[] myArray = {56, 73, 15, -10, 37, -14, 25, 65, 33, 38};

        int max = myArray[0];
        int pointer = -1;

        // Алгоритм:
        // пробегаем по всем элементам массива. Если нашли элемент, который больше max,
        // то max = myArray[i], то есть обновляем max значением этого элемента, сохраняем индекс в pointer.

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] > max) {
            max = myArray[i];
            pointer = i;
            }
        }

        System.out.println("Max element of array is: " + max + " Index: " + pointer);
    }
}