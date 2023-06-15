package homework_61;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  // Создайте список учеников с баллами.
  //
  // Попросите пользователя ввести минимальный проходной балл.
  //
  // Выведите список учеников согласно следующим условиям:
  // - каждый ученик выведен в отдельной строке
  // - баллы каждого ученика выше минимального проходного
  // - ученики отсортированы по убыванию среднего балла
  // - в списке не больше 10 учеников (извините, конкурс)
  //
  // Для обработки и вывода результата используйте потоки (`Stream`).
  //
  // ## Примечание
  // Cортировка потока выполняется при помощи промежуточного метода `sorted(Comparator<? super T> comparator)`.
  // В качестве компаратора используйте лямбда-функцию.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Student> students = createStudentList();
    System.out.print("Введите минимальный проходной балл: ");
    int passingScore = scanner.nextInt();
    scanner.nextLine();

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
