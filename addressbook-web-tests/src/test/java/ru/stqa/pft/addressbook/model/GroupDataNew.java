package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupDataNew {
  private int id;
  private final String name;
  private final String header;
  private final String footer;

  public GroupDataNew(int id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public void setId(int id) {
    this.id = id;
  }

  public GroupDataNew(String name, String header, String footer) {
    this.id = 0;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }


  public int getId() { return id; }
  public String getName() {
    return name;
  }
  public String getHeader() {
    return header;
  }
  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupDataNew{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupDataNew that = (GroupDataNew) o;
    return id == that.id &&
            Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
