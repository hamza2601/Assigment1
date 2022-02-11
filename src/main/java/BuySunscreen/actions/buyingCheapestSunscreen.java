package BuySunscreen.actions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static BuySunscreen.UserInterface.Targets.SUNSCREEN_SPF30;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class buyingCheapestSunscreen {
    public static ArrayList<String> unrefinedPriceList(Target T)
    {
        ArrayList<String> prices = new ArrayList<>();
        List<WebElementFacade> sunscreens = T.resolveAllFor(theActorInTheSpotlight());
        sunscreens.forEach(element -> {
            prices.add(element.getTextValue());
        });
        prices.forEach(ele->{
            System.out.println(ele);
        });
        return prices;

    }
    public static String [] refinedPrices(ArrayList<String> prices){
        int l = prices.size();
        String [] P = new String[l];
        System.out.println("*******Printing text with Rs and Price removed*******");
        for (int i=0; i<l; i++)
        {
            int a = i;
            Pattern intsOnly = Pattern.compile("\\d+");
            String sample = prices.get(a);
            Matcher makeMatch = intsOnly.matcher(sample);
            makeMatch.find();
            String inputInt = makeMatch.group();
            P[a] = inputInt;

            System.out.println(P[a]);
        }
        return P;

    }

    public static String lowestPrice(String []Prices) {
        ArrayList<Integer> intPrices = new ArrayList<>();
        int l = Prices.length;
        for (int i = 0; i < l; i++)
        {
            int add = Integer.parseInt(Prices[i]);
            intPrices.add(add);
        }
        System.out.println("Now we're displaying the prices in integer form");
        intPrices.forEach(ele->{
            System.out.println(ele);
        });
        int smallPrice = Collections.min(intPrices);
        String leastPrice = String.valueOf(smallPrice);
        System.out.println("Lowest price in SPF-30 is: Rs." + leastPrice);
        return leastPrice;
    }
    public static  String locator (String price)
    {
        String locator = " //p[contains(text(),'" + price + "')]/following-sibling::button";
//        System.out.println(locator);
        return locator;
    }
}
