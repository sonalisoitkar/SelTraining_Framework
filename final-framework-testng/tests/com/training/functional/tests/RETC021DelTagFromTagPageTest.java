package com.training.functional.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.LoginAdmin;
import com.training.pom.RETC021DelTagFromTagPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class RETC021DelTagFromTagPageTest extends LoginTests {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC021DelTagFromTagPage retc021DelTagFromTagPageTest;
	private LoginAdmin loginAdmin;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc021DelTagFromTagPageTest = new RETC021DelTagFromTagPage(driver);
		loginAdmin = new LoginAdmin(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@Test(priority = 0)
	public void validLoginTest() {
		loginAdmin.sendUserName("admin");
		loginAdmin.sendPassword("admin@123");
		loginAdmin.clickLoginBtn();
		screenShot.captureScreenShot("First");
			}

	
	  @Test(priority = 1) 
	  public void delTagFromTagPage() throws InterruptedException {
	  retc021DelTagFromTagPageTest.clickPosts();
	  retc021DelTagFromTagPageTest.clickTags();
	  retc021DelTagFromTagPageTest.selectCheckBox();
	  retc021DelTagFromTagPageTest.selectBulkList();	  
	  retc021DelTagFromTagPageTest.deleteTag();
	  retc021DelTagFromTagPageTest.applyTag();
	 

	}
	  @Test(priority = 2)
		public void delTagAssert() throws InterruptedException {
			String Expected = "Tags deleted.";
			String Actual = retc021DelTagFromTagPageTest.AssertTag();
			System.out.println();
			assertEquals(Actual, Expected);
			screenShot.captureScreenShot("First");
		}

/*	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
}
