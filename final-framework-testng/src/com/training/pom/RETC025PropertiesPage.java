package com.training.pom;

import java.awt.Desktop.Action;
import com.training.functional.tests.LoginTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC025PropertiesPage {
	private WebDriver driver;

	public RETC025PropertiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 1. Click on Properties link
	@FindBy(xpath = "//*[@id=\"menu-posts-property\"]/a/div[2]")
	private WebElement properties;

	public void clickProperties() {
		this.properties.click();
	}
	// 2. Click on All Properties link
	@FindBy(xpath = "//*[@id=\"menu-posts-property\"]/ul/li[2]/a")
	private WebElement allProperties;

	public void allProperties() {
		Actions action = new Actions(driver);
		action.moveToElement(this.allProperties).click().build().perform();
	}

	// 3. Click on All Dates list box
	@FindBy(xpath = "//select[@id='filter-by-date']")
	private WebElement allDates;

	public void addDates() {
		this.allDates.click();
	}

	// 4. Select valid credentials in All Dates list box
	@FindBy(xpath = "//select[@id='filter-by-date']")
	private WebElement date;

	public void validCredentialsInDateBox() {
		this.date.click();
		Select sc = new Select(date);
		sc.selectByVisibleText("March 2018");
	}

	// 5. Click on Filter button
	@FindBy(id = "post-query-submit")
	private WebElement filter;

	public void filterResult() {
		this.filter.click();
	}
	
	//6 To verify the properties for filter search result as Admin
		@FindBy(linkText="admin")
		private WebElement adminProperties;

		public String AdminProperties() {
			String str1=adminProperties.getText();
			System.out.println(str1);
			return str1;
		}


	
}