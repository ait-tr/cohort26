public class Task2 {

  // модификаторы доступа (access modifiers) бывают и у атрибутов, и у методов:
  // - private - доступны только внутри класса
  // - (default) (по умолчанию) (когда ничего не написано) - доступны всем в рамках пакета (папки)
  //   (package-private)
  // - protected - доступны всем потомкам (даже в других пакетах) (потомки будут позже)
  // - public - доступны всем, можно использовать откуда угодно

  // static - статичный - общий для всех членов класса
  // статичные поля (атрибуты):
  // - константы
  // - счётчики

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
