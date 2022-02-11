package BuySunscreen.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static BuySunscreen.UserInterface.Targets.SUNSCREEN_SPF30;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Questions {
    public static Question<List<WebElementFacade>> sunScreensDisplayedAre()
    {
//        return Question.about("Text displayed").answeredBy(Text.of("div.text-center.col-4").asListOf());
//       return List.of(WebElement).ByCssSelector("div.text-center.col-4");
//        return WebElement.ByCssSelector("div.text-center.col-4").asAList();
//        return Question.about("Text displayed about sunscreens").answeredBy(Text.of("div.text-center.col-4").asListOf(String.class));
//        return Question.about("Text displayed about sunscreens").answeredBy(Text.of("div.text-center.col-4").asListOf(String.class));
//        return Text.of("//p[@class='font-weight-bold top-space-10']").describedAs("Sunscreens displayed").asString();
//        .resolveAllFor(Actor.named("Hamza")).stream();
//        Target.the("Sunscreens").locatedBy("//p[contains(text(),'SPF-30')]").resolveAllFor(Actor.named("Hamza")).
         Question<List<WebElementFacade>> Sunscreens = (Question<List<WebElementFacade>>) SUNSCREEN_SPF30.resolveAllFor(theActorInTheSpotlight());
//        for (W:
//             ) {
//
//        }

        return Sunscreens;







    }
//    public static Question Boolean isActorAtSunscreenPage()
//    {
//        return Question.about("Actotor's current web location")
//    }
}
