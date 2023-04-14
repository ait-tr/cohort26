import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Alphabet");

//        Заполнить список символами латинского алфавита в цикле for
//        код символа "A" - 65, код символа "B" - 66, и т.д. до код "Z" = 90.

        ArrayList<String> alphabetList = new ArrayList<String>();
// ArrayList<Character> alphabetList = new ArrayList<Character>(); - можно попробовать

        for (int i = 0; i < 26; i++) {
            alphabetList.add(i, String.valueOf((char)(65 + i)));
        }
        System.out.println(alphabetList);
    }
}




















/*
    ArrayList<String> latAlphabet = new ArrayList<>(); //инициализация

        System.out.println();

                // заполняем в цикле
                for ( int i = 0 ; i < 26 ; i++ ) {
        latAlphabet.add(String.valueOf((char)(i + 65)));
        }

        System.out.println(latAlphabet); // печать полученного списка

 */