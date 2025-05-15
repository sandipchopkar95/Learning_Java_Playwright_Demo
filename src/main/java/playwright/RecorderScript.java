package playwright;
import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;


public class RecorderScript {
	  public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      
			/*
			 * //start tracing before creating/navigating to page
			 * context.tracing().start(new Tracing.StartOptions() .setScreenshots(true)
			 * .setSnapshots(true) .setSources(true));
			 */
	      
	      Page page = context.newPage();
	      page.navigate("https://rc.truvideo.com/login");
	      page.getByPlaceholder("Email/Username").click();
	      page.getByPlaceholder("Email/Username").fill("sandipadvisor@gmail.com");
	      page.getByPlaceholder("Password").click();
	      page.getByPlaceholder("Password").fill("Sandip@1234");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kenility Store Sandip Advisor")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
	      
			/*
			 * // Stop tracing and export it into a zip archive. context.tracing().stop(new
			 * Tracing.StopOptions() .setPath(Paths.get("trace.zip")));
			 */
	      
			
			  Page page1 = context.newPage();
			  page1.navigate("https://rc.truvideo.com/login");
			  page1.getByPlaceholder("Email/Username").click();
			  page1.getByPlaceholder("Email/Username").fill("dineshadvisor@gmail.com");
			  page1.getByPlaceholder("Password").click();
			  page1.getByPlaceholder("Password").fill("Sandip@1234");
			  page1.getByRole(AriaRole.BUTTON, new
			  Page.GetByRoleOptions().setName("Log In")).click();
			  page1.getByRole(AriaRole.LINK, new
			  Page.GetByRoleOptions().setName("Kenility Store Dinesh Advisor")).click();
			  page1.getByRole(AriaRole.LINK, new
			  Page.GetByRoleOptions().setName("Logout")).click();
			 
	      
	    }
	  }
	
	
}
