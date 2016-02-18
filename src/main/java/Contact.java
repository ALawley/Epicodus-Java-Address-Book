import java.util.ArrayList;

public class Contact {
  private static ArrayList<Contact> instances = new ArrayList<Contact>();
  private String mFirstName;
  private String mLastName;
  private String mBirthMonth;

  public Contact(String firstName, String lastName, String birthMonth) {
    mFirstName = firstName;
    mLastName = lastName;
    mBirthMonth = birthMonth;
    instances.add(this);
  }

  public String getFirstName() {
    return mFirstName;
  }

  public String getLastName() {
    return mLastName;
  }

  public String getBirthMonth() {
    return mBirthMonth;
  }

  public static ArrayList<Contact> all() {
    return instances;
  }
}
