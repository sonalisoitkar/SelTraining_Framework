package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPropertyPage {
	private WebDriver driver;

	public AddNewPropertyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// RETC_085_8. Enter Valid credentials in Enter title in textbox
	@FindBy(xpath = "//*[@id='title']")
	private WebElement title;

	public void enterTitle(String title) throws InterruptedException {
		Thread.sleep(3000);
		this.title.sendKeys(title);
	}

	//  RETC_085_9. Enter valid credentials in body textbox
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement textBody;

	public void enterTextBody(String textBody) {
		this.textBody.sendKeys(textBody);
	}

	//  RETC_085_10. Click on checkbox beside added Region of Regions section
	public void addRegionSelected(String addRegion) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
			String start="//label[contains(text(),'";
			String end="')]";
			String CompleteXpath=start+addRegion+end;
			this.driver.findElement(By.xpath(CompleteXpath)).click();
			}
			
		
	//  RETC_085_11. Click on Publish button
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publish;

	public void publishButton() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
		publish.click();

	}
	//6 To verify the assert message when post is published
	@FindBy(xpath = "//*[@id='message']/p")
	private WebElement assertMessage;

	public String assertPublish() throws InterruptedException {
		Thread.sleep(3000);
		String str1 = assertMessage.getText();
		return str1;
	}
//RETC_085_12 Mousehover on usericon
	@FindBy(xpath = "//*[@id=\"wp-admin-bar-my-account\"]/a/img")
	private WebElement mouseHoverIcon;

	public void mouseHoverIcon() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverIcon).perform();
		//Thread.sleep(3000);
	}

	//  RETC_085_12 Click on Logout
	@FindBy(xpath = "//*[@id='wp-admin-bar-logout']/a")
	private WebElement logout;

	public void clicklogoutButton() throws InterruptedException {
		logout.click();
	}
}
