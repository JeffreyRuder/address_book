import org.junit.*;
import static org.junit.Assert.*;

public class EmailTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void email_instantiatesCorrectly_true() {
    Email email = new Email("sample@test.com", "Work");
    assertEquals(true, email instanceof Email);
  }

  @Test
  public void getAddress_returnsCorrectAddress() {
    Email email = new Email("sample@test.com", "Work");
    assertEquals("sample@test.com", email.getAddress());
  }

  @Test
  public void getType_returnsCorrectType_Work() {
    Email email = new Email("sample@test.com", "Work");
    assertEquals("Work", email.getType());
  }

}
