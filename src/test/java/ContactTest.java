import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void contact_instantiatesCorrectly() {
    Contact testContact = new Contact("test");
    assertEquals(true, testContact instanceof Contact);
  }
}
