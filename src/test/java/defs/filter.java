package defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class filter {
    @And("the page for display tools is opened")
    public void thePageForDisplayToolsIsOpened() {
        
    }

    @When("the user requests to filter displayed tools by category {string}")
    public void theUserRequestsToFilterDisplayedToolsByCategory(String arg0) {
        
    }

    @Then("the system shows a list of tools that belong to this category as follows:")
    public void theSystemShowsAListOfToolsThatBelongToThisCategoryAsFollows() {
        
    }

    @Then("The system will respond with a message : {string}")
    public void theSystemWillRespondWithAMessage(String arg0) {

    }

    @When("the user requests to search for a tool from displayed tools by name {string}")
    public void theUserRequestsToSearchForAToolFromDisplayedToolsByName(String arg0) {
        
    }

    @Then("the system shows the tool named {string}")
    public void theSystemShowsTheToolNamed(String arg0) {
        
    }

    @When("the user requests to filter displayed tools by price within range [{double}]")
    public void theUserRequestsToFilterDisplayedToolsByPriceWithinRange(int arg0, int arg1) {
        
    }

    @Then("the system shows a list of tools that belong to this price range as follows:")
    public void theSystemShowsAListOfToolsThatBelongToThisPriceRangeAsFollows() {
    }

    @When("the user requests to search for a tool from displayed tools by name {string}")
    public void theUserRequestsToSearchForAToolFromDisplayedToolsByCategory(String arg0) {

    }
}
