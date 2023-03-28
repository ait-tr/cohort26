// Java program to show how to compare Strings
// using library function
public class Test2
{ public static void main(String[] args)
{
    String s1 = "Cohort26";
    String s2 = "Cohort26";
    String s3 = "School AIT";
    String s4 = "ABCEFG";

    System.out.println(" Comparing strings with compareTo:"); // анонс того, что делает этот код
    System.out.println(s1.compareTo(s2)); // Cohort26 сравниваем Cohort26, ожидаем true
    System.out.println(s1.compareTo(s3)); // Cohort26 сравниваем с School AIT, ожидаем false
    System.out.println(s1.compareTo(s4)); // Cohort26 сравнивам с ABCDEFG, ожидаем false

    // метод compareTo возвращает не boolean, а int , который рассчитан определенным образом
    // поэтому наши ожидания не сбылись

}
}