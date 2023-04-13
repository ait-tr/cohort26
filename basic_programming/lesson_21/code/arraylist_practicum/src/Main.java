import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("ArrayList practicum");

    // ArrayList<ТИП> имяМассива = new ArrayList<ТИП>(); - так объявляем ArrayList

        ArrayList<String> autoBrandList = new ArrayList<String>();

        // добавляем элементы в список
        autoBrandList.add("BMW");
        autoBrandList.add("AUDI");
        autoBrandList.add("Skoda");
        autoBrandList.add("Lexus");
        autoBrandList.add("Jaguar");
        autoBrandList.add("Dodge");
        autoBrandList.add("Opel");
        autoBrandList.add("Volvo");
        autoBrandList.add("ZAZ");
        autoBrandList.add("KIA");
        autoBrandList.add("Ferrari");

        // напечатали список
        System.out.println(autoBrandList);

        // узнаем длину списка (количество элементов)
        int length = autoBrandList.size();
        System.out.println("Numbers of brands in list " + length);

        // узнаем номер (индекс) в списке
        int index = autoBrandList.indexOf("Lexus");
        System.out.println("Index Lexus in the list: " + index);

        // узнаем наличие в списке
        boolean brandPresents = autoBrandList.contains("KIA");
        System.out.println("KIA presents: " + brandPresents);

        boolean brandPresents1 = autoBrandList.contains("Kia");
        System.out.println("KIA presents: " + brandPresents1);

        // добавляем
        autoBrandList.add("Audi");
        System.out.println(autoBrandList);
        // добавляем еще раз опять AUDI
        autoBrandList.add("AUDI");
        System.out.println(autoBrandList); // можно добавлять одинаковые элементы в список

        // удаление элемента из списка
        autoBrandList.remove("AUDI"); // удален первый из нашедшихся элемнтов
        System.out.println(autoBrandList);
        int ind1= autoBrandList.indexOf("Audi"); // ищем индекс
        autoBrandList.remove(ind1); // удаляем по индексу
        System.out.println(autoBrandList); // печатаем список

        String brand = autoBrandList.get(5); // получение элемента по индексу
        System.out.println(brand);

        for (int i = 0; i < autoBrandList.size(); i++) {
            System.out.println( i + " : " + autoBrandList.get(i));
        }

        //Сортировка списка (листа)
        Collections.sort(autoBrandList);
        System.out.println(autoBrandList); // печатаем список

    }
}