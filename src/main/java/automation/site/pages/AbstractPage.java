package automation.site.pages;

import automation.site.AbstractLoadable;

public abstract class AbstractPage extends AbstractLoadable implements Page {
    @Override
    public void openPage() {
        driverProvider.getInstance().get(getUrl());
    }
}
