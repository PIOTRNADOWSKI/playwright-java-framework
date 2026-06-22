package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GooglePage;
import static com.google.common.truth.Truth.assertWithMessage;

public class SearchGoogleTest extends BaseTest {

    @Test
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