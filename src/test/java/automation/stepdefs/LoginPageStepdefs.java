package automation.stepdefs;

import automation.framework.driver.DriverProvider;
import automation.site.pages.login.LogInPage;
import automation.site.spring.ApplicationConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = ApplicationConfig.class)
public class LoginPageStepdefs {

    DriverProvider driverProvider;
    @Autowired
    private LogInPage logInPage;

    @Given("^I open Login page$")
    public void customerOpensHomePage() {
        logInPage.openPage();
    }

    @Then("^Login page is opened$")
    public void homePageIsOpened() {
        Assertions.assertTrue(logInPage.isLoginPageOpened());
    }


    @When("I sign in with {string} and {string} credentials")
    public void iEnterAndCredentials(String login, String password) {
        logInPage.signIn(login, password);
    }

}
