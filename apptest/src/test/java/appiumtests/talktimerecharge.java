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

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.offset.PointOption;

public class talktimerecharge {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

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
					Thread.sleep(1000);
					pwd.sendKeys("2580");
					System.out.println("Value sent to password field.");

				} catch (Exception e) {
					System.err.println("Failed to locate the password field: " + e.getMessage());
					Assert.fail("Password field is not clickable or found.");
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

			// Wait for the full recharge screen to load
			WebElement rechargeFullScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.view.View")));
			System.out.println("Recharge full screen loaded.");

			// Wait for the smaller view in the recharge screen (sub-screen) to load
			WebElement rechargeSubScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.view.View/android.view.View[2]")));
			System.out.println("Recharge sub-screen loaded.");

			// Click on the Talk Time tab
			WebElement talkTimeTab = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc,'Talk Time')]")));
			talkTimeTab.click();
			System.out.println("Talk Time tab clicked.");

			// Wait for the number input field to be visible

			try {
			    // Perform a tap somewhere else (e.g., top of the screen) before entering the amount
			   TouchAction touchAction = new TouchAction((AndroidDriver) driver);
			    // Tap at a specific location (coordinates might need adjustment depending on your layout)
			   touchAction.tap(PointOption.point(100, 100)).perform();
			    
			   /* System.out.println("Waiting for the number input field...");
				WebElement amountInputFld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]\r\n" + "")));
				amountInputFld.click();*/

			    // Wait for the amount input field to be visible
			    System.out.println("Waiting for the amount input field...");
			    WebElement amountInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			           "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")));
			    amountInputField.click();
			   Thread.sleep(1000);
			   amountInputField.sendKeys("20"); // Replace with actual amount
			    System.out.println("Amount entered.");
			} catch (Exception e) {
			    System.out.println("Amount not entered.");
			}
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			System.out.println("Waiting for the number input field...");
			WebElement numberInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
			numberInputField.click();

			numberInputField.sendKeys("17112050"); // Replace with actual mobile number
			System.out.println("Mobile number entered.");
			//((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		
			
		}	try {
			WebElement recharge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Payment Method']")));
			recharge.click();

	WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='B-Ngul']")));
			amountInput.click();
			Thread.sleep(1000);
			WebElement rech = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Recharge']")));
			rech.click();
	} catch (Exception e) {
		System.err.println("recharge button" + e.getMessage());			
	}try {
		WebElement confrim = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Confirm\"]\r\n" + "")));
		confrim.click();
		WebElement mpin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText\r\n"+ "")));
		mpin.click();
		mpin.sendKeys("9012");
		//System.err.println("An error occurred: " + e.getMessage());
		WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText\r\n"+ "")));
		String s2 = errorMessageElement.getText();
		int endIndex = s2.indexOf("Please enter M-PIN to confirm!");
		// Trim the string to keep only the part until the specified index
		String trimmedString = s2.substring(0, endIndex);
		System.out.println(trimmedString);
		String expectedOutput = "Please enter M-PIN to confirm";
		System.out.println(s2);
		// System.out.println("Deletion successful");
		Assert.assertTrue(s2.contains(expectedOutput), "Please enter M-PIN to confirm");
		Thread.sleep(3000);
		
	}
	catch (Exception e) {
		System.err.println("An error occurred: " + e.getMessage());
		WebElement errorMessageElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Your available B-Ngul balance Nu.0 is less than the pack amount Nu.20, Add Nu.20 to wallet?\"]\r\n"+ "")));
		String s1 = errorMessageElement2.getText();
		int endIndex = s1.indexOf("Your available B-Ngul balance Nu.0 is less than the pack amount Nu.20, Add Nu.20 to wallet?");
		// Trim the string to keep only the part until the specified index
		String trimmedString = s1.substring(0, endIndex);
		System.out.println(trimmedString);
		String expectedOutput = "Your available B-Ngul balance Nu.0 is less than the pack amount Nu.20, Add Nu.20 to wallet?";
		System.out.println(s1);
		// System.out.println("Deletion successful");
		Assert.assertTrue(s1.contains(expectedOutput), "Your available B-Ngul balance Nu.0 is less than the pack amount Nu.20, Add Nu.20 to wallet?");
		Thread.sleep(3000);
	}
	}
		
	}
