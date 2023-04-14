public class Main1 {
    public static void main(String[] args) {
        System.out.println("Methods and arrays example");


        int [] numbers = new int[5];
        numbers[0] = 134;
        numbers[1] = 124;
        numbers[2] = 114;
        numbers[3] = 104;
        numbers[4] = 94;
  //      numbers[5] = 128;

        String [] strings = new String[6];
        strings[0] = "Петя";
        strings[1] = "Вася";
        strings[2] = "Лена";
        strings[3] = "Таня";
        strings[4] = "Руслан";
        strings[5] = "Саша";

        for (int i = 0; i < strings.length; i++) {
            System.out.println("Индекс элемента массива = " + i + ", элемент массива = " + strings[i] + ", длина слова = " + strings[i].length());
        }




        //______________end of Methods ______________

    }
}
