import java.util.ArrayList;

public class Phone {
  private String mType;
  private String mAreaCode;

  public Phone(String type, String areaCode) {
    mType = type;
    mAreaCode = areaCode;
  }

  public String getType() {
    return mType;
  }

  public String getAreaCode() {
    return mAreaCode;
  }
}
