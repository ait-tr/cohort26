import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Weather last week");

        HashMap<String, Double> weekTemperature = new HashMap<>();

        weekTemperature.put("Mon", 12.0);
        weekTemperature.put("Tue", 9.0);
        weekTemperature.put("Wed", 8.0);
        weekTemperature.put("Thu", 10.0);
        weekTemperature.put("Fri", 12.0);
        weekTemperature.put("Sat", 13.0);
        weekTemperature.put("Sun", 15.0);

        double sum = 0.0;
        // печатаем температуру по дням и складываем
        for (String day : weekTemperature.keySet()) {
            System.out.println("Day of week: " + day + ", temperature: " + weekTemperature.get(day));
            sum = sum + weekTemperature.get(day);
        }

        // считаем среднюю температуру
        double averageTemp = sum / weekTemperature.size();
        System.out.println("Average temperature last week: " + averageTemp);
        System.out.printf("Average temperature last week: %.2f", averageTemp);

    }
}