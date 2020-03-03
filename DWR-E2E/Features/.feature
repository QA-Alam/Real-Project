@guestUser
Feature: Guest User: Validate Product & Order details on Shopping Bag with Single Line Items

Scenario: Validate the Price, currency  and calculation of product should be correct.
	Given Launch web site
	And Click on Ship to Locale option from Top right to search for user's desired country  
	And Enter the Locale and select the respective locale. Validate user is able to select desired locale.
	And Validate user remains on site as Guest user when not logged in.
	And Navigate to categories from top.Click on Category"<item>"Validate user redirects to category page with list of products.
	When Click on any product to add it to bag. Validate product is added to bag successfully.
	And View bag & checkout. Validate user lands on Cart/Shopping page.
	And On Cart page, Validate product details should be displayed.
	And Validate correct product image, Name, Price, Quantity on shopping page.
	And Validate the Size and Color of Product should be mentioned correct on Shopping Bag page.
	And Validate Shopping bag has template containing Order sub-total, Discount (If any), Shipping & Handling charges, Estimated Tax and Grand Total of the order. 
	Then Validate the Price, currency  and calculation of product should be correct. 

@RegisteredUser	
Scenario: Registered User: Validate Product & Order details on Shopping Bag with Single Line Items		
	Given Launch web site
	And Click on Ship to Locale option from Top right to search for user's desired country   
	And Enter the Locale and select the respective locale. Validate user is able to select desired locale.
	And Login with valid credentials from My Account. Validate user is able to login successfully.
	And Navigate to categories from top. Click on Category"<item>"Validate user redirects to category page with list of products.
	When Click on any product to add it to bag. Validate product is added to bag successfully.
	And View bag & checkout. Validate user lands on Cart/Shopping page.
	And On Cart page, Validate product details should be displayed.
	And Validate correct product image, Name, Price, Quantity on shopping page.
	And Validate the Size and Color of Product should be mentioned correct on Shopping Bag page.
	And Validate Shopping bag has template containing Order sub-total, Discount (If any), Shipping & Handling charges, Estimated Tax and Grand Total of the order. 
	Then Validate the Price, currency  and calculation of product should be correct. 
	
	
	
	
	
	