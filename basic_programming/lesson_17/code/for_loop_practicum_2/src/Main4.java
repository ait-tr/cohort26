import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        System.out.println("Array sorting");
//        Задан массив целых чисел: 46, 13, 1, 10, 67, -4, 20, 56, 11, 35. Выполнить сортировку
//        массива от меньшего к большему.

        int[] numbers = {46, 13, 13, -10, 67, -4, 20, 56, -10, 35};

        System.out.println(Arrays.toString(numbers));
        // Алгоритм:
        // проходим по массиву от его начала до конца (слева на право),
        // если найдем минимальный элемент меньше текущего, то поставим его на место текущего,
        // затем сдвигаемся к следующему элементу и опять ищем минимальный из оставшихся.
        // То есть минимальные элементы "всплывают" к началу массива.

        int min, indexOfMin; // можно объявить несколько переменных сразу

        for (int i = 0; i < numbers.length; i++) { // проходим по массиву от его начала до конца (слева на право)
            min = numbers[i];
            indexOfMin = i;
            //пробегаем все элементы массива вправо от текущего
            for (int j = i; j < numbers.length; j++) { // ищем минимальный элемент и его индекс
                if (numbers[j] < min) {
                    min = numbers[j]; // это минимальный
                    indexOfMin = j; // это его индекс
                }
            }
            // делаем перестановку элементов
            int temp = numbers[i]; // забрали в temp "левый крайний" элемент массива
            numbers[i] = numbers[indexOfMin]; // на его место поставили найденный минимальный
            numbers[indexOfMin] = temp; // на место минимального поставили "левый крайний" элемент
            System.out.println(Arrays.toString(numbers)); // напечатали массив
        }
        // System.out.println(Arrays.toString(numbers)); // напечатали массив
    }
}