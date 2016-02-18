import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();


  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Add New Contact");
  }

  @Test
  public void contactFormTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New Contact"));
    assertThat(pageSource()).contains("Add a contact");
  }

  @Test
  public void contactsDisplayTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New Contact"));
    fill("#firstName").with("Bob");
    fill("#lastName").with("Smith");
    fill("#birthMonth").with("September");
    submit(".btn");
    assertThat(pageSource()).contains("Bob Smith");
  }

  @Test
  public void contactsDisplayMultipleTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New Contact"));
    fill("#firstName").with("Bob");
    fill("#lastName").with("Smith");
    fill("#birthMonth").with("September");
    submit(".btn");
    click("a", withText("Add New Contact"));
    fill("#firstName").with("Alice");
    fill("#lastName").with("Jones");
    fill("#birthMonth").with("October");
    submit(".btn");
    assertThat(pageSource()).contains("Bob Smith");
    assertThat(pageSource()).contains("Alice Jones");
  }

  @Test
  public void contactPageDisplayTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New Contact"));
    fill("#firstName").with("Bob");
    fill("#lastName").with("Smith");
    fill("#birthMonth").with("September");
    submit(".btn");
    click("a", withText("Bob Smith"));
    assertThat(pageSource()).contains("September");
  }

  @Test
  public void phoneAddTest() {
    goTo("http://localhost:4567/contacts/new");
    fill("#firstName").with("Bob");
    fill("#lastName").with("Smith");
    fill("#birthMonth").with("September");
    submit(".btn");
    click("a", withText("Bob Smith"));
    click("a", withText("Add a new Phone"));
    fill("#phoneType").with("Work");
    fill("#areaCode").with("555");
    fill("#phoneNumber").with("555-5555");
    submit(".btn");
    assertThat(pageSource()).contains("Work");
  }
}
