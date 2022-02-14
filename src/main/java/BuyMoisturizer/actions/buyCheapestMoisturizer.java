package BuyMoisturizer.actions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static checkoutCart.Questions.cartQuestions.nameofProductIs;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class buyCheapestMoisturizer {

    public static ArrayList<String> unrefinedListM (Target T)
    {
        ArrayList<String> pricesM = new ArrayList<>();
        List<WebElementFacade> moisturizers = T.resolveAllFor(theActorInTheSpotlight());
        moisturizers.forEach(element -> {
            pricesM.add(element.getTextValue());
        });
        pricesM.forEach(ele ->{
            System.out.println(ele);
        });
        return pricesM;

    }
    public static String [] refinedPricesM(ArrayList<String> prices)
    {
        int l = prices.size();
        String [] PM = new String[l];
        System.out.println("Printing text with RS and price removed");
        for(int i =0; i<l ; i++)
        {
            int a = i;
            Pattern intsOnly = Pattern.compile("\\d+");
            String sample = prices.get(a);
            Matcher makeMatch = intsOnly.matcher(sample);
            makeMatch.find();
            String inputInt = makeMatch.group();
            PM[a] = inputInt;
            System.out.println(PM[a]);
        }
        return PM;
    }
    public static String lowestPriceM(String[] PricesM)
    {
        ArrayList<Integer> intPricesM = new ArrayList<>();
        int l = PricesM.length;
        for(int i =0; i<l; i++)
        {
            int add = Integer.parseInt(PricesM[i]);
            intPricesM.add(add);
        }
        System.out.println("Now we're displaying prices in integer form.");
        intPricesM.forEach(ele -> {
            System.out.println(ele);
        });
        int smallPriceM = Collections.min(intPricesM);
        String leastPriceM = String.valueOf(smallPriceM);
        System.out.println("Lowest price in moisturizers is" + leastPriceM);
        return leastPriceM;

    }
    public static String locatorM (String leastPrice)
    {
        String locator = "//p[contains(text(),'" + leastPrice + "')]/following-sibling::button";
        return locator;
    }

    public static String cheapestMoisturizerName(String leastPrice)
    {
        String locator = "//p[contains(text(),'" + leastPrice + "')]/preceding-sibling::p";
        String name = theActorInTheSpotlight().asksFor(nameofProductIs(locator));
        System.out.println("Name is : "+name);
        return name;


    }



}
