# Задача и ее отладка в Debugger
## Задача: найти наибольший общий делитель (НОД) двух целых чисел a и b.
Примеры:
15 и 20: НОД = 5
15 и 60: НОД = 15
17 и 23: НОД = 1
24 и 40: НОД = 8
6 и 18: НОД = 6

## Алгоритм
Шаг 1 - сравниваем данные 2 числа, находим меньшее из них (если есть делители общие, то они <= этому числу)'
Шаг 2 - перебираем в цикле числа от 1 до меньшего и проверяем разделилось нацело ли мешьшее из чисел на пареметр цикла
Шаг 3 - если большее из чисел разделилось тоже, то это и есть наш НОД
24 и 40
меньшее 24
перебираем числа от 1 до 24 (включительно), 1, 2, 3, 4, 5, ... , 8 , ..., 24 
Делится ли 24 на одно из этих чисел? Если да, то проверяем, 40 делиться на это же число.

**Отладка в Debugger:**
1. Поставить точку остановки программы (break point) - красная точка слева от номера строки програмы
2. Запустить кнопкой с "жучком" (Run -> Debug...)
3. F8 - сделать шаг по программе, то есть перейти на строчку ниже с выполнением
4. F7 - войти/перейти в метод или цикл
5. Переключаться между окнами Debugger и Console в ходе исполнения программы
________________________________________________

# ArrayList - что это и зачем?
## Концепция массива Array:
ТИП[] имя_массива = new ТИП[размер];
Массивы хранят данные ОДНОГО ТИПА (int, Srting, double, ...).

В массиве данные можно сохранить и затем ими управлять:
**C - создать, R - прочитать, E|U - отредактировать или обновить, D - удалить = CRED.**
НО с массивами "трудно" работать. В массивах очень "затратны" операции
поиска, добавления и сдвига, сортировки и т.д.

### Концепция коллекций Collection (Collections Framework):
**Коллекция (Collection)** в Java — это структура, которая обеспечивает
архитектуру для хранения и управления группой **Объектов (Objects)**.

А что такое **Объект (Object)** ? - это нужная/полезная для смысла жизни "сущность", например:
предмет, человек или животное, организация, деталь и т.д.

Совокупность однородных объектов формирует **Класс (Class)**.
Пример: класс Автомобили, класс Млекопитающие, класс Звезды и т.д.

**Коллекции** позволяют хранить группы Объектов, это абстракция гораздо более общего уровня,
чем массивы. Хранить и управлять коллекциями в конечном счёте удобнее, выгоднее, чем массивами.

Для управления данными в коллекциях нужны **Интерфейсы** - способы управления/манипулирования
объектами в коллекциях. В целом интерфейсы обеспечивают примерно одно и то же - **CRED** объектов
в коллекциях, но их реализация бывает специфична из-за различий видов и типов объектов в коллекциях.

Кто-то в группе архитекторов Java очень хорошо подумал и выявил общее свойство
для хранимых данных - **ПЕРЕЧЕСЛИМОСТЬ(ITERABLE)**.

Интерфейс **Iterable** - "родитель" трех видов интерфейсов:
- List (Список)
- Queue (Очередь)
- Set (Набор),
  которые позволяют работать с коллекциями.

Наша с вами задача на данном этапе начать работать с классом **ArrayList**:
* Список - это коллекция, в которой все элементы имеют порядковый номер.
  Например, если элемент положили третьим, то его можно и получить под этим номером.

Класс **ArrayList** позволяет нам создавать объекты такого класса и ими пользоваться.

Снтаксис для создания объекта класса, который нам уже знаком:
класс Scanner позволяет создавать в каждой программе объект класса Scanner:
Scanner scanner = new Scanner(System.in);
и использовать его для чтения данных с клавиатуры.

### Синтаксис создания ArrayList:
import java.util.ArrayList;

ArrayList<ТИП> имяМассива = new ArrayList<ТИП>();

**примеры:**
ArrayList<int> myArrayList = new ArrayList<int>(); // список целых чисел
ArrayList<String> myNamesList = new ArrayList<String>(); // список строк

### Действия с ArrayList:
1. Создать список
2. Вывести на печать
3. Узнать длину списка
4. Узнать индекс объекта в списке
5. Удалить объект из списка
6. Проверить наличие объекта в списке
7. Добавить объект в список, если его в нем нет
8. Вывод списка в цикле
________________________________________
9. Сортировка списка
10. Сортировка в оратном порядке (*)

