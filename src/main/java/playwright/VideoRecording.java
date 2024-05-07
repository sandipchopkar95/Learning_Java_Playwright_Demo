package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setRecordVideoDir(Paths.get("MyVideos/")).
				setScreenSize(640,480));
		Page page = context.newPage();
		
		page.navigate("https://rc.truvideo.com/login");

		page.fill("input[name='j_username']", "dineshadvisor@gmail.com");
		page.fill("input[name='j_password']", "Sandip@1234");
		page.click("input[value='Log In']");
		
		context.close();
		page.close();
		playwright.close();
		
	}
	
	
	
	
}
