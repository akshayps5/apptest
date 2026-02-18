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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class etecases {

	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt");
		cap.setCapability("appActivity", ".MainActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		try {
			WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
			gettingStartedButton.click();
			
	
	} catch (Exception e) {
		Assert.fail("Test failed due to exception: " + e.getMessage());
	}
	}
	@Test (priority=1)
	public void testAppFunctionality() throws Exception {
		
		//	try {
			//	WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
				//gettingStartedButton.click();
			
			 try {
		            System.out.println("Waiting for the mobile number field to appear...");
		            WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
		            // Assert that the mobile number field is found and visible
		            Assert.assertNotNull(mobileNumberField, "Mobile number field is not found!");
		            Assert.assertTrue(mobileNumberField.isDisplayed(), "Mobile number field is not visible!");
		            // Interact with the mobile number field
		            mobileNumberField.click();
		            Thread.sleep(1000);
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
		            pwd.sendKeys("2580");
		        } catch (Exception e) {
					Assert.fail("Error occurred: " + e.getMessage());
				
				}
		        Thread.sleep(1000); 
		        try {
					WebElement rechargeIcon = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc='Recharge']")));
					rechargeIcon.click();
					System.out.println("Recharge icon clicked.");
				} catch (Exception e) {
					System.out.println("Failed to click the recharge icon.");
				}

				// Click on the Talk Time tab
				WebElement talkTimeTab = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc,'Talk Time')]")));
				talkTimeTab.click();
				System.out.println("Talk Time tab clicked.");

				// Tap before entering the amount
				TouchAction touchAction = new TouchAction(driver);
				touchAction.tap(PointOption.point(100, 100)).perform();

				// Enter amount in the recharge field
				WebElement amountInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")));
				amountInputField.click();
				Thread.sleep(1000);
				amountInputField.sendKeys("20");
				System.out.println("Amount entered.");
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
				WebElement numberInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
				numberInputField.click();

				numberInputField.sendKeys("17711482"); // Replace with actual mobile number
				System.out.println("Mobile number entered.");
				// ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
				Thread.sleep(1000);
				// Click on Payment Method and Recharge
				try {
					WebElement recharge = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Payment Method']")));
					recharge.click();

					WebElement amountInput = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='B-Ngul']")));
					amountInput.click();
					Thread.sleep(1000);

					WebElement rech = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Recharge']")));
					rech.click();
				} catch (Exception e) {
					System.err.println("Failed to click the recharge button: " + e.getMessage());
				}

				// Check confirmation and assert correct flow
				try {
					WebElement confirm = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Confirm']")));
					confirm.click();

					WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
					String message = errorMessageElement.getText();
					Assert.assertTrue(message.contains("Please enter M-PIN to confirm"),
							"M-PIN confirmation prompt did not appear.");
					System.out.println("Confirmed M-PIN prompt.");
				} catch (Exception e) {
					System.err.println("An error occurred: " + e.getMessage());
				}//	} catch (Exception e) {
					//Assert.fail("Test failed due to exception: " + e.getMessage());
				//}
			

   // ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
	@Test(priority = 2)
	public void rechkTime() {
		try {
			/*try {
				WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
				gettingStartedButton.click();
			} catch (Exception e) {
			}*/
			WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
			mobileNumberField.click();
			Thread.sleep(2000);
			mobileNumberField.sendKeys("17711482");
			WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
			pwd.click();
			pwd.sendKeys("2580");
			try {
				WebElement rechargeIcon = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc='Recharge']")));
				rechargeIcon.click();
			} catch (Exception e) {
			}
			WebElement viewPlansButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='View Plans']")));
			viewPlansButton.click();
			WebElement availablePlanPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//android.view.View[contains(@content-desc,'Available Plan')]")));
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1230, 1055))).perform();
			WebElement paymentMethodButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Payment Method']")));
			paymentMethodButton.click();
			/*	WebElement bngulOption = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='B-Ngul']")));
			bngulOption.click();
			WebElement rechargeButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Recharge']")));
			rechargeButton.click();
			WebElement confirmButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Confirm']")));
			confirmButton.click();
			try {
				WebElement insufficientBalancePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//android.view.View[@content-desc='Your available B-Ngul balance Nu.0 is less than the pack amount Nu.19, Add Nu.19 to wallet?']")));
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Cancel']")));
				cancelButton.click();
			} catch (Exception e) {
			}
			WebElement mpinField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
			mpinField.click();
			mpinField.sendKeys("2580");
			WebElement proceedButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Proceed']")));
			proceedButton.click();
			*/
		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
    //((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	//}
	@Test(priority = 3)
	public void rechargeTalkTime() throws InterruptedException {
		try {
			try {
				WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
				gettingStartedButton.click();
			} catch (Exception e) {
			}
			WebElement mobileNumberField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[1]")));
			mobileNumberField.click();
			mobileNumberField.sendKeys("17711482");
			Thread.sleep(2000);
			WebElement pwd = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[2]")));
			pwd.click();
			pwd.sendKeys("2580");
			WebElement homeScreen = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.View")));
			WebElement rechargeIcon = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc='Recharge']")));
			rechargeIcon.click();
			WebElement rechargeSubScreen = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[2]")));
			WebElement talkTimeTab = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Talktime']")));
			talkTimeTab.click();
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1230, 1062))).perform();
			Thread.sleep(10000);
		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
