import java.util.Arrays;
import java.util.HashMap;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Group list with Sex");

        HashMap<String,String> group26MapSex = new HashMap<>();

        group26MapSex.put("Galina", "W");
        group26MapSex.put("Oleksandr Zhurba", "M");
        group26MapSex.put("Aleksndra", "W");
        group26MapSex.put("Marina", "W");
        group26MapSex.put("Luka", "M");
        group26MapSex.put("Tetiana","W");
        group26MapSex.put("Christian", "M");
        group26MapSex.put("Yulia","W");
        group26MapSex.put("Andrei","M");
        group26MapSex.put("Egor", "M");
        group26MapSex.put("Dmitrijs","M");
        group26MapSex.put("Wladimir","M");
        group26MapSex.put("Galina", "W");

        int man = 0;
        // циклом for each подсчитать кол-во мужчин
        for (String name : group26MapSex.keySet()){
            if(group26MapSex.get(name).equals("M")) {
                man++;
            }
        }

        int woman = 0;
        // циклом for each подсчитать кол-во мужчин
        for (String name : group26MapSex.keySet()){
            if(group26MapSex.get(name).equals("W")) {
                woman++;
            }
        }

        System.out.println("Men in group: " + man);
        System.out.println("Women in group: " + woman);

    }
}










/*
HashMap<String, String> group26 = new HashMap<String, String>();

        int man = 0; // кол-во мужчин
        int woman = 0; // кол-во женщин

        group26.put( "N1", "M");
        group26.put( "N2", "M");
        group26.put( "N3", "M");
        group26.put( "N4", "M");
        group26.put( "N5", "W");
        group26.put( "N6", "W");
        group26.put( "N7", "W");
        group26.put( "N8", "W");
        group26.put( "N9", "W");

        System.out.println(group26);

        for (String name : group26.keySet()) {
            // System.out.println(group23.get(i));
            if (group26.get(name).equals("M")) { // берем значение для ключа name
                man++; // увеличили кол-во мужчин на 1
            }
        }

        for (String name : group26.keySet()) {
            // System.out.println(group23.get(i));
            if (group26.get(name).equals("W")) { // берем значение для ключа name
                woman++; // увеличили кол-во женщин на 1
            }
        }

        System.out.println("Мужчин в группе: " + man);
        // int woman = group23.size() - man;
        System.out.println("Женщин в группе: " + woman);

 */