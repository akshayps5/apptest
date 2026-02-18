package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class tt {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// Set desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		// cap.setCapability("appPackage", "com.bt.mybtnew");
		// cap.setCapability("appActivity", "com.bt.mybtnew.MainActivity");
		cap.setCapability("appPackage", "com.bt.mybt");
		cap.setCapability("appActivity", ".MainActivity t290");

		// Initialize the AndroidDriver
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		// Use WebDriverWait to wait for the mobile number field to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time
		WebElement gettingStartedButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
		gettingStartedButton.click();
		Thread.sleep(2000);
		try {
			// Locate the EditText field using the provided XPath
			System.out.println("Waiting for the mobile number field to appear...");
			WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
			// gettingStartedButton.click();

			mobileNumberField.click();

			// Send value to the mobile number field
			Thread.sleep(2000); // Wait for 1 second before interacting

			mobileNumberField.sendKeys("17658695");
			System.out.println("Value sent to mobile number field.");

		} catch (Exception e) {
			System.err.println("Failed to locate the mobile number field: " + e.getMessage());
		} finally {

		}
		try {
			// Locate the EditText field using the provided XPath
			System.out.println("Waiting for the mobile number field to appear...");
			WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
			// gettingStartedButton.click();

			pwd.click();

			// Send value to the mobile number field
			Thread.sleep(2000); // Wait for 1 second before interacting

			pwd.sendKeys("2580");
			System.out.println("Value sent to pwd field.");

		} catch (Exception e) {
			System.err.println("Failed to locate the pwd field: " + e.getMessage());
		} finally {

			Thread.sleep(2000);

			try {

				WebElement otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//android.view.View[@content-desc=\"OTP Verification Enter OTP\"]/android.widget.EditText")));

				otp.click();

				Thread.sleep(2000); // Wait for 1 second before interacting

				otp.sendKeys("2580");

			} catch (Exception e) {
				System.err.println("Failed to locate the otp field: " + e.getMessage());
			} finally {

				// Quit driver
				// driver.quit();
			}
		}
	}
}
