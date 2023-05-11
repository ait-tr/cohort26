package ait.tr.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<House> houses = new ArrayList<>();
    houses.add(new Mansion("ул. Мира, д.21"));
    houses.add(new Mansion("ул. Пушкина, д.45"));
    houses.add(new Apartment("ул. Программистов, д. 256", 2));

    for (House house : houses) {
      System.out.println(house);
    }
  }
}
