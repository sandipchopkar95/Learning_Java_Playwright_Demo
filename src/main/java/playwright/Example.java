package playwright;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Example {
	  public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://rc.truvideo.com/login");
	     // page.pause();
	      page.getByPlaceholder("Email/Username").fill("sandipadvisor@gmail.com");
	      page.getByPlaceholder("Password").fill("Sandip@1234");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
	      
	    }
	  }
}
