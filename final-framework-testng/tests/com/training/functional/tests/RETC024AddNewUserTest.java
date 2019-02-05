package com.training.functional.tests;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.CommonComponents;
import com.training.pom.LoginAdmin;
import com.training.pom.AllUserActionsPOM;
import com.training.pom.AddNewUserAction;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
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
	private AllUserActionsPOM allUserActionsPOM;
	private AddNewUserAction addNewUserAction;
	private LoginAdmin loginAdmin;
	private CommonComponents commonComponents;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		allUserActionsPOM = new AllUserActionsPOM(driver);
		addNewUserAction= new AddNewUserAction(driver);
		baseUrl = properties.getProperty("baseURL");
		loginAdmin = new LoginAdmin(driver);
		commonComponents=new CommonComponents(driver);
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
		commonComponents.Users();
		Thread.sleep(3000);
		addNewUserAction.addNewUser();
		//retc024addNewUser.showPassword();
		addNewUserAction.userLogin("sonaliDel1");
		addNewUserAction.email("sonali_kk1@gmail.com");
		addNewUserAction.firstName("sonaliDel1");
		addNewUserAction.lastName("soitkarjain1");
		addNewUserAction.showUrl("www.google.com");
		addNewUserAction.showPassword();
		Thread.sleep(3000);
		addNewUserAction.enterPassword("11b12345678@12345"); 
		Thread.sleep(3000);
		addNewUserAction.clickRoleList();
		addNewUserAction.validCredentialsInListBox();
		addNewUserAction.createUsers(); Thread.sleep(3000);
}
	  @Test(priority = 2) 
	  public void addNewUserAssert() 
	  { String Expected = "New user created. Edit user"; 
	  String Actual = allUserActionsPOM.AssertUser();
	  assertEquals(Actual, Expected);
	 screenShot.captureScreenShot("AddNewUser");
	 }
	 
}
