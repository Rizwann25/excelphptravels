package com.atmecs.excelphp.testscript;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import com.atmecs.excelphp.constant.ConstantClass;
import com.atmecs.excelphp.helper.HelperClass;
import com.atmecs.excelphp.reader.PropertyReader;
import com.atmecs.excelphp.setup.SetUp;
import com.atmecs.excelphp.testdata.DataProviderClass;


	public class ChatClass extends SetUp {

		Properties locators;

		@Test
		(dataProvider = "Data", dataProviderClass = DataProviderClass.class)

		public void startChat(String name, String email, String whatsapp) throws InterruptedException {
			Logger log = Logger.getLogger(ChatClass.class);
			PropertyConfigurator.configure("Log4j.properties");

			locators = PropertyReader.readProperty(ConstantClass.LOCATORS_PATH);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.switchTo().frame(locators.getProperty("Frame_Id"));
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.getProperty("ChatWidget"))));

			HelperClass.jsClick(driver, locators.getProperty("ChatWidget"));
			Thread.sleep(5000);
			HelperClass.sendKeyById(driver, locators.getProperty("NameData"), name);
			Thread.sleep(5000);
			HelperClass.ElementSendKeys(driver, locators.getProperty("WhatsApp"), whatsapp);
			Thread.sleep(5000);
			HelperClass.sendKeyById(driver, locators.getProperty("EmailData"), email);
			Thread.sleep(5000);
			HelperClass.selectFromDropDown(driver, locators.getProperty("Dropdown"), locators.getProperty("value"));
			HelperClass.jsClick(driver, locators.getProperty("StartChat"));

		}

}
