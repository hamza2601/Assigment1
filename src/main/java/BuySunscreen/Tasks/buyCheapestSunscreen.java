package BuySunscreen.Tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.testng.util.TimeUtils;

public class buyCheapestSunscreen {
    public static Task buySunscreen(String locator)
    {
        return Task.where("Actor buys cheapest sunscreen", Click.on(locator));

    }
    public static Task clickonCart()
    {
        return Task.where("Actor clicks on the task",Click.on("//button[contains(text(),'Cart')]"));
    }
}
