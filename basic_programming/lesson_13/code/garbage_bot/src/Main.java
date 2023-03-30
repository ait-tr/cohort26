import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

// Задача 3 (*). Создать "Бот-помощник", коорый помогает сортировать мусор. На входе - наименование выбрасываемого мусора,
// на выходе сообщение, в какого цвета урну нужно отправить этот мусор. Если выбрасывается стекло (бутылки, банки и т.д.),
// то бот должен запросить цвет и указать, куда выбросить цветное стекло.
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Добрый день, я бот, который поможет Вам сортировать мусор");
        System.out.println("Введите определение мусора, который Вы хотите выбросить:");
        String garbageName = br.readLine();
        garbageName = garbageName.toLowerCase();
        if (garbageName.equals(new String("бумага"))
                || garbageName.equals(new String("картон"))
                || garbageName.equals(new String("бумажный пакет"))
                || garbageName.equals(new String("газета"))
                || garbageName.equals(new String("газеты"))
                || garbageName.equals(new String("коробка"))
                || garbageName.equals(new String("пачка сигарет"))
        ){
            System.out.println("Этому мусору дорога в зеленый бак");
        }
        else if (garbageName.equals(new String("упаковка"))
                || garbageName.equals(new String("алюминиевая фольга"))
                || garbageName.equals(new String("пластиковый пакет"))
                || garbageName.equals(new String("консервная банка"))
                || garbageName.equals(new String("стаканчик из-под йогурта"))
                || garbageName.equals(new String("тетрапак"))
                || garbageName.equals(new String("пластиковая бутылка"))
                || garbageName.equals(new String("пачка из-под кофе"))) {
            System.out.println("Этому мусору дорога в желтый бак (или желтый мешок)");

        }
        else if (garbageName.equals(new String("органика"))
                || garbageName.equals(new String("чайная заварка"))
                || garbageName.equals(new String("кофейный жмых"))
                || garbageName.equals(new String("фрукты"))
                || garbageName.equals(new String("овощи"))
                || garbageName.equals(new String("очистки"))
                || garbageName.equals(new String("листья"))
                || garbageName.equals(new String("кухонные отходы"))
                || garbageName.equals(new String("садовые отходы"))
        ){
            System.out.println("Этому мусору дорога в коричневый бак");
        }
        else if(garbageName.equals(new String("стеклянная бутылка"))
                || garbageName.equals(new String("стеклянная банка"))){
            System.out.println("Введите цвет стекла:");
            String colorGlass = br.readLine();
            colorGlass = colorGlass.toLowerCase();
            if (colorGlass.equals(new String("белый"))){
                System.out.println("Этому мусору дорога в бак для белого стекла");
            } else if (colorGlass.equals(new String("коричневый"))){
                System.out.println("Этому мусору дорога в бак для коричневого стекла");
            } else if (colorGlass.equals(new String("зеленый"))){
                System.out.println("Этому мусору дорога в бак для зеленого стекла");
            }
            else {
                System.out.println("Я не смог по введенному Вами цвету подобрать бак, попробуйте выбрать соответствующий бак для стекла с наиболее похожим цветом");
            }
        } else if (garbageName.equals(new String("фарфор"))
                || garbageName.equals(new String("стекло"))
                || garbageName.equals(new String("обувь"))
                || garbageName.equals(new String("мешки для пылесоса"))
                || garbageName.equals(new String("памперсы"))
                || garbageName.equals(new String("сигаретные окурки"))
                || garbageName.equals(new String("предметы личной гигиены"))
                || garbageName.equals(new String("шприцы"))) {
            System.out.println("Этому мусору дорога в черный бак");
        }
        else
            System.out.println("Как-то сложно Вы вводите, я не могу помочь Вам. Но попробуйте почитать на сайте компании по вывозу мусора, например https://www.zakb.de/");
    }
}