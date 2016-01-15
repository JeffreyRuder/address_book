import java.time.LocalDate;

import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

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
    assertTrue(Contact.getAll().containsValue(johnDoe));
    assertTrue(Contact.getAll().containsValue(janeRoe));
  }

  @Test
  public void getID_returnsCorrectID_2() {
    Contact johnDoe = new Contact("John", "Doe");
    Contact janeRoe = new Contact("Jane", "Roe");
    assertEquals((Integer)2, (Integer)janeRoe.getID());
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
  public void clear_clearsContactsFromArrayList_true() {
    Contact contact = new Contact("John", "Doe");
    Contact.clear();
    assertTrue(Contact.getAll().isEmpty());
  }

  @Test
  public void addPhone_addsPhoneToContact() {
    Contact contact = new Contact("John", "Doe");
    Phone phone = new Phone("555", "8675309", "Home");
    contact.addPhone(phone);
    assertTrue(contact.getAllPhones().contains(phone));
  }

  @Test
  public void addEmail_addsEmailToContact() {
    Contact contact = new Contact("John", "Doe");
    Email email = new Email("test@testerson.com", "Work");
    contact.addEmail(email);
    assertTrue(contact.getAllEmails().contains(email));
  }

  @Test
  public void addBirthday_addsBirthdayToContact() {
    Contact contact = new Contact("John", "Doe");
    LocalDate birthday = LocalDate.of(1980, 3, 15);
    contact.setBirthday(birthday);
    assertEquals(birthday, contact.getBirthday());
  }

  @Test
  public void birthday_correctlyDisplaysAsString() {
    Contact contact = new Contact("John", "Doe");
    LocalDate birthday = LocalDate.of(1980, 3, 15);
    contact.setBirthday(birthday);
    assertEquals("1980-03-15", contact.getBirthday().toString());
  }

  @Test
  public void birthday_returnsNullWhenBirthdayNotSet_null() {
    Contact contact = new Contact("John", "Doe");
    assertEquals(null, contact.getBirthday());
  }

  @Test
  public void getAllContacts_returnsAllContacts() {
    Contact johnDoe = new Contact("John", "Doe");
    Contact janeRoe = new Contact("Jane", "Roe");
    assertTrue(Contact.getAllContacts().contains(johnDoe));
    assertTrue(Contact.getAllContacts().contains(janeRoe));
  }

}
