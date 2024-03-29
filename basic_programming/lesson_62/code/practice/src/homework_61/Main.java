package homework_61;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

  // Создайте список учеников с баллами.
  //
  // Попросите пользователя ввести минимальный проходной балл.
  //
  // Выведите список учеников согласно следующим условиям:
  // - каждый ученик выведен в отдельной строке
  // - баллы каждого ученика не ниже минимального проходного
  // - ученики отсортированы по убыванию среднего балла
  // - в списке не больше 10 учеников (извините, конкурс)
  //
  // Для обработки и вывода результата используйте потоки (`Stream`).
  //
  // ## Примечание
  // Сортировка потока выполняется при помощи промежуточного метода `sorted(Comparator<? super T> comparator)`.
  // В качестве компаратора используйте лямбда-функцию.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Student> students = createStudentList();
    System.out.print("Введите минимальный проходной балл: ");
    int passingScore = scanner.nextInt(); // минимальный проходной балл
    scanner.nextLine();

    // получаем из списка поток (stream)
    students.stream()
        // отбрасываем всех с баллами меньше минимального - intermediate operation
        .filter(s -> s.getScore() >= passingScore)
        // сортируем по убыванию баллов - stateful intermediate operation
        .sorted((s1, s2) -> -Integer.compare(s1.getScore(), s2.getScore()))
        // ограничиваем список - не больше 10 студентов - intermediate operation
        .limit(10)
        // каждого выводим в новой строке - terminal operation
        .forEach(System.out::println);
  }

  private static List<Student> createStudentList() {
    List<Student> result = new ArrayList<>();
    result.add(new Student("Бовша Альберт Рустамович", 99));
    result.add(new Student("Богатикова Антонина Дмитриевна", 101));
    result.add(new Student("Горохов Степан Леонидович", 75));
    result.add(new Student("Гусев Александр Семенович", 43));
    result.add(new Student("Дзугаев Ахсарбек Станиславович", 130));
    result.add(new Student("Загибалов Павел Дмитриевич", 76));
    result.add(new Student("Землянов Константин Александрович", 67));
    result.add(new Student("Игумеников Степан Владимирович", 99));
    result.add(new Student("Каламбетов Даниил Эдуардович", 88));
    result.add(new Student("Карданова Аида Аскеровна", 80));
    result.add(new Student("Кашина Оксана Алексеевна", 95));
    result.add(new Student("Киреев Кирилл Александрович", 100));
    result.add(new Student("Коротких Анна Алексеевна", 0));
    result.add(new Student("Кудряшов Дмитрий Романович", 200));
    result.add(new Student("Мамлеева Аделина Ринатовна", 90));
    result.add(new Student("Паршин Егор Ильич", 15));
    return result;
  }
}
