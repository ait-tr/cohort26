package ait.tr.task.dialog;

public class Main {

  public static void main(String[] args) {
    Gopnik gopnik = new Gopnik("спортивка",
        "кепка абибас", "чужие", 18, 5, "Эй");
    Professor professor = new Professor(60, "Доктор философских наук, профессор университета",
        "элегантно", "с бородкой и в очках");

    System.out.println(gopnik.greeting());
    System.out.println(gopnik.readName());
    System.out.println(professor.greeting());
    System.out.println(professor.readName());
    System.out.println("------");

    System.out.println(gopnik.askAboutDistrict());
    System.out.println(professor.askAboutDistrict());
    System.out.println("------");

    System.out.println(gopnik.askAboutLocation() + "Нас тут " + gopnik.getFriends());
    System.out.println(professor.askAboutLocation());
    System.out.println("------");
  }
}
