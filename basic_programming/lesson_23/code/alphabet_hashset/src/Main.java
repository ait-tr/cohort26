import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Alphabet - HashSet based");
//        Заполнить HashSet символами латинского алфавита в цикле for
//        код символа "A" - 65, код символа "B" - 66, и т.д. до код "Z" = 90.

        HashSet<String> alphabetSet = new HashSet<>();

        // цикл для заполнения множества
        for (int i = 0; i < 26; i++) {
            alphabetSet.add(String.valueOf((char)(65 + i))); // char - это преобразование в символ,
            // в скобках стоит код символа 65, 66, 67..
            // "обертка" String.valueOf - переводит этот символ в строку
        }
        System.out.println(alphabetSet); // печать полученного множества
        alphabetSet.add("Z");// элемент НЕ попал в множество, так как уже там есть
        System.out.println(alphabetSet);
        alphabetSet.add("A"); // элемент НЕ попал в множество, так как уже там есть
        System.out.println(alphabetSet);
        alphabetSet.add("a"); // новый элемент попал в множество
        System.out.println(alphabetSet);
        alphabetSet.add("f");// новый элемент попал в множество
        System.out.println(alphabetSet);

        boolean isPresent = false;
        String element = "Y";
        isPresent = alphabetSet.contains("Y");
        System.out.println("Set contains " + element + " : "+ isPresent);

        element = "y";
        isPresent = alphabetSet.contains(element);
        System.out.println("Set contains " + element + " : "+ isPresent);

        element = "Hello!";
        int hash = element.hashCode();

        System.out.println("Hash code of Hello: " + hash);


    }
}





/*

        HashSet<String> alphabetSet = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            alphabetSet.add(String.valueOf((char)(65 + i)));
            //alphabetList.add(i, String.valueOf((char)(65 + i)));
        }
        System.out.println(alphabetSet);
        alphabetSet.add("K");
        System.out.println(alphabetSet);
        alphabetSet.add("k");
        System.out.println(alphabetSet);
        alphabetSet.add("Z");
        System.out.println(alphabetSet);
        alphabetSet.add("z");
        System.out.println(alphabetSet);

        boolean isPresents = alphabetSet.contains("A");
        System.out.println("A is in HashSet: " + isPresents);
        isPresents = alphabetSet.contains("a");
        System.out.println("a is in HashSet: " + isPresents);

 */