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

	public class prarth {

	    private AndroidDriver driver;
	    private WebDriverWait wait;

	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	        // Set desired capabilities
	    	DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
			cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

			// Initialize the AndroidDriver for Appium
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

			// Use WebDriverWait to wait for elements
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

			try {
				// Handle "Getting Started" button if it appears
				try {
					WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
					gettingStartedButton.click();
					System.out.println("Clicked on 'Getting Started' button.");
				} catch (Exception e) {
					System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
				}

				// Wait for the mobile number field to appear and interact with it
				System.out.println("Waiting for the mobile number field to appear...");
				// Use a stable XPath or resource ID for mobile number field
				WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
				; // Adjusted for content-desc or use resource-id
				mobileNumberField.click();
				Thread.sleep(2000); // Small delay before entering text

				// Send value to the mobile number field
				mobileNumberField.sendKeys("17114003");
				System.out.println("Value sent to mobile number field.");
				Thread.sleep(2000);
				try {
					// Locate the EditText field using the provided XPath
					System.out.println("Waiting for the mobile number field to appear...");
					WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
					pwd.click();
					// Send value to the mobile number field
					Thread.sleep(2000); // Wait for 1 second before interacting
					pwd.sendKeys("2580");
					System.out.println("Value sent to pwd field.");
				} catch (Exception e) {
					System.err.println("Failed to locate the pwd field: " + e.getMessage());
				}
				try {
					System.out.println("Checking for the home screen...");
					WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
					System.out.println("Home screen appeared.");
					System.out.flush();

					// Click on the recharge icon since the home screen is visible
					System.out.println("Waiting for the recharge icon...");
					WebElement rechargeIcon = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc='Recharge']")));
					rechargeIcon.click();
					System.out.println("Recharge icon clicked.");

				} catch (Exception e) {
					System.out.println("Home screen did not appear immediately. Proceeding to click the login button...");
				}

	            // Validation: Ensure recharge icon was clicked
	          //  Assert.assertNotNull(rechargeIcon, "Recharge icon was not clicked.");

	            // After entering the recharge page, confirm the phone number
	            WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView")));

	            // Click on "View Plans"
	            WebElement viewPlansButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='View Plans']")));
	            viewPlansButton.click();

	            // Validation: Check if "View Plans" button is clicked
	            Assert.assertNotNull(viewPlansButton, "Failed to click on 'View Plans'.");

	            // Wait for available plans popup
	            WebElement availablePlanPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                "//android.view.View[contains(@content-desc,'Available Plan')]")));

	            // Use TouchAction to tap on "+" button by coordinates (based on your screenshot, X: 633, Y: 380)
	            TouchAction touchAction = new TouchAction(driver);
	            touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(633, 380))).perform();
	            System.out.println("Tapped on '+' button for the selected plan.");

	            // Select payment method
	            WebElement paymentMethodButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Payment Method']")));
	            paymentMethodButton.click();
	            System.out.println("Clicked on 'Payment Method'.");

	            // Validation: Ensure payment method was clicked
	            Assert.assertNotNull(paymentMethodButton, "Payment method button not clicked.");

	            // Select B-Ngul from the dropdown
	            WebElement bngulOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='B-Ngul']")));
	            bngulOption.click();
	            System.out.println("Selected 'B-Ngul' payment method.");

	            // Click on the "Recharge" button to complete the process
	            WebElement rechargeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Recharge']")));
	            rechargeButton.click();
	            System.out.println("Clicked on 'Recharge' button.");

	            // Validation: Check if recharge button was clicked
	            Assert.assertNotNull(rechargeButton, "'Recharge' button not clicked.");

	            // Wait for the confirmation pop-up and click on "Confirm"
	            WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Confirm']")));
	            confirmButton.click();
	            System.out.println("Clicked on 'Confirm' button.");

	            // Wait for the MPIN entry pop-up
	            WebElement mpinField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
	            mpinField.click();
	            mpinField.sendKeys("2580");
	            System.out.println("Entered MPIN.");

	            // Validation: Ensure MPIN is entered correctly
	            Assert.assertEquals(mpinField.getAttribute("text"), "2580", "MPIN not entered correctly.");

	            // Click on the "Proceed" button
	            WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Proceed']")));
	            proceedButton.click();
	            System.out.println("Clicked on 'Proceed' button.");

	            // Validation: Ensure proceed button was clicked
	            Assert.assertNotNull(proceedButton, "'Proceed' button not clicked.");

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
