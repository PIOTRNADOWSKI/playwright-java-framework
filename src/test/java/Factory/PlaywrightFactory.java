package Factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;

    public static Browser getBrowser() {

        if (browser == null) {
            playwright = Playwright.create();

            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(true)
            );
        }

        return browser;
    }

    public static void closeBrowser() {
        browser.close();
        playwright.close();
    }
}