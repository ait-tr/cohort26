public class Task2 {

  // модификаторы доступа (access modifiers) бывают и у атрибутов, и у методов:
  // - private - доступны только внутри класса
  // - (default) (по умолчанию) (когда ничего не написано) - доступны всем в рамках пакета (папки)
  //   (package-private)
  // - protected - доступны всем потомкам (даже в других пакетах) (потомки будут позже)
  // - public - доступны всем, можно использовать откуда угодно

  // static - статичный - общий для всех членов класса
  // статичные атрибуты и методы доступны не через "объект.членКласса", а через "Класс.членКласса"
  // статичные поля (атрибуты):
  // - константы
  // - счётчики
  // статические методы:
  // - чтение из строки (парсинг)
  // - действие, по смыслу неразрывно связанное с конкретым классом, но никак не связанное
  //   (может быть, пока) с конкретным объектом
  // - расчёты "в целом"
  // - проверка условия
  // - примеры:
  //   - String.format()
  //   - Integer.parseInt()
  // !!!
  // Статические методы НИЧЕГО не знают про конкретный объект - в статических методах нельзя
  // использовать this - нет никакого "этого" объекта, есть только сам класс.

  public static void main(String[] args) {
    Student first = new Student("First");
    System.out.println(first.getString()); // здесь студентов ровно 1 и Student.counter == 1
    Student second = new Student("Second");
    System.out.println(first.getString()); // здесь студентов ровно 2 и Student.counter == 2
    System.out.println(second.getString()); // здесь студентов ровно 2 и Student.counter == 2
    Student fourth = new Student("Fourth");
    System.out.println(first.getString()); // здесь студентов ровно 3 и Student.counter == 3
    System.out.println(second.getString()); // здесь студентов ровно 3 и Student.counter == 3
    System.out.println(fourth.getString()); // здесь студентов ровно 3 и Student.counter == 3
  }
}
