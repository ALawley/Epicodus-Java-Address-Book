import java.util.ArrayList;

public class Address {
  private static ArrayList<Address> instances = new ArrayList<Address>();
  private String mType;
  private String mStreet;
  private String mCity;
  private String mState;
  private int mZip;
  private int mId;

  public Address(String type, String street, String city, String state, int zip) {
    mType = type;
    mStreet = street;
    mCity = city;
    mState = state;
    mZip = zip;
    instances.add(this);
    mId = instances.size();
  }

  public String getType() {
    return mType;
  }

  public String getStreet() {
    return mStreet;
  }

  public String getCity() {
    return mCity;
  }

  public String getState() {
    return mState;
  }

  public int getZip() {
    return mZip;
  }

  public static ArrayList<Address> all() {
    return instances;
  }

  public int getId() {
    return mId;
  }

  public static Address find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
}
