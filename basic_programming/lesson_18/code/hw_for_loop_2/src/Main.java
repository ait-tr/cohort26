import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Throw two cubes");
//      Имитация броска 2-мя кубиками с 6 гранями. Использовать двухмерный массив.

        int[][] cube = new int[20][2];

        for (int i = 0; i < 20; i++) { // запускаем цикл 20 раз

            cube[i][0] = (int)(Math.random() * (6 - 1 + 1) + 1); // 1-й кубик
            cube[i][1] = (int)(Math.random() * (6 - 1 + 1) + 1); // 2-й кубик
        }
        System.out.println(Arrays.deepToString(cube)); // быстрая печать двумерного массива

        for (int i = 0; i < 20; i++) {
            System.out.print(cube[i][0] + ", " + cube[i][1]);
            System.out.println();
        }
    }
}