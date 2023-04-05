import java.util.Arrays;
public class Main1 {
    public static void main(String[] args) {
        System.out.println("Home work - for loop");
//        Создайте массив из 20 случайных целых чисел в интервале от 10 до 20.
//        Выведите массив на печать.
//        Поменяйте местами первый и последний элементы массива и снова выведите массив на печать.

        int[] myArray = new int[20];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int)(Math.random() * (20 - 10 + 1) + 10);
        }

        System.out.println(Arrays.toString(myArray));
        System.out.println();
        int temp = myArray[0]; // первый элемент массива помещаем в temp
        myArray[0] = myArray[myArray.length - 1]; // пермещаем последний элемент в первый
        myArray[myArray.length - 1] = temp; // последнему элементу присваиваем temp, то есть первый элемент
        System.out.println(Arrays.toString(myArray));

    }
}