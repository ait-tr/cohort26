**Роли в ИТ-команде:**
- проджект-менеджер (сроки, бюджеты, ЦЕЛЬ/РЕЗУЛЬТАТ);
- аналитик, архитектор (общие алгоритм, схема данны);
- кодер (програмист).

**Что мы уже знаем - ОБОБЩЕНИЕ:**
- переменные и их типы - примитивные(int, double, boolean...) и НЕпримитивные (String, 
Integer, Double ...), имя переменной надо придумывать, snakeStyle для переменных;
- ввод данных с клавиатуры (Scanner, BufferReader);
- математические действия (Math и в нем множество методов);
- датчик случайных чисел Math.random();

- условие (ветвление), тернарный оператор, switch ... case;

- циклы (loop) - while(){} может не проработать ни разу (не будет захода в тело цикла), 
do{ ... } while(); будет хотя бы один раз проход по телу цикла, 
- for отрабатывает нужно количество раз, пробегает по индексам (обычно);
- for each - ОСОБЫЙ ЦИКЛ, используется для обхода коллекции, в которой не индексов!!!,
задавемая в нем переменная (int, String, ...) - это итератор, который перебирает все элементы

- exceptions: try{  
  ...
  } catch (Exception e) { сообщение }
  } catch (Exception e) { сообщение }
  } catch (Exception e) { сoобщение }
- защита от ошибок ввода, математические, работа с файлами, переполнения, 
выход за пределы массива ...

- способы защиты от ввода некорректных данных;
  while (!sc.hasNextInt()) {
  System.out.println("Похоже вы ввели не число. Повторите ввод");
  sc.next();
  }
  int abc = sc.nextInt();

- структуры для храненеия и обработки данных:
   1. Массивы (Array) - только ОДИН тип данных, размер - фиксирован при объявлении.
   2. ArrayList - размер массива скрыт от нас, он увеличивается/уменьшается самостоятельно.
   3. HashSet - в нем не может быть ДУБЛИКАТОВ, все элементы УНИКАЛЬНЫ, не сортируется
  и НЕТ индексов, поэтому используем for each 
   4. HashMap - элементы вида ключ+значение, "прорыв" в том, что ключ и значение могут 
  быть разных типов 
  
- методы (функции)
**Особенности при программировании методов:**
- приходится "скакать" вверх-вниз по программе;
- надо придумывать название метода;
- надо принять решение о том, будет ли метод что-то возвращать или нет (void),
если будет, то какой тип данных;
- надо принять решение о передаваемых в метод параметрах(аргументов) 
и как они будут называться **внутри метода**!
- после написания метода надо его вызвать с передачей ему необходимых параметров 
(аргументов):
  - вар. 1 - в виде присвоения результата соответствующей переменной;
  - вар. 2 - просто в виде вызова метода по имени.

**Вопросы на понимание:**
- в чем отличие метода от функции?
  Ответ: ПРИНЦИПИАЛЬНО - различий нет, это синонимы
  Но метод может ничего не возвращать (void), а функция - обязана.

- как в Java реализованы процедуры?
  Ответ: НИКАК, термина "процедура" в Java нет.