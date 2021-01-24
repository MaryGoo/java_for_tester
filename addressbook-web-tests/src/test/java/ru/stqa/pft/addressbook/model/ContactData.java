package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table (name = "addressbook")
public class ContactData {
  @Id
  @Column (name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column (name = "firstname")
  private String firstname;
  @Column (name = "middlename")
  private String middlename;
  @Expose
  @Column (name = "lastname")
  private String lastname;
  @Expose
  @Column (name = "nickname")
  private String nickname;
  @Column (name = "title")
  private String title;
  @Column (name = "company")
  private String company;
  @Expose
  @Column (name = "address")
  @Type(type = "text")
  private String address;

  @Column (name = "home")
  @Type(type = "text")
  private String homePhone;
  @Expose
  @Column (name = "work")
  @Type(type = "text")
  private String workPhone;
  @Expose
  @Column (name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Expose
  @Column (name = "email")
  @Type(type = "text")
  private String email;
  @Column (name = "email2")
  @Type(type = "text")
  private String email2;
  @Column (name = "email3")
  @Type(type = "text")
  private String email3;
  @Transient
  private String allEmails;
  @Expose
  //@Column (name = "middlename")
  @Transient // do not take from the database
  private String group;
  @Transient
  private String allPhones;
  @Column (name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
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
    this.photo = photo.getPath();
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
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", title='" + title + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(middlename, that.middlename) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(nickname, that.nickname) &&
            Objects.equals(title, that.title) &&
            Objects.equals(company, that.company) &&
            Objects.equals(address, that.address) &&
            Objects.equals(homePhone, that.homePhone) &&
            Objects.equals(workPhone, that.workPhone) &&
            Objects.equals(mobilePhone, that.mobilePhone) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3) &&
            Objects.equals(group, that.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, middlename, lastname, nickname, title, company, address, homePhone, workPhone, mobilePhone, email, email2, email3, group);
  }
}
