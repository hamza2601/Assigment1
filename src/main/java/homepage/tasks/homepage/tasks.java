package homepage.tasks.homepage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import static homepage.user_interface.homepage.ui.BUY_MOISTURIZER_BUTTON;
import static homepage.user_interface.homepage.ui.BUY_SUNSCREEN_BUTTON;


public class tasks {

    public static Task ClickOnBuyMoisturizer(){
        return Task.where("Actor clicks the Buy Moisturizer option", Click.on(BUY_MOISTURIZER_BUTTON));

    }
    public static Task ClickOnBuySunScreen(){
        return Task.where("Actor clicks on the buy sunscreen option",Click.on(BUY_SUNSCREEN_BUTTON));


    }
//    public static Task ReadDisplayedTemperature (){
//
////        return Task.where("Actor reads the temperature", );
//
//
//    }

}
