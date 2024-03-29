# ArrayList углубленно
В обычном массиве (Array) мы **не можем изменить размер**, он задается при создании массива.

Arraylist имеет динамический размер, расширяется автоматически по мере добавления в него элементов.

## Вопрос: ArrayList - это динамический массив?

**ArrayList - реализован на базе стандартного Array.**
На самом деле, ArrayList "на лету" создает новый массив, а не меняет размер старого,
и переносит в него содержимое старого массива.
Размер массива при каждом добавлении элемента списка увеличивается в 1,5 раза.

**Размер массива ни в одном языке программирования "на лету", внутри программы
изменить нельзя.**

## Вопрос: чем ArrayList лучше, чем просто Array?
- Добавление и удаление элементов легче в ArrayList, не надо думать о размере массива
- Сортировка для ArrayList реализована стандартными методами в Collections, для Array надо писать самим
- поиск, проверка на наличие (.contains)
- ...
ArrayList against Array

## Вопрос: бывает ли ArrayList двух и более мерным? 
Ответ - грубо говоря, нет. Но в перспективе мы будем использовать классы/объекты (концепция ООП), 
элементами ArrayList будут объекты классов, у каждого объекта класса есть несколько разных полей 
и даже с разными типами данных. 
В теории мы можем построить ArrayList<ArrayList1>.
На практике для задач c многомерными массивами лучше использовать стандартный Array[][].

## ArrayList - прямое заполнение методом asList
ArrayList<String> namesList = new ArrayList<String>(Arrays.asList("Peter","Vladimir","Stepan"));
System.out.println(namesList);
_________________________________________________

## Список уже полученных знаний и умений:
    1. Типы переменных (ТИП , имя, значение )
int, double, long, char, float, short, byte, boolean - примитивные типы
String - сложный тип

    2. Символы и ASCII - коды, Unicode - расширенная таблица
большая часть внешней информации - строки
внутри компьютера все превращается в числа

    3. Накопление суммы/значения в переменной
sum = sum + 1;
sum++;
sum--;
++sum; - что это значит?

    4. Вывод текста и "результатов" на экран
sout => System. и тд
System.out.printf("   шаблон", переменная); - это для форматированного вывода

    5. Запрос данных от пользователя - число, строка, символ (Scanner)
Но есть BufferReader, его тоже можно и нежно не забывать.

    6. Проверка условия, выбор - if...else, switch...case
третьего НЕ ДАНО!!! , boolean может быть только true, false

    7. Формальная логика, логические операторы
таблица операторов &, &&, ||, и т.д.

    8. Проверка делимости нацело (if (i%2 == 0) - делимость на 2)
число%3 == 0, число%5 == 0 - это делимость нацело

    9. Циклы - while, do...while, for
fori - часто применяемый, 
нарисовать блок-схемы - это задание

    10. Массивы - объявление и наполнение
int[], есть индекс у элемента массива, а есть сам элемент массива под этим индеском

    11. Датчик случайных чисел
int n = (int)(Math.random() * (m - n + 1) + n) - целые числа в интервале от n до m включительно!  
кубик из 6 граней n = (int)(Math.random() * (6 - 1 + 1) + 1)
орел и решка n = (int)(Math.random() * (1 - 0 + 1) + 0)

    12. Методы
psvm -> public static void(или тип) имяМетода(параметр 1, ... ) - это называется сигнатура метода

    13. Алгоритм запуска цикла
**Алгоритм запуска цикла:**
Шаг 1. Задаем переменную (счетчик, параметр) цикла;
Шаг 2. Определить условие повторения цикла;
Шаг 3. Заполнить тело цикла необходимыми оператрами;
Шаг 4. Изменить переменную (счетчик, параметр) цикла;
Шаг 5. Запустить цикл и проверить его работу на крайних значениях и в целом.

    14. Руководство по разработке программ
Руководство по разработке программ:
ШАГ 1: Постановка задачи:
- Что будем вводить? Что на входе?
- Какие данные на входе?
- Что надо сделать?
- Что будет на выходе из программы?
- Ключевой алгоритм? - записать алгоритм, нарисовать блок-схему
- Какой будет интерфейс взаимодействия с пользователем? - кратко описать

ШАГ 2: Написание кода:
- импорт необ[одимых компонент;
- подcказки по синтаксису языка;
- похожие примеры кода... (компилятор помогает!)

ШАГ 3: Запуск и отладка
- устраняем ошибки синтаксиса...

ШАГ 4: Тестирование на разных наборах данных и на все случаи по логике

Шаг 5: Можно "продавать продукт" 😉

    15. Теорема Бёма-Якопини (три управляющих структуры)
Парадигма программирования - Структурированное программирование
GO TO - полный отказ
шаг, условие, цикл - всего три структуры 

    16. Вывод массива на печать по порядку и задом наперед
for (int i = array.length , i > 0, i--)

    17. Список - ArrayList - структура данных

18. Arrays - класс для массивов и его методы

