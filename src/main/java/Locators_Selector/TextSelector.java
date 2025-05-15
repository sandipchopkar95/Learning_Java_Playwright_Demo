package Locators_Selector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //start playwright server
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));//launch browser
		Page page = browser.newPage(); //Open new tab
		page.navigate("https://demo.automationtesting.in/"); //Enter url into the tab
		
		//Text Selector -> single lement -> ("text = Skip Sign In") -> ("text = visibleText")
		page.locator("text = Skip Sign In").click();
		
		//page.locator("text='WebTable'").click();
		
	   //multiple element
		Locator registerElements = page.locator("text='WebTable'");
		System.out.println(registerElements.count());
		for(int i=0;i<registerElements.count();i++) {
			String text = registerElements.nth(i).textContent();
			registerElements.nth(i).click();
			System.out.println(text);
		}
		
		//Parent child relation ("label:has-text(' Photo')" -> (tag:has-text('visibleText')")
	String photoText = 	page.locator("label:has-text(' Photo')").textContent();
	System.out.println(photoText);
	//String photoText1 = page.locator("div.col-xs-6 col-xs-offset-6 label:has-text(' Photo')").textContent();
	//System.out.println(photoText1);
	
	String pageHeader=page.locator("'Automation Demo Site '").textContent();  //just like ("text = visibleText")
	System.out.println(pageHeader);
	
	//text for buttons
	page.locator("text = Refresh").click();
	page.locator("div button:has-text('Refresh')").click(); //parent child when multiple elements with same text is available
	System.out.println("End");
	browser.close();
	}
}
