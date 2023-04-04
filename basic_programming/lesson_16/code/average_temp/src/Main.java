public class Main {
    public static void main(String[] args) {
        System.out.println("Average week temperature");

        //   double[] weekTemp = new double[7]; - объявление массива
        // double[] weekTemp = {-3.0, 1.5, 4.0, 7.0, 5.0, 9.5, 13}; - так тоже допустимо

        double[] weekTemp = new double[]{-3.0, 1.5, 4.0, 7.0, 5.0, 9.5, 13};
        for (int i = 0; i < weekTemp.length; i++) {
            System.out.print(weekTemp[i] + " | "); // печать элементов массива в строчку с разделителем
        }

        System.out.println();

        double sumTemp = 0;
        for (int i = 0; i < weekTemp.length; i++) {
            sumTemp = sumTemp + weekTemp[i];
        }

        double averageTemp = sumTemp/ weekTemp.length;
        System.out.println("Average week temperature is: " + averageTemp);

        System.out.println("Two digits after decimal with local decimal separator ");

        System.out.printf("Average week temperature is: %.2f", averageTemp); // printf instead println
    }
}