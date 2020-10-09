package com.atmecs.excelphp.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.atmecs.excelphp.constant.ConstantClass;

	public class SetUp {

		
		public WebDriver driver;

		@BeforeMethod
	//	@Parameters("browser")

		public void browserSetUp() {
		/*
		 * if (browser.equalsIgnoreCase("firefox")) {
		 * System.setProperty("webdriver.gecko.driver", ConstantClass.GECKO_PATH);
		 * driver = new FirefoxDriver();
		 * driver.navigate().to("https://www.phptravels.com/");
		 * driver.manage().window().maximize(); }
		 * 
		 * else {
		 */
				System.setProperty("webdriver.chrome.driver", ConstantClass.CHROME_PATH);

				driver = new ChromeDriver();
				driver.navigate().to("https://www.phptravels.com/");
				driver.manage().window().maximize();

			}

		//}

		@AfterMethod
		public void closeBrowser() {
			driver.quit();
		}
}
