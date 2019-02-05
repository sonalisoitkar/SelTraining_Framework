package com.training.pom;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.training.functional.tests.LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DisplayPropertiesPage {
	private WebDriver driver;

	public DisplayPropertiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// RETC_051_053_3.Click on Trash link
	@FindBy(xpath = "//*[@id='wpbody-content']/div[3]/ul/li[4]")
	private WebElement trashLink;

	public void trashLink() throws InterruptedException {
		Thread.sleep(3000);
		this.trashLink.click();
	}

	// RETC_051_053_4 and 5. Mouse over on Property you want to restore
	
	public void trashPropertyLinks(String propertyName) {
		List<WebElement> row = driver.findElements(By.xpath("//table/tbody[@id='the-list']/tr"));   //will get the row count as 20 webelements
		String beforeXpath = "//table/tbody[@id='the-list']/tr[";
		String afterXpath = "]/td[1]";
		for (int i = 1; i <= row.size(); i++) {
		String actualXpath = beforeXpath+i+afterXpath;
		WebElement element = driver.findElement(By.xpath(actualXpath));
	    String id=element.getText();
		if(id.equals(propertyName))
				{
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			String restore="//tr[" +i+"]//a[contains(text(),'Restore')]";
			WebElement restoreClick = driver.findElement(By.xpath(restore));
			restoreClick.click();
			break;
			}
		}
	}

	// RETC_051_053_5.b Asserting message
	@FindBy(xpath = "//*[@id='message']/p")
	private WebElement assertMess;

	public String assertMessage() {
		String Actual = assertMess.getText();
		return Actual;
	}

	// RETC_051_6 Click on All link after searching the element using search textbox
	
	@FindBy(xpath = "//*[@id='wpbody-content']/div[3]/ul/li[1]")
	private WebElement allLink;

	public void allPropertiesDisplayed() {
		this.allLink.click();
	}

	// RETC_053_6 launch home site in new window

	public void allPropertiesDisplayedInNewWindow() {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://realestate.upskills.in/wp-admin");
	}

	// RETC_051_053_7. Search for added property
	@FindBy(xpath = "//*[@id='post-search-input']")
	private WebElement searchTextBox;

	public void searchTextBoxEntered(String searchTextBox ) {
		this.searchTextBox.sendKeys(searchTextBox);
	}

	@FindBy(xpath = "//input[@value='Search Properties']")
	private WebElement searchProperties;

	public void searchPropertiesButton() {
		searchProperties.click();
	}

	// RETC_052_3 and RETC_052_4. Mouse over the property and Click on Trash link beside the property
	public void mouseOverProperty(String propertyName1) throws InterruptedException {
		List<WebElement> row = driver.findElements(By.xpath("//table/tbody[@id='the-list']/tr"));   //will get the row count as 20 webelements
		String beforeXpath = "//table/tbody[@id='the-list']/tr[";
		String afterXpath = "]/td[1]";
		for (int i = 1; i <= row.size(); i++) {
		String actualXpath = beforeXpath+i+afterXpath;
		WebElement element = driver.findElement(By.xpath(actualXpath));
	    String id=element.getText();
		if(id.equals(propertyName1))
				{
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			String trash="//tr[" +i+"]//a[@class='submitdelete'][contains(text(),'Trash')]";
			WebElement trashClick = driver.findElement(By.xpath(trash));
			trashClick.click();
			break;
			}
		}
	}

	// RETC_052_4.b Assert message
	@FindBy(xpath = "//*[@id='message']/p")
	private WebElement assertUndoMess;

	public String assertMessageOnUndo() {
		String str1 = assertUndoMess.getText();
		return str1;
	}

	// RETC_052_5. Click on Trash link
	@FindBy(xpath = "//*[@id='wpbody-content']/div[3]/ul/li[4]")
	private WebElement trashPropertyForDelete;

	public void alltrashPropertyDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		this.trashPropertyForDelete.click();
	}

	// RETC_052_6 Mouse over property details and RETC_052_7.a Click on Delete Permanently
	
	public void mouseOverOneProperty(String propertyName1) {
		List<WebElement> row = driver.findElements(By.xpath("//table/tbody[@id='the-list']/tr"));//will get the row count as 20 webelements
		String beforeXpath = "//table/tbody[@id='the-list']/tr[";
		String afterXpath = "]/td[1]";
		for (int i = 1; i <= row.size(); i++) {
		String actualXpath = beforeXpath+i+afterXpath;
		WebElement element = driver.findElement(By.xpath(actualXpath));
	    String id=element.getText();
		if(id.equals(propertyName1))
				{
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			String trash="//tr[" +i+"]//a[@class='submitdelete'][contains(text(),'Delete Permanently')]";
			WebElement delPermanentlyClick = driver.findElement(By.xpath(trash));
			delPermanentlyClick.click();
			break;
			}
		}
	}
	// RETC_052_7.b Assert message of Delete Permanently
	@FindBy(xpath = "//*[@id='message']/p")
	private WebElement assertDelMessage;

	public String assertMessageDel() {
		String str1 = assertDelMessage.getText();
		return str1;
	}

}