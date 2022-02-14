package checkoutCart.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class targets {
    public static Target PURCHASE_BUTTON = Target.the("Pay with card button").locatedBy("//button");
    public static Target PAY_INR_BUTTON = Target.the("Final pay button").locatedBy("//span[@class='iconTick']");


}
