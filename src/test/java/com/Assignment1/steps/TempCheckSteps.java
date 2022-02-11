package com.Assignment1.steps;

import BuyMoisturizer.Tasks.buyMoisturizer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import homepage.questions.homepage.questions;
import BuySunscreen.actions.NavigateTo;
import homepage.tasks.homepage.tasks;
import BuySunscreen.Tasks.buyCheapestSunscreen;

import net.serenitybdd.screenplay.conditions.Check;

import java.util.ArrayList;
import java.util.Objects;

import static BuyMoisturizer.UserInterface.Targets_Moisturizers.ALMOND_MOISTURIZERS;
import static BuyMoisturizer.UserInterface.Targets_Moisturizers.ALOE_MOISTURIZERS;
import static BuyMoisturizer.actions.buyCheapestMoisturizer.*;
import static BuySunscreen.UserInterface.Targets.SUNSCREEN_SPF30;
import static BuySunscreen.UserInterface.Targets.SUNSCREEN_SPF50;
import static BuySunscreen.actions.buyingCheapestSunscreen.*;
import static BuySunscreen.actions.intExtractionFromString.extractNumerals;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TempCheckSteps {
    String temp;
    @Given("the actor is on the homepage")
    public void actor_is_on_homepage()
    {
        theActorInTheSpotlight().wasAbleTo(NavigateTo.homepage());

    }
    @When("actor read the displayed temperature")
    public void actor_reads_displayed_temperature(){
//        String temp;
        temp= theActorInTheSpotlight().asksFor(questions.temperatureIs());

        System.out.println(temp);

    }
    @Then("actor will either buy sunscreen or moisturizer")
    public void actor_buys_sunscreen_or_moisturizer() throws InterruptedException {

//        System.out.println(temp);
//        theActorInTheSpotlight().attemptsTo(tasks.ClickOnBuySunScreen());
//        ArrayList<String> prices;
//        prices =  unrefinedPriceList(); //we get the prices, but not in numerics only
//
//
//
//        int l= prices.size();  //getting size of the prices array
//        String[] Prices;
//        Prices = refinedPrices(prices);
//        String lowest_Price = lowestPrice(Prices);
//
//
//
//        String buttonLocator = locator(lowest_Price);
//        System.out.println(buttonLocator);
//        theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.buySunscreen(buttonLocator));
//        System.out.println("Element clicked on");
//        theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.clickonCart());


////
       int temperature =  extractNumerals(temp);
//       if( temperature < 19)
//       {
//           theActorInTheSpotlight().attemptsTo(tasks.ClickOnBuyMoisturizer());
//
//
//       }
//       if(temperature > 34)
//       {
//           theActorInTheSpotlight().attemptsTo(tasks.ClickOnBuySunScreen());
//
//
//       }
//      Check.whether(temperature<19).andIfSo(tasks.ClickOnBuyMoisturizer());
//      Check.whether(temperature>34).andIfSo(tasks.ClickOnBuySunScreen());
//      String current_Page = theActorInTheSpotlight().asksFor(questions.NameOfCurrentPage());
//        System.out.println(current_Page);
      if(temperature >34)
      {
        theActorInTheSpotlight().attemptsTo(tasks.ClickOnBuySunScreen());

          System.out.println("We're shopping for sunscreens!");
          ArrayList<String> prices = new ArrayList<>();
          prices =  unrefinedPriceList(SUNSCREEN_SPF30); //we get the prices, but not in numerics only



          int l= prices.size();  //getting size of the prices array
          String[] Prices;
          Prices = refinedPrices(prices);
          String lowest_Price = lowestPrice(Prices);



          String buttonLocator = locator(lowest_Price);
          System.out.println(buttonLocator);
          theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.buySunscreen(buttonLocator));
          System.out.println("Element clicked on");
//          theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.clickonCart());

          //now we try to do the same prcedure for SPF-50
          ArrayList<String> pricesSPF50 = new ArrayList<>();
          pricesSPF50 = unrefinedPriceList(SUNSCREEN_SPF50);
          String [] PricesSPF50;
          PricesSPF50 = refinedPrices(pricesSPF50);
          String lowestPriceSPF50 = lowestPrice(PricesSPF50);
          String locator_SPF50 = locator(lowestPriceSPF50);
          System.out.println("locator for cheapest spf50 is: " + locator_SPF50  );
          theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.buySunscreen(locator_SPF50));
          theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.clickonCart());


      }
      else if (temperature < 19)
      {
          theActorInTheSpotlight().attemptsTo(tasks.ClickOnBuyMoisturizer());
          ArrayList<String> pricesMoisturizers = unrefinedListM(ALOE_MOISTURIZERS);
          int lM = pricesMoisturizers.size();
          String[] PricesM;
          PricesM = refinedPricesM(pricesMoisturizers);
          String cheapPriceM =lowestPriceM(PricesM);
          String buttonLocatorM = locatorM(cheapPriceM);
          theActorInTheSpotlight().attemptsTo(buyMoisturizer.purchaseMoisturizer(buttonLocatorM));



          System.out.println("******************Always keep your skin moisturized in winters!!***************");

          ArrayList<String> pricesAlmond = new ArrayList<>();
          pricesAlmond = unrefinedListM(ALMOND_MOISTURIZERS);
          String[] PricesAlmond;
          PricesAlmond = refinedPricesM(pricesAlmond);
          String lowPriceAlmond = lowestPriceM(PricesAlmond);
          String locatorAlmond = locatorM(lowPriceAlmond);
          theActorInTheSpotlight().attemptsTo(buyMoisturizer.purchaseMoisturizer(locatorAlmond));
          theActorInTheSpotlight().attemptsTo(buyMoisturizer.clickonCartM());
      }

    }
}
