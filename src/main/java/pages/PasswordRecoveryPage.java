package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage extends BasePage  {
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        super (driver);}

    @Override
    public boolean isPageLoaded() {
        try {
            return waitForElementVisible(loginLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }}
        @Step("Кликаем на кнопку Войти ")
        public void clickLoginLink() {
            clickToElement(loginLink);
        }
    }