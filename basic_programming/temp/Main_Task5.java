import java.util.Arrays;

public class Main_Task5 {
    public static void main(String[] args) {
        System.out.println("Denomination");

        double[] accountSum = new double[20];

        double random, temp;

        for (int i = 0; i < accountSum.length; i++) {
            random = Math.random()*((10000000L - 10000 +1) + 10000); // это случайное дробное число в интервале от
            // 10 000 до 10 000 000
            temp = Math.round(random * 100.0) / 100.0; // а здесь ему оставили 2 знака после запятой
            accountSum[i] = temp;
        }

        System.out.println(Arrays.toString(accountSum));

        // проводим деноминацию
        double[] accountSumDenominated = new double[20];

        for (int i = 0; i < accountSumDenominated.length; i++) {
            accountSumDenominated[i] = accountSum[i] / 1000.0;
            temp = Math.round(accountSumDenominated[i] * 100.00) / 100.00;
            accountSumDenominated[i] = temp;
        }
        System.out.println(Arrays.toString(accountSumDenominated));
    }
}