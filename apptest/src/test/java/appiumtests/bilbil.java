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
	import io.appium.java_client.touch.TapOptions;
	import io.appium.java_client.touch.offset.PointOption;
	import io.appium.java_client.TouchAction;
	 
	public class bilbil {
	 
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
	    public void testBillPayFlow() throws InterruptedException {
	        try {
	        	try {
		            WebElement gettingStartedButton = wait.until(ExpectedConditions
		                    .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
		            gettingStartedButton.click();
		            System.out.println("Clicked on 'Getting Started' button.");
		            Assert.assertNotNull(gettingStartedButton, "'Getting Started' button was not clicked successfully.");
		        } catch (Exception e) {
		            System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
		            Assert.fail("Failed to click on 'Getting Started' button.");
		        }
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
					mobileNumberField.sendKeys("17711482");
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
 
	 
	            // Click on the Billpay icon
	            WebElement billpayIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.ImageView[contains(@content-desc,'Bill Payment')]")));
	            billpayIcon.click();
	            System.out.println("Billpay icon clicked.");
	 
	                       // Click on dropdown box to choose bill type
	            WebElement dropdownBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Button[contains(@content-desc,'Broadband')]")));
	            dropdownBox.click();
	            System.out.println("Clicked on dropdown box.");
	 
	              // Select "Broadband" from dropdown
	            WebElement broadbandOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.view.View[contains(@content-desc,'Broadband')]")));
	            broadbandOption.click();
	            System.out.println("Selected 'Broadband' option.");
	 
	            try {
		            // Locate and interact with the first amount field
		            WebElement enterAmountContainer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		                "//android.view.View[contains(@content-desc, 'Enter Broadband')]")));
		            WebElement avlbal1 = enterAmountContainer1.findElement(By.xpath(".//android.widget.EditText"));
	 
		            Assert.assertTrue(avlbal1.isDisplayed(), "First amount field is not displayed.");
		            Assert.assertTrue(avlbal1.isEnabled(), "First amount field is not enabled.");
		            avlbal1.click();
		            avlbal1.sendKeys("post8080"); // Enter the amount in the first field
		            System.out.println("First amount field clicked and amount entered.");
		        } catch (Exception e) {
		            System.err.println("Failed to enter amount in the first field: " + e.getMessage());
		            Assert.fail("First amount field not displayed or clickable.");
		        }
	 
	            // Click on "Get Bill Amount" button
	            WebElement getBillAmountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Button[@content-desc='Get Bill Amount']")));
	            getBillAmountButton.click();
	            System.out.println("Clicked on 'Get Bill Amount'");
	 
	        } catch (Exception e) {
	            System.err.println("An error occurred: " + e.getMessage());
	            Assert.fail("Test failed due to exception: " + e.getMessage());
	        }
	    }
	 
	    @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit(); // Quit the driver after execution
	        }
	   }
	}


