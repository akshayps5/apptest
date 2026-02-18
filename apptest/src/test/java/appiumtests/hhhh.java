package appiumtests;


	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.remote.MobilePlatform;
	 
	public class hhhh {
	 
	    private AndroidDriver driver;
	    private WebDriverWait wait;
	 
	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	        // Set desired capabilities
	        DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	        cap.setCapability("appPackage", "com.bt.mybt");  // Replace with your app package
	        cap.setCapability("appActivity", ".MainActivity");  // Replace with your app activity
	 
	        // Initialize the AndroidDriver for Appium
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    }
	 
	    @Test
	    public void testRechargeFlow() throws InterruptedException {
	    	 try {
	             // Locate and click the "Getting Started" button
	             WebElement gettingStartedButton = wait.until(ExpectedConditions
	                     .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
	             gettingStartedButton.click();
	             System.out.println("Clicked on 'Getting Started' button.");
	             // Validation: Check if "Getting Started" button is clicked
	             Assert.assertNotNull(gettingStartedButton, "'Getting Started' button was not clicked successfully.");
	         } catch (Exception e) {
	             System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
	             Assert.fail("Failed to click on 'Getting Started' button.");
	         }
	 
	         try {
	             // Enter mobile number
	        	 	try {
						System.out.println("Waiting for the mobile number field to appear...");
						WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
								"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));

						// Assert that the mobile number field is found and visible
						Assert.assertNotNull(mobileNumberField, "Mobile number field is not found!");
						Assert.assertTrue(mobileNumberField.isDisplayed(), "Mobile number field is not visible!");

						// Interact with the mobile number field
						mobileNumberField.click();
						Thread.sleep(2000);
						mobileNumberField.sendKeys("17112050");
						System.out.println("Value sent to mobile number field.");

					} catch (Exception e) {
						System.err.println("Failed to locate the mobile number field: " + e.getMessage());
						Assert.fail("Mobile number field is not clickable or found.");
					}
					// Password Field
					try {
						System.out.println("Waiting for the password field to appear...");
						WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
								"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));

						// Assert that the password field is found and visible
						Assert.assertNotNull(pwd, "Password field is not found!");
						Assert.assertTrue(pwd.isDisplayed(), "Password field is not visible!");

						// Interact with the password field
						pwd.click();
						Thread.sleep(2000);
						pwd.sendKeys("2580");
						System.out.println("Value sent to password field.");

					} catch (Exception e) {
						System.err.println("Failed to locate the password field: " + e.getMessage());
						Assert.fail("Password field is not clickable or found.");
					}
	 
	             // Click on the Transaction purchase icon
	             WebElement transactionIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                     "//android.widget.ImageView[contains(@content-desc,'Transaction')]")));
	             transactionIcon.click();
	             System.out.println("Transaction History icon clicked.");
	 
	            // Step 6: Click on Self Care
	            //WebElement selfCareIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	          //          "//android.widget.ImageView[@content-desc='Self Care']")));
	            WebElement selfCareIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.ImageView[@content-desc='B-Ngul']")));
	            selfCareIcon.click();
	            System.out.println("b nugal icon clicked.");
	 
	            // Step 7: Click on Filter to select Date
	            WebElement filterDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.view.View[@content-desc='Filter']/android.widget.ImageView")));
	            filterDate.click();
	            System.out.println("Date filter clicked.");

	            // Step 9: Select Year (2023)
	            WebElement selectYearButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "(//android.widget.Button[@content-desc='Select year'])[2]")));
	            selectYearButton.click();
	            WebElement year2023 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Button[@content-desc='2022']")));
	            year2023.click();
	            System.out.println("Year 2023 selected.");
	 
	            // Step 8: Select Month (October)
	            WebElement selectMonthButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "(//android.widget.Button[@content-desc='Select year'])[1]")));
	            selectMonthButton.click();
	            WebElement monthOctober = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Button[@content-desc='Oct']")));
	            monthOctober.click();
	            System.out.println("Month October selected.");
	 
	            // Step 10: Select Date Range (1st Oct 2023 to 17th Oct 2024)
	            WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.view.View[@content-desc='1, Tuesday, October 1, 2023']")));
	            startDate.click();
	            WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.view.View[@content-desc='17, Thursday, October 17, 2024']")));
	            endDate.click();
	            System.out.println("Date range selected: 1st Oct 2023 to 17th Oct 2024.");
	 
	            // Step 11: Click OK
	            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.view.View[@content-desc='OK']")));
	            okButton.click();
	            System.out.println("OK button clicked.");
	 
	            // Step 12: Handle pop-up if no transactions found
	            WebElement noTransactionsPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//android.view.View[@content-desc='Info no transactions found']")));
	            WebElement closePopupButton = noTransactionsPopup.findElement(By.xpath(
	                    ".//android.widget.Button"));
	            closePopupButton.click();
	            System.out.println("No transactions found popup closed.");
	 
	        } catch (Exception e) {
	            System.err.println("An error occurred during the test: " + e.getMessage());
	            Assert.fail("Test failed due to an exception: " + e.getMessage());
	        }
	    }
	 
	   // @AfterTest
	    //public void tearDown() {
	      //  if (driver != null) {
	        //    driver.quit();
	     //   }
	    //}
	}

