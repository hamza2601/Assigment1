package com.Assignment1.steps;

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
          prices =  unrefinedPriceList(); //we get the prices, but not in numerics only



          int l= prices.size();  //getting size of the prices array
          String[] Prices;
          Prices = refinedPrices(prices);
          String lowest_Price = lowestPrice(Prices);



          String buttonLocator = locator(lowest_Price);
          System.out.println(buttonLocator);
          theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.buySunscreen(buttonLocator));
          System.out.println("Element clicked on");
          theActorInTheSpotlight().attemptsTo(buyCheapestSunscreen.clickonCart());

      }
      else if (temperature < 19)
      {
          theActorInTheSpotlight().attemptsTo(tasks.ClickOnBuyMoisturizer());
          System.out.println("******************Always keep your skin moisturized in winters!!***************");
      }

    }
}
