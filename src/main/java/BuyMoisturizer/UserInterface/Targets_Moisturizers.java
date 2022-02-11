package BuyMoisturizer.UserInterface;

import BuySunscreen.UserInterface.Targets;
import net.serenitybdd.screenplay.targets.Target;



public class Targets_Moisturizers {
    public static Target ALOE_MOISTURIZERS = Target.the("Moisturizers with Aloe").locatedBy("//p[contains(text(),'Aloe')]/following-sibling::p | //p[contains(text(),'aloe')]/following-sibling::p");
    public static Target ALMOND_MOISTURIZERS = Target.the("Moisturizers with Almond").locatedBy("//p[contains(text(),'Almond')]/following-sibling::p | //p[contains(text(),'almond')]/following-sibling::p");
}

