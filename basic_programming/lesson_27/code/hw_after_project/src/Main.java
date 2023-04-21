import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Run competition results");
//      Имеются результаты забега на 100 метров группы бегунов из 10 участников.
//      Внести эти результаты в компьютер согласно протоколу.
//      Отсортировать результаты, напечатать кто занял 1-е и кто занял последнее место.
//      Используйте HashMap для хранения результатов забега и ArrayList для сортировки.

        // участники забега: номер + Фамилия
        HashMap<Double, String> resultsMap = new HashMap<>();
        resultsMap.put(10.2, "Owens");
        resultsMap.put(9.95, "Hines");
        resultsMap.put(9.92, "Lewis");
        resultsMap.put(9.79, "Grin");
        resultsMap.put(9.58, "Bolt");
        resultsMap.put(9.93, "Smith");
        resultsMap.put(10.00, "Hary");
        resultsMap.put(10.60, "Lippincott");
        resultsMap.put(10.07, "Borzov");
        resultsMap.put(9.74, "Powell");

        // результаты забега
        ArrayList<Double> resultsList = new ArrayList<>();
        resultsList.add(10.2);
        resultsList.add(9.95);
        resultsList.add(9.92);
        resultsList.add(9.79);
        resultsList.add(9.58);
        resultsList.add(9.93);
        resultsList.add(10.00);
        resultsList.add(10.60);
        resultsList.add(10.07);
        resultsList.add(9.74);

        Collections.sort(resultsList);
        System.out.println(resultsList);
        // кто занял 1-е место
        String firstPlace = resultsMap.get(resultsList.get(0));
        System.out.println("The winner is: " + firstPlace);
        // кто занял посдеднее место
        String lastPlace = resultsMap.get(resultsList.get(resultsList.size() - 1));
        System.out.println("The last place took: " + lastPlace);
     }
}