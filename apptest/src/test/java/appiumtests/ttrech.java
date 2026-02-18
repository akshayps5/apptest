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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.offset.PointOption;

public class ttrech {

	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		// Set desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
		cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

		// Initialize the AndroidDriver for Appium
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	}

	@Test(priority = 1)
	public void testLoginAndNavigateToRecharge() throws InterruptedException {
		// Handle "Getting Started" button if it appears
		try {
			WebElement gettingStartedButton = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
			gettingStartedButton.click();
			System.out.println("Clicked on 'Getting Started' button.");
		} catch (Exception e) {
			System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
		}

		// Login steps: Enter mobile number and password
		WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
		mobileNumberField.click();
		Thread.sleep(2000);
		mobileNumberField.sendKeys("17114003");
		System.out.println("Value sent to mobile number field.");

		WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
		pwd.click();
		Thread.sleep(2000);
		pwd.sendKeys("2580");
		System.out.println("Value sent to password field.");

		// Navigate to recharge screen
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

		numberInputField.sendKeys("17112050"); // Replace with actual mobile number
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
		}
	}

	@AfterMethod
	public void tearDown() {
		// Close the app after tests
		if (driver != null) {
			driver.quit();
		}
	}
}
