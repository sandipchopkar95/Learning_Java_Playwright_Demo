package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class chatscreen {

	 public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://rc.truvideo.com/login");
		      page.getByPlaceholder("Email/Username").fill("sandipadvisor@gmail.com");
		      page.getByPlaceholder("Password").fill("Sandip@1234");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Chat")).click();
		      page.frameLocator("#chat-v2-iframe").getByPlaceholder("Search a conversation").click();
		      page.frameLocator("#chat-v2-iframe").getByPlaceholder("Search a conversation").fill("test");
		      page.frameLocator("#chat-v2-iframe").locator("ngx-messaging-channels-list-item:nth-child(2) > .channels-list-item > div > .channels-list-item__main > div").first().click();
		    }
		  }
}
