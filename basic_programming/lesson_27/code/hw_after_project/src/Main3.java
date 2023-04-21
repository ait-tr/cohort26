import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Array 10 x 10 by 0 and 1, sum by row");
//        Заполнить массив 10 х 10 случайными числами 0 или 1.
//        Для каждой строки подсчиать сумму всех элементов массива в этой строке.
//        (int)(Math.random() * (1 - 0 + 1) + 0); // это 0 или 1

        int[][] myArray = new int[10][10];  // задаем (объявляем) массив
        int sum = 0; // переменная для суммы строки

        for (int i = 0; i < myArray.length; i++) { // это цикл по строчкам (перебираем строки)
            for (int j = 0; j < myArray[0].length; j++) { // это цикл по столбцам (заполняет строку)
                myArray[i][j] = (int)(Math.random() * (1 - 0 + 1) + 0);// 0 или 1
                sum = sum + myArray[i][j]; // считаем сумму по строке
                System.out.print( myArray[i][j] + " | "); // печать в строчку с разделителем |
            }  // это конец внутреннего цикла
            System.out.print("sum of row is: " + sum);
            sum = 0; // сбросили сумму на 0
            System.out.println(); // переход на сл. строку
        } // это конец внешнего цикла

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                sum = sum + myArray[j][i]; // считаем сумму по столбцу
            }
            System.out.println("sum of columns " + sum);
            sum = 0;
        }

    }
}
