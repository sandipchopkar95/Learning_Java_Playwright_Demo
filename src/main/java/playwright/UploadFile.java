package playwright;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class UploadFile {
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

		// input type='file' is required
		page.setInputFiles("input[type='file']", Paths.get("C:/Users/windows10/Desktop/ScreenShots/Advisor Name.png"));
		Thread.sleep(4000);
		page.setInputFiles("input[type='file']", new Path[0]); // deselect file

		// multiple files
		page.setInputFiles("input[type='file']",
				new Path[] { 
						Paths.get("C:/Users/windows10/Desktop/ScreenShots/Advisor Name.png"),
						Paths.get("C:/Users/windows10/Desktop/ScreenShots/Screenshot.png"), 
						});
		Thread.sleep(4000);
		page.setInputFiles("input[type='file']", new Path[0]); // deselect all files
		
		//run time create new file and upload it
		page.setInputFiles("input[type='file']", 
				new FilePayload("ABCD.text", "text/plain", "Sandip here".getBytes(StandardCharsets.UTF_8)));
		
		//create , Upload and verify
		Page page2=browser.newPage();
		page2.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		page2.setInputFiles("input[type='file']", 
				new FilePayload("ABCD.text", "text/plain", "Sandip here".getBytes(StandardCharsets.UTF_8)));
		
		page2.click("//input[@type='submit']");
		
	}

}
