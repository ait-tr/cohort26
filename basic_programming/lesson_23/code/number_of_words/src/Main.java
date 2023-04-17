import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Number of unique words in sentence");
        // посчитать количество разных слов в тексте (частоту повторений пока посчитать не можем).
        // Алгоритм:
        // Шаг 1: split(" ") предложение на слова -> массив
        // Шаг 2: ереносим массив в HashSet
        // Шаг 3: размер HashSet - и есть количество уникальных слов

        String sentence = "В 1800-х годах, в те времена, когда не было еще ни железных, ни шоссейных дорог, ни газового, ни стеаринового света, ни пружинных низких диванов, ни мебели без лаку, ни разочарованных юношей со стеклышками, ни либеральных философов-женщин, ни милых дам-камелий, которых так много развелось в наше время, – в те наивные времена, когда из Москвы, выезжая в Петербург в повозке или карете, брали с собой целую кухню домашнего приготовления, ехали восемь суток по мягкой, пыльной или грязной дороге и верили в пожарские котлеты, в валдайские колокольчики и бублики, – когда в длинные осенние вечера нагорали сальные свечи, освещая семейные кружки из двадцати и тридцати человек, на балах в канделябры вставлялись восковые и спермацетовые свечи, когда мебель ставили симметрично, когда наши отцы были еще молоды не одним отсутствием морщин и седых волос, а стрелялись за женщин и из другого угла комнаты бросались поднимать нечаянно и не нечаянно уроненные платочки, наши матери носили коротенькие талии и огромные рукава и решали семейные дела выниманием билетиков, когда прелестные дамы-камелии прятались от дневного света, – в наивные времена масонских лож, мартинистов, тугендбунда, во времена Милорадовичей, Давыдовых, Пушкиных, – в губернском городе К. был съезд помещиков, и кончались дворянские выборы.";
        int l = sentence.length();
        System.out.println("Number of symbols in sentence is : " + l);

        String[] words = new String[sentence.length()];

        words = sentence.split(" "); // в массив попадут все слова предложения
        int numberOfWords = words.length;
        System.out.println("Number of words in sentence is : " + numberOfWords);

        HashSet<String> wordsSet = new HashSet<>();

        for (int i = 0; i < numberOfWords; i++) {
            wordsSet.add(words[i]);
        }

        System.out.println("Number unicue words in sentence: " + wordsSet.size());

    }
}




/*
 String[] words = new String[l]; // объявили массив
        words = sentence.split(" "); // - в массив words попадут слова из sentence без пробелов
        int numberOfWordds = words.length;
        System.out.println("Number of words in sentence: " + numberOfWordds);

        HashSet<String> wordsSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            wordsSet.add(words[i]);
        }

        int uniqueWords = wordsSet.size();
        System.out.println("Number of unique words in sentence is: " + uniqueWords);

 */