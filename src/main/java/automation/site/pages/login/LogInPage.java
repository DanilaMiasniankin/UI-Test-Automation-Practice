package automation.site.pages.login;

public interface LogInPage {
    boolean isLoginPageOpened();

    void signIn(String login, String password);

    void openPage();
}
