package BuyMoisturizer.actions;

import BuyMoisturizer.UserInterface.BuyMoisturizer;
import BuySunscreen.UserInterface.BuySunscreen;
import homepage.user_interface.homepage.homepage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable homepage() {
        return Task.where("{0} opens the home page",
                Open.browserOn().the(homepage.class));
    }
    public static Performable BuyMoisturizer(){
        return Task.where("{0} opens the Buy Moisturizer page",Open.browserOn().the(BuyMoisturizer.class));
    }
    public static Performable BuySunscreen()
    {
        return Task.where("{0} opens the Buy Sunscreen page",Open.browserOn().the(BuySunscreen.class));
    }
}
