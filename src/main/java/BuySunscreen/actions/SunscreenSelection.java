package BuySunscreen.actions;

import BuySunscreen.Tasks.buyCheapestSunscreen;
import homepage.tasks.homepage.tasks;

import java.util.ArrayList;

import static BuyMoisturizer.actions.buyCheapestMoisturizer.cheapestMoisturizerName;
import static BuySunscreen.UserInterface.Targets.SUNSCREEN_SPF30;
import static BuySunscreen.UserInterface.Targets.SUNSCREEN_SPF50;
import static BuySunscreen.actions.buyingCheapestSunscreen.*;
import static BuySunscreen.actions.buyingCheapestSunscreen.locator;
import static checkoutCart.Actions.FieldFillingIn.fillInFields;
import static checkoutCart.Actions.checkoutActions.*;
import static checkoutCart.Tasks.tasksCart.clickOnPayWithCard;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SunscreenSelection {
    public static void undertake_Sunscreen_Selection_And_Purchase()
    {
        theActorInTheSpotlight().attemptsTo(tasks.ClickOnBuySunScreen());


        ArrayList<String> prices = new ArrayList<>();
        prices =  unrefinedPriceList(SUNSCREEN_SPF30); //we get the prices, but not in numerics only



        int l= prices.size();  //getting size of the prices array
        String[] Prices;
        Prices = refinedPrices(prices);
        String lowest_Price = lowestPrice(Prices);
        String SPF30_NAME = cheapestMoisturizerName(lowest_Price);



        String buttonLocator = locator(lowest_Price);
        System.out.println(buttonLocator);
        theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.buySunscreen(buttonLocator));



        //now we try to do the same prcedure for SPF-50
        ArrayList<String> pricesSPF50 = new ArrayList<>();
        pricesSPF50 = unrefinedPriceList(SUNSCREEN_SPF50);
        String [] PricesSPF50;
        PricesSPF50 = refinedPrices(pricesSPF50);
        String lowestPriceSPF50 = lowestPrice(PricesSPF50);
        String SPF_50NAME = cheapestMoisturizerName(lowestPriceSPF50);
        String locator_SPF50 = locator(lowestPriceSPF50);
        System.out.println("locator for cheapest spf50 is: " + locator_SPF50  );
        theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.buySunscreen(locator_SPF50));
        theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.clickonCart());

        //now the final test case
        boolean nameVerify = productNameVerificationSunscreen(SPF30_NAME,SPF_50NAME);
        boolean priceVerify = productPriceVerification(lowest_Price,lowestPriceSPF50);
        boolean totalVerification = totalSumVerification();
        if(nameVerify && priceVerify && totalVerification)
        {
//              Thread.sleep(570);
            theActorInTheSpotlight().attemptsTo(clickOnPayWithCard());
            fillInFields();
//            Thread.sleep(1000);

            theActorInTheSpotlight().attemptsTo(clickOnPayButton());
//            Thread.sleep(5000);
            if(verifySuccessMesaage())
                System.out.println("Congrats! Purchase was successful");
            else
                System.out.println("Sorry :( Payment failed");



        }
        else
        {
            System.out.println("Sorry! Cart page had some issues, try again");
        }

    }
}
