package phase2;



	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.touch.WaitOptions;
	import io.appium.java_client.touch.offset.PointOption;
	import java.time.Duration;

	// Other imports...
	import java.net.MalformedURLException;
	import java.net.URL;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.remote.MobilePlatform;

	public class login {

		private AndroidDriver driver;
		private WebDriverWait wait;

		@BeforeTest
		public void setUp() throws MalformedURLException {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			cap.setCapability("appPackage", "com.bt.mybt");
			cap.setCapability("appActivity", "MainActivity");

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
	            
	            try {
	                WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//android.view.View[contains(@content-desc,'Register')]")));
	                WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(
	                        By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
	                cancelButton.click();
	                System.out.println("Popup handled successfully by clicking 'Cancel'.");
	            } catch (Exception e) {
	                System.out.println("No popup appeared or it was already handled.");
	            }
				// Enter mobile number
				WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")));
				mobileNumberField.click();
				Thread.sleep(2000);
				//mobileNumberField.sendKeys("17658695");
				//mobileNumberField.sendKeys("17711482");
				mobileNumberField.sendKeys("17317670");
				System.out.println("Value sent to mobile number field.");

				// Enter password
				WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]\r\n"
						+ "")));
				pwd.click();
				Thread.sleep(2000);
				pwd.sendKeys("2580");
				System.out.println("Value sent to password field.");

				// Click on the Sim Retention   icon
	            WebElement rechargeIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.ImageView[contains(@content-desc,'SIM Retention')]")));
	            rechargeIcon.click();
	            System.out.println("SIM Retention icon clicked.");
	            //After entering sim retention page,, confirm the phone number
	            WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//android.widget.ImageView[@content-desc=\"Mobile Number Enter M-PIN This feature is for mobile number retention,and it will remain suspended i.e., until you unsuspend it again. The retention charge is Nu.50 per year.Please visit BT counter for retention beyond one year.\"]/android.view.View")));
	            //Enter M-PIN
	            WebElement mpinField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//android.widget.ImageView[@content-desc='Mobile Number Enter M-PIN This feature is for mobile number retention,and it will remain suspended i.e., until you unsuspend it again. The retention charge is Nu.50 per year.Please visit BT counter for retention beyond one year.']/android.widget.EditText")));
	            mpinField.click();
	            mpinField.sendKeys("2580");
	            System.out.println("MPIN entered.");
	            // Validation: Ensure MPIN is entered correctly
	            Assert.assertEquals(mpinField.getAttribute("text"), "2580", "MPIN not entered correctly.");
	        } catch (Exception e) {
	            System.err.println("An error occurred: " + e.getMessage());
	            Assert.fail("Test failed due to exception: " + e.getMessage());
	        }
	    }
			
		/*// Method to scroll until the element is visible
		public void scrollToElement(By locator) {
			int maxScrolls = 5;
			for (int i = 0; i < maxScrolls; i++) {
				try {
					// Try to locate the element
					driver.findElement(locator);
					return; // If found, exit the method
				} catch (Exception e) {
					// Scroll down if not found
		/*			new TouchAction(driver)
							.press(PointOption.point(500, 1500))
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
							.moveTo(PointOption.point(500, 500))
							.release()
							.perform();*/
//				}

		

		@AfterTest
		public void tearDown() {
			if (driver != null) {
				driver.quit(); // Quit the driver after execution
			}
		}
	}


