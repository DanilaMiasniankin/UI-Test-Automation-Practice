package automation.framework.propertyhelpers;

import automation.framework.propertyhelpers.propertyholder.TestConfigHolder;
import org.aeonbits.owner.ConfigFactory;

public class PropertyResolver {
    public static TestConfigHolder testConfig = ConfigFactory.create(TestConfigHolder.class);
}
