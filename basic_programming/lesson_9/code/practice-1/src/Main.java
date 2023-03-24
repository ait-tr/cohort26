public class Main {
    public static void main(String[] args) {
        System.out.println("Работаем с классом Math");

        int a = Math.min(10, 4);
        System.out.println("Минимальное из двух чисел: " + a);

        int b = Math.max(10, 45);
        System.out.println("Максимальное из двух чисел: " + b);

        double m1 = Math.min(45.0d, 95.6D);
        System.out.println("Минимальное из двух чисел: " + m1);

        int mod = Math.abs(-25);
        System.out.println("Модуль числа -25: " + mod);

        double sq = Math.sqrt(25);
        System.out.println("Корень квадратный из 25: " + sq);

        double p = Math.pow(2.0, 5.0);
        System.out.println(" 2 в степени 5 : " + p);

        // методы для округлений
        double ce = Math.ceil(12.34567); // округление до ближайшего большего целого
        System.out.println(" Округляем до целого вверх 12.34567 " + ce);
        double fl = Math.floor(12.34567); // округление до ближайшего меньшего целого
        System.out.println(" Округляем до целого вниз 12.34567 " + fl);

        double ro = Math.round(12.34567);
        System.out.println(" Округляем 12.34567 " + ro);

        double ro1 = Math.round(12.56);
        System.out.println(" Округляем 12.56 " + ro1);

        double price = Math.round(15.12745 * 100.0)/100.0;
        System.out.println(" Округляем 15.12345 рубли (еввро) до 2-х знаков после запятой " + price);

    }
}


/*
        System.out.println("Первая строка\nвторая строка\nтретья строка");
        System.out.println("Первая строка\rвозврат каретки\r строка");
        System.out.println("Первая строка\t табуляция \t табуляция");
        System.out.println("Первая строка\b\b"); // - backspace

        // что делать, если в строке надо напечатать служебные символы ", ', /
        //  \' - вывод апострофа внутри строки
        //  \" - вывод кавычек внутри строки
        //  \\ - вывод наклонной черты внутри строки

        System.out.println("Это пример строки с \"кавычками\" внутри");

        //
        String sentence = "One Two Three Four"; // объявили строковую переменную
        int countWords = sentence.split("\\s").length; // объявили целочисленную переменную
        System.out.println("Количество слов:  " + countWords);

 */