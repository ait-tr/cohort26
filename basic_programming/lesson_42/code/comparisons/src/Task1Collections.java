import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1Collections {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();

    Collections.addAll(numbers, 3, 2, 7, 4);
    System.out.println("numbers = " + numbers);
    System.out.println("Collections.max(numbers) = " + Collections.max(numbers));
    System.out.println("Collections.min(numbers) = " + Collections.min(numbers));

    Collections.reverse(numbers);
    System.out.println("После Collections.reverse(numbers):");
    System.out.println("numbers = " + numbers);

    // Сортировка in-place - на месте - мы не получаем новый (отсортированный) список,
    // а меняем порядок в уже существующем
    Collections.sort(numbers); // sort всегда сортирует по возрастанию
    System.out.println("После Collections.sort(numbers):");
    System.out.println("numbers = " + numbers);

    // Сортировка по убыванию: sort + reverse
    // Collections.rotate(): 1, 2, 3, 4  ->  2, 3, 4, 1
    // - замечательно подойдёт для шифра Цезаря - в нём используется алфавит со сдвигом
  }
}
