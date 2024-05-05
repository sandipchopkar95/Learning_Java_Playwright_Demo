package Locators_Selector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOM {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.htmlelements.com/demos/menu/shadow-dom/index.htm");
		
		
		//Page--DOM-->Shadow DOM-->elements
		//Page--DOM-->iFrame-->Shadow DOM-->elements
		page.locator("smart-ui-menu[class='smart-ui-component'] .smart-menu-item-label-container").first().click();
		page.locator("//smart-ui-menu[@class='smart-ui-component']//*[@id='menuItemsGroup6375']/div[1]").click();
	   
	}

}
