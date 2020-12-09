package ru.stqa.pft.addressbook.model;

public class FormDate {
  private final String groupDate;
  private final String day;
  private final String month;
  private final String year;

  public FormDate(String groupDate, String day, String month, String year) {
    this.groupDate = groupDate;
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public String getGroupDate() {
    return groupDate;
  }

  public String getDay() {
    return day;
  }

  public String getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }
}
