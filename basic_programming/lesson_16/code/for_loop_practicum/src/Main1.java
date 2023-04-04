public class Main1 {
    public static void main(String[] args) {
        System.out.println("Print array in reverse order");
//        Имеется массив целых чисел (задать самостоятельно), например, оценки студента за семестр.
//        Распечатаь оценки в обратном порядке.
        int[] marks = {2, 5, 4, 5, 3, 5, 4, 1}; // так тоже можно задавать массив

        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " | ");
        }

        System.out.println();

        // запустим цикл в обратном порядке
        for (int i = marks.length - 1; i >= 0 ; i--) {
            System.out.print(marks[i] + " | ");
        }

    }
}