import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Array 10 x 10 by 0 and 1, sum by row");
//        Заполнить массив 10 х 10 случайными числами 0 или 1.
//        Для каждой строки подсчиать сумму всех элементов массива в этой строке.
//        (int)(Math.random() * (1 - 0 + 1) + 0); // это 0 или 1

        int[][] myArray = new int[10][10];  // задаем массив
        int sum = 0; // переменная для суммы строки

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                myArray[i][j] = (int)(Math.random() * (1 - 0 + 1) + 0);
                sum = sum + myArray[i][j];
                System.out.print( myArray[i][j] + " | ");
            }
            System.out.print("sum of row is: " + sum);
            sum = 0; // сбросили сумму на 0
            System.out.println(); // переход на сл. строку
        }
    }
}
