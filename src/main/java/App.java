import java.time.LocalDate;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

      staticFileLocation("/public");
      String layout = "templates/layout.vtl";

        //RESTful ARCHITECTURE
        //Use POST to create something on the server
        //Use GET to retrieve something from the server
        //Use PUT to change or update something on the server
        //Use DELETE to remove or delete something on the server
        //Keep URLs intuitive
        //Each request from client contains all info necessary for that request

        //ROUTES: Home Page

        get("/contacts", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          model.put("contacts", Contact.getAll());

          model.put("template", "templates/contacts.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //ROUTES: Identification of Resources

        get("/contacts/new", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/addcontact.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/contacts/:id", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          Contact contact = Contact.find(Integer.parseInt(request.params(":id")));

          model.put("contact", contact);
          model.put("contacts", Contact.getAll());

          model.put("template", "templates/contact.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/contacts/:id/addbirthday", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          Contact contact = Contact.find(Integer.parseInt(request.params(":id")));

          model.put("contact", contact);

          model.put("template", "templates/addbirthday.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/contacts/:id/addemail", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          Contact contact = Contact.find(Integer.parseInt(request.params(":id")));

          model.put("contact", contact);

          model.put("template", "templates/addemail.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/contacts/:id/addphone", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          Contact contact = Contact.find(Integer.parseInt(request.params(":id")));

          model.put("contact", contact);

          model.put("template", "templates/addphone.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/contacts/:id/addmailing", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          Contact contact = Contact.find(Integer.parseInt(request.params(":id")));

          model.put("contact", contact);

          model.put("template", "templates/addmailing.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //ROUTES: Changing Resources

        //add a new contact

        post("/contacts", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          String newFirst = request.queryParams("first");
          String newLast = request.queryParams("last");
          Contact newContact = new Contact(newFirst, newLast);

          model.put("contacts", Contact.getAll());

          model.put("template", "templates/contacts.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/contacts/:id", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          Contact contact = Contact.find(Integer.parseInt(request.params(":id")));

          //add a birthday
          if (request.queryParams("birthmonth") != null) {
            Integer birthMonth = Integer.parseInt(request.queryParams("birthmonth"));
            Integer birthDay = Integer.parseInt(request.queryParams("birthday"));
            Integer birthYear = Integer.parseInt(request.queryParams("birthyear"));
            LocalDate birthDate = LocalDate.of((int)birthYear, (int)birthMonth, (int)birthDay);
            contact.setBirthday(birthDate);
          }

          //add a phone
          if (request.queryParams("areacode") != null) {
            String areaCode = request.queryParams("areacode");
            String phoneNumber = request.queryParams("phonenumber");
            String phoneType = request.queryParams("phonetype");
            Phone phone = new Phone(areaCode, phoneNumber, phoneType);
            contact.addPhone(phone);
          }

          //add an email
          if (request.queryParams("emailtype") != null) {
            String emailAddress = request.queryParams("emailaddress");
            String emailType = request.queryParams("emailtype");
            Email email = new Email(emailAddress, emailType);
            contact.addEmail(email);
          }

          //add a mailing address
          if (request.queryParams("streetaddress") != null) {
            String street = request.queryParams("streetaddress");
            String city = request.queryParams("city");
            String state = request.queryParams("state");
            String zip = request.queryParams("zipcode");
            String mailingType = request.queryParams("mailingtype");
            Address address = new Address(street, city, state, zip, mailingType);
            contact.addAddress(address);
          }

          model.put("contact", contact);
          model.put("template", "templates/contact.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}
