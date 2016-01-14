import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

  @Test
  public void contact_instantiatesCorrectly_true() {
    Contact johnDoe = new Contact("John", "Doe");
    assertEquals(true, johnDoe instanceof Contact);
  }

  @Test
  public void contact_hasFirstName_John() {
    Contact johnDoe = new Contact("John", "Doe");
    assertEquals("John", johnDoe.getFirst());
  }

  @Test
  public void contact_hasLastName_Doe() {
    Contact johnDoe = new Contact("John", "Doe");
    assertEquals("John", johnDoe.getFirst());
  }

  @Test
  public void getAll_returnsAllContacts_true() {
    Contact johnDoe = new Contact("John", "Doe");
    Contact janeRoe = new Contact("Jane", "Roe");
    assertTrue(Contact.getAll().contains(johnDoe));
    assertTrue(Contact.getAll().contains(janeRoe));
  }

  @Test
  public void find_returnsContactWithCorrectID_janeRoe() {
    Contact johnDoe = new Contact("John", "Doe");
    Contact janeRoe = new Contact("Jane", "Roe");
    assertEquals(Contact.find(janeRoe.getID()), janeRoe);
  }

  @Test
  public void find_returnsNullWhenNoInstances_null() {
    assertTrue(Contact.find(1) == null);
  }

  @Test
  public void clear_clearsContactsFromArrayList_0() {
    Contact contact = new Contact("John", "Doe");
    Contact.clear();
    assertEquals(Contact.getAll().size(), 0);
  }

}
