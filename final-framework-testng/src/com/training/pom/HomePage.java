package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click on Real Estate icon
	@FindBy(xpath = "//a[@title='Real Estate']")
	private WebElement realEstateIcon;

	public void clickIcon() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(realEstateIcon).click().perform();
		this.realEstateIcon.click();
	}
	//search for added property
	@FindBy(xpath = "//*[@id=\"ajaxsearchlite1\"]/div/div[3]/form/input[1]")
	private WebElement searchProperty;

	public void searchAddedProperty(String searchProperty) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		this.searchProperty.sendKeys(searchProperty);
	}
	}
