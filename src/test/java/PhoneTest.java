import org.junit.*;
import static org.junit.Assert.*;

public class PhoneTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void phone_instantiatesCorrectly_true() {
    Phone number = new Phone("555", "867-5309", "Home");
    assertEquals(true, number instanceof Phone);
  }

  @Test
  public void getAreaCode_returnsCorrectAreaCode_555() {
    Phone number = new Phone("555", "8675309", "Home");
    assertEquals("555", number.getAreaCode());
  }

  @Test
  public void getNumber_returnsCorrectNumber_8675309() {
    Phone number = new Phone("555", "8675309", "Home");
    assertEquals("8675309", number.getNumber());
  }

  @Test
  public void getType_returnsCorrectType_Home() {
    Phone number = new Phone("555", "8675309", "Home");
    assertEquals("Home", number.getType());
  }
}
