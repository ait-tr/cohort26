import java.util.ArrayList;
import java.util.List;

public class Task2DifferentObjects {

  public static void main(String[] args) {
    List<Alive> beings = new ArrayList<>();
    beings.add(new Alive() {
      @Override
      public void introduce() {
        System.out.println("Меня зовут Кирилл");
      }
    });
    beings.add(new Alive() {
      @Override
      public void introduce() {
        System.out.println("А я - Мефодий");
      }

      @Override
      public void greet() {
        System.out.println("Здравствуйте!");
      }
    });
    // так не очень удобно - анонимный класс слишком большой,
    // есть смысл вынести весь код в отдельный файл этого нового класса
    beings.add(new Alive() {
      private final String additionalInfo = "Tom Marvolo Riddle";

      @Override
      public void introduce() {
        System.out.println("I am lord Voldemort (" + additionalInfo + ")");
      }

      @Override
      public void greet() {
        System.out.println("Avada Kedavra!");
      }

      // этот метод сейчас недоступен - мы не можем указать тип ссылки "анонимный класс"
      public String getRealName() {
        return additionalInfo;
      }
    });
//    beings.get(2).getRealName(); - так нельзя, в beings лежит "просто какой-то Alive"

    // Итог: анонимный класс должен описывать ВРЕМЕННУЮ (одноразовую) и ПРОСТУЮ (короткую)
    // реализацию.
    // Если в вашем классе заложена сложная внутренняя логика, стоит вынести код в отдельный класс,
    // даже если такой класс будет использоваться только один раз.

    for (Alive someone : beings) {
      someone.introduce();
      someone.greet();
      System.out.println("Это был " + someone.getClass().getName());
    }
  }
}
