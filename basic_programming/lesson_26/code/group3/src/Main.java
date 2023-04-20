import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Создаем HashMap для хранения курсов валют
        HashMap<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.00);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.72);
        exchangeRates.put("UAH", 40.46);
        exchangeRates.put("JPY", 147.68);
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        do {
            printMenu();
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1: {
                    // Выводим список валют и их курсов
                    for (String currency : exchangeRates.keySet()) {
                        System.out.println(currency + " - " + exchangeRates.get(currency));
                    }
                    break;
                }
                case 2: {
                    // Предлагаем выбрать исходную валюту
                    System.out.println("Выберите исходную валюту:");
                    System.out.println("1 - USD, 2 - EUR, 3 - GBP, 4 - UAH, 5 - JPY");
                    int fromCurrency = scanner.nextInt();
                    // Проверяем введенное значение
                    while (fromCurrency < 1 || fromCurrency > 5) {
                        System.out.println("Некорректный выбор. Пожалуйста, попробуйте еще раз:");
                        fromCurrency = scanner.nextInt();
                    }
                    // Предлагаем выбрать целевую валюту
                    System.out.println("Выберите целевую валюту:");
                    System.out.println("1 - USD, 2 - EUR, 3 - GBP, 4 - UAH, 5 - JPY");;
                    int toCurrency = scanner.nextInt();
                    // Проверяем введенное значение
                    while (toCurrency < 1 || toCurrency > 5) {
                        System.out.println("Некорректный выбор. Пожалуйста, попробуйте еще раз:");
                        toCurrency = scanner.nextInt();
                    }
                    // Запрашиваем сумму для конвертации
                    System.out.println("Введите сумму для конвертации:");
                    double amount = scanner.nextDouble();
                    // Проверяем введенное значение
                    while (amount <= 0) {
                        System.out.println("Сумма должна быть больше нуля. Пожалуйста, попробуйте еще раз:");
                        amount = scanner.nextDouble();
                    }
                    // Вычисляем курс для исходной валюты и целевой валюты
                    double fromRate = exchangeRates.get(getCurrency(fromCurrency));
                    double toRate = exchangeRates.get(getCurrency(toCurrency));
                    // Конвертируем введенную сумму в целевую валюту и выводим результат
                    double result = convert(amount, fromRate, toRate);
                    System.out.println(amount + " " + getCurrency(fromCurrency) + " = " + round(result, 2) + " " + getCurrency(toCurrency));
                    break;
                }
                case 3: {
                    // Выход
                    return;
                }
            }
        } while (true);
    }
    public static void printMenu() {
        System.out.println("1 - Показать список валют и их курс");
        System.out.println("2 - Конвертировать валюту");
        System.out.println("3 - Закончить");
        System.out.println("Выберите действие: ");
    }
    // Получаем название валюты по ее номеру
    public static String getCurrency(int currencyNum) {
        String currency = "";
        switch (currencyNum) {
            case 1:
                currency = "USD";
                break;
            case 2:
                currency = "EUR";
                break;
            case 3:
                currency = "GBP";
                break;
            case 4:
                currency = "JPY";
                break;
            case 5:
                currency = "AUD";
                break;
        }
        return currency;
    }
    // Метод для конвертации суммы из исходной валюты в целевую валюту
    public static double convert(double amount, double fromRate, double toRate) {
        return amount * toRate / fromRate;
    }
    // Метод для округления числа до заданного количества знаков после запятой
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}