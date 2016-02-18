import org.junit.*;
import static org.junit.Assert.*;

public class AddressTest {
  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void address_instantiatesCorrectly() {
    Address testAddress = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertEquals(true, testAddress instanceof Address);
  }

  @Test
  public void getType_returnsAddressType_home() {
    Address testAddress = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertEquals("home", testAddress.getType());
  }

  @Test
  public void getAddress_returnsAddressStreet_street() {
    Address testAddress = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertEquals("123 E Burnside", testAddress.getStreet());
  }

  @Test
  public void getCity_returnsAddressCity_Portland() {
    Address testAddress = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertEquals("Portland", testAddress.getCity());
  }

  @Test
  public void getState_returnsAddressState_OR() {
    Address testAddress = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertEquals("OR", testAddress.getState());
  }

  @Test
  public void getZip_returnsAddressZip_97214() {
    Address testAddress = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertEquals(97214, testAddress.getZip());
  }

  @Test
  public void all_returnsAllAddressEntries() {
    Address testAddress = new Address("work", "123 SW Stark", "Portland", "OR", 97219);
    Address testAddress2 = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertTrue(Address.all().contains(testAddress));
    assertTrue(Address.all().contains(testAddress2));
  }

  @Test
  public void getId_returnsId_Id() {
    Address testAddress = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertEquals(Address.all().size(), testAddress.getId());
  }

  @Test
  public void find_returnsAddressObjectWithId_testAddress() {
    Address testAddress = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertEquals(testAddress, Address.find(testAddress.getId()));
  }

  @Test
  public void find_throwsExceptionWhenIdIsNotFound() {
    Address testAddress = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    assertTrue(Address.find(999) == null);
  }

  @Test
  public void clear_removesAllPhoneObjects() {
    Address testAddress = new Address("work", "123 SW Stark", "Portland", "OR", 97219);
    Address testAddress2 = new Address("home", "123 E Burnside", "Portland", "OR", 97214);
    Address.clear();
    assertEquals(0, Address.all().size());
  }
}
