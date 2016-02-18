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
}
