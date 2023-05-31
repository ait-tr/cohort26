package ait.tr.task.dialog;

public class Professor implements Dialog {

  private int age;
  private String title;
  private String clothes;
  private String face;

  public Professor(int age, String title, String clothes, String face) {
    this.age = age;
    this.title = title;
    this.clothes = clothes;
    this.face = face;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getClothes() {
    return clothes;
  }

  public void setClothes(String clothes) {
    this.clothes = clothes;
  }

  public String getFace() {
    return face;
  }

  public void setFace(String face) {
    this.face = face;
  }

  @Override
  public String readName() {
    return "Я Аристарх Виссарионович Задунайский";
  }

  @Override
  public String greeting() {
    return "Добрый вечер любезный!";
  }

  @Override
  public String askAboutDistrict() {
    return "С центрального района, там чудесный воздух";
  }

  @Override
  public String askAboutLocation() {
    return "Был в картинной галерее";
  }

  @Override
  public String askAboutPosition() {
    return "Доктор философских наук, профессор университета, в третьем поколении";
  }

  @Override
  public String askAboutPhone() {
    return "Кнопочная нокиа, в одном кармане с пейджером";
  }

  @Override
  public void result() {
    System.out.println(
        "Профессор убегает от гопника с криком помогите хулиганы любимой нокии лишают!!!");

  }
}
