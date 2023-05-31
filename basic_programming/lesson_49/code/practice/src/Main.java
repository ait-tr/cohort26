public class Main {

  // - дизайн программы (и методов) для тестов
  // - работа с датами и форматтером
  // - работа с файлами и Map
  // - удаление из коллекций

  // Внутренняя система учёта заказов в цветочном магазине.
  // Функционал:
  // - добавить заказ
  // - изменить заказ
  // - удалить заказ
  // заказы должны оставаться (сохраняться) после окончания работы программы
  // Заказ:
  // - ID // число
  // - описание букета // строка (без переносов)
  // - дата доставки // ДД.ММ.ГГГГ ЧЧ:ММ

  // Делаем дизайн программы - отдельный класс Order для каждого заказа.
  // Будет общая база (система учёта), в которой заказы будут храниться в Map<Integer, Order>
  // Заказы могут удаляться, а ID при этом меняться не будут. Нумерация будет "разреженной" 1, 2, 7
  public static void main(String[] args) {
    Base orders = new Base();
    orders.add();
    orders.printOrders();
  }
}