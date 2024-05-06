package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JsPopupHandle {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		//Custom lister
		page.onDialog(dialog->{
			    String text= dialog.message();
			    System.out.println(text);
			     dialog.accept();
			    //dialog.accept("Sandip");
			    });
		 
		 
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		page.click("button:has-text('Click for JS Alert')");
	    System.out.println(page.textContent("#result"));	
	    
	    page.click("button:has-text('Click for JS Confirm')");
	    System.out.println(page.textContent("#result"));
	    
	   
	    page.click("button:has-text('Click for JS Prompt')");
	    System.out.println(page.textContent("#result"));
	    
	    page.close();
	    browser.close();
	    playwright.close();
	}
}
