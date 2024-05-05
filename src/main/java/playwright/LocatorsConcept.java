package playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorsConcept {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://demo.automationtesting.in/Register.html");

			/*
			 * // Text locator (Single elements) Locator createAccount =
			 * page.locator("text = Create Account"); createAccount.hover();
			 * createAccount.click();
			 * 
			 * Locator signIn = page.locator("text = Sign in"); signIn.hover();
			 * signIn.click();
			 * 
			 * // text locator (multiple elements) Locator LogInButton1 =
			 * page.locator("text = Log In"); int totalLoginButton = LogInButton1.count();
			 * // will give count of elements System.out.println(totalLoginButton); Locator
			 * LogInButton = page.locator("text = Log In").first(); // will click on first
			 * element LogInButton.hover(); LogInButton.click();
			 */

			Locator skillsOption = page.locator("select#Skills option"); // locator to find list under select tag
																			// (select#id option)
			System.out.println(skillsOption.count());

			/*
			 * //first way for(int i =0;i<skillsOption.count();i++) { String skills =
			 * skillsOption.nth(i).textContent(); //textContent() methods gives the text
			 * System.out.println(skills); }
			 */

			/*
			 * // Second way 
			 * List<String> skillList = skillsOption.allTextContents(); for
			 * (String e : skillList) { System.out.println(e); }
			 */

		}
	}
}
