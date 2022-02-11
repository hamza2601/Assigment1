package homepage.user_interface.homepage;

import net.serenitybdd.screenplay.targets.Target;

public class ui {
    public static Target TEMPERATURE = Target.the("temperature").locatedBy("#temperature");
    public static Target BUY_MOISTURIZER_BUTTON = Target.the("buy moisturizer button").locatedBy("//button[text()='Buy moisturizers']");
    public static Target BUY_SUNSCREEN_BUTTON = Target.the("buy sunscreen button").locatedBy("//button[text()='Buy sunscreens']");

}
