package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {



    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By bunSection = By.xpath(".//span[text()='Булки']/..");
    private final By sauceSection = By.xpath(".//span[text()='Соусы']/..");
    private final By fillingSection = By.xpath(".//span[text()='Начинки']/..");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By titleInTheConstructor = By.xpath("//h1[contains(@class, 'text text_type_main-large')]");
    private final By selectedConstructorSelection = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]");


    public MainPage(WebDriver driver) {
        super (driver);
    }
    @Override
    public boolean isPageLoaded() {
        try {
            return waitForElementVisible(constructorButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    @Step("Кликаем на кнопку Войти в аккаунт ")
    public void clickLoginButton() {
        clickToElement(loginButton);
    }

    @Step("Кликаем на кнопку Личный Кабинет ")
    public void clickPersonalAccountButton() {
        clickToElement(personalAccountButton);
    }
    @Step("Кликаем на раздел Булочки ")
    public void clickBunSection() {
        clickToElement(bunSection);
    }

    @Step("Кликаем на Раздел Соусы ")
    public void clickSauceSection() {
        clickToElement(sauceSection);
    }

    @Step("Кликаем на раздел Начинки ")
    public void clickFillingSection() {
        clickToElement(fillingSection);
    }

    @Step("Получаем название заголовка в конструкторе бургеров Соберите бургер")
    public String getTextHeaderConstructor() {
        return getTextFromElement(titleInTheConstructor);
    }

    @Step("Кликаем на логотип Stellar Burgers. ")
    public void clickLogo() {
        clickToElement(logo);
    }
    @Step("Кликаем на кнопку Конструктор ")
    public void clickConstructorButton() {
        clickToElement(constructorButton);
    }
    @Step("Проверяем, что указанный раздел конструктора активен")
    public boolean isSectionSelected(String section) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selectedConstructorSelection, section));
    }
}