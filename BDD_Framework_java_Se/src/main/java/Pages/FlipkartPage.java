package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FlipkartPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	public FlipkartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='q']")
	private WebElement searchField;
	public void enterSearchField(String value) {
		wait.until(ExpectedConditions.visibilityOf(searchField));
		searchField.sendKeys(value);
		searchField.sendKeys(Keys.ENTER);
	}


	@FindBy(xpath="(//div[contains(text(),'Acer Aspire')])[1]")
	private WebElement product;
	public void ClickOnTheProduct() {
		wait.until(ExpectedConditions.visibilityOf(product));
		wait.until(ExpectedConditions.elementToBeClickable(product));
		product.click();
	}

	@FindBy(className="B_NuCI")
	private WebElement productText;

	public String GetProductText() {
	return 	productText.getText();
	}

	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	private WebElement AddToCartBtn;
	public void ClickOnAddToCartBtn() {
		wait.until(ExpectedConditions.visibilityOf(AddToCartBtn));
		wait.until(ExpectedConditions.elementToBeClickable(AddToCartBtn));
		AddToCartBtn.click();
	}
	public void ClickOnAddToCart() {
		AddToCartBtn.click();
	}
	public String GetTitle() {
		return driver.getTitle();
	}

	public void switchTab(WebDriver driver, int tabIndex) {
		// Get all window handles (tabs)
		var windowHandles = driver.getWindowHandles();

		// Check if the requested tab index is valid
		if (tabIndex < 0 || tabIndex >= windowHandles.size()) {
			throw new IllegalArgumentException("Invalid tab index: " + tabIndex);
		}

		// Convert window handles set to array and get the handle at the specified index
		var handlesArray = windowHandles.toArray(new String[0]);
		var handle = handlesArray[tabIndex];

		// Switch to the tab with the specified handle
		driver.switchTo().window(handle);

	}
	public void wait(int timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}
	@FindBy(xpath="//button[normalize-space()='Place Order']")
	private WebElement PlaceOrderBtn;
	public void ClickOnPlaceOrderBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(PlaceOrderBtn));
		PlaceOrderBtn.click();
	}


}
