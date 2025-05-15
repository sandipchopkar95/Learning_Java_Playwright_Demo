package Locators_Selector;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathSelector {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");
		// page.locator("﻿﻿﻿xpath=//input[@id='twotabsearchtextbox']").fill("Macbook");
		page.locator("﻿﻿﻿//input[@id='twotabsearchtextbox']").fill("Macbook");

		Locator totalAmazonLinks = page.locator("//a[contains(text(), 'Amazon')]");
		System.out.println(totalAmazonLinks.count());
		List<String> list = totalAmazonLinks.allInnerTexts();
		for (String w : list) {
			System.out.println(w);
		}

		Page page2=browser.newPage();
		page2.navigate("https://selectorshub.com/xpath-practice-page/");
		page2.locator("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']").click();
		
		
		Page page3=browser.newPage();
		page3.navigate("https://selectorshub.com/xpath-practice-page/");
		Locator listOfCkeckbox = page3.locator("//table[@id='resultTable']//input[@type='checkbox']");
		for(int i=0; i<listOfCkeckbox.count(); i++ ){
			listOfCkeckbox.nth(i).click();
		}
		page3.locator("(//table[@id='resultTable']//input[@type='checkbox'])[4]").click();
		
			
		
		browser.close();
	}

}
