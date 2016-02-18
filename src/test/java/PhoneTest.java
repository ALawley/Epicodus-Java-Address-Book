import org.junit.*;
import static org.junit.Assert.*;

public class PhoneTest {
  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void phone_instantiatesCorrectly() {
    Phone testPhone = new Phone("cell", "503", "555-5555");
    assertEquals(true, testPhone instanceof Phone);
  }

  @Test
  public void getType_instantiatesCorrectly_cell() {
    Phone testPhone = new Phone("cell", "503", "555-5555");
    assertEquals("cell", testPhone.getType());
  }

  @Test
  public void getAreaCode_returnsAreaCode_503() {
    Phone testPhone = new Phone("cell", "503", "555-5555");
    assertEquals("503", testPhone.getAreaCode());
  }

  @Test
  public void getPhoneNumber_returnsPhoneNumber_555_5555() {
    Phone testPhone = new Phone("cell", "503", "555-5555");
    assertEquals("555-5555", testPhone.getPhoneNumber());
  }
  @Test
  public void all_returnsAllPhoneEntries() {
    Phone testPhone = new Phone("cell", "503", "555-5555");
    Phone testPhone2 = new Phone("home", "555", "555-5555");
    assertTrue(Phone.all().contains(testPhone));
    assertTrue(Phone.all().contains(testPhone2));
  }
}
