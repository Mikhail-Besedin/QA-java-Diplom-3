import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


@Feature("Конструктор бургеров")
public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void testNavigateToBunSection() {
        mainPage.clickFillingSection();
        mainPage.clickBunSection();
        assertTrue(mainPage.isSectionSelected("Булки"));
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void testNavigateToSauceSection() {
        mainPage.clickFillingSection();
        mainPage.clickSauceSection();
        assertTrue(mainPage.isSectionSelected("Соусы"));

    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void testNavigateToFillingSection() {
        mainPage.clickSauceSection();
        mainPage.clickFillingSection();
        assertTrue(mainPage.isSectionSelected("Начинки"));
    }



}