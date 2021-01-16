package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;
import java.util.Objects;


public class ContactData {
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstname;
  private String middlename;
  @Expose
  private String lastname;
  @Expose
  private String nickname;
  private String title;
  private String company;
  @Expose
  private String address;
  private String homePhone;
  @Expose
  private String workPhone;
  @Expose
  private String mobilePhone;
  @Expose
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  @Expose
  private String group;
  private String allPhones;
  private File photo;

  public File getPhoto() {
    return photo;
  }

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
  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getGroup() {
    return group;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this; //setter
  }

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

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this; //setter
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this; //setter
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this; //setter
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this; //setter
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this; //setter
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
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
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

}
