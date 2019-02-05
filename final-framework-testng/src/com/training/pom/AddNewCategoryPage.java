package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Mouse over posts->Add new->Add New Category->Enter Details->Select Value->click button->Refresh page->EnterTitle values->
Enter Body Values->Click Checkbox->Publish Buton*/
public class AddNewCategoryPage {
	private WebDriver driver;

	public AddNewCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//3. click on Add New Category link of category section
	@FindBy(xpath = "//a[@id='category-add-toggle']")
	private WebElement addNewCategoryButton;

	public void addNewCategoryButtonClick() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		addNewCategoryButton.click();
	}

//4. enter valid details in textbox
	@FindBy(id = "newcategory")
	private WebElement categoryTestBox;

	public void enterCategoryTestBox(String categoryTestBox) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		this.categoryTestBox.click();
		this.categoryTestBox.sendKeys(categoryTestBox);
	}

	// 5. Select value from Parent Category list box

	@FindBy(xpath = "//*[@id='newcategory_parent']")
	private WebElement parentCategory;

	public void selectParentCategory() {
		Select sc = new Select(parentCategory);
		sc.selectByVisibleText("New Launches");
	}

	// 6. Click on Add New category button
	@FindBy(xpath = "//*[@id=\"category-add-submit\"]")
	private WebElement addNewCategory;

	public void addNewCatagoryClick() {
		addNewCategory.click();
	}

	// 7. Refresh the page
	public void refreshPageView() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	// 8. Enter Valid credentials in Enter title here textbox
	@FindBy(xpath = "//input[@id='title']")
	private WebElement title;

	public void enterTitle(String title) {
		this.title.sendKeys(title);
	}

	// 9. Enter valid credentials in body textbox
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement textBody;

	public void enterTextBody(String textBody) {
		this.textBody.sendKeys(textBody);
	}

	// 10. Click on checkbox beside created category
	@FindBy(xpath = "//input[@id='in-category-1']")
	private WebElement createdCategory;

	public void createdCategorySelected() {
		createdCategory.click();
	}

	// 11. Click on Publish button
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publish;

	public void publishButton() throws InterruptedException  {
		Thread.sleep(3000);
		publish.click();

	}

	// 13 To verify the added user with successful message.
	@FindBy(xpath = "//*[@id='message']/p")
	private WebElement assertMessage;

	public String assertPublish() throws InterruptedException {
		Thread.sleep(3000);
		String str1 = assertMessage.getText();
		return str1;
	}
}
