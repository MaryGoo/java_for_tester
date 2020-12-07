package ru.stqa.pft.addressbook;

public class FormCompany {
  private final String company;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;

  public FormCompany(String company, String address, String homePhone, String mobilePhone) {
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
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

  public String getMobilePhone() {
    return mobilePhone;
  }
}
