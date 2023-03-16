import java.io.*;

public class Bot {
    public static void main(String[] args) throws IOException {
        // менять в следующей строке можно только имя переменной - сейчас это br и везде должно быть br

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Привет! Как тебя зовут?");
        String name = br.readLine(); // Прочитать одну строку с клавиатуры и записать в переменную name
        System.out.println("Привет, " + name + ". Какое красивое имя!");

        System.out.println("А сколько тебе лет?");
        String ageText = br.readLine(); // Прочитать строку, в которой будет указан возраст (например, "31")
        System.out.println(ageText + " - замечательный возраст!");

        int age = Integer.parseInt(ageText); // Превратить строку в число
        int targetAge = 100; // возраст, которого надо достичь
        int ageDifference = targetAge - age;
        System.out.print("Получается, тебе будет " + targetAge + " лет через " + ageDifference + " лет. ");
        System.out.println("Ничего себе!");

        System.out.println("Извини, брат, мне пора бежать :( Пока!");
    }
}