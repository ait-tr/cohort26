import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       System.out.println("Phone book");
//        Создайте телефонную книгу нашей группы со следющим функционалом:
//        - добавить контакт (имя и телефон)
//        - найти контакт
//        - вывести(напечатать) все контакты
//        - удалить контакт

// Шаг 1 - сделать костяк по выбору из меню и само меню
// Шаг 2 - сделаем методы для выполнения задач из меню

        Scanner scanner = new Scanner(System.in);
        int userChoise = 0;
        HashMap<String, String> phoneBook = new HashMap<>();

        do {
            printMenu();
            try {
                userChoise = scanner.nextInt();

            switch (userChoise) {
                case 1: {
                    // add
                    addContact(phoneBook);
                    break;
                }
                case 2: {
                    // show (print contacts)
                    printContacts(phoneBook);
                    break;
                }
                case 3: {
                    // search phone number by name
                    String phone = searchContacts(phoneBook);
                    if (!phone.equals(null)){
                        System.out.println("Phone: " + phone); // печатаем результат работы метода
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                }
                case 4: {
                    // delete
                    if (deleteContact(phoneBook)){ // если метод вернул true
                        System.out.println("Contact deleted.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                }
                case 5: {
                    // Exit
                    return;
                }
            } // конец оператора switch
            } catch (InputMismatchException e) { // проверка на некорректный ввод
                System.out.println("Wrong input, try again.");
                scanner.next();
            }

        } while(true); // конец цикла while

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

    // метод печатает все контакты
    public static void printContacts (HashMap<String, String> contacts){
        // цикл for each переберет весь HashMap по ключу и напечатает
        for (String name: contacts.keySet()) {
            System.out.println("Name: "+ name + " | Phone number: " + contacts.get(name));
        }
    }

    // метод для поиска телефона по имени
    public static String searchContacts(HashMap<String, String> contacts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scanner.next();
            if (contacts.containsKey(name)) { // если имя нашлось, то
                return contacts.get(name); // возвращаем телефон
            }
        return null;
    }

    // метод для удаления телефона по имени
    public static boolean deleteContact(HashMap<String, String> contacts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scanner.next();
        if (contacts.containsKey(name)) { // если имя нашлось, то
            contacts.remove(name); // удаляем элемент HashMap contacts
            return true; // возвращаем true
        }
        return false;
    }
    //_________end of Methods_____________________
}
