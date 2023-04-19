import java.util.ArrayList;
import java.util.Collections;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Temperature during the week");

        ArrayList<Double> temperatureList = new ArrayList<>();
        ArrayList<String> dayWeekList = new ArrayList<>();

        temperatureList.add(12.2);
        temperatureList.add(9.8);
        temperatureList.add(11.3);
        temperatureList.add(8.0);
        temperatureList.add(13.5);
        temperatureList.add(15.0);
        temperatureList.add(15.5);

        dayWeekList.add("Mon");
        dayWeekList.add("Thu");
        dayWeekList.add("Wen");
        dayWeekList.add("The");
        dayWeekList.add("Fri");
        dayWeekList.add("Sat");
        dayWeekList.add("Sun");

        // в цикле суммируем значения температур по дням недели
        // разделим полученную сумму на кол-во измерений

        double sum = 0;

        for (int i = 0; i < temperatureList.size(); i++) {
            sum = sum + temperatureList.get(i);
        }

        double averageTemp = sum / temperatureList.size();

        for (int i = 0; i < temperatureList.size(); i++) {
            System.out.println(dayWeekList.get(i) + " temperature: " + temperatureList.get(i));
        }
        System.out.println();
        System.out.println("Average temperature is: " + averageTemp);

        System.out.printf("Average temperature is: %.2f", averageTemp);

    }
}