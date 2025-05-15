package playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandling {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://demo.automationtesting.in/Frames.html");
		Locator textfieldUnderIFrame = page.frameLocator("iframe[name='SingleFrame']").locator("input[type='text']")
				.first();
		textfieldUnderIFrame.fill("ABCD");
		System.out.println(textfieldUnderIFrame.textContent());
		System.out.println("END first frame");

		page.locator("'Iframe with in an Iframe'").click();

		// frame under frame & by frameUrl
		// page.frameLocator("iframe[style='float: left;height: 300px;width:600px']")
		page.frameByUrl("https://demo.automationtesting.in/MultipleFrames.html")
				.frameLocator("iframe[style='float: left;height: 250px;width: 400px']").locator("input[type='text']")
				.first().fill("PQRS");

		System.out.println("END second frame");
		
		
		//Visible Element
		Page page1 = browser.newPage();
		page1.navigate("https://demo.automationtesting.in/Index.html");
        System.out.println(page1.locator("button:visible").allTextContents());
        System.out.println(page1.locator("button >> visible=true").allTextContents());
       
       // print all available links on the page
        Page page2 = browser.newPage();
        page2.navigate("https://www.amazon.in/");
        List<String> allLinksOnPage= page2.locator("a:visible").allTextContents();
        for(int i=0;i<allLinksOnPage.size();i++) {
        	System.out.println(allLinksOnPage.get(i));
        }
        
       int imageCount = page2.locator("xpath=//img >> visible=true").count();
        System.out.println(imageCount);
        
		browser.close();
	}
	
	
}
