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

    get("/contacts/:id", (request,response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();

      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);

      model.put("template", "templates/contact.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/contacts/:id/phones/new", (request,response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();

      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);

      model.put("template", "templates/contact-phone-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/phone-new", (request,response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();

      String type = request.queryParams("phoneType");
      String areaCode = request.queryParams("areaCode");
      String phoneNumber = request.queryParams("phoneNumber");
      Contact contact = Contact.find(Integer.parseInt(request.queryParams("contactId")));
      Phone newPhone = new Phone(type, areaCode, phoneNumber);
      Contact.find(contact.getId()).addPhone(newPhone);
      model.put("contact", contact);

      model.put("template", "templates/contact.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/contacts/:id/emails/new", (request,response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();

      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);

      model.put("template", "templates/contact-email-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/email-new", (request,response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();

      String type = request.queryParams("emailType");
      String emailAddress = request.queryParams("emailAddress");
      Contact contact = Contact.find(Integer.parseInt(request.queryParams("contactId")));
      Email newEmail = new Email(type, emailAddress);
      Contact.find(contact.getId()).addEmail(newEmail);
      model.put("contact", contact);

      model.put("template", "templates/contact.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }


}
