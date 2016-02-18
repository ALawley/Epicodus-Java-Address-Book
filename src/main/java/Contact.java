import java.util.ArrayList;

public class Contact {
  private String mFirstName;
  private String mLastName;

  public Contact(String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
  }

  public String getFirstName() {
    return mFirstName;
  }

  public String getLastName() {
    return mLastName;
  }
}
