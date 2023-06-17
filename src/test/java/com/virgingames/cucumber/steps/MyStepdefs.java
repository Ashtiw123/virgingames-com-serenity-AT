package com.virgingames.cucumber.steps;


import com.virgingames.games.GamesSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;


public class MyStepdefs {

    static ValidatableResponse response;

    float amount;

    @Steps
    GamesSteps gamesSteps;

    @When("^User send GET request to list endpoint$")
    public void iSendGETRequestToListEndpoint() {
        response = gamesSteps.getGamesSteps();
        amount = response.extract().jsonPath().get("data.pots[0].amount");
    }


    @And("^User must get back valid status code (\\d+)$")
    public void iMustGetBackValidStatusCode(int arg0) {
        response.statusCode(200);
    }

/*    @Then("^All the games has currency \"([^\"]*)\"$")
    public boolean allTheGamesHasCurrency(String EUR)  {
        Assert.assertTrue("Currency is EUR", allTheGamesHasCurrency(EUR));
        return allTheGamesHasCurrency(EUR);
    }*/

    @Then("^I verify amount is not negative$")
    public void iVerifyAmountIsNotNegative() {
        Assert.assertTrue("Amount is negative", amount > 0);
    }
}
