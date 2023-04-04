import java.util.Arrays;

public class Main_Task4 {
    public static void main(String[] args) {
        System.out.println("Array sorting");
//        Задан массив целых чисел: 46, 13, 1, 10, 67, -4, 20, 56, 11, 35. Выполнить сортировку
//        массива от меньшего к большему.

        int[] numbers = {46, 13, 1, 10, 67, -4, 20, 56, 11, 35};
        System.out.println(Arrays.toString(numbers));

        // Алгоритм:
        // проходим по массиву слева на право,
        // если найдем минимальный элемент меньше текущего, то поставим его на место текущего,
        // затем сдвигаемся к следующему элементу и опять ищем минимальный из оставшихся.
        // То есть минимальные элементы "всплывают" к началу массива.

        int min, indexOfMin;

        for (int i = 0; i < numbers.length; i++) {
            min = numbers[i];
            indexOfMin = i;
            // пробегаем все элементы массива вправо от текущего
            for (int j = i; j < numbers.length; j++) {
                // как только нашли новый минимальный
                if (numbers[j] < min) {
                    // то запоминаем его значение и индекс
                    min = numbers[j];
                    indexOfMin = j;
                }
            }
            // как только нашли минимальный элемент, меняем его местами с первым текущим
            int temp = numbers[i];
            numbers[i] = numbers[indexOfMin];
            numbers[indexOfMin] = temp;

            System.out.println(Arrays.toString(numbers));
        }

    }
}