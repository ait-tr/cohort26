package ait.tr.task.dialog;

public interface Dialog {

  String readName();

  String greeting();

  String askAboutDistrict();

  String askAboutLocation();

  String askAboutPosition();

  String askAboutPhone();

  void result();
}
