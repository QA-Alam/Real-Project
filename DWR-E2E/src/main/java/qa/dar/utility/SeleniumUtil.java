package qa.dar.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 15;
	public WebDriver driver;
	static Workbook book;
	static Sheet sheet;

	public SeleniumUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static String TESTDATA_SHEET_PATH = "/Users/mohammedalam/eclipse-workspace/DAR-E2E/Test cases/Test_Cases_Automation.xlsx";

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static WebElement getExplicitWait(By locator, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	public static String captureScreenShot(WebDriver driver, String ScreenShotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		String dateTime = dateFormat.format(date.getTime());
		String destination = currentDir + "//Screen Shot//" + dateTime + "//" + ScreenShotName + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
		}
		return destination;
	}

	public void loader() {

		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.attributeContains(
					By.xpath("//*[@class='template loading-spinner-spp']"), "style", "display:none"));
		} catch (Exception e) {
		}
	}

	public void javScriptClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void actionClick(List<WebElement> element) {
		while (element.size() > 0) {
			Actions action = new Actions(driver);
			new Highlighter(driver).drawBorder(element.get(0), "red");
			action.moveToElement(element.get(0)).click(element.get(0)).build().perform();
			new SeleniumUtil(driver).loader();
			break;
		}
	}

	public void conditionActionClick(WebElement element, List<WebElement> list) {
		while (list.size() == 0) {
			System.out.println("list not found");
			Actions action = new Actions(driver);
			new Highlighter(driver).drawBorder(element, "red");
			action.moveToElement(element).click(element).build().perform();
			try {
				Thread.sleep(3000);
				new SeleniumUtil(driver).explicitClick(list.get(0));
			} catch (InterruptedException e) {
			}
			if (list.size() > 0) {
				System.out.println("Got my list element");
				break;
			}
		}
	}

	public void explicitClick(WebElement element) {
		try {
			Thread.sleep(3000);
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
		}
	}

	public void explicitVisible(WebElement element) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		}
	}

	public List<String> getListElementText(List<WebElement> element) {
		List<String> list = new ArrayList<>();
		element.forEach(name -> {
			list.add(name.getAttribute("innerText"));
		});
		return list;
	}

	public List<Double> getListElementValue(List<WebElement> element) {
		List<Double> list = new ArrayList<>();
		list = element.stream().map(e -> e.getAttribute("innerText")).map(e -> e.replaceAll("[^0-9.]", ""))
				.map(e -> Double.parseDouble(e)).collect(Collectors.toList());
		return list;
	}
}