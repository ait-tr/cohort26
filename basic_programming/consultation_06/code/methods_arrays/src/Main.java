public class Main {
    public static void main(String[] args) {
        System.out.println("Methods and arrays example");
//        Создайте метод, который принимает массив слов, и заменяет все самые длинные слова на "***".
//
//        Например,для массива {"John","Ann", "Jack", "Ray"} вызов метода изменит
//        массив на {"***","Ann", "***", "Ray"}.
//        Данный метод должен менять исходный массив

        String[] words1 = new String[]{"John","Ann", "Jack", "Ray"};

        for (int i = 0; i < words1.length; i++) {
            System.out.println("Индекс элемента массива = " + i + " длина слова " + words1[i] + " = " + words1[i].length()); // у каждого элемента массива считаем длину строки
        }


        String[] words2 = new String[]{"Johny","Ann", "Jack", "Ray Charles"};

//        String myName = "Ruslan!!";
//        int l = myName.length();
//        System.out.println(l);

        replaceLongest(words1);

        replaceLongest(words2);
        print(words1);
        print(words2);
    }
    public static void print(String[] arr){
        for (int i =0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // ___________Methods__________________
    //Этот метод заменяет длинные слова в массиве слов на ***
    //
    public static void replaceLongest(String[] words) {
        // - находим maxLength
        int maxLength = words[0].length(); // переменной maxLength присвоена длина 0-го элемента массива
        for(int i = 1; i < words.length; i++){
            if(words[i].length() > maxLength){ // вычисляется длина i-го слова в массиве, который называется words
                maxLength = words[i].length(); //
            }
        }
        // после того как мы прошли по всему массиву
        // только теперь maxLength - длинна самого большого слова
        // - заменить все слова с этой длинной на звездочки
        for (int i = 0; i < words.length; i++){
            if (words[i].length() == maxLength){
                words[i] = "***";
            }
        }
    }
    //______________end of Methods ______________

}
