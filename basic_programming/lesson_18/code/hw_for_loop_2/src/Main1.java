import java.util.Arrays;


public class Main1 {
    public static void main(String[] args) {
        System.out.println("Atmosphere pressure last week");

        int[] weekPressure = new int[]{ 740, 743, 745, 750, 742, 739, 746};
        String[] weekDays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int minPressure = weekPressure[1];
        int maxPressure = weekPressure[6];
        int indexMin = -1;
        int indexMax = -1;

        // поиск минимального давления
        for (int i = 0; i < weekPressure.length; i++) {
            if (weekPressure[i] < minPressure) {
                minPressure = weekPressure[i];
                indexMin = i;
            }
        }

        // поиск максимального давления
        for (int i = 0; i < weekPressure.length; i++) {
            if (weekPressure[i] > maxPressure) {
                maxPressure = weekPressure[i];
                indexMax = i;
            }
        }

        // print results
        System.out.println("Min pressure: " +  minPressure + ", it was at " + weekDays[indexMin]);
        System.out.println("Max pressure: " +  maxPressure + ", it was at " + weekDays[indexMax]);
    }
}