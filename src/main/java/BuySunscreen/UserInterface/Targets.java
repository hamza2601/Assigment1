package BuySunscreen.UserInterface;

import net.serenitybdd.screenplay.targets.Target;

public class Targets {
    public static Target SUNSCREEN_SPF30 = Target.the("Sunscreen_Name").locatedBy("//p[contains(text(),'SPF-30')]/following-sibling::p  |  //p[contains(text(),'spf-30')]/following-sibling::p");
    public static Target SUNSCREEN_SPF50 = Target.the("Sunscreen_Name").locatedBy("//p[contains(text(),'SPF-50')]/following-sibling::p  |  //p[contains(text(),'spf-50')]/following-sibling::p");


}
