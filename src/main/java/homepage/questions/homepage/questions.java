package homepage.questions.homepage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.WebElementLocator;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static homepage.user_interface.homepage.ui.TEMPERATURE;

public class questions {
    public static Question<String> temperatureIs() {
        return Question.about("temperature").answeredBy(Text.of(TEMPERATURE).asString());

    }
    public static Question<List<String>> sunScreensDisplayedAre()
    {
//        return Question.about("Text displayed").answeredBy(Text.of("div.text-center.col-4").asListOf());
//       return List.of(WebElement).ByCssSelector("div.text-center.col-4");
//        return WebElement.ByCssSelector("div.text-center.col-4").asAList();
        return Question.about("Text displayed about sunscreens").answeredBy(Text.of("div.text-center.col-4").asString().asListOf(String.class));

    }
    public static Question<String>NameOfCurrentPage()
    {
        return Question.about("The current page we're present on").answeredBy(Text.of("//h2")).asString();
    }
}
