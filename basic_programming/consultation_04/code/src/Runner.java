import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите кол-во км 1-й день");
        double s = scanner.nextInt();
        System.out.println("Введите желаемое кол-во км");
        int target = scanner.nextInt();
        int day = 1;
        while (s < target) {
            s = s * 1.1;
            day++;
            System.out.println(day);
        }
    }
}