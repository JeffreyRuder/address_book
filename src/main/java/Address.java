public class Address {
  private String mStreetAddress;
  private String mCity;
  private String mState;
  private String mZip;
  private String mType;

  public Address(String streetAddress, String city, String state, String zip, String type) {
    mStreetAddress = streetAddress;
    mCity = city;
    mState = state;
    mZip = zip;
    mType = type;
  }

  public String getStreet() {
    return mStreetAddress;
  }

  public String getCity() {
    return mCity;
  }

  public String getState() {
    return mState;
  }

  public String getZip() {
    return mZip;
  }

  public String getType() {
    return mType;
  }
  
}
