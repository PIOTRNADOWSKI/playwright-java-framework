package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class GooglePage extends BasePage {

    private final Locator searchBox;

    public GooglePage(Page page) {
        super(page);
        this.searchBox = page.locator("textarea[name='q']");
    }


    public void search(String text) {
        searchBox.fill(text);
        searchBox.press("Enter");
        page.waitForLoadState();
    }

    public String getTitle() {

        return page.title();
    }

    public String getUrl() {
        return page.url();
    }
}
