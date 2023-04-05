public class Main1 {
    public static void main(String[] args) {
        System.out.println("Перестановка данных в массиве");

        // Мой дядя самых честных правил

        String[] words = new String[5];

        // words[0] = "";
        words[0] = "Мой";
        words[1] = "дядя";
        words[2] = "самых";
        words[3] = "честных";
        words[4] = "правил";

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }

        String buffer;
        buffer = words[4];
        words[4] = words[0];
        words[0] = buffer;

        System.out.println();

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }



    }
}