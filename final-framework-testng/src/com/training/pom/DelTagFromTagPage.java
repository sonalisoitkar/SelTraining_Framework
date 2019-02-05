package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//posts->tags->click checkbox->click bulk action list->select delete->click apply
public class DelTagFromTagPage {
	private WebDriver driver;

	public DelTagFromTagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// 1. Mouse over on Posts link

	@FindBy(xpath = "//*[@id='menu-posts']/a/div[2]")
	private WebElement Posts;

	public void clickPosts() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(Posts).click().build().perform();
		this.Posts.click();
	}

//2. Click on Add New link
	@FindBy(xpath = "//a[@href='edit-tags.php?taxonomy=post_tag']")
	private WebElement tags;

	public void clickTags() throws InterruptedException {
		tags.click();
	}

	// 3. click on Add New Category link of category section
	@FindBy(xpath = "//input[@id='cb-select-547']")
	private WebElement checkbox;

	public void selectCheckBox() throws InterruptedException {
		this.checkbox.click();
	}

//4. enter valid details in textbox
	@FindBy(id = "bulk-action-selector-top")
	private WebElement bulkselector;

	public void selectBulkList() {
		bulkselector.click();
	}

	// 5. Select value from Parent Category list box

	@FindBy(id = "bulk-action-selector-top")
	private WebElement delete;

	public void deleteTag() {
		Select sc = new Select(delete);
		sc.selectByVisibleText("Delete");
	}

//6. Click on Add New category button
	@FindBy(id = "doaction2")
	private WebElement apply;

	public void applyTag() {
		this.apply.click();
	}

	// 7. Refresh the page
	@FindBy(xpath = "//*[@id='message']/p")
	private WebElement deleteTags;

	public String AssertTag() throws InterruptedException {
		Thread.sleep(3000);
		String str1 = deleteTags.getText();
		return str1;
	}
}
