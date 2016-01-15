import java.time.LocalDate;
import java.util.*;

public class Contact {
  private static HashMap<Integer, Contact> mInstances = new HashMap<Integer, Contact>();

  private String mFirstName;
  private String mLastName;
  private LocalDate mBirthday;
  private ArrayList<Phone> mPhones;
  private ArrayList<Email> mEmails;
  private ArrayList<Address> mAddresses;

  public Contact(String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
    mPhones = new ArrayList<Phone>();
    mEmails = new ArrayList<Email>();
    mAddresses = new ArrayList<Address>();
    mInstances.put((mInstances.size() + 1), this);
  }

  public static HashMap<Integer, Contact> getAll() {
    return mInstances;
  }

  public static Contact find(Integer key) {
    return mInstances.get(key);
  }

  public static void clear() {
    mInstances.clear();
  }

  public Integer getID() {
    Set set = mInstances.entrySet();
    Iterator i = set.iterator();
    while (i.hasNext()) {
      Map.Entry item = (Map.Entry)i.next();
      if (item.getValue() == this) {
        return (Integer)item.getKey();
      }
    }
    return -1;
  }

  public String getFirst() {
    return mFirstName;
  }

  public String getLast() {
    return mLastName;
  }

  public void addPhone(Phone phone) {
    mPhones.add(phone);
  }

  public ArrayList<Phone> getAllPhones() {
    return mPhones;
  }

  public void addEmail(Email email) {
    mEmails.add(email);
  }

  public ArrayList<Email> getAllEmails() {
    return mEmails;
  }

  public void setBirthday(LocalDate birthday) {
    mBirthday = birthday;
  }

  public LocalDate getBirthday() {
    return mBirthday;
  }

  public void addAddress(Address address) {
    mAddresses.add(address);
  }

  public ArrayList<Address> getAllAddresses() {
    return mAddresses;
  }

}
