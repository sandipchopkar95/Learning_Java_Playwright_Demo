package Locators_Selector;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Nth_Selector {
	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.bigbasket.com/");

		Locator firstElement = page.locator("div.container li.mt-3 a >> nth=0");
		String firstElement_Link = firstElement.textContent();
		System.out.println(firstElement_Link);
		
		Locator lastElement = page.locator("div.container li.mt-3 a >> nth=-1");
		String lastElement_Link = lastElement.textContent();
		System.out.println(lastElement_Link);

		browser.close();
	}
}
