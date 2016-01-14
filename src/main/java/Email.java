public class Email {
  private String mAddress;
  private String mType;

  public Email(String address, String type) {
    mAddress = address;
    mType = type;
  }

  public String getAddress() {
    return mAddress;
  }

  public String getType() {
    return mType;
  }

}
