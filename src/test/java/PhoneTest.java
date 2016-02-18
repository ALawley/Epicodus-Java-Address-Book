import org.junit.*;
import static org.junit.Assert.*;

public class PhoneTest {
  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void phone_instantiatesCorrectly() {
    Phone testPhone = new Phone();
    assertEquals(true, testPhone instanceof Phone);
  }
}
