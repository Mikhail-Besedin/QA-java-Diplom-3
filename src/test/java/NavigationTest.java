
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.ApiClient;
import utils.User;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@Feature("Навигация")
public class NavigationTest extends BaseTest {
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
    @DisplayName("Переход в личный кабинет")
    public void testToPersonalAccount() {
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        assertTrue("Должна отображаться страница личного кабинета",
                personalAccountPage.isProfileLinkDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор через кнопку 'Конструктор'")
    public void testFromPersonalAccountToConstructorViaButton() {
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        mainPage.clickConstructorButton();
        assertEquals("Соберите бургер",
                mainPage.getTextHeaderConstructor());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор через логотип")
    public void testFromPersonalAccountToConstructorViaLogo() {
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        mainPage.clickLogo();
        assertEquals("Соберите бургер",
                mainPage.getTextHeaderConstructor());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void testLogout() {
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickLogoutButton();

        assertTrue("Должна отображаться страница входа",
                loginPage.isLoginButtonDisplayed());
    }

    @After
    public void tearDownUser() {
        if (accessToken != null) {
            ApiClient.deleteUser(accessToken);
            if (driver != null) {
                driver.quit();
            }


}}}