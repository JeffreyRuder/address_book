import java.util.*;

public class Contact {
  private static HashMap<Integer, Contact> mInstances = new HashMap<Integer, Contact>();

  private String mFirstName;
  private String mLastName;
  // private ArrayList<Phone> mPhoneNumbers;
  // private ArrayList<Email> mEmailAddresses;

  public Contact(String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
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

  public String lastName() {
    return mLastName;
  }

}
