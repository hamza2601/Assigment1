package checkoutCart.Actions;

import checkoutCart.userInterface.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable payWithCard()
    {
        return Task.where("{0} pays with the card", Open.browserOn().the(CheckoutPage.class));
    }
}
