package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewRegionPage {
	private WebDriver driver;

	public AddNewRegionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// RETC_085_3.Enter Valid Credentials in Name textbox
	@FindBy(xpath="//*[@id='tag-name']")
	private WebElement regionName;

	public void enterRegionNameText(String regionName) {
		this.regionName.sendKeys(regionName);
	}
	// RETC_085_4.Enter Valid Credentials in Slug textbox
	@FindBy(xpath="//*[@id='tag-slug']")
	private WebElement slugName;

	public void enterSlugText(String slugName) {
		this.slugName.sendKeys(slugName);
	}
	// RETC_085_5 and RETC_085_6.Click on Parent Region and Select Valid credentials in Parent Region list box
	@FindBy(xpath="//*[@id='parent']")
	private WebElement parentRegion;

	public void selectParentRegion() {
		this.parentRegion.click();
		Select sc = new Select(parentRegion);
		sc.selectByVisibleText("Apartments");
	}
	// RETC_085_7.Enter Valid Credentials in Description textbox
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement enterDescription;

	public void enterDescriptionText(String enterDescription) {
		this.enterDescription.sendKeys(enterDescription);
	}
	//RETC_085_8. Click on Add New Region button
	@FindBy(xpath="//*[@id='submit']")
	private WebElement addNewRegionButton;

	public void addNewRegionButtonClick() {
		addNewRegionButton.click();
	}
	// Search for the added Region
	
}