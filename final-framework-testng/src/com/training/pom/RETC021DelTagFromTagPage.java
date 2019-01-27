package com.training.pom;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//posts->tags->click checkbox->click bulk action list->select delete->click apply
public class RETC021DelTagFromTagPage {
	private WebDriver driver;

	public RETC021DelTagFromTagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='menu-posts']/a/div[2]")
	private WebElement Posts;

	public void clickPosts() throws InterruptedException {
		System.out.println("Click on the Post Link");
		Thread.sleep(5000);
		this.Posts.click();
	}

	@FindBy(xpath="//a[@class='current']")
	private WebElement tags;

	public void clickTags() throws InterruptedException  {
		System.out.println("Click on the tags link");
			//Thread.sleep(5000);
			Actions action=new Actions(driver);
			action.moveToElement(tags).click().build().perform();
			Thread.sleep(5000);
			System.out.println("tags page");
	}

	@FindBy(xpath = "//input[@id='cb-select-606']")
	private WebElement checkbox;

	public void selectCheckBox() throws InterruptedException  {
		System.out.println("Click on the checkbox of the tag to be deleted");
		Thread.sleep(5000);
		this.checkbox.click();
	}

	@FindBy(id = "bulk-action-selector-top")
	private WebElement bulkselector;

	public void selectBulkList() {
		System.out.println("Click on Bulk Action list box");
		bulkselector.click();
		}
	
	

	@FindBy(id = "bulk-action-selector-top")
	private WebElement delete;

	public void deleteTag() {
		System.out.println("Select the delete dropdown value");
		Select sc = new Select(delete);
		sc.selectByVisibleText("Delete");
	}

	@FindBy(id = "doaction2")
	private WebElement apply;

	public void applyTag() {
		System.out.println("6. Click on Apply button");
		this.apply.click();	
	}
	@FindBy(xpath="//*[@id='message']/p")
	private WebElement deleteTags;

	public String AssertTag() throws InterruptedException {
		Thread.sleep(3000);
		String str1=deleteTags.getText();
		System.out.println(str1);
		return str1;
	}
}
