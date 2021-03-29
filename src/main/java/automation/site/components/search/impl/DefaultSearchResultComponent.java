package automation.site.components.search.impl;

import automation.site.components.AbstractComponent;
import automation.site.components.search.SearchResultComponent;
import automation.site.spring.SkipInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@SkipInit
public class DefaultSearchResultComponent extends AbstractComponent implements SearchResultComponent {
    private static final By PRODUCT_NAME = By.className("product-name");

    private WebElement rootSearchResult;

    public DefaultSearchResultComponent(WebElement rootElement) {
        this.rootSearchResult = rootElement;
    }

    @Override
    public WebElement getLoadableComponent() {
        return rootSearchResult;
    }

}
