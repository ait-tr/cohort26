package homework33;

public class Soda {

  // атрибут = поле класса = член класса
  // class field / class member
  private String supplement;

  // Создайте класс `Soda` (для определения типа газированной воды).
  //
  // У класса должен быть конструктор, принимающий 1 аргумент при инициализации -
  // строку добавка (например, `"малина"`), отвечающий за добавку к выбираемому лимонаду.
  //
  // Напишите для этого класса геттер и сеттер.
  public Soda(String supplement) {
    // this - "этот объект", используется для обращения к членам класса, ссылка на самого себя
    // совпадение имени локальной переменной метода или аргумента этого метода с атрибутами
    // приводит к "затенению" (shadowing) атрибута - "закрытию" его собой.
    // Атрибут становится не доступен "просто по имени", нужно явно указать объект - this (этот)
    this.supplement = supplement; // если не написать this, будет использован аргумент, а не атрибут
//    System.out.println(supplement); // будет использована переменная из скобочек вызова (стр. 15)
//    System.out.println(this.supplement); // будет использован член класса
  }

  public String getSupplement() {
    return supplement; // можно не писать this - перепутать не с чем
  }

  public void setSupplement(String supplement) {
    this.supplement = supplement; // если не написать this, будет использован аргумент, а не атрибут
  }
}
