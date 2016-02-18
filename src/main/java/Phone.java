import java.util.ArrayList;

public class Phone {
  private static ArrayList<Phone> instances = new ArrayList<Phone>();
  private String mType;
  private String mAreaCode;
  private String mPhoneNumber;

  public Phone(String type, String areaCode, String number) {
    mType = type;
    mAreaCode = areaCode;
    mPhoneNumber = number;
    instances.add(this);
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
}
