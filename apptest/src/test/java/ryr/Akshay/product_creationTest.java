package ryr.Akshay;

import org.testng.annotations.Test;


	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class product_creationTest {
		public static WebDriver driver;

		@BeforeClass
		public void setUp() {
			WebDriver driver = new FirefoxDriver(); // Initialize the WebDriver instance
			ryr.Akshay.product_creationTest.driver = driver; // Set the WebDriver instance

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

		@Test(priority = 1)
		public void f() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[4]/a/b")).click();//product
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsPDDiv\"]/div/span[1]/i")).click();//add button
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"prodName\"]")).sendKeys("GUI_AUTOMATION");
			
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"PDService\"]"));// Service dropdown
			Thread.sleep(2000);
			Select select = new Select(dropdown);
			String optionText = "QOS Policy";
			select.selectByVisibleText(optionText);
			System.out.println("Selected: " + optionText);
			
			//*[@id="policyTreeDiv"]/span[2]/div/button
			WebElement dropdownContainer39 = driver.findElement(By.xpath("//*[@id=\"policyTreeDiv\"]/span[2]/div/button"));
			dropdownContainer39.click();
			Thread.sleep(3000);
			String chargerule = "PCRF_Sprint6_PR_div";
			driver.findElement(By.xpath("//*[@id=\"policyTreeDiv\"]/span[2]/div/ul/li[2]/a/label")).click();
			System.out.println(chargerule);
			WebElement bodyElement = driver.findElement(By.tagName("body"));
			bodyElement.click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"descTB\"]")).sendKeys("GUI_AUTOMATION");// description
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[normalize-space()='ADD']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(2000);
			
			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
			 String message2 = messageconfirm1.getText(); 
			 Thread.sleep(2000);
			 int index = message2.indexOf('×');// Find the index of '×'
				String ActualOutput1 = message2.substring(index + 1).trim();
				System.out.println(ActualOutput1);
				
				String message1expected1 = "Product GUI_AUTOMATION added Successfully!";
				Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");
		}
		
		@Test(priority = 2)
		public void f1() throws InterruptedException {
		
			driver.findElement(By.xpath("//*[@id=\"tableBtnsPDDiv\"]/div/span[2]/i")).click();//refresh button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"PolicyProdTab_filter\"]/label/input")).sendKeys("GUI_AUTOMATION");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"PolicyProdTab\"]/tbody/tr/td[6]/i")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			
			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
			 String message2 = messageconfirm1.getText(); 
			 Thread.sleep(2000);
			 int index = message2.indexOf('×');// Find the index of '×'
				String ActualOutput1 = message2.substring(index + 1).trim();
				System.out.println(ActualOutput1);
				
				String message1expected1 = "Product deleted Successfully!";
				Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");

			
		}
	}


