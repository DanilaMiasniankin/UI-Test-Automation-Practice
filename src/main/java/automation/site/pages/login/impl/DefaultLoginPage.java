package automation.site.pages.login.impl;

import automation.framework.propertyhelpers.PropertyResolver;
import automation.site.pages.AbstractPage;
import automation.site.pages.login.LogInPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class DefaultLoginPage extends AbstractPage implements LogInPage {

    @FindBy(css = "#user-name")
    private WebElement loginField;
    @FindBy(css = "#password")
    private WebElement passwordField;
    @FindBy(css = "#login-button")
    private WebElement submitLogin;

    @Override
    public WebElement getLoadableComponent() {
        return submitLogin;
    }

    @Override
    public String getUrl() {
        return PropertyResolver.testConfig.getBaseUrl();
    }

    @Override
    public boolean isLoginPageOpened() {
        return driverProvider.getInstance().getCurrentUrl().contains(getUrl());
    }

    @Override
    public void signIn(String login, String password) {
        this.waitForLoad();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitLogin.click();
    }
}
