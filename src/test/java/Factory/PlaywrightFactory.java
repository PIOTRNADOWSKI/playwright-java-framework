package Factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;

    public static Browser getBrowser() {

        if (browser == null) {
            playwright = Playwright.create();

            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            );
        }

        return browser;
    }

    public static void closeBrowser() {
        browser.close();
        playwright.close();
    }
}