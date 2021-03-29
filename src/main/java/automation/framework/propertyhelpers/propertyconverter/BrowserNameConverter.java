package automation.framework.propertyhelpers.propertyconverter;

import automation.framework.propertyhelpers.dao.Browser;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class BrowserNameConverter implements Converter {
    public Browser convert(Method method, String s) {
        return Browser.valueOf(s.toUpperCase());
    }
}
