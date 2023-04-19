import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       System.out.println("Phone book");
//        Создайте телефонную книгу нашей группы со следющим функционалом:
//        - добавить контакт (имя и телефон)
//        - найти контакт
//        - вывести(напечатать) все контакты
//        - удалить контакт

    // Шаг 1 - сделать костяк по выбору из меню и собственно меню
    // Шаг 2 - сделаем методы для выполнения задач из меню

        Scanner scanner = new Scanner(System.in);
        int userChoise = 0;
        HashMap<String, String> phoneBook = new HashMap<>();

        do {
            printMenu();
            userChoise = scanner.nextInt();

            switch (userChoise) {
                case 1: {
                    // add
                    addContact(phoneBook);
                    break;
                }
                case 2: {
                    // show
                    printPhoneBook(phoneBook);
                    break;
                }
                case 3: {
                    // search
                    System.out.println(searchPhoneBook(phoneBook));

                    break;
                }

                case 4: {
                    // 4-й пункт меню
                    break;
                }

                case 5: {
                    // Exit
                    return;
                }

            }

        } while(true);

    }
    //_________Methods_____________________
// печатаем меню
    public static void printMenu() {
        System.out.println("1 - add, 2 - show, 3 - search, 4 - delete, 5 - exit");
        System.out.println("Input your choice: ");
    }

    // метод добавляет контакт
    public static HashMap<String, String> addContact(HashMap<String, String> contacts)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scanner.next();
        System.out.println("Input phone number: ");
        String phone = scanner.next();
        contacts.put(name, phone);
        return contacts;
    }

    public static void printPhoneBook (HashMap<String, String> contacts){
        // цикл for each переберет весь HashMap по ключу и напечатает
        for (String name: contacts.keySet()) {
            System.out.println("Name: "+ name + " | Phone number: " + contacts.get(name));
        }
    }

    // метод для поиска телефона по имени
    public static String searchPhoneBook(HashMap<String, String> contacts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scanner.next();
       // for (String n : contacts.keySet()) { // перебор всех значений
            if (contacts.containsKey(name)) { // если совпало
       //         System.out.println(n + " | " + contacts.get(n));
                return contacts.get(name);
            }

        return null;
    }

    //_________end of Methods_____________________
}





/*
 Scanner scanner = new Scanner(System.in);
       int userChoice;

       HashMap<String, String> phoneBook = new HashMap<>();
       do {
           menu();
           System.out.println("Input your choice:");
           userChoice = scanner.nextInt();

           switch (userChoice) {
               case 1: {
                   // add
                   System.out.println("Add contact");
                   addContact(phoneBook);
                   break;
               }
               case 2: {
                   //show
                   System.out.println("Show contacts");
                   printPhoneBook(phoneBook);
                   break;
               }
               case 3: {
                   //find
                   System.out.println("Find contact");
                   // вызов метода
                   System.out.println("Input name: ");
                   String name = scanner.next();
                   findContact(phoneBook, name);
                   break;
               }
               case 4: {
                   //delete
                   System.out.println("Delete contact");
                   // вызов метода
                   break;
               }
               case 5: {
                   //exit
                   System.out.println("Exit");
                   return;
               }

           }
       }while (true); // конец цикла

     // печатаем меню
    public static void menu() {
        System.out.println("Menu:");
        System.out.println("1 - add, 2 - show, 3 - find, 4 - delete contact, 5 - exit");

    }
    // добавляем контакт
    public static HashMap<String, String> addContact( HashMap<String, String> contact) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name");
        String name = scanner.next();
        System.out.println("Input phone number");
        String phone = scanner.next();
        contact.put(name, phone);
        System.out.println("Contact added");
        return contact;
    }
    // печатем все контакты
    public static void printPhoneBook (HashMap<String, String> contacts){
        for (String name: contacts.keySet()){
            System.out.println("Name: " + name + "| Phone: " + contacts.get(name));
        }
    }

    // метод ищет контакт
    public static void findContact (HashMap<String, String> contacts, String name){
        for (String n: contacts.keySet()){
            if(contacts.containsKey(name)) {
                System.out.println(n + " | " + contacts.get(name));
            } else {
                System.out.println("Contact not found");
            }
        }

    }


 */