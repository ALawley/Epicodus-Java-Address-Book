import java.util.ArrayList;

public class Email {
  private static ArrayList<Email> instances = new ArrayList<Email>();
  private String mType;
  private String mEmailAddress;
  private int mId;

  public Email(String type, String email) {
    mType = type;
    mEmailAddress = email;
    instances.add(this);
    mId = instances.size();
  }

  public String getType() {
    return mType;
  }

  public String getEmailAddress() {
    return mEmailAddress;
  }

  public static ArrayList<Email> all() {
    return instances;
  }

  public int getId() {
    return mId;
  }

  public static Email find(int id) {
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
