package cashier;

import java.util.Comparator;

public class LineTitleComparator implements Comparator<Line> {

  @Override
  public int compare(Line o1, Line o2) {
    String title1 = o1.getTitle().toLowerCase();
    String title2 = o2.getTitle().toLowerCase();
    if (!title1.equals(title2)) {
      return title1.compareTo(title2);
    }
    return Double.compare(o1.getPrice(), o2.getPrice());
  }
}
