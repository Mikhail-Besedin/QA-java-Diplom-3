
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Browser;


public class BaseTest  {
    protected WebDriver driver;
    protected String browserName;

    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected PasswordRecoveryPage passwordRecoveryPage;
    protected PersonalAccountPage personalAccountPage;

    @Before
    public void setUp() {
        browserName = System.getProperty("browser");

        if (browserName == null || browserName.isEmpty()) {
            browserName = "chrome";
        }

        System.out.println("Starting test in browser: " + browserName);

        driver = Browser.getBrowser(browserName);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
        System.out.println("Test finished in browser: " + browserName);
    }
}