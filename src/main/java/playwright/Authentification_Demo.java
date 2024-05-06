package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Authentification_Demo {
	public static void main(String[] args) {
		 Playwright playwright = Playwright.create();
         Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         BrowserContext brContext = browser.newContext();
         Page page = browser.newPage();
         page.navigate("https://rc.truvideo.com/login");

         page.fill("input[name='j_username']", "dineshadvisor@gmail.com");
         page.fill("input[name='j_password']", "Sandip@1234");
         page.click("input[value='Log In']");
         
         // Wait for login process to complete (you might need to add a wait here)
         
         brContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin2.json")));
         
         // Save the storage state to a file
         brContext.close(); // Close the browser context

         browser.close(); // Close the browser
	}

}
