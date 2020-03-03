package qa.dwr.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import qa.dwr.base.page.BaseTest;
import qa.dwr.element.page.LoginPageElements;

public class StepDefinition extends BaseTest {
	LoginPageElements element;

	@Given("^Launch web site$")
	public void launch_web_site() {
		initialization();
		element = new LoginPageElements();
	}

	@Given("^Click on Ship to Locale option from Top right to search for user's desired country$")
	public void click_on_Ship_to_Locale_option_from_Top_right_to_search_for_user_s_desired_country() {
		element.getClickToprightCornerToSearchCountry().click();
		element.getSelectDesiredCountry().click();
	}

	@Given("^Enter the Locale and select the respective locale\\. Validate user is able to select desired locale\\.$")
	public void enter_the_Locale_and_select_the_respective_locale_Validate_user_is_able_to_select_desired_locale() {

	}

	@Given("^Validate user remains on site as Guest user when not logged in\\.$")
	public void validate_user_remains_on_site_as_Guest_user_when_not_logged_in() {

	}

	@Given("^Navigate to categories from top\\. Click on Category\"([^\"]*)\"Validate user redirects to category page with list of products\\.$")
	public void navigate_to_categories_from_top_Click_on_Category_Validate_user_redirects_to_category_page_with_list_of_products(
			String Itame) {

	}

	@When("^Click on any product to add it to bag\\. Validate product is added to bag successfully\\.$")
	public void click_on_any_product_to_add_it_to_bag_Validate_product_is_added_to_bag_successfully() {

	}

	@When("^View bag & checkout\\. Validate user lands on Cart/Shopping page\\.$")
	public void view_bag_checkout_Validate_user_lands_on_Cart_Shopping_page() {

	}

	@When("^On Cart page, Validate product details should be displayed\\.$")
	public void on_Cart_page_Validate_product_details_should_be_displayed() {

	}

	@When("^Validate correct product image, Name, Price, Quantity on shopping page\\.$")
	public void validate_correct_product_image_Name_Price_Quantity_on_shopping_page() {

	}

	@When("^Validate the Size and Color of Product should be mentioned correct on Shopping Bag page\\.$")
	public void validate_the_Size_and_Color_of_Product_should_be_mentioned_correct_on_Shopping_Bag_page() {

	}

	@When("^Validate Shopping bag has template containing Order sub-total, Discount \\(If any\\), Shipping & Handling charges, Estimated Tax and Grand Total of the order\\.$")
	public void validate_Shopping_bag_has_template_containing_Order_sub_total_Discount_If_any_Shipping_Handling_charges_Estimated_Tax_and_Grand_Total_of_the_order() {

	}

	@Then("^Validate the Price, currency  and calculation of product should be correct\\.$")
	public void validate_the_Price_currency_and_calculation_of_product_should_be_correct() {

	}

	@Given("^Login with valid credentials from My Account\\. Validate user is able to login successfully\\.$")
	public void login_with_valid_credentials_from_My_Account_Validate_user_is_able_to_login_successfully() {

	}

	@Given("^Navigate to categories from top click on category\"([^\"]*)\"validate user redirects to category page with list of products\\.$")
	public void navigate_to_categories_from_top_click_on_category_validate_user_redirects_to_category_page_with_list_of_products(
			String arg1) {
		driver.quit();
	}

}
