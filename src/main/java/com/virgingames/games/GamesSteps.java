package com.virgingames.games;

import com.virgingames.constants.EndPoints;
import com.virgingames.constants.Path;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GamesSteps {
    @Step("Getting jackpot bingo information")
    public ValidatableResponse getGamesSteps(){
        return SerenityRest.given().log().all()
                .basePath(Path.getApi)
                .when()
                .get(EndPoints.jackpotBingo)
                .then();
    }


}
