public class Car { // имя класса пишется в PascalCase

  // атрибуты пишутся отдельно, лучше в начале класса
  // private тип название;
  private String manufacturer; // производитель
  private String color; // цвет
  private int power; // мощность

  // конструктор класса - метод, который создаёт (конструирует) экземпляр класса
  // именно он вызывается командой new
  // Если не определить свой конструктор, то у класса будет "конструктор по умолчанию" -
  // без аргументов и без дополнительных действий
  // конструктор: public Класс(аргументы)
  public Car(String manufacturer, String color, int power) {
    this.manufacturer = manufacturer;
    // этотОбъект.производитель (как атрибут) = manufacturer (как аргумент конструктора);
    this.color = color;
    this.power = power;
  }

  // геттер - метод для получения значения атрибута (от get - получить)
  public String getManufacturer() {
    return manufacturer;
  }

  public String getColor() {
    return color;
  }

  // сеттер - метод для задания значения атрибута (от set - задать)
  public void setColor(String color) {
    this.color = color;
  }

  // Идеальный класс - "вещь в себе", "чёрный ящик" - есть несколько доступных снаружи (публичных)
  // методов, но никто даже не знает, какие у вас там атрибуты и как они взаимосвязаны
  // Эта идея - самодостаточность и самостоятельность класса - называется "инкапсуляция"
  // (encapsulation) - класс ничего не должен знать о других классах, кроме их публичных методов.
  // Это один из трёх важных принципов ООП.
}
