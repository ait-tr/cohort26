import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("ArrayList reverse");

//        Напишите программу, которая:
//        - прочитает размер списка (ArrayList) косметических брендов (можно и другие бренды)
//        - прочитает элементы списка с клавиатуры
//        - выведет список на печать
//                - "перевернёт" элементы (поменяет местами первый с последним, второй с предпоследним и т.д.)
//                - выведет изменённый список

        Scanner scanner = new Scanner(System.in); // включили сканер
        ArrayList<String> furnitureList = new ArrayList<>(); // задали лист
        System.out.println("Input number of list's elements");
        int numList = scanner.nextInt();

        for (int i = 0; i < numList; i++) {
            System.out.println("Input furniture: ");
            furnitureList.add(scanner.next());
           // String listElement = scanner.next();
           // furnitureList.add(i,listElement);
        }

        System.out.println(furnitureList);

        for (int i = 0; i < furnitureList.size() / 2; i++) {
            String temp = furnitureList.get(i); // отложили в temp i-ый элемент массива
            furnitureList.set(i, furnitureList.get(furnitureList.size() - 1 - i)); // на место первого элемента списка кладем правый крайний
            furnitureList.set(furnitureList.size() - 1 - i, temp);
        }

        System.out.println(furnitureList);

    }
}