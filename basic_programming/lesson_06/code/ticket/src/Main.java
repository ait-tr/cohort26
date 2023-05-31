import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Расчет средней стоимости поездки");
        //    Написать программу для вычисления средней стомости поездки
        //    по транспортному проездному.
        //    Попросить пользователя ввести стоимость проездного на месяц
        //    и количество рабочих дней.
        //    Считая, что в рабочий день в среднем две поездки,
        //    и 1.5 поездки в выходной,
        //    посчитать и округлить общее число поездок в месяц
        //    и посчитать среднюю стоимость одной поездки по проездному.

    Scanner scanner = new Scanner(System.in);
        System.out.println("Введите стоимость проездного на месяц: ");
        double priceMonatsCart = scanner.nextDouble();
        System.out.println("Введите количество рабочих дней: ");
        int workingDays = scanner.nextInt();

        int trip = workingDays * 2;
        int holidays = 31 - workingDays; // это для месяца март

        int holidayTrips = (int) Math.round(holidays * 1.5);

        trip = trip + holidayTrips; //  оператор присвоения , раньше присали  :=

        System.out.println("Среднее количество поездок за прошедший месяц: " + trip);

        double averageTripPrise = priceMonatsCart/trip;
        System.out.println("Средняя стоимость поездки: " + averageTripPrise + " евро.");

    }
}