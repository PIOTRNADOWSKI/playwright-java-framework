package Tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GooglePage;
import static com.google.common.truth.Truth.assertWithMessage;

public class SearchGoogleTest extends BaseTest {

    @Test
    public void testGoogle() {

        page.navigate("https://www.google.com");

        GooglePage googlePage = new GooglePage(page);
        page.getByRole(
                        AriaRole.BUTTON,
                        new Page.GetByRoleOptions()
                                .setName("Zaakceptuj wszystko"))
                .click();
        page.waitForLoadState();

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