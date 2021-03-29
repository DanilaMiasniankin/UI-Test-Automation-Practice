package automation.framework.driver;

import automation.framework.driver.impl.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DriverProvider {
    private ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    @Bean(destroyMethod = "quit")
    public WebDriver getInstance() {
        if (driverInstance.get() == null) {
            driverInstance.set(DriverFactory.getDriver());
            driverInstance.get().manage().window().maximize();
        }
        return driverInstance.get();
    }
}
