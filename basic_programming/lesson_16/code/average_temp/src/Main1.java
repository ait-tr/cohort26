public class Main1 {
    public static void main(String[] args) {
        System.out.println("Average week: day + temperature");

        //   double[] weekTemp = new double[7]; - объявление массива
        // double[] weekTemp = {-3.0, 1.5, 4.0, 7.0, 5.0, 9.5, 13}; - так тоже допустимо

        // Solution  1
        String[] weekTemp = new String[]{"Mon: -3.0", "Tu: 1.5", "We: 4.0", "Th: 7.0", "Fr: 5.0", "St: 9.5", "Su: 13"};
        for (int i = 0; i < weekTemp.length; i++) {
            System.out.print(weekTemp[i] + " | "); // печать элементов массива в строчку с разделителем
        }

        System.out.println(); // next line

        // Solution 2
        String[] weekDays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        double[] weekTemperature = {-3.0, 1.5, 4.0, 7.0, 5.0, 9.5, 13};
        double sumTemp = 0;
        for (int i = 0; i < weekTemperature.length; i++) {
            sumTemp = sumTemp + weekTemperature[i];
        }

        // printing two arrays simultaneously
        for (int i = 0; i < weekDays.length; i++) {
            System.out.println(weekDays[i] + " temperature is: " + weekTemperature[i]);
        }

        double averageTemp = sumTemp/ weekTemperature.length;
        System.out.printf("Average week temperature is: %.2f", averageTemp); // printf instead println

    }
}