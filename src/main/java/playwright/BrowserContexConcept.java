package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class BrowserContexConcept {
	public static void main(String[] args) {
	 
	try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      
	      BrowserContext context1 = browser.newContext();
	      Page page1 = context1.newPage();
	      page1.navigate("https://rc.truvideo.com/login");
	      page1.getByPlaceholder("Email/Username").click();
	      page1.getByPlaceholder("Email/Username").fill("sandipadvisor@gmail.com");
	      page1.getByPlaceholder("Password").click();
	      page1.getByPlaceholder("Password").fill("Sandip@1234");
	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
	      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kenility Store Sandip Advisor")).click();
	      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
	      
	     BrowserContext context2 = browser.newContext();
		 Page page2 = context2.newPage();
		 page2.navigate("https://rc.truvideo.com/login");
		 page2.getByPlaceholder("Email/Username").click();
		 page2.getByPlaceholder("Email/Username").fill("dineshadvisor@gmail.com");
		 page2.getByPlaceholder("Password").click();
		 page2.getByPlaceholder("Password").fill("Sandip@1234");
		 page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
		 page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kenility Store Dinesh Advisor")).click();
		 page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
			 
	      
	    }
	}
}
