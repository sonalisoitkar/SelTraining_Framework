package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCategoryPage {
	private WebDriver driver;

	public AddNewCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// RETC_083_3..Enter Valid Credentials in Name textbox
	@FindBy(id = "tag-name")
	private WebElement categoryName;

	public void enterCategoryNameText(String categoryName) {
		this.categoryName.sendKeys(categoryName);
	}

	// RETC_085_4.Enter Valid Credentials in Slug textbox
	@FindBy(id = "tag-slug")
	private WebElement slugName;

	public void enterSlugText(String slugName) {
		this.slugName.sendKeys(slugName);
	}

	// RETC_085_5. Click on Parent Catagory
	@FindBy(id = "parent")
	private WebElement parentCatagory1;

	public void selectParentCatagory(String parentCatagory ) {
		this.parentCatagory1.click();
		Select sc = new Select(parentCatagory1);
		sc.selectByVisibleText(parentCatagory);
	}

//RETC_083_7.Enter Valid Credentials in Description textbox
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement enterDescription;

	public void enterDescriptionText(String enterDescription) {
		this.enterDescription.sendKeys(enterDescription);
	}
// Click on Add New Category button
		@FindBy(id = "submit")
		private WebElement addNewCategoryButton;

		public void addNewCategoryButtonClick() {
			addNewCategoryButton.click();
		}}
// Click on Posts link
// Click on Add New Posts link
//// Enter Valid credentials in Enter title here textbox
// Enter valid credentials in body textbox
// Click on Checkbox beside created category name of category section
// Click on Publish button