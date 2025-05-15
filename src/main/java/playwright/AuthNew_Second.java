package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AuthNew_Second {

	public static void main(String[] args) {
	    Playwright playwright = Playwright.create();
	    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    BrowserContext brContext = browser.newContext();

	    // Load the storage state from the JSON file
	    brContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin2.json")));

	    Page page = brContext.newPage();

	    page.navigate("https://rc.truvideo.com/reports/home"); // Navigate to the main page

	    // Continue with other actions

	    // Close the browser context and browser
	    brContext.close();
	    browser.close();
	}
}
