package StepDefinations;

import Factory.DriverFactory;
import Pages.FlipkartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class FlipkartSteps {
public FlipkartPage flipkartPage;

	WebDriver driver;


	@When("Verify that the homepage loads successfully.")
	public void verify_that_the_homepage_loads_successfully() {
		driver=DriverFactory.getDriver();
		flipkartPage = new FlipkartPage(driver);
		Assert.assertEquals(flipkartPage.GetTitle(),"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");

	}

	@Given("User search {string} and press Enter.")
	public void user_search_and_press_enter(String string) {
		driver=DriverFactory.getDriver();
		flipkartPage = new FlipkartPage(driver);
		flipkartPage.enterSearchField(string);
	}

	@When("User Click on one of the search results to view the product details.")
	public void user_click_on_one_of_the_search_results_to_view_the_product_details() {
		driver=DriverFactory.getDriver();
		flipkartPage = new FlipkartPage(driver);
		flipkartPage.ClickOnTheProduct();
		flipkartPage.wait(10);

	}

	@Then("User Add the selected laptop to the shopping cart.")
	public void user_add_the_selected_laptop_to_the_shopping_cart() {
		driver=DriverFactory.getDriver();
		flipkartPage = new FlipkartPage(driver);
		flipkartPage.switchTab(driver,1);
		flipkartPage.ClickOnAddToCartBtn();
		flipkartPage.ClickOnAddToCart();

	}
	@When("User Navigate to the shopping cart.")
	public void user_navigate_to_the_shopping_cart() {
		driver=DriverFactory.getDriver();
		flipkartPage = new FlipkartPage(driver);
		Assert.assertTrue(flipkartPage.GetTitle().contains("Acer Aspire "));
	}

	@When("Verify that the correct item is in the cart.")
	public void verify_that_the_correct_item_is_in_the_cart() {
		driver=DriverFactory.getDriver();
		flipkartPage = new FlipkartPage(driver);
		Assert.assertTrue(flipkartPage.GetProductText().contains("Acer Aspire"));
	}

	@Then("Click on the Proceed to Checkout button.")
	public void click_on_the_proceed_to_checkout_button() {
		driver=DriverFactory.getDriver();
		flipkartPage = new FlipkartPage(driver);
		flipkartPage.switchTab(driver,1);
		flipkartPage.ClickOnPlaceOrderBtn();
		Assert.assertEquals(flipkartPage.GetTitle(),"Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order");
	}



}
