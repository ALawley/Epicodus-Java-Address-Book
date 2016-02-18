import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.ArrayList;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request,response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/contacts/new", (request,response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();

      model.put("template", "templates/contact-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contacts", (request,response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();

      String firstName = request.queryParams("firstName");
      String lastName = request.queryParams("lastName");
      String birthMonth = request.queryParams("birthMonth");
      Contact newContact = new Contact(firstName, lastName, birthMonth);
      model.put("contacts", Contact.all());

      model.put("template", "templates/contacts.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }


}
