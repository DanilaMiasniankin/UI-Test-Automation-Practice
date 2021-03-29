package automation.site;

import automation.framework.driver.DriverProvider;
import io.vavr.control.Try;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

public abstract class AbstractLoadable implements Loadable {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration SHORT_TIMEOUT = Duration.ofSeconds(2);
    @Autowired
    protected DriverProvider driverProvider;

    public boolean isLoaded() {
        return Try.of(() ->
                getDriverWait(SHORT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(getLoadableComponent())).isDisplayed()).
                isSuccess();
    }

    public void waitForLoad() {
        getDriverWait(DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(getLoadableComponent()));
    }

    public void waitForDisappear() {
        getDriverWait(DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOf(getLoadableComponent()));
    }

    private FluentWait<WebDriver> getDriverWait(Duration timeout) {
        return new WebDriverWait(driverProvider.getInstance(), timeout).pollingEvery(Duration.ofMillis(500));
    }
}
