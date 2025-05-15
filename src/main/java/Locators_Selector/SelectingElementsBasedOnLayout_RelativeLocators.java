package Locators_Selector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectingElementsBasedOnLayout_RelativeLocators {
	static Page page2;

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://demo.automationtesting.in/Register.html");

		Locator address = page.locator("textarea[ng-model='Adress']:right-of(:text('Address'))");
		address.fill("Janjeerwala Square Indore 452001");
		System.out.println("Address : " + address.textContent());

		Locator enteredPass = page.locator("input[type='password']:right-of(:text('Password'))").first();
		enteredPass.fill("Sandip@1234");
		System.out.println("Entered pass : " + enteredPass.textContent());

		Locator confirmPass = page.locator("input[type='password']:right-of(:text('Confirm Password'))").first();
		confirmPass.fill("Sandip@1234");
		System.out.println("ConfrmPass : " + confirmPass.textContent());

		page2 = browser.newPage();
		page2.navigate("https://selectorshub.com/xpath-practice-page/");
		selectCheckBox("Joe.Root");
		selectUserRole("Joe.Root");
		selectCheckBox("John.Smith");
		selectUserRole("John.Smith");
		
		
	}

	public static void selectCheckBox(String username) {
		page2.locator("input[type='checkbox']:left-of(:text('" + username + "'))").first().click();
	}

	public static void selectUserRole(String username) {
		String role = page2.locator("td:right-of(:text('" + username + "'))").first().textContent();
		System.out.println("Role of " + username + " :-> " + role);
	}

}
