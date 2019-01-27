package com.training.functional.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.LoginAdmin;
import com.training.pom.RETC024AddNewUser;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class RETC024AddNewUserTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC024AddNewUser retc024addNewUser;
	private LoginAdmin loginAdmin;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc024addNewUser = new RETC024AddNewUser(driver);
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

	}

	@Test(priority = 1)

	public void addNewUserTest() throws InterruptedException {
		retc024addNewUser.clickUsers();
		Thread.sleep(3000);
		retc024addNewUser.addNewUser();
		//retc024addNewUser.showPassword();
		retc024addNewUser.userLogin("11bb1234");
		retc024addNewUser.email("11bb1234@gmail.com");
		retc024addNewUser.firstName("11bb1234");
		retc024addNewUser.lastName("soitkarjain12");
		retc024addNewUser.showUrl("www.google.com");
		retc024addNewUser.showPassword();
		Thread.sleep(3000);

		retc024addNewUser.enterPassword("11bb12345@12345"); 
		Thread.sleep(3000);
		retc024addNewUser.clickRoleList();
		retc024addNewUser.validCredentialsInListBox();
		retc024addNewUser.createUsers(); Thread.sleep(3000);

	}

	
	  @Test(priority = 2) public void addNewUserAssert() 
	  { String Expected = "New user created. Edit user"; 
	  String Actual = retc024addNewUser.AssertUser();
	 System.out.println(); assertEquals(Actual, Expected);
	 screenShot.captureScreenShot("AddNewUser");
	 }
	 
}
