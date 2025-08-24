
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.ApiClient;
import utils.User;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;


@Feature("Регистрация пользователя")
public class RegistrationTest extends BaseTest {
    private User user;
    private ApiClient apiClient;
    private String accessToken;

    @Before
    public void setUpUser() {
        user = User.getRandom();

    }
    @Test
    @DisplayName("Успешная регистрация")
    public void testSuccessfulRegistration() {
        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
        assertTrue("После успешной регистрации должна отображаться страница входа",
                loginPage.isLoginButtonDisplayed());
        accessToken = ApiClient.loginUser(user)
                .then().statusCode(200)
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");
    }
    @Test
    @DisplayName("Ошибка при регистрации с некорректным паролем")
    public void testRegistrationWithInvalidPassword() {
        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        user=User.getUserInvalidPassword();
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
        assertTrue("Должна отображаться ошибка о некорректном пароле",
                registrationPage.isPasswordErrorDisplayed());
    }
    @After
    public void tearDownUser() {
        if (accessToken != null) {
            ApiClient.deleteUser(accessToken);
            if (driver != null) {
                driver.quit();
            }
        }
    }}