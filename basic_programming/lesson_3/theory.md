Для вывода данных на экран мы использовали System.out. (Класс и метод)
Для ввода данных будем использовать System.in. (Класс и метод)

**Вариант 1**
import java.io.*;

Reader inputStreamReader = new InputStreamReader(System.in);
BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

String name = bufferedReader.readLine(); //читаем строку с клавиатуры
String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
int nAge = Integer.parseInt(sAge); //преобразовываем строку в число.

Более компактная запись:
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

String name = br.readLine(); // читаем строку
String sAge = br.readLine(); // читаем строку
int nAge = Integer.parseInt(sAge); // преобразовываем строку в целое число

**Вариант 2**
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
String name = sc.next(); // - чтение строки до символа " "
String name = sc.nextLine(); // - чтение строки до символа "ввод"
int num = sc.nextInt(); // - чтение целого числа
int double = sc.nextDouble(); // - чтение числа c десятичной дробной частью

Подробности про класс BufferedReader: https://javarush.com/groups/posts/1919-schitihvanie-s-klaviaturih--riderih
Подробности про класс Scanner: https://javarush.com/groups/posts/klass-scanner



### Алгоритм организации ввода данных с клавиатуры:
Шаг 1. import необх. библиотек
Шаг 2. Инициализация классов и методов для чтения вводимых данных
Шаг 3. Приглашение пользователю с помощью System.out.println("Введите ...");
Шаг 4. Выбор типа переменной, придумывание ей имени, выбор метода чтения;
Шаг 5. Использование полученных данных.
