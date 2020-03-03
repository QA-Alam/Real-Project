package qa.dwr.my.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/mohammedalam/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.dwr.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement locator = driver.findElement(By.xpath("//*[text()='Decline Offers']"));
		js.executeScript("arguments[0].click();", locator);
		
		
		WebElement locato = driver.findElement(By.xpath("(//*[text()='United States'])[1]"));
		js.executeScript("arguments[0].click();", locato);
		
		WebElement locat = driver.findElement(By.xpath("(//a[text()='Canada'])[1]"));
		js.executeScript("arguments[0].click();", locat);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		WebElement mainMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accessible-megamenu-1583111042839-4']/text()")));
		actions.moveToElement(mainMenu).build().perform();
	
		
		
		
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'accessible-megamenu-1583111042839-4')]")));
		js.executeScript("arguments[0].click();", element);
		
		

    driver.quit();
	}

}
