import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Perimeter of rectangle");
//        Напишите программу, которая запрашивет N имен учащихся группы и выводит список имен в столбик.
//        N запрашивется с клавиатуры, имена вносятся в массив для последующей сортировки по алфавиту.
//        Программа должна быть защищена от ввода чисел вместо имен.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of students");
        int numStudents = scanner.nextInt(); // получаем количество элементов массива (его длину)

        String[] students = new String[numStudents]; // задаем (определяем) массив

        for (int i = 0; i < students.length; i++) {
            // System.out.println("Input name of student: ");
            students[i] = inputName();
        }

        // распечатали массив в строчку
        System.out.println(Arrays.toString(students));

        // распечатали массив в столбик
        System.out.println();
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

    }
    // _____________Methods _____________
    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        String inputName = ""; // это так инициализируется пустая строка
        System.out.println("Input name: ");
        inputName = scanner.nextLine();
        while (!inputName.matches("[ a-zA-Z]+")) {
            System.out.println("Invalid name, pls, try again.");
            inputName = scanner.nextLine();
        }
        return inputName;
    }


    //_____________end of Methods ____________
}