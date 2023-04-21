import java.util.ArrayList;
import java.util.HashMap;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Run competition results");
//        Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран.
//        Первый и второй члены последовательности Фибоначчи равны единицам, а каждый следующий
//         — сумме двух предыдущих. Используйте методы для заполнения Array и ArrayList.

        // реализация на основе Array
        int[] fibNum = new int[20]; // задаем массив на 20 чисел
        fibNum[0] = 1; // первый член последовательности
        fibNum[1] = 1; // второй член последовательности
        // переменные для хранения
        int fib1 = 0;
        int fib2 = 0;
        int fibNext = 0;

        for (int i = 2; i < 20; i++) { // начинаем с 3-го элемента в массиве, его ииндекс = 2
            fib1 = fibNum[i - 2];
            fib2 = fibNum[i - 1];
            fibNext = fib1 + fib2; // вычисляем следующее число Фиббоначи
            fibNum[i] = fibNext; // записываем его в массив
        }
        // печать результата
        for (int i = 0; i < fibNum.length; i++) {
            System.out.print(fibNum[i] + " | ");
        }
        System.out.println();
        // реализация на основе ArrayList
        ArrayList<Integer> fibList = new ArrayList<>();
        fibList.add(0, 1);
        fibList.add(1, 1);
        for (int i = 2; i < 20; i++) {
            fib1 = fibList.get(i - 2); // первый член последовательности
            fib2 = fibList.get(i - 1); // второй член последовательности
            fibNext = fib1 + fib2; // вычисляем следующее число Фиббоначи
            fibList.add(i, fibNext); // записываем его в массив
        }
        // печатаем результат
        System.out.println(fibList);
     }
}
