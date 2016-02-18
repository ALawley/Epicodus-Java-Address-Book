import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void contact_instantiatesCorrectly() {
    Contact testContact = new Contact("test", "test2");
    assertEquals(true, testContact instanceof Contact);
  }

  @Test
  public void getFirstName_returnsFirstName_test() {
    Contact testContact = new Contact("test", "test2");
    assertEquals("test", testContact.getFirstName());
  }

  @Test
  public void getLastName_returnsLastName_test() {
    Contact testContact = new Contact("test", "test2");
    assertEquals("test2", testContact.getLastName());
  }
}
