package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FillFormUsingBelow {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.locator("input[title='Email']:below(:text('User Email'))").click();
		page.locator("input[title='Email']:below(:text('User Email'))").fill("abcd@gmail.com");
		page.locator("input[title='Password']:below(:text('Password'))").fill("password@1234");
		//page.locator("input:below(label:text('Company'))").first().click();
		//page.locator("input:below(label:text('Company'))").first().fill("ABCD Comapny");
		page.locator("input[type='text']").first().click();
		page.locator("input[type='text']").first().fill("5Exceptions");
		page.locator("input[type='number']").first().click();
		page.locator("input[type='number']").first().fill("9876543210");
		page.locator("button[value='Submit']").click();
		page.locator("input[placeholder='First Crush']").fill("Someone Special");
		page.getByPlaceholder("First Crush").fill("Someone Special from placeholder");
	}

}
