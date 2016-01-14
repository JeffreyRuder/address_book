import org.junit.*;
import static org.junit.Assert.*;

public class AddressTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void address_instantiatesCorrectly_true() {
    Address address = new Address("111 Mulberry St.", "Portland", "OR", "90210", "Work");
    assertTrue(address instanceof Address);
  }

  @Test
  public void getStreet_returnsCorrectStreetAddress() {
    Address address = new Address("111 Mulberry St.", "Portland", "OR", "90210", "Work");
    assertEquals("111 Mulberry St.", address.getStreet());
  }

  @Test
  public void getCity_returnsCorrectCity_Portland() {
    Address address = new Address("111 Mulberry St.", "Portland", "OR", "90210", "Work");
    assertEquals("Portland", address.getCity());
  }

  @Test
  public void getState_returnsCorrectState_OR() {
    Address address = new Address("111 Mulberry St.", "Portland", "OR", "90210", "Work");
    assertEquals("OR", address.getState());
  }

  @Test
  public void getZip_returnsCorrectZip_90210() {
    Address address = new Address("111 Mulberry St.", "Portland", "OR", "90210", "Work");
    assertEquals("90210", address.getZip());
  }

  @Test
  public void getType_returnsCorrectType_Work() {
    Address address = new Address("111 Mulberry St.", "Portland", "OR", "90210", "Work");
    assertEquals("Work", address.getType());
  }

}
