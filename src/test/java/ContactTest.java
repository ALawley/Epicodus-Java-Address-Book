import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void contact_instantiatesCorrectly() {
    Contact testContact = new Contact("test", "test2", "August");
    assertEquals(true, testContact instanceof Contact);
  }

  @Test
  public void getFirstName_returnsFirstName_test() {
    Contact testContact = new Contact("test", "test2", "August");
    assertEquals("test", testContact.getFirstName());
  }

  @Test
  public void getLastName_returnsLastName_test2() {
    Contact testContact = new Contact("test", "test2", "August");
    assertEquals("test2", testContact.getLastName());
  }

  @Test
  public void getBirthMonth_returnsBirthMonth_August() {
    Contact testContact = new Contact("test", "test2", "August");
    assertEquals("August", testContact.getBirthMonth());
  }

  @Test
  public void all_returnsAllContacts() {
    Contact testContact = new Contact("test", "test2", "August");
    Contact testContact2 = new Contact("test2", "test3", "October");
    assertTrue(Contact.all().contains(testContact));
    assertTrue(Contact.all().contains(testContact2));
  }

  @Test
  public void getId_returnsIdOfContact_id() {
    Contact testContact = new Contact("test", "test2", "August");
    assertEquals(Contact.all().size(), testContact.getId());
  }

  @Test
  public void find_returnsContactByItsID_testContact() {
    Contact testContact = new Contact("test", "test2", "August");
    Contact testContact2 = new Contact("test2", "test3", "October");
    assertEquals(testContact2, Contact.find(testContact2.getId()));
  }

  @Test
  public void clear_clearsMemoryOfContact(){
    Contact testContact = new Contact("test", "test2", "August");
    Contact testContact2 = new Contact("test2", "test3", "October");
    Contact.clear();
    assertEquals(Contact.all().size(), 0);
  }
}
