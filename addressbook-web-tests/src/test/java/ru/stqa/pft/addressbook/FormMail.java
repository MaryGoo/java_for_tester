package ru.stqa.pft.addressbook;

public class FormMail {
  private final String mailValue;
  private final String mailNumber;

  public FormMail(String mailValue, String mailNumber) {
    this.mailValue = mailValue;
    this.mailNumber = mailNumber;
  }

  public String getMailValue() {
    return mailValue;
  }

  public String getMailNumber() {
    return mailNumber;
  }
}
