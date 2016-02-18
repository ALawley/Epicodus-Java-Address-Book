import org.junit.*;
import static org.junit.Assert.*;

public class PhoneTest {
  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void phone_instantiatesCorrectly() {
    Phone testPhone = new Phone("cell");
    assertEquals(true, testPhone instanceof Phone);
  }

  @Test
  public void getType_instantiatesCorrectly_cell() {
    Phone testPhone = new Phone("cell");
    assertEquals("cell", testPhone.getType());
  }
}
