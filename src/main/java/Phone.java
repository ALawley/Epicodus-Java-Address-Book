import java.util.ArrayList;

public class Phone {
  private static ArrayList<Phone> instances = new ArrayList<Phone>();
  private String mType;
  private String mAreaCode;
  private String mPhoneNumber;
  private int mId;

  public Phone(String type, String areaCode, String number) {
    mType = type;
    mAreaCode = areaCode;
    mPhoneNumber = number;
    instances.add(this);
    mId = instances.size();
  }

  public String getType() {
    return mType;
  }

  public String getAreaCode() {
    return mAreaCode;
  }

  public String getPhoneNumber() {
    return mPhoneNumber;
  }

  public static ArrayList<Phone> all() {
    return instances;
  }

  public int getId() {
    return mId;
  }

  public static Phone find(int id) {
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
