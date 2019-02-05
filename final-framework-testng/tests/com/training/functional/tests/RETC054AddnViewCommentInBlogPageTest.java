package com.training.functional.tests;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.training.generics.ScreenShot;
import com.training.pom.LoginAdmin;
import com.training.pom.AddnViewCommentInBlogPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RETC054AddnViewCommentInBlogPageTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddnViewCommentInBlogPage addViewCommentInBlogPageTest;
	private LoginAdmin loginAdmin;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		addViewCommentInBlogPageTest = new AddnViewCommentInBlogPage(driver);
		loginAdmin = new LoginAdmin(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@Test(priority = 0)
	public void addnViewCommentInBlogPageTest() throws InterruptedException, AWTException {
		addViewCommentInBlogPageTest.clickBlog();
		addViewCommentInBlogPageTest.clickReadMore();
		{
			Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		addViewCommentInBlogPageTest.enterCommentBox("bestest1234561");
		addViewCommentInBlogPageTest.NameFieldBox("Sonali1211");
		addViewCommentInBlogPageTest.emailFieldBox("sonali.kkks12@gmail.com");
		addViewCommentInBlogPageTest.postButton();
		addViewCommentInBlogPageTest.adminSiteWindow();
		loginAdmin.sendUserName("admin");
		loginAdmin.sendPassword("admin@123");
		loginAdmin.clickLoginBtn();
		addViewCommentInBlogPageTest.clickDashboard();
		addViewCommentInBlogPageTest.mouseOverComment();
		addViewCommentInBlogPageTest.clickReplyLink();
		addViewCommentInBlogPageTest.replyCommentBox("Howdy");
		Thread.sleep(3000);
		addViewCommentInBlogPageTest.approveNReplyButon();
		addViewCommentInBlogPageTest.refreshPage();
		Thread.sleep(3000);
		screenShot.captureScreenShot("Comment");
	}

	
	 @AfterClass
	 public void tearDown() throws Exception { Thread.sleep(1000);
	  driver.quit(); }
	 
}
