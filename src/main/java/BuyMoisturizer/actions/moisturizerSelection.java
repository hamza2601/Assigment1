package BuyMoisturizer.actions;

import BuyMoisturizer.Tasks.buyMoisturizer;
import homepage.tasks.homepage.tasks;

import java.util.ArrayList;

import static BuyMoisturizer.UserInterface.Targets_Moisturizers.ALMOND_MOISTURIZERS;
import static BuyMoisturizer.UserInterface.Targets_Moisturizers.ALOE_MOISTURIZERS;
import static BuyMoisturizer.actions.buyCheapestMoisturizer.*;
import static BuyMoisturizer.actions.buyCheapestMoisturizer.cheapestMoisturizerName;
import static checkoutCart.Actions.FieldFillingIn.fillInFields;
import static checkoutCart.Actions.checkoutActions.clickOnPayButton;
import static checkoutCart.Actions.checkoutActions.verifySuccessMesaage;
import static checkoutCart.Actions.checkoutActionsMoisturizers.*;
import static checkoutCart.Tasks.tasksCart.clickOnPayWithCard;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class moisturizerSelection {
    public static void undertake_Moisturizer_Selection_And_Purchase()
    {
        theActorInTheSpotlight().attemptsTo(tasks.ClickOnBuyMoisturizer());
        ArrayList<String> pricesMoisturizers = unrefinedListM(ALOE_MOISTURIZERS);
        int lM = pricesMoisturizers.size();
        String[] PricesM;
        PricesM = refinedPricesM(pricesMoisturizers);
        String cheapPriceM =lowestPriceM(PricesM);
        String buttonLocatorM = locatorM(cheapPriceM);
        String Aloe_Name = cheapestMoisturizerName(cheapPriceM);
        theActorInTheSpotlight().attemptsTo(buyMoisturizer.purchaseMoisturizer(buttonLocatorM));



        System.out.println("******************Always keep your skin moisturized in winters!!***************");

        ArrayList<String> pricesAlmond = new ArrayList<>();
        pricesAlmond = unrefinedListM(ALMOND_MOISTURIZERS);
        String[] PricesAlmond;
        PricesAlmond = refinedPricesM(pricesAlmond);
        String lowPriceAlmond = lowestPriceM(PricesAlmond);
        String locatorAlmond = locatorM(lowPriceAlmond);
        String Almond_Name = cheapestMoisturizerName(lowPriceAlmond);
        theActorInTheSpotlight().attemptsTo(buyMoisturizer.purchaseMoisturizer(locatorAlmond));
        theActorInTheSpotlight().attemptsTo(buyMoisturizer.clickonCartM());
        //now the final test cases
        boolean nameVerifyMOS = productNameVerificationMoisturizers(Aloe_Name,Almond_Name);
        boolean priceVerifyMOS = productPriceVerificationMoisturizers(cheapPriceM,lowPriceAlmond);
        boolean totalVerificationMOS = totalSumVerifyMoisturizers();
        if(nameVerifyMOS && priceVerifyMOS && totalVerificationMOS)
        {
            theActorInTheSpotlight().attemptsTo(clickOnPayWithCard());
            fillInFields();
//            Thread.sleep(1000);
            theActorInTheSpotlight().attemptsTo(clickOnPayButton());
//            Thread.sleep(5000);
            if(verifySuccessMesaage())
                System.out.println("Congrats! Purchase was successful!");
            else
                System.out.println("Sorry! :( Payment failed");
        }
        else
        {
            System.out.println(Aloe_Name + "Sorry! cart page had some issues :-/" + Almond_Name);
        }
    }
}
