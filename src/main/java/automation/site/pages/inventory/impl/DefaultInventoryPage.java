package automation.site.pages.inventory.impl;

import automation.framework.propertyhelpers.PropertyResolver;
import automation.site.pages.AbstractPage;
import automation.site.pages.inventory.InventoryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class DefaultInventoryPage extends AbstractPage implements InventoryPage {
    @FindBy(css = "inventory_list")
    private WebElement inventoryList;

    @Override
    public WebElement getLoadableComponent() {
        return inventoryList;
    }

    @Override
    public String getUrl() {
        return PropertyResolver.testConfig.getBaseUrl() + "inventory.html";
    }

    @Override
    public boolean isInventoryPageOpened() {
        return driverProvider.getInstance().getCurrentUrl().contains(getUrl());
    }
}
