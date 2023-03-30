import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите первый коэффициент: ");
                double a = scanner.nextInt();
                System.out.print("Введите второй коэффициент: ");
                double b = scanner.nextInt();
                System.out.print("Введите третий коэффициает: ");
                double c = scanner.nextInt();

                double d = b * b - 4 * a * c;

                if (d >= 0) {
                    System.out.println("x1 = " + (-b + Math.sqrt(d))/( 2 * a));
                    System.out.println("x2 = " + (-b - Math.sqrt(d))/( 2 * a));
                } else {
                    System.out.println("Дискриминант отрицательный, корней нет" );
                }

            }
        }