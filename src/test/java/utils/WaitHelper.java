package utils;

import com.microsoft.playwright.Page;

public class WaitHelper {

    public static void waitForLoad(Page page) {
        page.waitForLoadState();
    }
}