package com.Assignment1.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import homepage.questions.homepage.questions;
import BuySunscreen.actions.NavigateTo;

import static BuyMoisturizer.actions.moisturizerSelection.undertake_Moisturizer_Selection_And_Purchase;
import static BuySunscreen.actions.SunscreenSelection.undertake_Sunscreen_Selection_And_Purchase;
import static BuySunscreen.actions.intExtractionFromString.extractNumerals;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ProductSelectionAndPurchaseSteps {
    String temp;
    @Given("the actor is on the homepage")
    public void actor_is_on_homepage()
    {
        theActorInTheSpotlight().wasAbleTo(NavigateTo.homepage());

    }
    @When("actor read the displayed temperature")
    public void actor_reads_displayed_temperature(){

        temp= theActorInTheSpotlight().asksFor(questions.temperatureIs());


    }
    @Then("actor will either buy sunscreen or moisturizer")
    public void actor_buys_sunscreen_or_moisturizer() throws InterruptedException {





       int temperature =  extractNumerals(temp);


      if(temperature >34)
      {

         undertake_Sunscreen_Selection_And_Purchase();
         Thread.sleep(5000);



      }
      else if (temperature < 19)
      {

          undertake_Moisturizer_Selection_And_Purchase();
          Thread.sleep(5000);
      }

    }
}
