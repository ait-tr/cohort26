import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) throws Exception {

        HashMap<Integer, Double> mapWithCources = new HashMap<>();
        HashMap<Integer, String> mapWithNames = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int userChoise = 0;
        fillHashMap(mapWithCources, mapWithNames);//инициализация и заполнение хешмэпов
        do {//бесконечный цикл
            printMenu();//печать меню
            try {
                userChoise = scanner.nextInt();//чтение ввода с клавиатуры
                switch (userChoise) {
                    case 1: {
                        //показать все
                        showAllCurrencies(mapWithCources, mapWithNames);
                        break;
                    }
                    case 2: {
                        //showOne
                        int code = inputCodeOfCurrency("валюты, курс которой Вы хотите узнать:");
                        showOne(mapWithCources, mapWithNames, code);
                        break;
                    }
                    case 3: {
                        //convert
                        String messsageFromMain = "исходной валюты";
                        int codeIn = inputCodeOfCurrency(messsageFromMain);
                        int codeOut = inputCodeOfCurrency("целевой валюты");
                        double sum = inputSum();
                        convertAndPrint(codeIn, codeOut, sum, mapWithCources, mapWithNames);
                        break;
                    }
                    case 4: {
                        //exit
                        return;
                    }
                    default: {
                        System.out.println("Команда не распознана, повторите ввод.");
                        break;
                    }
                }
            } catch (InputMismatchException e) { // проверка на некорректный ввод
                System.out.println("Wrong input, try again.");
                scanner.next();
            }
        } while (true);
    }

    //-->>Methods
    public static double inputSum() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму ");
        double sum = Double.parseDouble(scanner.next());
        System.out.println("Вы ввели: " + sum);
        return sum;
    }

    public static int inputCodeOfCurrency(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ведите код " + message);
        int code = scanner.nextInt();
        System.out.println("Вы ввели: " + code);
        return code;
    }

    public static double convertCurrency(double valueToConvert, double inCurrencyCoef, double outCurrencyCoef) {
        return valueToConvert * inCurrencyCoef / outCurrencyCoef;
    }

    public static void printResult(double inputValue, double resultValue, String currencyNamein, String currencyNameOut) {
        System.out.printf("%.2f", inputValue);
        System.out.print(" " + currencyNamein + " = ");
        System.out.printf("%.2f", resultValue);
        System.out.println(" " + currencyNameOut);
    }

    public static void convertAndPrint(int codeOfCurrencyIn,
                                       int codeOfCurrencyOut,
                                       double valueToConvert,
                                       HashMap<Integer, Double> exchangeRates,
                                       HashMap<Integer, String> currencyNames) {
        double conversionResult = convertCurrency(valueToConvert,
                exchangeRates.get(codeOfCurrencyIn),
                exchangeRates.get(codeOfCurrencyOut));
        printResult(valueToConvert, conversionResult, currencyNames.get(codeOfCurrencyIn), currencyNames.get(codeOfCurrencyOut));
    }

    public static void showAllCurrencies(HashMap<Integer, Double> courses, HashMap<Integer, String> names) {
        System.out.println("Курс валют на сегодня:");
        for (int key : courses.keySet()
        ) {
            System.out.println("" + names.get(key) + " (" + key + ")" + "\t" + courses.get(key) + "\tк 1 Евро");
        }
    }

    public static void showOne(HashMap<Integer, Double> courses, HashMap<Integer, String> names, Integer code) {
        System.out.println("" + names.get(code) + " текущий курс " + courses.get(code) + " к одному Евро");
    }

    public static void fillHashMap(HashMap<Integer, Double> courses, HashMap<Integer, String> names) {
        names.put(1, "AMD");
        names.put(2, "BLL");
        names.put(3, "EUR");
        names.put(4, "USD");
        names.put(5, "SSD");
        names.put(6, "TRL");
        names.put(7, "CZK");
        names.put(8, "JPY");
        names.put(9, "GKD");
        names.put(10, "GBP");

        for (int key : names.keySet()) {
            courses.put(key, (double) (int) (Math.random() * (150 - 10 + 1) + 10));
        }
        courses.put(3, 1D);
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1 - показать список валют и курсов, " +
                "\n2 - показать курс по одной валюте, " +
                "\n3 - конвертировать из одной валюты в другую, " +
                "\n4 - выход");
        System.out.println("Введите код операции:");
    }

    //<<--Methods
        /*
        1. Конвертер валют -

        --метод, который заполнит стартовый хешмэп с кодами и наименованиями,
            и хешмэп с кодами и курсами.
                public static void fillHashMap(mapWithCources, mapWithNames)
        --вывести меню
            -MENU:
            1 - showAll, 2 - showOne, 3 - convert, 4 - exit
                public static void printMenu()

        --показать список доступных валют
            public static void showAllCurrencies(HashMap<Integer, Double> courses, HashMap<Integer, String> names)

        --показать курс введенной
        --конвертация
            -запрашивает валюту исходную
            -запрашивает валюту целевую
                public static integer inputCodeOfCurrency("Введите исходную валюту" "целевую")
            -запрашивает количество исходных денег.
                public static double inputSum()
            -конвертирует и выводит количество в целевой валюте.
                public static void convertAndPrint(codeCurrencyIn,codeCurrencyOut,sum,mapWithCources, mapWithNames)

            типы данных
            для сумм - тип дабл, для наименования валюты - стринг,
            код валюты - интеджер.

            два хешмэп
            1-й интеджер стринг (код валюты, строка)
            2-й интеджер дабл (код валюты, курс валюты)

            пользователь ввел код 840 (1,06)
            мы показали что он ввел доллар, спросили следующую валюту
            пользщователь ввел 333 (2,5)
            мы показали что он ввел юань, и спросили сумму
            пользователь ввел 100

            введенная сумма /курс 1 *курс2

         --выход
         */

}
