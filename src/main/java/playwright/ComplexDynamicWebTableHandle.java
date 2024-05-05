package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ComplexDynamicWebTableHandle {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://datatables.net/extensions/select/examples/initialisation/multi.html");

		Locator row = page.locator("table#example tr");
		String startDate = row.locator(":scope", new Locator.LocatorOptions().setHasText("Ashton Cox"))
				.locator(".dt-type-date").innerText();
		System.out.println(startDate);
		
		//List<String> allTextUnderTable= row.locator(":scope").allInnerTexts();
		row.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));
		//System.out.println(allTextUnderTable);
		browser.close();
	}
}
