package ait.tr.task.dialog;

public class Gopnik implements Dialog {

  private String clothes;
  private String cap;
  private String cigarette;
  private int age;
  private int friends;
  private String language;

  public Gopnik(String clothes, String cap, String cigarette, int age, int friends,
      String language) {
    this.clothes = clothes;
    this.cap = cap;
    this.cigarette = cigarette;
    this.age = age;
    this.friends = friends;
    this.language = language;
  }

  public String getClothes() {
    return clothes;
  }

  public void setClothes(String clothes) {
    this.clothes = clothes;
  }

  public String getCap() {
    return cap;
  }

  public void setCap(String cap) {
    this.cap = cap;
  }

  public String getCigarette() {
    return cigarette;
  }

  public void setCigarette(String cigarette) {
    this.cigarette = cigarette;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getFriends() {
    return friends;
  }

  public void setFriends(int friends) {
    this.friends = friends;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Override
  public String readName() {
    return "Я Серега Ржавый";
  }

  @Override
  public String greeting() {
    return "Чо? Каво! Даров";
  }

  @Override
  public String askAboutDistrict() {
    return "Мужичок, каким ветром тебя сюда, с какого района будешь?";
  }

  @Override
  public String askAboutLocation() {
    return "Я тут смотрящий, все меня знают, в уважухе я. Мой район!";
  }

  @Override
  public String askAboutPosition() {
    return "Я бродяга по жизни. Мамкина гордость.";
  }

  @Override
  public String askAboutPhone() {
    return "Слышь, есть что с камерой позвонить? Мамочка переживает, срочно надо.";
  }

  @Override
  public void result() {
    System.out.println("Гопник с удивлением рассматривает кнопочный телефон. ");
  }
}
