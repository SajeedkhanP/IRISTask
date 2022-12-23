package com.Iris.pom.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Iris.pom.base.BasePage;
import com.Iris.pom.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoPage extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	private By groupTab = By.xpath("//*[@id='root']/div/main/ol/li[20]");
	private By activeIcon = By.xpath("//*[@id='root']/div/main/ol/li[20]/div");
	private By searchButton = By.xpath("//button[@id='searchPostcodeButton']");
	private By searchBox = By.xpath("//*[@id='main']");
	private By activeButton = By.xpath("//*[@id='root']/div/main/ol/li[20]/div");
	public By newIcon = By.xpath("//*[@id='main']/li[1]/ol/li/div/div[1]/img");
	private By newsImages = By.xpath("//img");
	public String curentUrl = "";
	public static String homePage = "https://osa-web.t-cg.co.uk/";
	private static HttpURLConnection huc;
	private static int respCode;
	public void verifyElementsOnNewsPage(ExtentTest test) throws Throwable {
		test.log(LogStatus.INFO, "Sign into Iris.com");
		driver.get(homePage);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		curentUrl = driver.getCurrentUrl();
		assertEquals(homePage, curentUrl);
		driver.findElement(searchBox).sendKeys("B16 8PE");
		driver.findElement(searchButton).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(groupTab);
		driver.findElement(groupTab).isDisplayed();
		element.sendKeys(Keys.DOWN);
		driver.findElement(activeIcon).isEnabled();
		driver.findElement(groupTab).click();
		WebElement image = driver.findElement(newsImages);
		boolean imagePresent = image.isDisplayed();
		assertTrue(imagePresent);
		Thread.sleep(3000);
		driver.get("https://osa-web.t-cg.co.uk/qatest");
		brokenLinks();
	}
	public static void brokenLinks() throws IOException {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			String url = it.next().getAttribute("href");

			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}
			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
