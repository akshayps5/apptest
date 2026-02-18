package ryr.Akshay;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class sub_mgmtTest {

	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriver driver = new FirefoxDriver(); // Initialize the WebDriver instance
		ryr.Akshay.sub_mgmtTest.driver = driver; // Set the WebDriver instance

		driver.get("https://10.0.6.20:8443/tssgui/welcome/jsp/HomePage_Main.jsp#");

		// Set implicit wait to 10 seconds
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// Check if the "Advanced" button is present
		List<WebElement> advancedButton = driver.findElements(By.xpath("//*[@id='details-button']"));
		if (advancedButton.size() > 0) {
			// Click the "Advanced" button and then click the "Proceed" link
			driver.findElement(By.cssSelector("#details-button")).click();
			driver.findElement(By.cssSelector("#proceed-link")).click();
		}

		// Perform login steps
		try {
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
			driver.findElement(By.xpath("//*[@id=\"passdiv\"]/div/input")).sendKeys("admin123");
			driver.findElement(By.xpath("//*[@id=\"subBtn\"]")).click();
		} catch (Exception e) {
			System.err.println("Error during login: " + e.getMessage());
			e.printStackTrace();
		}
	}

//		@AfterClass
//		public void tearDown() {
//			if (driver != null) {
//				driver.quit();
//			}
//		}

	@Test
	public void f() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[5]/div/div[2]/ul/li[3]/a/b"))
				.click();
		Thread.sleep(2000);
		// add button
		driver.findElement(By.xpath("//*[@id=\"tableBtnsSubsDiv\"]/div/span[1]/i")).click();
		Thread.sleep(2000);
		// *************************subscriberprofile**********************************************

		driver.findElement(By.xpath("//*[@id=\"Pcrf_SubsProfileRowDiv\"]/div[1]/div[1]/span[2]/span[1]/span")).click();
		Thread.sleep(5000);
		// service
