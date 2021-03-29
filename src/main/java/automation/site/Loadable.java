package automation.site;

import org.openqa.selenium.WebElement;

public interface Loadable {
    WebElement getLoadableComponent();

    boolean isLoaded();

    void waitForLoad();

    void waitForDisappear();
}
