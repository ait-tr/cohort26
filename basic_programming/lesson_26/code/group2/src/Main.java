import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * <h1> CurrencyConverter (Конвертер валют) </h1>
 * Программа CurrencyConverter реализует приложение, которое конвертирует валюты.
 * По умолчанию в программе уже введено 10 выбранных авторами валют, с возможностью добавления любых новых валют.
 * Программа спрашивает пользователя выбрать две валюты (1-из какой конвертируем, 2-в какую конвертируем).
 * Далее вводиться кол-во валюты №1 и программа выведет результат для валюты №2.
 * <p>
 * <b>Примечание:</b> Основная валюта нашего банка AIT-TR GmbH - евро, поэтому расчет производиться через продажу евро
 * (если валюта №1 отличная от евро), после чего покупает евро за валюту №2.
 * <p>
 *  * <em>Курсы валют усреднённые и действительны на 20.04.2023.</em>
 *
 * @author Wladimir Weizen, Gkalina Borisevits, Andrei Vilcu, Luka Gavrice
 * @version 1.0
 * @since 20.04.2023
 */
public class Main {

    /**
     * <b> Метод "addCurrency" </b>
     * <p>
     * Метод реализует добавление новых валют в заранее подготовленную базу данных.
     * Метод ничего не возвращает, а только мутирует переданные аргументы.
     * Он принимает на входе следующие аргументы:
     * @param curr это переменная типа String с названием валюты. Прим.: "EUR";
     * @param value это переменная типа double со значением цены продажи евро. Прим.: 0.91255;
     * @param exchangeRates это HashMap < String,Double > для хранения цен продажи евро;
     * @param currencies это ArrayList < String > для упорядоченного хранения валют и вывода на кансоль.
     */
    public static void addCurrency (String curr, double value, HashMap<String,Double> exchangeRates, ArrayList<String> currencies) {
        if (!exchangeRates.containsKey(curr)) {
            exchangeRates.put(curr, value);
            currencies.add(curr);
        }
    }

    /**
     * <b> Метод "printingCurrencies" </b>
     * <p>
     * Метод реализует вывод на консоль валют, которые храняться в базе данных нашего банка.
     * На вход методу подается:
     * @param currencies это ArrayList < String > для упорядоченного хранения валют и вывода на кансоль.
     */
    public static void printingCurrencies (ArrayList<String> currencies) {
        for (int i = 0; i < currencies.size(); i++) {
            System.out.print((i+1) + " - " + currencies.get(i) + "; ");
        }
        System.out.println();
    }

    /**
     * <b> Метод "choiceCurrency" </b>
     * <p>
     * Метод реализует выбор валют, которые храняться в базе данных нашего банка.
     * Включает другой метод (printingCurrencies) для быстрого вывода на консоль вариантов валют.
     * На вход методу подается:
     * @param currencies это ArrayList < String > для упорядоченного хранения валют и вывода на кансоль.
     * @return возвращает переменную типа String. Прим.: "EUR"
     */
    public static String choiceCurrency (ArrayList<String> currencies) {
        String choice;
        int curr;
        Scanner sc = new Scanner(System.in);
        System.out.println("(введите соответствующую цифру)");
        printingCurrencies(currencies);

        while (!sc.hasNextInt()) {
            System.out.println("Похоже вы ввели не число. Повторите ввод");
            sc.next();
        }
        curr = sc.nextInt();
        while (curr < 1 | curr > currencies.size()) {
            System.out.println("Вы выбрали не cуществующее число. Повторите ввод");
            while (!sc.hasNextInt()) {
                System.out.println("Похоже вы ввели не число. Повторите ввод");
                sc.next();
            }
            curr = sc.nextInt();
        }
        choice = currencies.get(curr-1);
        return choice;
    }

    public static void main(String[] args) {
        String curr1, curr2, ch;
        double sum, res1, res2;
        Scanner sc = new Scanner(System.in);

        // база данных валютных пар
        HashMap<String,Double> exchangeRates = new HashMap<>(); //для хранения цен продажи евро
        ArrayList<String> currencies = new ArrayList<>(); // для упорядоченного хранения валют
        // добавление валют
        addCurrency("EUR",1,exchangeRates,currencies);
        addCurrency("USD",0.91255,exchangeRates,currencies);
        addCurrency("RUB",0.01116,exchangeRates,currencies);
        addCurrency("GBP",1.13453,exchangeRates,currencies);
        addCurrency("CHF",1.01649,exchangeRates,currencies);
        addCurrency("CNY",0.13247,exchangeRates,currencies);
        addCurrency("JPY",0.00678,exchangeRates,currencies);
        addCurrency("DKK",0.13418,exchangeRates,currencies);
        addCurrency("INR",0.0111,exchangeRates,currencies);
        addCurrency("TRY",0.04702,exchangeRates,currencies);
        addCurrency("BRL",0.18163,exchangeRates,currencies);
        addCurrency("BRL",0.18163,exchangeRates,currencies);
        addCurrency("BRL",0.18163,exchangeRates,currencies);

        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\n\t\t\t\t\t  *** Конвертер валют банк AIT-TR GmbH ***");
        System.out.println();
        // выбор юзером валюты
        while (true) {
            System.out.println("Выбор валюты, которая у Вас есть");
            curr1 = choiceCurrency(currencies); // "RUB"
            System.out.println("Выбор валюты, в которую хотите конвертировать");
            curr2 = choiceCurrency(currencies); // USD
            // ввод количества валюты №1
            System.out.println("Введите количество валюты, для конвертации - " + curr1);
            while (!sc.hasNextDouble()) {
                System.out.println("Похоже вы ввели не число. Повторите ввод");
                sc.next();
            }
            sum = sc.nextDouble();
            // расчет/вывод результата
            res1 = sum * exchangeRates.get(curr1); // банк продал евро
            res2 = res1 * (1 / exchangeRates.get(curr2)); // банк купил евро
            res2 = (Math.round(res2 * 100.0)) / 100.0;
            System.out.println("********Результат***********");
            System.out.println(sum + " " + curr1 + " = " + res2 + " " + curr2);
            System.out.println("Продолжить работать в приложении? y/n ");
            ch = sc.next();
            // вопрос пользователю
            while (!ch.equalsIgnoreCase("y") & !ch.equalsIgnoreCase("n")) {
                System.out.println("Упс. Вы ввели не существующий ответ (y/n). Повторите ввод.");
                ch = sc.next();
            }
            if (ch.equalsIgnoreCase("n")) {
                System.out.println("Благодарим за использование конвертера валют от AIT-TR GmbH");
                return;
            }
        }
    }
}