package automation.site.components.search;

public interface HeaderBar {
    void searchFor(String query);

    void clickSignInButton();

    boolean isUserLoggedIn();
}
