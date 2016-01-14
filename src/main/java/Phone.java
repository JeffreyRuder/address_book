public class Phone {
  private String mAreaCode;
  private String mNumber;
  private String mType;

  public Phone(String areaCode, String number, String type) {
    mAreaCode = areaCode;
    mNumber = number;
    mType = type;
  }

  public String getAreaCode() {
    return mAreaCode;
  }

  public String getNumber() {
    return mNumber;
  }

  public String getType() {
    return mType;
  }
}
