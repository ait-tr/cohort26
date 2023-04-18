import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Group list with Ages");
//        Создать HashMap с именами и возрастом членов нашей группы.
//        Распечатать список группы с возрастами.

        HashMap<String, Integer> group26Map = new HashMap<>();

        group26Map.put("Galina", 44);
        group26Map.put("Oleksandr Zhurba", 38);
        group26Map.put("Aleksndra", 16);
        group26Map.put("Marina", 41);
        group26Map.put("Luka", 28);
        group26Map.put("Tetiana",34);
        group26Map.put("Christian",30);
        group26Map.put("Yulia",52);
        group26Map.put("Andrei",36);
        group26Map.put("Egor", 29);
        group26Map.put("Dmitrijs",32);
        group26Map.put("Wladimir",31);
        group26Map.put("Galina", 34); // это значение заместило старое, тк ключ совпал

        //       System.out.println(group26Map); // - это быстрая печать HashMap

//        // Print keys - проход по всем ключам
//        for (String i : nameHashMap.keySet()) {
//            System.out.println(i);
//        }

        // цикл for each, проход по всем ключам
        for (String name : group26Map.keySet()) {
            System.out.println(name); // в операторе должна участвовать переменная цикла
        }

//        // Print values - проход по всем значениям
//        for (String i : nameHashMap.values()) {
//            System.out.println(i);
//        }

        // цикл for each, проход по всем значениям
        for (int age: group26Map.values()) {
            System.out.print(age + ", "); // в операторе должна участвовать переменная цикла
        }

//        // Print keys and values - проход по всем ключам и их значениям
//        for (String i : nameHashMap.keySet()) {
//            System.out.println("key: " + i + " value: " + nameHashMap.get(i));
//        }
        for (String st : group26Map.keySet() ) {
            System.out.println("Key: " + st + " value: " + group26Map.get(st));
        }
    }
}









/*
        HashMap<String, Integer> group26 = new HashMap<String, Integer>(); // инициализация HashMap

        group26.put( "Name 1", 25);
        group26.put( "Name 2", 35);
        group26.put( "Name 3", 45);
        group26.put( "Name 0", 50);
        group26.put( "Name 10", 15);

//        for (String i : nameHashMap.keySet()) {
//            System.out.println("key: " + i + " value: " + nameHashMap.get(i));
//        }

        for (String name : group26.keySet()) {
            System.out.println("key: " + name + " value: " + group26.get(name));
        }
 */