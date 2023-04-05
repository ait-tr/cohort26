import java.util.Arrays;

public class Main7 {
    public static void main(String[] args) {
        System.out.println("Home work - chess desk ");
//      Заполнить двухмерный массив 8 х 8 элементами 0 и 1, как на шахматной достке.

        int[][] chessDesk = new int[8][8];

        // Алгоритм - будем делить индекс с остатком на 2
        // остаток от деления будет равен 0 или 1, это и будем записывать в массив

        for (int i = 0; i < chessDesk.length; i++) {
            for (int j = 0; j < chessDesk[0].length; j++) {

            }
        }

        for (int i = 0; i < chessDesk.length; i++) {
            for (int j = 0; j < chessDesk[0].length; j++) {
                chessDesk[i][j] = (i + j) % 2;
                System.out.print(chessDesk[i][j] + " | ");
            }
            System.out.println();
        }

       // System.out.println(Arrays.deepToString(chessDesk)); // быстрая печать двумерного массива
    }
}