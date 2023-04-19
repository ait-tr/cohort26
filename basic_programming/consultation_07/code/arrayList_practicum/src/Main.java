import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("ArrayList practicum");
//        Создать собственный ArrayList, выполнить с ним все операции, которые мы делали на занятии:
//        - создать список
//        - наполнить элементами
//        - распечатать
//        - узнать размер (длину)
//        - узнать индекс какого-либо элемента
//        - удалить какой-либо элемент
//        - проверка на наличие
//        - добавление дубликата
//        - печать списка с индексами
//        - сортировка

        ArrayList<String> employeeList = new ArrayList<>(); // задали (определили) новый ArrayList
        employeeList.add("Пол Маккартни");
        employeeList.add("Джон Леннон");
        employeeList.add("Риго Старр");
        employeeList.add("Джорж Харрисон");

        System.out.println(employeeList);

        int length = employeeList.size();
        System.out.println(length);

        System.out.println(employeeList.get(0));
        System.out.println(employeeList.get(3));

        employeeList.set(3, "Джордж Харрисон");
        System.out.println(employeeList.get(3));

//        - узнать индекс какого-либо элемента
//        - удалить какой-либо элемент
        int index = employeeList.indexOf("Джон Леннон");
        System.out.println(index);

        employeeList.remove(2);
        System.out.println(employeeList);

//        - проверка на наличие
//        - добавление дубликата
        boolean isInList = employeeList.contains("Пол Маккартни");
        System.out.println(isInList);

        employeeList.add("Джон Леннон");
        System.out.println(employeeList);

        // пройти в цикле по всем элементам листа.
        // ищем случай, когда для i-го элемента нашелся ему равный, но с другим индексом.
        // в этом случае, найденный элемент необходимо удалить.

        int pointer = -1;

        for (int i = 0; i < employeeList.size(); i++) {
            for (int j = i + 1 ; j < employeeList.size(); j++) {
                if (employeeList.get(i).equals(employeeList.get(j))) {
                    pointer = j;// нашли индекс дубликата
                    System.out.println("Duplicate value is: " + employeeList.get(pointer));
                }
            }
        }

        // удаляем дубликат
        employeeList.remove(pointer);
        System.out.println(employeeList);

        employeeList.add("Пол Маккартни");
        employeeList.add("Джон Леннон");
        employeeList.add("Ринго Старр");
        employeeList.add("Джорж Харрисон");

        Collections.sort(employeeList);
        System.out.println(employeeList);

    }
}