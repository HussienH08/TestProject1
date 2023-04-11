package tests;

import java.util.Iterator;
import java.util.Set;

import pages.PrimeTechPage;
import utils.DataReader;
import utils.Driver;

public class ReuseableCases {

	public static void main(String[] args) {
		ReuseableCases testCases = new ReuseableCases();
		//testCases.testCase1();
		testCases.testCase2();
	}

	PrimeTechPage ptPage;

	public void testCase1() {
		ptPage = new PrimeTechPage();
		// go to http://practice.primetech-apps.com/practice/browser-windows
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		// Click on 'New Tab' button.
		ptPage.newTabBtn.click();
		// Then get the window handles and print what are they.
		Set<String> WindowIds = Driver.getDriver().getWindowHandles();
		Iterator<String> ids = WindowIds.iterator();
			String mainWindowId = ids.next();
			String secondWindowId = ids.next();
				System.out.println("Main Window Id: " + mainWindowId);
				System.out.println("Second Window Id:" + secondWindowId);
	}

	public void testCase2() {
		ptPage = new PrimeTechPage();
		// go to http://practice.primetech-apps.com/practice/browser-windows
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		// 1. Get the main window ID and store it in a String called mainWindowId,
		String mainWindowId = Driver.getDriver().getWindowHandle();
		// 2. Click on the 'New Tab' button
		ptPage.newTabBtn.click();
		// 3. Get window IDs and store it into a Set
		Set<String> WindowIds = Driver.getDriver().getWindowHandles();
			Iterator<String> ids = WindowIds.iterator();
			String firstWindowId = ids.next();
		// 4. Get the first window ID from the Set and Verify it matches with the main window id in step1.
			if (firstWindowId.equals(mainWindowId)) {
				System.out.println("Pass! Window Id Matches");
			} else {
				System.out.println("Fail! Window Id Does NOT Matches");
		}
		// Then get the second window id and store it in variable called secondWindowId.
		String secondWindowId = ids.next();
		// 5. Switch to the second window
		Driver.getDriver().switchTo().window(secondWindowId);
		// 6. Verify that there is a button called 'New Tab'
			if (ptPage.newTabBtn.isDisplayed()) {
				System.out.println("Pass! 'New Tab' Button is Displayed");
			} else {
				System.out.println("Fail! 'New Tab' Button is NOT Displayed");
		}
		// 7. Close the window, Switch back to the main window, Verify you are on the main window.
		Driver.getDriver().close();
		Driver.getDriver().switchTo().window(mainWindowId);
			if (ptPage.browserText.isDisplayed()) {
				System.out.println("Pass! On the Main Window");
			} else {
				System.out.println("Fail! NOT On the Main Window");
		}

	}
}