//			WebElement dropdown = driver.findElement(By.id("select2-serviceSB-container"));
//			((JavascriptExecutor) driver).executeScript("arguments[1].scrollIntoView(true);", dropdown);
//			dropdown.click();

		WebElement dropdown = driver.findElement(
				By.xpath("//*[@id=\"Pcrf_SubsProfileRowDiv\"]/div[1]/div[1]/span[2]/span[1]/span/span[2]"));
		dropdown.click();
		// Thread.sleep(3000);
		driver.findElement(By.id("select2-serviceSB-container")).click();
		String kotapack = "Broadband";
		WebElement optionToSelect = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack + "')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(optionToSelect).click().build().perform();

		driver.findElement(By.xpath("//*[@id=\"serviceNum\"]")).sendKeys("96385214");
		// subscription type
		driver.findElement(By.xpath("//*[@id=\"select2-subsTypeSB-container\"]")).click();
		List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"select2-subsTypeSB-results\"]"));
		String option22 = "Prepaid";
		Options2.get(0).click(); // Click on the first option
		System.out.println(" selected: " + option22);
		Thread.sleep(3000);

		// BROADBAND DETAILS

		driver.findElement(By.xpath("//*[@id=\"viewBBDiv\"]")).click();
		// USERNAME
		driver.findElement(By.xpath("//*[@id=\"bbUserName\"]")).sendKeys("broadbandusername");
		driver.findElement(By.xpath("//*[@id=\"bbPassword\"]")).sendKeys("username12309");

		// mac binding
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"broadbandBodyDiv\"]/div[2]/div[4]/div/span"));
		if (!checkbox1.isSelected()) {
			checkbox1.click();
		}
		driver.findElement(By.xpath("//*[@id=\"bbMacId_1\"]")).sendKeys("AB:a9:8D:dB:53:7a");

		driver.findElement(By.xpath("//*[@id=\"ipPoolName\"]")).sendKeys("profile10");
		driver.findElement(By.xpath("//*[@id=\"dnsProfile\"]")).sendKeys("profile20");

		// expire date
		String dateTime = "12/07/2014 2:00 PM";
		WebElement selectexpate = driver.findElement(By.xpath("//*[@id=\"expDateDiv\"]/div/span/i"));
		selectexpate.click();

		WebElement nextLink = driver
				.findElement(By.xpath("/html/body/div[5]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]"));

		driver.findElement(By.xpath("//*[@id=\"language\"]")).sendKeys("hindi");
		// driver.findElement(By.xpath("//*[@id=\"imeiNum\"]")).sendKeys("123456789111111");
		driver.findElement(By.xpath("//*[@id=\"homezone\"]")).sendKeys("india");
		driver.findElement(By.xpath("//*[@id=\"cosId\"]")).sendKeys("2");

		// connection profile
		driver.findElement(By.xpath("//*[@id=\"select2-connProfile-container\"]")).click();
		List<WebElement> Options3 = driver.findElements(By.xpath("//*[@id=\"select2-connProfile-results\"]"));
		String option33 = "profile_two";
		Options3.get(0).click(); // Click on the first option
		System.out.println(" selected: " + option33);

		// status
		driver.findElement(By.xpath("//*[@id=\"select2-status-container\"]")).click();
		List<WebElement> Options4 = driver.findElements(By.xpath("//*[@id=\"select2-status-results\"]"));
		String option44 = "Active";
		Options4.get(0).click(); // Click on the first option
		System.out.println("selected: " + option44);

		// Locate the checkbox element using its ID, name, XPath, or other methods
		WebElement checkbox = driver
				.findElement(By.xpath("//*[@id=\"Pcrf_SubsProfileRowDiv\"]/div[3]/div[10]/div/div"));

		// Check the checkbox if it is not already checked
		if (!checkbox.isSelected()) {
			checkbox.click();
		}

		// add button
		driver.findElement(By.xpath("//*[@id=\"viewSubsHeadDiv\"]")).click();

		// demography details

		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("megha");
		driver.findElement(By.xpath("//*[@id=\"middleName\"]")).sendKeys("kedar");
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("kariya");
		driver.findElement(By.xpath("//*[@id=\"businessName\"]")).sendKeys("adhjd");

		// GENDER DROPDOWN
		WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"genderSB\"]"));
		Select dropdown25 = new Select(dropdownElement);
		dropdown25.selectByVisibleText("FEMALE");

		driver.findElement(By.xpath("//*[@id=\"occupation\"]")).sendKeys("teacher");
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("mgroad");
		driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("trinity ");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("banglore");
		driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("karnataka");
		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("565654");

		// COUNTRY DROPDOWN
		driver.findElement(By.xpath("//*[@id=\"select2-countrySB-container\"]")).click();
		List<WebElement> Options5 = driver.findElements(By.xpath("//*[@id=\"select2-countrySB-results\"]"));
		String option55 = "Algeria";
		Options5.get(0).click(); // Click on the first option
		System.out.println(" selected: " + option55);

		// nationality DROPDOWN
		driver.findElement(By.xpath("//*[@id=\"select2-nationalitySB-container\"]")).click();
		List<WebElement> Options6 = driver.findElements(By.xpath("//*[@id=\"select2-nationalitySB-results\"]"));
		String option66 = "Angola";
		Options6.get(0).click(); // Click on the first option
		System.out.println(" selected: " + option66);

		driver.findElement(By.xpath("//*[@id=\"contactNum\"]")).sendKeys("12345678");
		driver.findElement(By.xpath("//*[@id=\"altContactNum\"]")).sendKeys("1234579");
		driver.findElement(By.xpath("//*[@id=\"mailId\"]")).sendKeys("sample@example.com");
		driver.findElement(By.xpath("//*[@id=\"altMailId\"]")).sendKeys("samplee@example.com");
		// driver.findElement(By.xpath("//*[@id=\"extendedInfo\"]")).sendKeys("abcd");

		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		Thread.sleep(3000);

		WebElement textElement = driver.findElement(By.xpath("//*[@id=\"dispMsgCust\"]/div/div"));
		String actualOutput1 = textElement.getText();
		System.out.println(actualOutput1);
		// String actualOutputPrefix = actualOutput1.split("Success")[0].trim();
		String expectedOutput = "Create Subscriber Profile Success";
		// Assert.assertEquals(actualOutput1.contains(expectedOutput), "Test mismatch");
		Assert.assertEquals(actualOutput1, expectedOutput, "Test mismatch");
	}

}
