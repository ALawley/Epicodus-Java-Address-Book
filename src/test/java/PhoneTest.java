import org.junit.*;
import static org.junit.Assert.*;

public class PhoneTest {
  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void phone_instantiatesCorrectly() {
    Phone testPhone = new Phone("cell", "503");
    assertEquals(true, testPhone instanceof Phone);
  }

  @Test
  public void getType_instantiatesCorrectly_cell() {
    Phone testPhone = new Phone("cell", "503");
    assertEquals("cell", testPhone.getType());
  }

  @Test
  public void getAreaCode_returnsAreaCode_503() {
    Phone testPhone = new Phone("cell", "503");
    assertEquals("503", testPhone.getAreaCode());
  }
}
