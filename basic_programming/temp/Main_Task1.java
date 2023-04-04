public class Main_Task1 {
    public static void main(String[] args) {
        System.out.println("Array reverse");
//        Имеется массив целых чисел (задать самостоятельно), например, оценки студента за семестр.
//        Напечатать его в обратном порядке.

        // задаем масив
        int[] marks = {5, 4, 4, 4, 3, 4, 5, 5, 5, 4, 3, 2};

        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " | ");
        }
        System.out.println();
        // печатаем массив с конца к началу
        for (int i = marks.length - 1; i >= 0 ; i--) {
            System.out.print(marks[i] + " | ");
        }

    }
}