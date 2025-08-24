package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private final By emailInput = By.xpath(".//input[@name='name']");
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By recoverPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");


    public LoginPage(WebDriver driver) {
        super (driver);
    }
    @Override
    public boolean isPageLoaded() {
        try {
            return waitForElementVisible(loginButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Кликаем  по кнопке Войти ")
    public void clickLoginButton() {
        clickToElement(loginButton);
    }
    @Step("Кликаем по кнопке Зарегистрироваться ")
    public void clickRegisterLink() {
        clickToElement(registerLink);
    }
    @Step("Кликаем по кнопке Восстановить пароль ")
    public void clickRecoverPasswordLink() {
        clickToElement(recoverPasswordLink);
    }

    @Step("Проверяем наличие отображения кнопки Войти ")
    public boolean isLoginButtonDisplayed(){
        return checkBoolUntilNotInvisabilityElement(loginButton);
    }
    @Step("Вводим логин и пароль для авторизации ")
    public void login(String email, String password) {
        addTextToElement(emailInput,email);
        addTextToElement(passwordInput,password);
        clickLoginButton();
    }
}