import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача про месяц и год");
        // Написать программу, которая принимает с клавиатуры номер месяца и год и выводит на экран название месяца
        // и количество дней в нем.

        // Что на входе: номер месяца (int , больше 0 и меньше 13 ), год (int , положительное)
        // Что на выходе: месяц (Sting) , количество в нем дней
        // Ключевой алгоритм:
        // Как перевести число в название месяца?
        // Как определить количество дней в месяце?
        // Зависит ли это от года? Високосный или нет?
        // Ключевой алгоритм: используем switch case 12 раз 1 -> cтроку с названием месяца
        // количество дней в месяце сабидно известно, исключение - високосный год, только месяц февраль
        // полезные фрагменты кода:
        // определение високосного года

        // вариант 1
//      if (year%4==0 && year%100==0){
//                System.out.println("It's a leap year");
//        } else if (year%100==0 && year%400==0)
//        System.out.println("It's a leap year");
//        else
//            System.out.println("It's not a leap year");
//            }
//        }

        // вариант 1
    //      if (year%4==0 && !year%100==0){
//                System.out.println("It's a leap year");
//        } else if (year%100==0 & year%400==0)
//        System.out.println("It's a leap year");
//        else
//            System.out.println("It's not a leap year");
//            }
//        }


    }
}




// Что на входе? - целое число месяцев (1, 2, 3 и ... до 12) и целое положительное число год
// Что на выходе? - название месяка (строка) и количество дней в этом месяце




