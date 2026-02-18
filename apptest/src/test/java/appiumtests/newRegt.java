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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class newRegt {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability("appPackage", "com.bt.mybt");
        cap.setCapability("appActivity", "MainActivity");

        // Initialize the AndroidDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        // Use WebDriverWait to wait for the "Getting Started" button to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Locate and click "Getting Started" button
        WebElement gettingStartedButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
        Assert.assertNotNull(gettingStartedButton, "Getting Started button is not found!");
        Assert.assertTrue(gettingStartedButton.isDisplayed(), "Getting Started button is not visible!");
        gettingStartedButton.click();
        WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
        cancelButton.click();

        Thread.sleep(2000);

        // Mobile Number Field
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
            mobileNumberField.sendKeys("17392111");
           // mobileNumberField.sendKeys("17711510");
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
           // pwd.sendKeys("2580");
            pwd.sendKeys("3689");
            System.out.println("Value sent to password field.");
        } catch (Exception e) {
            System.err.println("Failed to locate the password field: " + e.getMessage());
            Assert.fail("Password field is not clickable or found.");
        
		
		} finally {

			Thread.sleep(3000);
			// Check for the registration popup
			try {
				System.out.println("Waiting for the registration popup...");
				WebElement dismissButton = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//android.view.View[contains(@content-desc, 'Failed!')]/android.widget.Button")));
				dismissButton.click(); // Click the dismiss button
				System.out.println("Clicked on the dismiss button to close the registration popup.");
			} catch (Exception dismissException) {
				System.err.println("Failed to locate or click the dismiss button: " + dismissException.getMessage());
			}
			Thread.sleep(2000);
			try {
				// Wait for the registration mobile number field
//				System.out.println("Waiting for the registration mobile number field...");
				//WebElement registrationMobileField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					//	"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.EditText[1]")));
	//			registrationMobileField.click();
		//		registrationMobileField.sendKeys("17711333");
			//	System.out.println("Value sent to registration mobile number field and moved to next field.");
				// Wait for the create pin field
				try {
				    System.out.println("Waiting for the create pin field...");
				    WebElement createPinField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
				    
				    createPinField.click();
				    Thread.sleep(1000);  // Ensure the field is focused
				    createPinField.clear();  // Clear the field before sending value
				    createPinField.sendKeys("3689");

				 // Simulate pressing "Next" or "Done" on the mobile keyboard
					((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
				    System.out.println("Value sent to create pin field.");
				} catch (Exception e) {
				    System.err.println("An error occurred while entering the create pin: " + e.getMessage());
				}

				System.out.println("Value sent to create pin field and moved to next field.");
				// Wait for the confirm pin field
				System.out.println("Waiting for the confirm pin field...");
				WebElement confirmPinField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.EditText[3]")));
				confirmPinField.click();
				confirmPinField.sendKeys("3689");
				System.out.println("Value sent to confirm pin field.");
			} catch (Exception e) {
				System.err.println("An error occurred: " + e.getMessage());
			}
			try {
				// Wait for the terms and conditions checkbox to appear and click it
				System.out.println("Waiting for the T&C checkbox...");
				WebElement termsCheckbox = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.CheckBox[@content-desc='T&C']")));
				termsCheckbox.click();
				System.out.println("Clicked on the T&C checkbox.");

				// Wait for the register button to appear and click it
				System.out.println("Waiting for the register button...");
				WebElement registerButton = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Register']")));
				registerButton.click();
				System.out.println("Clicked on the register button.");
			} catch (Exception registrationException) {
				System.err.println("Failed to locate registration fields: " + registrationException.getMessage());
			}
			// driver.quit();
		}
	}
}
