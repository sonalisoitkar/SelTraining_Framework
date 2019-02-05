package com.training.functional.tests;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.LoginAdmin;
import com.training.pom.RETC025PropertiesPage;
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

public class RETC025PropertiesPageTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC025PropertiesPage retc025PropertiesPage;
	private LoginAdmin loginAdmin;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc025PropertiesPage = new RETC025PropertiesPage(driver);
		baseUrl = properties.getProperty("baseURL");
		loginAdmin = new LoginAdmin(driver);
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
	public void userProperties() {
		retc025PropertiesPage.clickProperties();
		retc025PropertiesPage.allProperties();
		retc025PropertiesPage.addDates();
		retc025PropertiesPage.validCredentialsInDateBox();
		retc025PropertiesPage.filterResult();
		
	}
	@Test(priority = 2)
	public void adminPropertiesAssert() {
		String Expected = "admin";
		//String Actual = retc025PropertiesPage.AdminProperties();
		System.out.println();
		//assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}
