package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends BasePage {


    private final By profileLink = By.xpath(".//a[text()='Профиль']");
    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        try {
            return waitForElementVisible(logoutButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    @Step("Проверяем наличие отображения кнопки Профиль применяя ожидание, чтобы элемент стал видимым ")
    public boolean isProfileLinkDisplayed() {
        return checkBoolUntilNotInvisabilityElement(profileLink);
    }
    @Step("Кликаем на кнопку Выход ")
    public void clickLogoutButton() {
        clickToElement(logoutButton);
    }
}