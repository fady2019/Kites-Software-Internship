package defs;
import io.cucumber.java.en.*;

public class newTooldefs {
    @Given("user logged in as an inventory manager")
    public void userLoggedInAsAnInventoryManager() {

    }

    @And("User add the attributes of the tool as:")
    public void userAddTheAttributesOfTheToolAs() {
    }

    @Given("inventory manager logged in")
    public void inventoryManagerLoggedIn() {
        
    }

    @When("inventory manager requests to add a tool {string} with label {string}, expiration date {string}, category {string}, price {string}, supplier {string}, quantity {string}, reusable {string}, minimum quantity {string}")
    public void inventoryManagerRequestsToAddAToolWithLabelExpirationDateCategoryPriceSupplierQuantityReusableMinimumQuantity(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) {
    }

    @Then("the system makes the reservation as")
    public void theSystemMakesTheReservationAs() {
    }


    @Then("The system will respond with an error {string}")
    public void theSystemWillRespondWithAnError(String arg0) {
    }
}
