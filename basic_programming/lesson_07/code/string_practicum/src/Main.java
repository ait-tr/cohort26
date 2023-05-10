public class Main {
    public static void main(String[] args) {
        System.out.println("Класс String - практикум ");

        String day = "День";
        String and = "и";
        String night = "Ночь";
        String dayAndNight = day + " " + and + " " + night;
        System.out.println(dayAndNight);

        String st = "Привет!";
        int l = st.length();
        System.out.println("Кол-во символов в строке Привет! " + l);

        char ch = st.charAt(0);
        System.out.println(" Буква строки с индексом 1: " + ch);
        // Распечатать последний символ строки. Используем метод String.charAt().

        char ch1 = st.charAt(l - 1); // индекс последней буквы равен l - 1
        System.out.println(" Последняя буква строки : " + ch1);

    // Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains().
        String st1 = "Java - это язык для ООП";
        boolean b;
        b = st1.contains("Java"); // переменная логическая, true или false
        System.out.println("В строке содержится Java: "  + b);

    // Найти позицию подстроки “Java” в строке “I like Java!!!”.
       String st2 = "I like Java!!!";
       int index = st2.indexOf("Java");
       System.out.println("Слово Java в строке I like Java!!! начинается с позиции: " + index);

   //Заменить все символы “а” на “о” в строке “I like Java!!!”
        System.out.println( "Заменяем букву a на букву o в строке I like Java!!! : " + st2.replace('a', 'o'));

    // Преобразуйте строку к верхнему регистру.
        System.out.println("Преобразуем строку I like Java!!! к верхнему регистру " + st2.toUpperCase());

    // Преобразуйте строку к нижнему регистру.
        System.out.println("Преобразуем строку I like Java!!! к нижнему регистру " + st2.toLowerCase());

    // Вырезать строку Java c помощью метода String.substring() из строки I like Java!!!
        String st3 = st2.substring(7, 11);
        System.out.println("Вырезали Java из строки I like Java!!! " + st3 );

    // Проверить, заканчивается ли ваша строка подстрокой “!!!”
        System.out.println("Заканчивается ли ваша строка подстрокой “!!!” : " + st2.endsWith("!!!!"));

    }
}