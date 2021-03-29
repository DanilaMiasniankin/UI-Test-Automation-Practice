package automation.framework.propertyhelpers.propertyholder;

import automation.framework.propertyhelpers.dao.Browser;
import automation.framework.propertyhelpers.propertyconverter.BrowserNameConverter;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:testconfig.property")
public interface TestConfigHolder extends Config {
    @Config.Key("browser")
    @ConverterClass(BrowserNameConverter.class)
    Browser getBrowser();

    @Key("application.url")
    String getBaseUrl();
}
