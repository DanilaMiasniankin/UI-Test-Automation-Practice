package automation.site.components.search.impl;

import automation.site.components.AbstractComponent;
import automation.site.components.search.HeaderBar;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class DefaultHeaderBar extends AbstractComponent implements HeaderBar {

    @FindBy(css = ".header-search-input")
    private WebElement searchBox;

    @FindBy(css = ".d-lg-flex > .mr-3")
    private WebElement signInButton;

    @FindBy(css = ".js-details-container")
    private WebElement rootHeader;

    @Override
    public WebElement getLoadableComponent() {
        return rootHeader;
    }

    @Override
    public void searchFor(String query) {
        this.waitForLoad();
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    @Override
    public void clickSignInButton() {
        this.waitForLoad();
        signInButton.click();
    }

    @Override
    public boolean isUserLoggedIn() {
        try {
            return signInButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
