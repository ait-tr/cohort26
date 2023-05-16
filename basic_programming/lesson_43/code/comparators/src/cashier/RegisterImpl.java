package cashier;

import java.util.ArrayList;
import java.util.List;

public class RegisterImpl implements Register {

  List<Bill> closed = new ArrayList<>(); // список закрытых чеков
  Bill current = new Bill(); // текущий (открытый) чек

  @Override
  public void addLine(String position, double price) {
    current.addLine(position, price); // добавляем позицию в текущий чек
  }

  @Override
  public void closeBill() {
    if (!current.isEmpty()) { // если в чеке есть позиции
      closed.add(current);
      current = new Bill();
    }
    // если чек пустой, ничего не произойдёт, он так и останется текущим
  }

  @Override
  public void close() {
    closeBill(); // закрываем текущий (последний) чек, чтобы позиции не потерялись
    // можем захотеть отсортировать closed при помощи какого-нибудь компаратора
    double total = 0.0;
    for (Bill bill : closed) {
      System.out.println(bill);
      total += bill.getTotal();
    }
    System.out.printf("Общий итог: %.2f EUR%n", total);
  }
}
