package com.Assignment1.steps;

import BuySunscreen.actions.NavigateTo;
import BuySunscreen.questions.Questions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuySunscreenSteps {
    @Given("Admin is on the buy sunscreen homepages")
    public void go_To_Buy_Sunscreen_Homepage()
    {
        theActorInTheSpotlight().wasAbleTo(NavigateTo.BuySunscreen());
        theActorInTheSpotlight().wasAbleTo();
    }
    @When("Admin views prices of all the sunscreens")
    public void actor_Views_Prices_Of_Sunscreens()
    {
        Question<List<String>> Sunscreens;
        Sunscreens = (Question<List<String>>) theActorInTheSpotlight().asksFor(Questions.sunScreensDisplayedAre());
        System.out.println("assssssssssadfsfffffffffffffffffffffffffffffffff............................");
        System.out.println(Sunscreens);
//        for (String info:Sunscreens
//             ) {
//            System.out.println(info);
//
//        }
    }
    @Then("Admin will buy the cheapest SPF-30 and SPF-50")
    public void actor_Buys_Cheapest_Sunscreens()
    {

    }
}
