package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopup {
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext bx1 = browser.newContext();
		/*
		 * BrowserContext bx2 = browser.newContext();
		 * 
		 * Page page1= bx1.newPage(); Page page2=bx2.newPage();
		 * 
		 * page1.navigate("https://rc.truvideo.com/login");
		 * page2.navigate("https://amazon.in");
		 */
		
		Page page1=bx1.newPage();
		page1.navigate("https://orangehrm.com/");
		
		//Browser popup -> whenever new tab is opened
		Page popup= page1.waitForPopup(()->{
			page1.click("img[alt='facebook logo']");
		});
		
		System.out.println("Pop up window title is : -> "+ popup.title());
		popup.close();
		
		//open new tab with blank window
		Page popup1= page1.waitForPopup(()->{
			page1.click("a[target='_blank']"); //open a new tab window
		});
		popup1.waitForLoadState();
		popup1.navigate("https://google.com/");
		System.out.println("Title for nee window   "+popup1.title());
		popup1.close();
		Thread.sleep(2000);
		
		System.out.println("Parent window title is : -> "+ page1.title());
		
		Thread.sleep(2000);
		page1.close();
		
	}

}
