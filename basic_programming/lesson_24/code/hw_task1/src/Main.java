import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lands of Germany");
        HashSet<String> germanyLands = new HashSet<>();
        germanyLands.add("Bavaria");
        germanyLands.add("Baden-Wurtemberg");
        germanyLands.add("Hesse");

        // ...

        System.out.println(germanyLands);

    }
}