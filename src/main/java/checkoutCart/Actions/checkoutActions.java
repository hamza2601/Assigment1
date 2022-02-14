package checkoutCart.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;

import java.util.Objects;

import static BuySunscreen.actions.intExtractionFromString.extractNumerals;
import static checkoutCart.Questions.cartQuestions.*;
import static checkoutCart.userInterface.targets.PURCHASE_BUTTON;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class checkoutActions {
    //first we're gonna verify the page contents
    public static boolean productNameVerificationSunscreen(String SPF30Name, String SPF50Name)
    {
        String nameLocator = "//td[contains(text(),'SPF-30')] | //td[contains(text(),'spf-30')]";
       String nameSpf30 = theActorInTheSpotlight().asksFor(nameofProductIs(nameLocator));

       String nameLocator2 = "//td[contains(text(),'SPF-50')] | //td[contains(text(),'spf-50')]";

       String nameSPF50 = theActorInTheSpotlight().asksFor(nameofProductIs(nameLocator2));
       if(Objects.equals(nameSpf30, SPF30Name) && Objects.equals(nameSPF50, SPF50Name)) {
           System.out.println("Prices are displayed correctly");
           return true;
       }
       else
           return  false;
    }
    public static boolean productPriceVerification(String SPF30Price, String SPF50Price)
    {
        String pricelocator1 = "//td[contains(text(),'SPF-30')]/following-sibling::td | //td[contains(text(),'spf-30')]/following-sibling::td";
        String price_spf30 = theActorInTheSpotlight().asksFor(priceOfProductIs(pricelocator1));
        String priceLocator2 = "//td[contains(text(),'SPF-50')]/following-sibling::td | //td[contains(text(),'spf-50')]/following-sibling::td";
        String price_spf50 = theActorInTheSpotlight().asksFor(priceOfProductIs(priceLocator2));
        if(Objects.equals(SPF30Price,price_spf30) && Objects.equals(SPF50Price,price_spf50))
        {
            System.out.println("Prices are displayed correctly");
            return true;
        }
        else
            return false;
    }
    public static boolean totalSumVerification()
    {
        String P1_locator = "//td[contains(text(),'SPF-30')]/following-sibling::td | //td[contains(text(),'spf-30')]/following-sibling::td";
        String Price_1 = theActorInTheSpotlight().asksFor(priceOfProductIs(P1_locator));
        int P1_int = Integer.parseInt(Price_1);
        String P2_locator = "//td[contains(text(),'SPF-50')]/following-sibling::td | //td[contains(text(),'spf-50')]/following-sibling::td";
        String Price_2 = theActorInTheSpotlight().asksFor(priceOfProductIs(P2_locator));
        int P2_int = Integer.parseInt(Price_2);
        //now we get the locator of the total
        String totalP_locator = "//p[contains(text(),'Total')]";
        String totalPrice = theActorInTheSpotlight().asksFor(priceOfProductIs(totalP_locator));
        int TotalInt = extractNumerals(totalPrice);
        int sum = P1_int + P2_int;
        if (sum == TotalInt)
            return true;
        else
            return false;


    }
    public static Task clickOnPayButton()
    {
        return Task.where("Actor cliks on the payment button", Click.on(PURCHASE_BUTTON));
    }

    public static void fill_In_Fields(String email, String cardNumber, String month,String year, String CVC)
    {
        int l = cardNumber.length();
        int parts = 4;
        int temp =0;
        int chars = l/parts;
        String [] equalStrParts = new String[parts];
        for(int i =0; i<l; i=i+chars)
        {
            String part = cardNumber.substring(i,i+chars);
            equalStrParts[temp] = part;
            temp++;
        }



        getDriver().switchTo().frame("stripe_checkout_app");

        theActorInTheSpotlight().attemptsTo(

                Enter.keyValues(email).into("//input[@id='email']"),
                Enter.keyValues(equalStrParts[0]).into("//input[@id='card_number']"),
                Enter.keyValues(equalStrParts[1]).into("//input[@id='card_number']"),
                Enter.keyValues(equalStrParts[2]).into("//input[@id='card_number']"),
                Enter.keyValues(equalStrParts[3]).into("//input[@id='card_number']"),
                Enter.keyValues(month).into("//input[@id='cc-exp']"),
                Enter.keyValues(year).into("//input[@id='cc-exp']"),
                Enter.keyValues(CVC).into("//input[@id='cc-csc']")



        );
    }

    public static boolean verifySuccessMesaage()
    {
        String message = theActorInTheSpotlight().asksFor(displayedMessageIs());
        if (Objects.equals(message, "PAYMENT SUCCESS"))
            return true;
        else
            return false;
    }

}
