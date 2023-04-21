import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Run competition results");
//        Смоделировать с помощью датчика случайных чисел
//        поведение биржевого индекса в течение месяца.
//        Биржевой индекс выбрать самостоятельно,
//        данные о диапазоне его изменений взять из Интернета, месяц - март 2023 года.
//        Используйте HashMap для сохранения даты (ключ) и значения индекса.
//        Найдите максимальное, минимальное и среднее значение индекса за месяц.
//        Определите тренд путем сравнения средних значений индекса за первую и
//        второую половину месяца.

        // выбрал NASDAQ, на начало марта: 11373, на конец марта: 12210
        // среднее изменение в день (12210 - 11373)/31 = 27 пунктов

        HashMap<Integer, Integer> nasdaqMap = new HashMap<>();

        for (int i = 0; i < 31; i++) {
            // меняется в среднем на +/- 30 пунктов
            int dayChange = (int)(Math.random() * (30 - 1 + 1) + 1); // это величина изменения
            int dayChangeSign = (int)(Math.random() * (1 - 0 + 1) + 0); // это 0 или 1
            int sign = 0; // это знак + или -
            if (dayChangeSign == 0) {
                sign = 1;
            } else {
                sign = -1;
            }
            nasdaqMap.put(i, 11373 + dayChange * sign);
        }

        // печатаем
        System.out.println(nasdaqMap);

        // ищем минимум за месяц
        int min = nasdaqMap.get(0);
        int minDay = 0;
        for (int day : nasdaqMap.keySet()){
            if (nasdaqMap.get(day) < min){
                min = nasdaqMap.get(day);
                minDay = day;
            }
        }
        System.out.println("Min: " + min + ", it was at " + (minDay + 1) + "of March.");

        // ищем максимум за месяц
        int max = nasdaqMap.get(0);
        int maxDay = 0;
        for (int day : nasdaqMap.keySet()){
            if (nasdaqMap.get(day) > max){
                max = nasdaqMap.get(day);
                maxDay = day;
            }
        }
        System.out.println("Max: " + max + ", it was at " + (maxDay + 1) + "of March.");

        // суммируем за первую половину месяца
        int sum1 = 0;
        for (int i = 0; i < nasdaqMap.size()/2; i++) {
            sum1 = sum1 + nasdaqMap.get(i);
        }
        double average1 = sum1 / (nasdaqMap.size()/2);
        System.out.println(average1);

        // суммируем за вторую половину месяца
        int sum2 = 0;
        for (int i = nasdaqMap.size()/2; i < nasdaqMap.size(); i++) {
            sum2 = sum2 + nasdaqMap.get(i);
        }
        double average2 = sum2 / (nasdaqMap.size() - nasdaqMap.size()/2);
        System.out.println(average2);

        // сравниваем средние значения и делаем вывод
        if (average1 < average2) {
            System.out.println("NASDAQ index grow");
        } else {
            System.out.println("NASDAQ index decrease");
        }
     }
}

/*
        ArrayList<Integer> nasdaqList = new ArrayList<>();

        for (int day : nasdaqMap.keySet()) {
            nasdaqList.add(day, nasdaqMap.get(day));
        }

        System.out.println(nasdaqList);
 */