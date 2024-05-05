package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasic {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create(); //start playwright server
		
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));//launch browser
		LaunchOptions options=new LaunchOptions();
		options.setChannel("chrome");
		options.setHeadless(false);
		Browser browser = playwright.chromium().launch(options);
		
		Page page = browser.newPage(); //Open new tab
		
		page.navigate("https://www.google.com/"); //Enter url into the tab
		
		String title = page.title(); //Store page title in the String
		
		System.out.println("Page title is : "+ title);
		
		String url = page.url();  //Store url in the String
		
		System.out.println("Page url is : "+ url);
		
		browser.close();       //Browser closed
		playwright.close();    //Server closed

	}

}
