package ryr.Akshay;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.testng.annotations.Test;

public class output_parameterTest {
	
		public static WebDriver driver;

		@BeforeClass
		public void setUp() {
			WebDriver driver = new FirefoxDriver(); // Initialize the WebDriver instance
			ryr.Akshay.output_parameterTest.driver = driver; // Set the WebDriver instance

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

		@Test(priority =1)
		public void f() throws InterruptedException {

			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[1]/a/b"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsDivId\"]/div/span[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"outputServiceSB\"]")).click();
			List<WebElement> Options1 = driver.findElements(By.xpath("//*[@id=\"outputServiceSB\"]/option[4]"));
			Thread.sleep(3000);
			String option11 = "QOS Policy";
			Options1.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option11);
			driver.findElement(By.xpath("//*[@id=\"categoryDiv\"]/span[2]/i")).click();
			driver.findElement(By.xpath("//*[@id=\"newoutputServiceSB\"]")).click();
			List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"newoutputServiceSB\"]/option[4]"));
			Thread.sleep(3000);
			String option22 = "QOS Policy";
			Options2.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option22);

			driver.findElement(By.xpath("//*[@id=\"categoryName\"]")).sendKeys("GUI_AUTOMATION10");

			driver.findElement(By.xpath("//*[@id=\"addCategoryModal\"]/div/div/div[2]/div/div[2]/button")).click();// button
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(5000);
			

			
			 driver.findElement(By.xpath("//*[@id=\"select2-categorySB-container\"]")).click();
		        // Locate the options within the dropdown
		        List<WebElement> districtOptions = driver.findElements(By.xpath("//ul[@id='select2-categorySB-results']/li"));

		        String optionToSelect = "GUI_AUTOMATION10";
		        for (WebElement option : districtOptions) {
		            if (option.getText().equals(optionToSelect)) {
		                option.click();
		                System.out.println("Selected option: " + optionToSelect);
		                break;
		            }
		        }
		     // parameter name
		     		driver.findElement(By.xpath("//*[@id=\"paramName_0\"]")).sendKeys("CounterExhaust1");
		     		// description
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_0\"]")).sendKeys("CounterExhaust1");
		     		

		     		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		     		driver.findElement(By.xpath("//*[@id=\"paramName_1\"]")).sendKeys("Normal1");
		     		// description
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_1\"]")).sendKeys("Normal1");

		     		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		     		driver.findElement(By.xpath("//*[@id=\"paramName_2\"]")).sendKeys("Threshold1");
		     		// description
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_2\"]")).sendKeys("Threshold11");

		     		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		     		driver.findElement(By.xpath("//*[@id=\"paramName_3\"]")).sendKeys("Threshold22");
		     		// description
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_3\"]")).sendKeys("Threshold22");

		     		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		     		driver.findElement(By.xpath("//*[@id=\"paramName_4\"]")).sendKeys("Threshold32");
		     		// description
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_4\"]")).sendKeys("Threshold32");

		     		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		     		driver.findElement(By.xpath("//*[@id=\"paramName_5\"]")).sendKeys("ThresholdExhaust1");
		     		// description
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_5\"]")).sendKeys("ThresholdExhaust1");
		     		Thread.sleep(3000);
		     		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		     		Thread.sleep(3000);
		     		driver.findElement(By.xpath("(//button[normalize-space()='Yes'])[1]")).click();
		     		Thread.sleep(3000);
		     		
		     		WebElement message = driver.findElement(By.xpath("//*[@id=\"dispMsgOP\"]/div/div"));
		    		String fullMessage = message.getText();
		    		int index = fullMessage.indexOf('×');// Find the index of '×'
		    		String ActualOutput = fullMessage.substring(index + 1).trim();// Extract the desired text
		    		System.out.println(ActualOutput);
		    		String ExpectedOutput = "Output Parameters added to Category \"GUI_AUTOMATION10\" Successfully !!!";
		    		Assert.assertTrue(ActualOutput.contains(ExpectedOutput), "Test mismatch");
		    		Thread.sleep(2000);
		}
		
		@Test(priority =2)
		public void f1() throws InterruptedException {
			//*[@id="navbar-collapse"]/ul[1]/li/a/i
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a/i")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[1]/a/b"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsDivId\"]/div/span[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"outputServiceSB\"]")).click();
			List<WebElement> Options1 = driver.findElements(By.xpath("//*[@id=\"outputServiceSB\"]/option[4]"));
			Thread.sleep(3000);
			String option11 = "QOS Policy";
			Options1.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option11);
			
	        driver.findElement(By.xpath("//*[@id=\"select2-categorySB-container\"]")).click();
	        // Locate the options within the dropdown
	        List<WebElement> districtOptions = driver.findElements(By.xpath("//ul[@id='select2-categorySB-results']/li"));

	        String optionToSelect = "GUI_AUTOMATION10";
	        for (WebElement option : districtOptions) {
	            if (option.getText().equals(optionToSelect)) {
	                option.click();
	                System.out.println("Selected option: " + optionToSelect);
	                break;
	            }
	        }
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//*[@id=\"deletecat\"]")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		}
		}




