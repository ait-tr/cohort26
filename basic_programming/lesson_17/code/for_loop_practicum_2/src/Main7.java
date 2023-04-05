import java.util.Arrays;

public class Main7 {
    public static void main(String[] args) {
        System.out.println("Chess desk");
        // Заполнение полей шахматной доски. Двумерный массив.
        // 1 - черное поле, 0 - белое поле

        int[][] chessDesk = new int[8][8];
        // chessDesk[i][j] - это элементы двумерного массива

        for (int i = 0; i < chessDesk.length; i++) {
            for (int j = 0; j < chessDesk[0].length; j++) {
                chessDesk[i][j] = (j + i) % 2;
                System.out.print(chessDesk[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(chessDesk[0][0]);
        System.out.println(chessDesk[7][7]);

        System.out.println(Arrays.deepToString(chessDesk));

    }
}