import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import static org.junit.Assert.assertTrue;


@Feature("Конструктор бургеров")
public class ConstructorTest extends BaseTest {


    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void testNavigateToBunSection() {
        mainPage.clickFillingSection();
        mainPage.clickBunSection();
        assertTrue("Должно отобразиться название раздела Булки",
                mainPage.isBunDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void testNavigateToSauceSection() {
        mainPage.clickFillingSection();
        mainPage.clickSauceSection();
        assertTrue("Должно отобразиться название раздела Соусы",
                mainPage.isSauceDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void testNavigateToFillingSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingSection();
        assertTrue("Должно отобразиться название раздела Начинки",
                mainPage.isFillingDisplayed());
    }


}