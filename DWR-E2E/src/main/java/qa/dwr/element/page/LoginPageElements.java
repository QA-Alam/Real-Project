package qa.dwr.element.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.dwr.base.page.BaseTest;

public class LoginPageElements extends BaseTest {

	// Initializing the Page Objects:
	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//*[text()='United States'])[1]")
	@CacheLookup
	private WebElement ClickToprightCornerToSearchCountry;

	public WebElement getClickToprightCornerToSearchCountry() {
		return ClickToprightCornerToSearchCountry;

	}
	@FindBy(xpath = "(//a[text()='Canada'])[1]")
	@CacheLookup
	private WebElement SelectDesiredCountry;

	public WebElement getSelectDesiredCountry() {
		return SelectDesiredCountry;

	}
}
