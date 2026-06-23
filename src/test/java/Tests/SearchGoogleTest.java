package Tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GooglePage;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import static com.google.common.truth.Truth.assertWithMessage;

@Epic("Google")
@Feature("Search")
@Listeners({AllureTestNg.class})
public class SearchGoogleTest extends BaseTest {

    @Test
    @Description("Verify Google search")
    @Severity(SeverityLevel.CRITICAL)
    public void testGoogle() {

        page.navigate("https://www.google.com/?hl=pl");

        GooglePage googlePage = new GooglePage(page);

        googlePage.acceptCookies();
        googlePage.search("Playwright Java");

        assertWithMessage("Nieprawidłowy tytuł strony")
                .that(googlePage.getTitle())
                .contains("Playwright");

        Assert.assertTrue(
                googlePage.getUrl().contains("search"),
                "Nie jesteśmy na stronie wyników wyszukiwania"
        );
    }
}