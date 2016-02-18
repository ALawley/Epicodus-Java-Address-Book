import java.util.ArrayList;

public class Contact {
  private static ArrayList<Contact> instances = new ArrayList<Contact>();
  private ArrayList<Phone> mPhones;
  private ArrayList<Email> mEmails;
  private ArrayList<Address> mAddresses;
  private String mFirstName;
  private String mLastName;
  private String mBirthMonth;
  private int mId;

  public Contact(String firstName, String lastName, String birthMonth) {
    mFirstName = firstName;
    mLastName = lastName;
    mBirthMonth = birthMonth;
    instances.add(this);
    mId = instances.size();
    mPhones = new ArrayList<Phone>();
    mEmails = new ArrayList<Email>();
    mAddresses = new ArrayList<Address>();
  }

  public String getFirstName() {
    return mFirstName;
  }

  public String getLastName() {
    return mLastName;
  }

  public String getFullName() {
    return mFirstName + " " + mLastName;
  }

  public String getBirthMonth() {
    return mBirthMonth;
  }

  public static ArrayList<Contact> all() {
    return instances;
  }

  public int getId() {
    return mId;
  }

  public static Contact find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }

  public ArrayList<Phone> getPhones() {
    return mPhones;
  }

  public void addPhone(Phone phone) {
    mPhones.add(phone);
  }

  public ArrayList<Email> getEmails() {
    return mEmails;
  }

  public void addEmail(Email email) {
    mEmails.add(email);
  }

  public ArrayList<Address> getAddresses() {
    return mAddresses;
  }

  public void addAddress(Address address) {
    mAddresses.add(address);
  }
}
