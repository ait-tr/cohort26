public class Apples {
    public static void main(String[] args) {

        int number = 30; // Начальное число яблок в корзине
        int debt = 3; // по скольку яблок берем

        while( number > 0 ) { // условие входа в цикл
            number = number - debt; // берем яблоки;
            System.out.println(" в корзине остается " + number + " яблок " );
        }

        System.out.println("Яблоки закончились!");

    }
}









//       System.out.println("Цифры, из которых состоит число");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input positive number: ");
//        int num = scanner.nextInt();

//    int i = 1;
//        while (num % 10 > 0 ) {
//                int digit = num % 10;
//                System.out.println(i + " цифра числа " + digit);
//                int div = num / 10;
//                num = (num - digit)/10;
//                i++;
//                }