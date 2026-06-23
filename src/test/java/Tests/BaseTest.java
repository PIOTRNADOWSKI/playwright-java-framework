package Tests;

import Factory.PlaywrightFactory;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class BaseTest {

    protected Page page;
    protected Browser browser;
    protected BrowserContext context;

    @BeforeMethod
    public void setup() {

        browser = PlaywrightFactory.getBrowser();

        context = browser.newContext();

        page = context.newPage();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (!result.isSuccess()) {
            page.screenshot(
                    new Page.ScreenshotOptions()
                            .setPath(Paths.get("screenshots",
                                    result.getName() + ".png"))
            );
        }

        context.close();
    }
}