import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        System.out.println("Ruletka");
    //   Запустить "Рулетку" 20 раз. В "Рулетке" на круге 36 (37 с зеро) ячеек, куда может попасть шарик,
    //   и два цвета - красный, черный.
    //   Результат попытки вывести так:
    //   "Выиграл номер NN, четное или нечетное, цвет".

        // Что на входе? Что дано? - ввод с клавиатуры "начать крутить"
        // Что на выходе? - "результат кручения рулетки", 20 раз она прокрутилась, и 20 результатов показались
        // Что должно произойти? - появится "результат кручения рулетки"
        // Ключевой алгоритм? - работаем с датчиком случайных чисел
        // какой интерфейс с пользователем? - работу рулетки покажем в виде готового результата
        // Что делать с "зеро"? - ДА, конечно нужно
        // Как красное и черное соотносится с номерами? - красное и черное просто загадываем (0 или 1)
        // Чет, нечет определяется по числу/номеру - делимость на 2 с остатком
        // Что со ставками ??? - ничего не делать, это дело казино

//        * int n = (int)(Math.random() * (b - a + 1) + a) - генерирует случайное **целое** число в интервале [a, b]
//        a - может быть, b - может быть

        int[] result = new int[20]; // сюда положим результаты "колеса"
        int[] color = new int[20];
        String[] iven = new String[20];
        String[] color1 = new String[20];

        for (int i = 0; i < result.length; i++) {
            result[i] = (int)(Math.random() * (36 - 0 + 1) + 0); // это мы крутнули рулетку
            color[i] = (int)(Math.random() * (1 - 0 + 1) + 0); // это мы задумываем цвет
            if (result[i] % 2 == 0) {
                iven[i] = "четное";
            } else {
                iven[i] = "нечетное";
            }
            if (color[i] == 0) {
                color1[i] = "красный";
            } else {
                color1[i] = "черный";
            }
            System.out.println("Выиграл номер: " + result[i] + ", " + iven[i] + ", цвет " + color1[i]);
        }
    }
}