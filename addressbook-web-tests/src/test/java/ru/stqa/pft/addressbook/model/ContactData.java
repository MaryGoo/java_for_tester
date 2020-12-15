package ru.stqa.pft.addressbook.model;

public class ContactData {
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


  public ContactData(String firstname,
                     String middlename,
                     String lastname,
                     String nickname,
                     String title,
                     String company,
                     String address,
                     String homePhone,
                     String workPhone,
                     String email,
                     String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.workPhone = workPhone;
    this.email = email;
    this.group = group;

  }
  public ContactData (String homePhone, String workPhone) {
    this.homePhone = homePhone;
    this.workPhone = workPhone;
  }


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

  public String getGroup() {
    return group;
  }

}
