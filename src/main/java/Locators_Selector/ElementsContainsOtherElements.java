package Locators_Selector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ElementsContainsOtherElements {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create(); // start playwright server
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));// launch
																											// browser
		Page page = browser.newPage(); // Open new tab
		page.navigate("https://demo.automationtesting.in/Register.html");
		Locator loc = page.locator("select#Skills:has(Option[value='Java'])");
		loc.allInnerTexts().forEach(e -> System.out.println(e));
		// System.out.println(loc.allTextContents());

		Page page2 = browser.newPage(); // Open new tab
		page2.navigate("https://amazon.in/");
		Locator footerList = page2.locator("div.navFooterLinkCol:has(a[href='https://amazon.jobs'])");
		footerList.allInnerTexts().forEach(e -> System.out.println(e));
		browser.close();
	}

}
