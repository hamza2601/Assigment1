package checkoutCart.Actions;

import java.util.Objects;

import static BuySunscreen.actions.intExtractionFromString.extractNumerals;
import static checkoutCart.Questions.cartQuestions.nameofProductIs;
import static checkoutCart.Questions.cartQuestions.priceOfProductIs;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class checkoutActionsMoisturizers {
    public static  Boolean productNameVerificationMoisturizers(String aloeName, String almondName){
        String nameLocator = "//td[contains(text(),'Aloe')] | //td[contains(text(),'aloe')]";
        String nameAloe = theActorInTheSpotlight().asksFor(nameofProductIs(nameLocator));
        String nameLocator2 = "//td[contains(text(),'Almond')] | //td[contains(text(),'almond')]";
        String nameAlmond = theActorInTheSpotlight().asksFor(nameofProductIs(nameLocator2));
        if(Objects.equals(nameAloe,aloeName) && Objects.equals(nameAlmond,almondName))
            return true;
        else
            return false;

    }
    public static boolean productPriceVerificationMoisturizers(String AloePrice, String AlmondPrice)
    {
        String priceLocator1 = "//td[contains(text(),'Aloe')]/following-sibling::td | //td[contains(text(),'aloe')]/following-sibling::td";
        String priceAloe = theActorInTheSpotlight().asksFor(priceOfProductIs(priceLocator1));
        String priceLocator2 = "//td[contains(text(),'Almond')]/following-sibling::td | //td[contains(text(),'almond')]/following-sibling::td";
        String priceAlmond = theActorInTheSpotlight().asksFor(priceOfProductIs(priceLocator2));
        if(Objects.equals(AloePrice,priceAloe) && Objects.equals(AlmondPrice,priceAlmond))
            return true;
        else
            return false;


    }
    public static boolean totalSumVerifyMoisturizers()
    {
        String Pr1Locator ="//td[contains(text(),'Aloe')]/following-sibling::td | //td[contains(text(),'aloe')]/following-sibling::td";
        String priceAloe = theActorInTheSpotlight().asksFor(priceOfProductIs(Pr1Locator));
        int priceAloeInt = Integer.parseInt(priceAloe);
        String Pr2Locator = "//td[contains(text(),'Almond')]/following-sibling::td | //td[contains(text(),'almond')]/following-sibling::td";
        String priceAlmond = theActorInTheSpotlight().asksFor(priceOfProductIs(Pr2Locator));
        int priceAlmondInt = Integer.parseInt(priceAlmond);
        //for total price
        String totalPrice_locator = "//p[contains(text(),'Total')]";
        String totalPrice = theActorInTheSpotlight().asksFor(priceOfProductIs(totalPrice_locator));
        int totalPriceMInt = extractNumerals(totalPrice);
        int sumMoist = priceAlmondInt + priceAloeInt;
        if (sumMoist == totalPriceMInt)
            return true;
        else
            return false;


    }
}
