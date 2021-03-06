package com.training.functional.tests;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.CommonComponents;
import com.training.pom.LoginAdmin;
import com.training.pom.DelTagFromTagPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

/*
 * Author               :Sonali Soitkar
 * Test CaseID          :RETC_021
 * Test Case Description:To verify whether application allows admin to delete tag from the tag page
 * Precondition         :user should have launched the application by entering valid URL
 *                      :admin should be logged in
 */

public class RETC021DelTagFromTagPageTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private DelTagFromTagPage delTagFromTagPageTest;
	private LoginAdmin loginAdmin;
	private CommonComponents commonComponents;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		delTagFromTagPageTest = new DelTagFromTagPage(driver);
		commonComponents=new CommonComponents(driver);
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
		  commonComponents.clickPosts();
		  delTagFromTagPageTest.clickTags();
		  delTagFromTagPageTest.selectCheckBox();
		  delTagFromTagPageTest.selectBulkList();	  
		  delTagFromTagPageTest.deleteTag();
		  delTagFromTagPageTest.applyTag();
	 	}
	  @Test(priority = 2)
		public void delTagAssert() throws InterruptedException {
			String Expected = "Tags deleted.";
			String Actual = delTagFromTagPageTest.AssertTag();
			System.out.println();
			assertEquals(Actual, Expected);
			screenShot.captureScreenShot("First");
		}

@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
