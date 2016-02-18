import org.junit.*;
import static org.junit.Assert.*;

public class EmailTest {
  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void email_instantiatesCorrectly() {
    Email testEmail = new Email("personal", "example@gmail.com");
    assertEquals(true, testEmail instanceof Email);
  }

  @Test
  public void getType_instantiatesCorrectly_personal() {
    Email testEmail = new Email("personal", "example@gmail.com");
    assertEquals("personal", testEmail.getType());
  }

  @Test
  public void getEmailAddress_returnsEmailAddress_email() {
    Email testEmail = new Email("personal", "example@gmail.com");
    assertEquals("example@gmail.com", testEmail.getEmailAddress());
  }

  @Test
  public void all_returnsAllEmailEntries() {
    Email testEmail = new Email("work", "example@yahoo.com");
    Email testEmail2 = new Email("personal", "example@gmail.com");
    assertTrue(Email.all().contains(testEmail));
    assertTrue(Email.all().contains(testEmail2));
  }

  @Test
  public void getId_returnsId_Id() {
    Email testEmail = new Email("personal", "example@gmail.com");
    assertEquals(Email.all().size(), testEmail.getId());
  }

  @Test
  public void find_returnsEmailObjectWithId_testEmail() {
    Email testEmail = new Email("personal", "example@gmail.com");
    assertEquals(testEmail, Email.find(testEmail.getId()));
  }

  @Test
  public void find_throwsExceptionWhenIdIsNotFound() {
    Email testEmail = new Email("personal", "example@gmail.com");
    assertTrue(Email.find(999) == null);
  }

  @Test
  public void clear_removesAllPhoneObjects() {
    Email testEmail = new Email("personal", "example@gmail.com");
    Email testEmail2 = new Email("personal", "example@gmail.com");
    Email.clear();
    assertEquals(0, Email.all().size());
  }
}
