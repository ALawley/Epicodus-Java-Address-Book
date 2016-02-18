import java.util.ArrayList;

public class Phone {
  private String mType;
  private String mAreaCode;
  private String mPhoneNumber;

  public Phone(String type, String areaCode, String number) {
    mType = type;
    mAreaCode = areaCode;
    mPhoneNumber = number;
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
}
