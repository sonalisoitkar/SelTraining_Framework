package com.training.pom;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*Blog->Read More->Enter comments->Post Comment-Open Admin Site-UID-PWD-Sign in-Dashboard-
Mousover the comment-Reply-enter details-Click on Approve an reply-Refresh*/
public class AddnViewCommentInBlogPage {
	private WebDriver driver;

	public AddnViewCommentInBlogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//1. Click on Blog Tab
	@FindBy(linkText = "Blog")
	private WebElement blog;

	public void clickBlog() {
			this.blog.click();;
	}

	// 2. Click on Read More link of post added by admin
	@FindBy(xpath = "//h3//a[text()='vihar1']//parent::h3//following-sibling::a[text()='Read More ']")
	private WebElement readMore;

	public void clickReadMore() throws AWTException {
				readMore.click();
		}
	

//3. Enter valid details in Comment textbox
	@FindBy(xpath = "//textarea[@name='comment']")
	private WebElement enterComment;

	public void enterCommentBox(String enterComment) throws InterruptedException {
		Thread.sleep(3000);
		this.enterComment.sendKeys(enterComment);
	
	}
	// Enter valid Name textbox");
	@FindBy(xpath = "//input[@id='author']")
	private WebElement nameField;

	public void NameFieldBox(String nameField) throws InterruptedException {
	
		Thread.sleep(3000);
		this.nameField.sendKeys(nameField);
	
	}
	//3. Enter valid email in textbox;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;

	public void emailFieldBox(String emailField) throws InterruptedException {
	
		Thread.sleep(3000);
		this.emailField.sendKeys(emailField);
	
	}
	
//4. Click on Post Comment button
	@FindBy(xpath = "//input[@id='submit']")
	private WebElement button;

	public void postButton() throws InterruptedException {
		Thread.sleep(3000);
		button.click();
	}
	// 5. Open admin site in new window
	public void adminSiteWindow() {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://realestate.upskills.in/my-profile/");
	}

	// 6. Enter valid credential in Username textbox
	// 7. Enter valid credential in Password textbox
	// 8. Click on Sign in button

	// 9. click on Dashboard tab
	@FindBy(xpath = "//div[contains(text(),'Dashboard')]")
	private WebElement dashboard;

	public void clickDashboard() {
		this.dashboard.click();
	}

	// 10.mouse over the comment added by user recently
	@FindBy(xpath = "//ul[1]/li[1]/div[1]/p[1]")
	private WebElement comment;

	public void mouseOverComment() {
		Actions action = new Actions(driver);
		action.moveToElement(this.comment).build().perform();
	}

	// 11. Click on Reply icon
	@FindBy(xpath = "  //div[@class='dashboard-comment-wrap has-row-actions']//a[@class='vim-r hide-if-no-js'][contains(text(),'Reply')]")
	private WebElement replyLink;

	public void clickReplyLink() {
		this.replyLink.click();
	}

	// 12. enter valid details in comments textbox
	@FindBy(xpath = "//textarea[@id='replycontent']")
	private WebElement replyComment;

	public void replyCommentBox(String replyComment) {
			this.replyComment.sendKeys(replyComment);
	}

	// 13. Click on Reply button
	@FindBy(xpath = "//span[@id='replybtn']")
	private WebElement replyResend;

	public void approveNReplyButon() {
				this.replyResend.click();
	}

	// 14. Refresh the page
	@FindBy(xpath = "//div[contains(text(),'Dashboard')]")
	private WebElement refresh;

	public void refreshPage() {
				this.refresh.click();
	}
	
	}
