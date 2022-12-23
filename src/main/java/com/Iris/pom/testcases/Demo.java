package com.Iris.pom.testcases;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Iris.pom.base.BasePage;
import com.Iris.pom.pages.DemoPage;
import com.Iris.pom.testcases.base.BaseTest;
import com.Iris.pom.util.Log;

public class Demo extends BaseTest {
	public DemoPage signupTest;

	@BeforeSuite
	public void startUpTest() {
		init("Chrome");
		signupTest = new DemoPage();
	}	
    @Test(priority = 0)
	public void verifyOurSchoolApp() throws Throwable {
		startExtent = extent.startTest("Verify News Page");
		Log.startLog("Verify News Tab");
		signupTest.verifyElementsOnNewsPage(startExtent);
		reportPass("test case pass");
		Log.endLog("inventorySearch");
	}	
}
