package automation.stepdefs;

import automation.framework.driver.DriverProvider;
import automation.site.pages.inventory.InventoryPage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryPageStepdefs {
    DriverProvider driverProvider;
    @Autowired
    private InventoryPage inventoryPage;

    @Then("^I am authorized$")
    public void homePageIsOpened() {
        Assertions.assertTrue(inventoryPage.isInventoryPageOpened());
    }

}
