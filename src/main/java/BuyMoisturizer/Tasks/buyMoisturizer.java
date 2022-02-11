package BuyMoisturizer.Tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class buyMoisturizer {
    public static Task purchaseMoisturizer(String locator)
    {
        return Task.where("Actor buys cheapest moisturizer",Click.on(locator));
    }
    public static Task clickonCartM()
    {
        return Task.where("Actor clicks on the task",Click.on("//button[contains(text(),'Cart')]"));
    }
}
