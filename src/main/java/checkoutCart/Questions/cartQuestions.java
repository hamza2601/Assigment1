package checkoutCart.Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class cartQuestions {
    public static Question<String> nameofProductIs(String locator)
    {
        return Question.about("Name of product").answeredBy(Text.of(locator).asString());
    }
    public static Question<String> priceOfProductIs(String locator)
    {
        return Question.about("price of the product:").answeredBy(Text.of(locator).asString());
    }
    public static Question<String> displayedMessageIs()
    {
        return Question.about("The message displayed").answeredBy(Text.of("//h2").asString());
    }
}
