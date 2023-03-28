import java.util.Scanner;

public class Bot_pizza {
    public static void main(String[] args) {
        System.out.println("Добрый день! Закажите у нас пиццу! ");
//        Необходимо выяснить у клиента:
//        - имя,
//        - адрес - город, улица, дом,
//        - размер L или S
//        - по результату выбора сообщить цену и далее запросить способ оплаты
//        - закончить корректно диалог
        int pizzaPrice = 0;
    Scanner scanner = new Scanner(System.in);
        // узнаем имя
        System.out.println("Как вас зовут?");
        String name = scanner.next();
        int l = name.length();
        System.out.println("Здавствуйте, " + name.toUpperCase().charAt(0) + name.substring(1,l) + "!");
        String nameCorrect = name.toUpperCase().charAt(0) + name.substring(1,l);

        // узнаем адрес
        System.out.println("Из какого вы города?");
        String city = scanner.next();
        // надо проверить корректность введенного города
        if ( city.equalsIgnoreCase("Берлин") || city.equalsIgnoreCase("Berlin" ) ) {
            System.out.println("Мы готовы принять ваш заказ. Говорите дальше по-русски!");
        } else {
            System.out.println(" Ваш город пока не обслуживется. Нам очень жаль, " + nameCorrect);
            return; // этот оператор завершает программу
        }
        System.out.println("На какой улице вы живете");
        String street = scanner.next();
        System.out.println("Какой номер дома ");
        String house = scanner.next();

        // - размер L или S
        System.out.println("Выберите размер пиццы: S - маленькая пицца, L - большая пицца ");
        String pizzaSize = scanner.next();

        if (pizzaSize.equalsIgnoreCase("s")) {
            pizzaPrice = 45;
            System.out.println("Ваша пицца стоит " + pizzaPrice);
        } else if (pizzaSize.equalsIgnoreCase("l")) {
            pizzaPrice = 55;
            System.out.println("Ваша пицца стоит " + pizzaPrice);
        } else {
            System.out.println("Извините, мы вас не поняли");
            return;
        }

        // запросить способ оплаты - на сайте картой или наличными при получении

        System.out.println("Спасибо за заказ, ваши данны переданы в службу доставки. Ожидайте!");
    }
}
