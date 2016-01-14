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

          model.put("contacts", Contact.all());

          model.put("template", "templates/contacts.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //ROUTES: Identification of Resources

        get("/contacts/:id", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          Contact contact = Contacts.find(Integer.parseInt(request.params(":id")))

          model.put("contact", contact)
          model.put("contacts", Contact.all());

          model.put("template", "templates/contacts.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //ROUTES: Changing Resources

    }
}
