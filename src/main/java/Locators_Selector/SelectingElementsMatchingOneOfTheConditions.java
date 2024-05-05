package Locators_Selector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectingElementsMatchingOneOfTheConditions {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// OR condition by css
		Page page = browser.newPage();
		page.navigate("https://demo.automationtesting.in/Register.html");
		String text = page.locator("label:has-text('Full Name* '), label:has-text('Full Name')").textContent();
		System.out.println(text);

		// AND condition by css
		Page page2 = browser.newPage();
		page2.navigate("https://demo.automationtesting.in/Register.html");
		int andLocatorCount = page2.locator("a:has-text('Home'), a:has-text('Register')").count();
		System.out.println(andLocatorCount);

		// AND condition by xpath union
		Page page3 = browser.newPage();
		page3.navigate("https://demo.automationtesting.in/Register.html");
		int countByxpath = page3.locator("//a[text()='Home'] | //a[text()='Register']").count();
		System.out.println(countByxpath);
		
		//working as a OR condition with xpath union
		Page page4 = browser.newPage();
		page4.navigate("https://demo.automationtesting.in/Register.html");
		String textByxpath = page4.locator("//label[text()='Full Name* '] | //label[text()='Full Name']").textContent();
		System.out.println(textByxpath);

		page.close();
		page2.close();
		page3.close();
		browser.close();
	}

}
