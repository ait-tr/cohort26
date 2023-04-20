import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        boolean repeat = true;
        System.out.println("══════════  Конвертер валют ＄€￡ ══════════");
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        HashMap<String, Double> exchangeRates = new HashMap<String, Double>();

        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.72);
        exchangeRates.put("CAD", 1.25);
        exchangeRates.put("AUD", 1.31);
        exchangeRates.put("JPY", 108.92);

        do {
            printMenu(); // вызываем метод для печати меню
            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1: {  // Список доступных валют
                    System.out.println("Список доступных валют:");
                    for (String currency : exchangeRates.keySet()) {
                        System.out.println(currency + " (" + exchangeRates.get(currency) + ")");
                    }
                    System.out.println("");
                    break;
                }
                case 2: {  // Добавить валюту
                    System.out.print("Введите код новой валюты: ");
                    String newCurrency = scanner.nextLine().toUpperCase();
                    System.out.print("Введите курс новой валюты: ");
                    Double newRate = inputDoublePostNumber();
                    exchangeRates.put(newCurrency, newRate);
                    System.out.println("Валюта " + newCurrency + " добавлена в список.");
                    break;
                }
                case 3: {  // Конвертер
                    System.out.print("Введите код первой валюты: ");
                    String currency1 = scanner.nextLine().toUpperCase();
                    System.out.print("Введите сумму для конвертации: ");
                    Double amount = inputDoublePostNumber();
                    System.out.print("Введите код второй валюты: ");
                    String currency2 = scanner.nextLine().toUpperCase();
                    double rate1 = exchangeRates.get(currency1);
                    double rate2 = exchangeRates.get(currency2);
                    double result = (Math.round((amount * (rate1 / rate2))*1000/1000));
                    System.out.println( amount + " " + currency1 + " = " + result + " " + currency2);
                    break;
                }
                case 4: {  // Выход
                    System.out.println("До свидания!");
                    repeat = false;
                    break;
                }
                default: {  // Некорректный выбор
                    System.out.println("Некорректный выбор. Попробуйте снова.\n");
                    break;
                }
            }
        } while (repeat);
    }

    public static void printMenu() {
        System.out.println("\n〚 МЕНЮ 〛");
        System.out.println("1. Просмотреть список доступных валют");
        System.out.println("2. Добавить новую валюту");
        System.out.println("3. Конвертер валют");
        System.out.println("4. Выход");
        System.out.print("\nВведите номер пункта меню: ");
    }
    public static Double inputDoublePostNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        Double n = scanner.nextDouble();
        while (n<=0) {
            System.out.println("Вы ввели отрицательное число. Введите число больше нуля:");
            n = scanner.nextDouble();
        }
        return n;
    }
}

