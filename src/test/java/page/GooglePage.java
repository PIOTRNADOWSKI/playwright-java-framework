package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

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

    public void acceptCookies() {
        Locator acceptPl = page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Zaakceptuj wszystko"));

        Locator acceptEn = page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Accept all"));

        if (acceptPl.count() > 0) {
            acceptPl.click();
        } else if (acceptEn.count() > 0) {
            acceptEn.click();
        }
    }


    public String getTitle() {

        return page.title();
    }

    public String getUrl() {
        return page.url();
    }
}
