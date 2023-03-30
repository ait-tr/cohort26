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

