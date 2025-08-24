package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public abstract boolean isPageLoaded();

    public void waitForLoad() {
        wait.until(d -> isPageLoaded());
    }
    @Step("ожидание видимости элемента")
    protected WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    @Step("ожидание кликабельности элемента")
    protected void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    @Step("Получаем булевое значение видимости элемента ")
    protected boolean checkBoolUntilNotInvisabilityElement(By locator) {
        waitForElementVisible(locator);
        return driver.findElement(locator).isDisplayed();
    }

    @Step("Кликаем на элемент применяя ожидание, чтобы элемент стал кликабельным")
    protected void clickToElement(By locator) {
        waitForElementClickable(locator);
        driver.findElement(locator).click();
    }
    @Step("Получаем текст в  элементе применяя ожидание, чтобы элемент стал видимым ")
    public String getTextFromElement(By locator) {
        waitForElementVisible(locator);
        return driver.findElement(locator).getText();
    }

    @Step("Добавляем текст в  элемент применяя ожидание, чтобы элемент стал видимым")
    public void addTextToElement( By locator, String text) {
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

}