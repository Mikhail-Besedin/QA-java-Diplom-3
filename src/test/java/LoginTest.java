import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.ApiClient;
import utils.User;
import static org.junit.Assert.assertTrue;

@Feature("Логин пользователя ")
public class LoginTest extends BaseTest {
    private User user;
    private ApiClient apiClient;
    private String accessToken;

    @Before
    public void setUpUser() {

        user = User.getRandom();
        accessToken = ApiClient.createUser(user)
                .then()
                .extract()
                .path("accessToken");}

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт' на главной")
    public void testLoginViaMainPageLoginButton() {

        mainPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        assertTrue("После входа должен отображаться профиль в личном кабинете",
                personalAccountPage.isProfileLinkDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void testLoginViaPersonalAccountButton() {
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        assertTrue("После входа должен отображаться профиль в личном кабинете",
                personalAccountPage.isProfileLinkDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void testLoginViaRegistrationForm() {
        mainPage.clickLoginButton();

        loginPage.clickRegisterLink();

        registrationPage.clickLoginLink();

        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        assertTrue("После входа должен отображаться профиль в личном кабинете",
                personalAccountPage.isProfileLinkDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void testLoginViaPasswordRecoveryForm() {
        mainPage.clickLoginButton();

        loginPage.clickRecoverPasswordLink();

        passwordRecoveryPage.clickLoginLink();

        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        assertTrue("После входа должен отображаться профиль в личном кабинете",
                personalAccountPage.isProfileLinkDisplayed());
    }

    @After
    public void tearDownUser() {
        if (accessToken != null) {
            ApiClient.deleteUser(accessToken);
            if (driver != null) {
            driver.quit();
        }
}}}