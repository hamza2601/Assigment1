package checkoutCart.Tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static checkoutCart.userInterface.targets.PAY_INR_BUTTON;
import static checkoutCart.userInterface.targets.PURCHASE_BUTTON;

public class tasksCart {

public static Task clickOnPayINR()
{

    return Task.where("Actor makes the final payment", Click.on(PAY_INR_BUTTON));
}

    public static Task clickOnPayWithCard()
    {
        return Task.where("Actor proceeds to enter detail",Click.on(PURCHASE_BUTTON));

    }

}


