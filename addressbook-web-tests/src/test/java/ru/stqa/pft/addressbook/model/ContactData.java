package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String title;
  private String company;
  private String address;
  private String homePhone;
  private String workPhone;
  private String email;
  private String group;

  public int getId() { return id; }
  public String getFirstname() {
    return firstname;
  }
  public String getMiddlename() {
    return middlename;
  }
  public String getLastname() {
    return lastname;
  }
  public String getNickname() {
    return nickname;
  }
  public String getTitle() {
    return title;
  }
  public String getCompany() {
    return company;
  }
  public String getAddress() {
    return address;
  }
  public String getHomePhone() {
    return homePhone;
  }
  public String getWorkPhone() {
    return workPhone;
  }
  public String getEmail() {
    return email;
  }
  public String getGroup() { return group;}

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this; //setter
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this; //setter
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this; //setter
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this; //setter
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this; //setter
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this; //setter
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this; //setter
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this; //setter
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this; //setter
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this; //setter
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this; //setter
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }
}
