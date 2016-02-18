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

  @Test
  public void getName_returnsName_test() {
    Contact testContact = new Contact("test");
    assertEquals("test", testContact.getName());
  }
}
