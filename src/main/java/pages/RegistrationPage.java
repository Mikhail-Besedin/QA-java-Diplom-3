package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {


    private static final By nameInput = By.xpath(".//input[@name='name']");
    private static final By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private static final By passwordInput = By.xpath(".//input[@name='Пароль']");
    private static final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By loginLink = By.xpath(".//a[text()='Войти']");
    private static final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");



    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @Step("Кликаем на кнопку Личный Кабинет ")
    @Override
    public boolean isPageLoaded() {
        return waitForElementVisible(registerButton).isDisplayed();
    }

    @Step("Кликаем на кнопку Зарегистрироваться ")
    public void clickRegisterButton() {
        clickToElement(registerButton);
    }
    @Step("Кликаем на кнопку Войти ")
    public void clickLoginLink() {
        clickToElement(loginLink);
    }
    @Step("проверяем наличие ошибки Некорректный пароль ")
    public boolean isPasswordErrorDisplayed() {
        return checkBoolUntilNotInvisibilityElement(passwordError);
    }
    @Step("Заполняем данные для регистрации пользователя и кликаем зарегистрироваться ")
    public void register(String name, String email, String password) {
        addTextToElement(nameInput,name);
        addTextToElement(emailInput,email);
        addTextToElement(passwordInput,password);
        clickRegisterButton();
    }
}