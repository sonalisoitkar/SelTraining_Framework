package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewFeaturePageDisplayedInDB {
	private WebDriver driver;

	public AddNewFeaturePageDisplayedInDB(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// RETC_081_3.Enter Valid Credentials in Name textbox
	@FindBy(id="tag-name")
	private WebElement featureName;

	public void enterFeatureNameText(String featureName) {
		this.featureName.sendKeys(featureName);
	}
	// RETC_081_4.Enter Valid Credentials in Slug textbox
	@FindBy(id="tag-slug")
	private WebElement slugName;

	public void enterSlugText(String slugName) {
		this.slugName.sendKeys(slugName);
	}
	// RETC_081_5.Select details from Parent Feature list box
	@FindBy(id = "parent")
	private WebElement parentFeature;

	public void selectParentFeature() {
		this.parentFeature.click();
		Select sc = new Select(parentFeature);
		sc.selectByVisibleText("Test");
	}
	// RETC_081_6.Enter Valid Credentials in Description textbox
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement enterDescription;

	public void enterDescriptionText(String enterDescription) {
		this.enterDescription.sendKeys(enterDescription);
	}
	// RETC_081_7.Click on Add New Feature button
	@FindBy(id = "submit")
	private WebElement addNewFeatureButton;

	public void addNewFeatureButtonClick() {
		addNewFeatureButton.click();
	}
	// RETC_081_8.Login into Real Estate database
	// RETC_081_9.search feature details
	
	public String getfeaturename()
	{
		return this.featureName.getAttribute("value");
	}
	public String getslugName()
	{
		return this.slugName.getAttribute("value");
	}
	public String getenterDescription()
	{
		return this.enterDescription.getAttribute("value");
	}


	
}