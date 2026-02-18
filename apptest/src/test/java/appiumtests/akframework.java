package appiumtests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class akframework {
	private WebDriverWait wait;

	@Test(priority = 4)
	public void Btunes() throws MalformedURLException, InterruptedException {

		// Set desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
		cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

		// Initialize the AndroidDriver for Appium
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		// Use WebDriverWait to wait for elements
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			WebElement gettingStartedButton = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
			gettingStartedButton.click();
			System.out.println("Clicked on 'Getting Started' button.");
			WebElement cancelButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
			cancelButton.click();
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
		Thread.sleep(1000); // Small delay before entering text

		// Send value to the mobile number field
		mobileNumberField.sendKeys("17711482");
		System.out.println("Value sent to mobile number field.");
		Thread.sleep(1000);
		try {
			// Locate the EditText field using the provided XPath
			System.out.println("Waiting for the mobile number field to appear...");
			WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
			pwd.click();
			// Send value to the mobile number field
			Thread.sleep(1000); // Wait for 1 second before interacting
			pwd.sendKeys("2580");
			System.out.println("Value sent to pwd field.");

			// Wait for the home screen and click on the B-Tunes icon
			try {
				System.out.println("Checking for the home screen...");
				WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
				System.out.println("Home screen appeared.");
				System.out.flush();

				// Click on the B-Tunes icon
				System.out.println("Waiting for the B-Tunes icon...");
				WebElement bTunesIcon = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc='B-Tunes']")));
				bTunesIcon.click();
				System.out.println("B-Tunes icon clicked.");
			} catch (Exception e) {
				System.out.println("Home screen did not appear immediately. Proceeding to click the B-Tunes button...");
			}

			// Wait for the full B-Tunes screen to load
			WebElement btunesFullScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//android.view.View[contains(@content-desc,'Subscribe to B-Tunes')]")));
			System.out.println("B-Tunes full screen loaded.");

			// Click on the toggle to subscribe to B-Tunes
			WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.view.View[contains(@content-desc,'Subscribe to B-Tunes')]/android.widget.Switch")));
			toggleButton.click();
			System.out.println("Toggled B-Tunes subscription.");

			// Wait for the success popup and click OK
			WebElement successPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//android.view.View[contains(@content-desc,'Success! B-Tunes registration Success')]")));
			System.out.println("Success popup appeared.");
		} catch (Exception e) {
			System.out.println("success popup is not appeared ..!!!!!!!!!!!!");
		}
		try {
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'OK')]")));
			okButton.click();
			System.out.println("Success popup closed.");
		} catch (Exception e) {
			System.out.println("success popup is not closed ..!!!!!!!!!!!!");
		} // finally {
			// driver.quit(); // Quit the driver after execution

	}
	@Test(priority = 2)

	public void talktimerecharge() throws MalformedURLException, InterruptedException {

// Set desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
		cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

// Initialize the AndroidDriver for Appium
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

// Use WebDriverWait to wait for elements
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // Increased wait time to 120 seconds

		try {
			// Handle "Getting Started" button if it appears
			try {
				WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
				gettingStartedButton.click();
				System.out.println("Clicked on 'Getting Started' button.");
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton.click();
			} catch (Exception e) {
				System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
			}

			// Wait for the mobile number field to appear and interact with it
			System.out.println("Waiting for the mobile number field to appear...");
			WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
			mobileNumberField.click();
			Thread.sleep(1000); // Small delay before entering text

			// Send value to the mobile number field
			mobileNumberField.sendKeys("17711482");
			System.out.println("Value sent to mobile number field.");
			Thread.sleep(1000);

			// Wait for the password field to appear and interact with it
			try {
				System.out.println("Waiting for the password field to appear...");
				WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
				pwd.click();
				Thread.sleep(1000); // Wait before interacting
				pwd.sendKeys("2580");
				System.out.println("Value sent to password field.");
			} catch (Exception e) {
				System.err.println("Failed to locate the password field: " + e.getMessage());
			}

			// Locate and print the Recharge Balance element
			WebElement balanceElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='RECHARGE BALANCE']")));
			String balanceText = balanceElement.getText();
			System.out.println("Recharge Balance: " + balanceText);

			// Locate and print "Remaining" element
			WebElement remainingElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'Remaining')]")));
			String remainingText = remainingElement.getAttribute("content-desc");
			System.out.println("Remaining Data Usage: " + remainingText);

			// Print Talktime
			WebElement talktimeElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Talktime']")));
			String talktimeText = talktimeElement.getAttribute("content-desc");
			System.out.println("Talktime: " + talktimeText);

			// Print Nu.
			WebElement nuElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Nu.']")));
			String nuText = nuElement.getAttribute("content-desc");
			System.out.println("Nu.: " + nuText);

			// Print "Validity: N/A"
			WebElement validityNAElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//android.view.View[@content-desc='Validity: N/A'])[1]")));
			String validityNAText = validityNAElement.getAttribute("content-desc");
			System.out.println("Validity: N/A: " + validityNAText);

			// Print "Monthly 299"
			WebElement monthly299Element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Monthly 299']")));
			String monthly299Text = monthly299Element.getAttribute("content-desc");
			System.out.println("Monthly Plan: " + monthly299Text);

			// Print "Validity: 12/11/2024"
			WebElement validityDateElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Validity: 12/11/2024']")));
			String validityDateText = validityDateElement.getAttribute("content-desc");
			System.out.println("Validity Date: " + validityDateText);

		} catch (Exception e) {
			System.err.println("Error occurred: " + e.getMessage());
		}
	}

	@Test(priority = 3,  enabled= false)

	public void otp_grep() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt");
		cap.setCapability("appActivity", "MainActivity t254");

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
		WebElement cancelButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
		cancelButton.click();
		Thread.sleep(1000);

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
			mobileNumberField.sendKeys("17392651");
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
			pwd.sendKeys("3691");
			System.out.println("Value sent to password field.");
		} catch (Exception e) {
			System.err.println("Failed to locate the password field: " + e.getMessage());
			Assert.fail("Password field is not clickable or found.");
		}

// CGI API Call to retrieve OTP
		String otpValue = ""; // Initialize OTP variable

		try {
			// Construct the URL for the CGI script
			URL url = new URL("http://10.0.6.42:80/cgi-bin/aklog?");

			// Open HTTP connection
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/json");
			http.setRequestProperty("Accept", "application/json");

			// Read the response from CGI script
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8")); // Corrected
																											// getContent()
																											// to
																											// getInputStream()
			StringBuilder response1 = new StringBuilder();
			String responseLine;
			while ((responseLine = br.readLine()) != null) {
				response1.append(responseLine.trim());
			}

			// Print the CGI response (for debugging purposes)
			System.out.println("\nResponse from CGI: " + response1.toString());

			// Close the connection
			br.close();
			http.disconnect();
			Thread.sleep(1000);

			// Directly use the response as the OTP value
			otpValue = response1.toString(); // Since response only contains OTP number
			System.out.println("Extracted OTP: " + otpValue);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred during API call: " + e.getMessage());
		}

// Enter OTP in the mobile app
		try {
			// Make sure the OTP was successfully extracted
			if (otpValue.isEmpty()) {
				throw new Exception("No OTP value found.");
			}

			WebElement otp = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText")));
			otp.click();

			// Send the extracted OTP to the field
			otp.sendKeys(otpValue);

			// Simulate pressing the BACK key to close the keyboard
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

			// Click on the 'Proceed' button
			WebElement prc = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Proceed']")));
			prc.click();

		} catch (Exception e) {
			System.err.println("Failed to locate the OTP field: " + e.getMessage());
		}
	}

	@Test(priority = 1)
	public void checkTabs() throws InterruptedException, MalformedURLException {
		// XPath list of tabs to check
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt");
		cap.setCapability("appActivity", "MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		// Use WebDriverWait to wait for the "Getting Started" button to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Locate and click the "Getting Started" button
		WebElement gettingStartedButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
		gettingStartedButton.click();
		System.out.println("Clicked on 'Getting Started' button.");
		WebElement cancelButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
		cancelButton.click();

		try {
			WebElement popup = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc,'Register')]")));
			WebElement cancelButton3 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
			cancelButton3.click();
			System.out.println("Popup handled successfully by clicking 'Cancel'.");
		} catch (Exception e) {
			System.out.println("No popup appeared or it was already handled.");
		}
		// Enter mobile number
		WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
		mobileNumberField.click();
		Thread.sleep(1000);
		mobileNumberField.sendKeys("17658695");
		System.out.println("Value sent to mobile number field.");

		// Enter password
		WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
		pwd.click();
		Thread.sleep(1000);
		pwd.sendKeys("2580");
		System.out.println("Value sent to password field.");

		String[] tabXPaths = { "//android.widget.ImageView[@content-desc='Recharge']",
				"//android.widget.ImageView[@content-desc='B-Tunes']",
				"//android.widget.ImageView[@content-desc='Bill Payment']",
				"//android.widget.ImageView[@content-desc='Add Money']",
				"//android.widget.ImageView[@content-desc='Send Money']",
				"//android.widget.ImageView[@content-desc='Tickets']",
				"//android.widget.ImageView[@content-desc='Airtime Purchase']",
				"//android.widget.ImageView[@content-desc='Transaction History']",
				"//android.widget.ImageView[@content-desc='Miss Call Alert']" };

		// Corresponding back button XPaths for each tab
		String[] backButtonXPaths = { "//android.view.View[@content-desc='Recharge']/android.widget.Button[1]",
				"//android.view.View[@content-desc='B-Tunes']/android.widget.Button[1]",
				"//android.view.View[@content-desc='Bill Payment']/android.widget.Button[1]",
				"//android.view.View[@content-desc='Add Money']/android.widget.Button[1]",
				"//android.view.View[@content-desc='Send Money']/android.widget.Button[1]",
				"//android.widget.View[@content-desc='Tickets']/android.widget.Button[1]",
				"//android.widget.ImageView[@content-desc='Airtime Purchase']/android.widget.Button[1]",
				"//android.widget.ImageView[@content-desc='Transaction History']/android.widget.Button[1]",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button" };

		// Iterate through each tab and its corresponding back button
		for (int i = 0; i < tabXPaths.length; i++) {
			String tabXPath = tabXPaths[i];
			String backButtonXPath = backButtonXPaths[i];

			try {
				System.out.println("Checking tab: " + tabXPath);

				// Wait for the tab to be visible and clickable
				WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tabXPath)));
				Assert.assertNotNull(tab, "Tab is not found: " + tabXPath);
				Assert.assertTrue(tab.isDisplayed(), "Tab is not visible: " + tabXPath);
				Assert.assertTrue(tab.isEnabled(), "Tab is not clickable: " + tabXPath);

				// Interact with the tab (click it)
				tab.click();
				System.out.println("Tab clicked: " + tabXPath);
				Thread.sleep(1000); // wait for 2 seconds after clicking the tab

				// Click on the back button using its corresponding XPath
				WebElement backButton = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(backButtonXPath)));
				Assert.assertNotNull(backButton, "Back button is not found!");
				Assert.assertTrue(backButton.isDisplayed(), "Back button is not visible!");
				backButton.click();
				System.out.println("Back button clicked.");
				Thread.sleep(2000); // wait for 2 seconds after clicking the back button

			} catch (Exception e) {
				System.err.println("Error while checking tab: " + tabXPath + " - " + e.getMessage());
				Assert.fail("Tab is not clickable or found: " + tabXPath);
			}
		}

	}

	@Test(priority = 4)
	public void talktimereacharge() throws InterruptedException, MalformedURLException {
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
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton.click();
				System.out.println("Popup handled successfully by clicking 'Cancel'.");
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
			mobileNumberField.sendKeys("17112050");
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

			try {
				TouchAction touchAction = new TouchAction((AndroidDriver) driver);

				touchAction.tap(PointOption.point(100, 100)).perform();

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

			numberInputField.sendKeys("17711510"); // Replace with actual mobile number
			System.out.println("Mobile number entered.");
			// ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());

			// OTP Field
			try {
				WebElement otp = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//android.view.View[@content-desc='OTP']/android.widget.EditText")));
				otp.click();
				otp.sendKeys("258089");
				WebElement otp1 = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\" Proceed \"]")));
				otp1.click();

			} catch (Exception e1) {
				System.err.println("Failed to locate the OTP field: " + e1.getMessage());
				Assert.fail("OTP field is not clickable or found.");
			}

		}
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
			System.err.println("recharge button" + e.getMessage());
		}
		try {
			WebElement confrim = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//android.widget.Button[@content-desc=\"Confirm\"]\r\n" + "")));
			confrim.click();
			WebElement mpin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText\r\n"
							+ "")));
			mpin.click();
			mpin.sendKeys("9012");
			// System.err.println("An error occurred: " + e.getMessage());
			WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText\r\n"
							+ "")));
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

		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			WebElement errorMessageElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.view.View[@content-desc=\"Your available B-Ngul balance Nu.0 is less than the pack amount Nu.20, Add Nu.20 to wallet?\"]\r\n"
							+ "")));
			String s1 = errorMessageElement2.getText();
			int endIndex = s1.indexOf(
					"Your available B-Ngul balance Nu.0 is less than the pack amount Nu.20, Add Nu.20 to wallet?");
			// Trim the string to keep only the part until the specified index
			String trimmedString = s1.substring(0, endIndex);
			System.out.println(trimmedString);
			String expectedOutput = "Your available B-Ngul balance Nu.0 is less than the pack amount Nu.20, Add Nu.20 to wallet?";
			System.out.println(s1);

			Assert.assertTrue(s1.contains(expectedOutput),
					"Your available B-Ngul balance Nu.0 is less than the pack amount Nu.20, Add Nu.20 to wallet?");
			Thread.sleep(3000);

		}
	}

	@Test(priority = 5)
	public void testBillPayFlow() throws InterruptedException, MalformedURLException {
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
			try {
				WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
				gettingStartedButton.click();
				System.out.println("Clicked on 'Getting Started' button.");
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton.click();
				System.out.println("Popup handled successfully by clicking 'Cancel'.");
			} catch (Exception e) {
				System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
			}

			try {
				WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.view.View[contains(@content-desc,'Register')]")));
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton.click();
				System.out.println("Popup handled successfully by clicking 'Cancel'.");
			} catch (Exception e) {
				System.out.println("No popup appeared or it was already handled.");
			}

			// Wait for the mobile number field to appear and interact with it
			System.out.println("Waiting for the mobile number field to appear...");
			// Use a stable XPath or resource ID for mobile number field
			WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
			; // Adjusted for content-desc or use resource-id
			mobileNumberField.click();
			Thread.sleep(1000); // Small delay before entering text

			// Send value to the mobile number field
			mobileNumberField.sendKeys("17631732");
			System.out.println("Value sent to mobile number field.");

			try {
				// Locate the EditText field using the provided XPath
				System.out.println("Waiting for the mobile number field to appear...");
				WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
				pwd.click();
				// Send value to the mobile number field
				Thread.sleep(1000); // Wait for 1 second before interacting
				pwd.sendKeys("2580");
				System.out.println("Value sent to pwd field.");
			} catch (Exception e) {
				System.err.println("Failed to locate the pwd field: " + e.getMessage());
			}

			System.out.println("Checking for the home screen...");
			WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
			System.out.println("Home screen appeared.");
			Assert.assertNotNull(homeScreen, "Home screen not loaded.");

			// Click on the Tickets icon
			WebElement ticketIcon = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.ImageView[contains(@content-desc,'Tickets')]")));
			ticketIcon.click();
			System.out.println("Ticket icon clicked.");
			// Click on Create Complaint
			WebElement complaintcreate = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Create New Complaints']")));
			complaintcreate.click();
			System.out.println("Create New Complaints clicked.");

			// Click on Complaint Type
			WebElement complaintTypeButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Select Complaint Type']")));
			complaintTypeButton.click();
			System.out.println("Complaint Type button clicked.");

			// Select 'Mobile' from the dropdown
			WebElement mobileOption = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Mobile']")));
			mobileOption.click();
			System.out.println("'Mobile' option selected from Complaint Type dropdown.");

			// Click on Complaint Sub Type
			WebElement complaintSubTypeButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//android.widget.Button[@content-desc='Select Complaint Sub Type']")));
			complaintSubTypeButton.click();
			System.out.println("Complaint Sub Type button clicked.");

			// Select 'BWALLET' from the dropdown
			WebElement bwalletOption = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='BWALLET']")));
			bwalletOption.click();
			System.out.println("'BWALLET' option selected from Complaint Sub Type dropdown.");

			// Click on Dzongkhag Type
			WebElement dzongkhagTypeButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Select Dzongkhag Type']")));
			dzongkhagTypeButton.click();
			System.out.println("Dzongkhag Type button clicked.");

			// Select 'Gasa' from the dropdown
			WebElement gasaOption = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Gasa']")));
			gasaOption.click();
			System.out.println("'Gasa' option selected from Dzongkhag Type dropdown.");

			// Enter Location
			WebElement locationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.widget.EditText[1]")));
			locationField.click();
			locationField.sendKeys("Thimphu"); // Replace with desired location
			System.out.println("Location entered.");

			// Enter Name
			WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.widget.EditText[2]")));
			nameField.click();
			nameField.sendKeys("John Doe"); // Replace with desired name
			System.out.println("Name entered.");

			// Enter Number
			WebElement numberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.widget.EditText[3]")));
			numberField.click();
			numberField.sendKeys("1234567890"); // Replace with desired number
			System.out.println("Number entered.");

		} catch (Exception e) {
			System.err.println("An error occurred during the test: " + e.getMessage());
			Assert.fail("Test failed due to an error.");
		}
	}

	@Test(priority = 6)
	public void Dashboard() throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
		cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

		// Initialize the AndroidDriver for Appium
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		// Use WebDriverWait to wait for elements
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // Increased wait time to 120 seconds

		try {
			// Handle "Getting Started" button if it appears
			try {
				WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
				gettingStartedButton.click();
				System.out.println("Clicked on 'Getting Started' button.");
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton.click();
				System.out.println("Popup handled successfully by clicking 'Cancel'.");
			} catch (Exception e) {
				System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
			}

			// Wait for the mobile number field to appear and interact with it
			System.out.println("Waiting for the mobile number field to appear...");
			WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
			mobileNumberField.click();
			Thread.sleep(1000); // Small delay before entering text

			// Send value to the mobile number field
			mobileNumberField.sendKeys("17631732");
			System.out.println("Value sent to mobile number field.");
			Thread.sleep(1000);

			// Wait for the password field to appear and interact with it
			try {
				System.out.println("Waiting for the password field to appear...");
				WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
				pwd.click();
				Thread.sleep(1000); // Wait before interacting
				pwd.sendKeys("2580");
				System.out.println("Value sent to password field.");
			} catch (Exception e) {
				System.err.println("Failed to locate the password field: " + e.getMessage());
			}

			// Locate and print the Recharge Balance element
			WebElement balanceElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='RECHARGE BALANCE']")));
			String balanceText = balanceElement.getText();
			System.out.println("Recharge Balance: " + balanceText);

			// Locate and print "Remaining" element
			WebElement remainingElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'Remaining')]")));
			String remainingText = remainingElement.getAttribute("content-desc");
			System.out.println("Remaining Data Usage: " + remainingText);

			// Print Talktime
			WebElement talktimeElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Talktime']")));
			String talktimeText = talktimeElement.getAttribute("content-desc");
			System.out.println("Talktime: " + talktimeText);

			// Print Nu.
			WebElement nuElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Nu.']")));
			String nuText = nuElement.getAttribute("content-desc");
			System.out.println("Nu.: " + nuText);

			// Print "Validity: N/A"
			WebElement validityNAElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//android.view.View[@content-desc='Validity: N/A'])[1]")));
			String validityNAText = validityNAElement.getAttribute("content-desc");
			System.out.println("Validity: N/A: " + validityNAText);

			// Print "Monthly 299"
			WebElement monthly299Element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Monthly 299']")));
			String monthly299Text = monthly299Element.getAttribute("content-desc");
			System.out.println("Monthly Plan: " + monthly299Text);

			// Print "Validity: 12/11/2024"
			WebElement validityDateElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Validity: 12/11/2024']")));
			String validityDateText = validityDateElement.getAttribute("content-desc");
			System.out.println("Validity Date: " + validityDateText);

		} catch (Exception e) {
			System.err.println("Error occurred: " + e.getMessage());
		}
	}

	@Test(priority = 7)
	public void simretention() throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
		cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

		// Initialize the AndroidDriver for Appium
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // Increased wait time to 120 seconds

		try {
			// Locate and click the "Getting Started" button
			WebElement gettingStartedButton = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
			gettingStartedButton.click();
			System.out.println("Clicked on 'Getting Started' button.");
			WebElement cancelButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
			cancelButton.click();
			System.out.println("Popup handled successfully by clicking 'Cancel'.");

			try {
				WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.view.View[contains(@content-desc,'Register')]")));
				WebElement cancelButton2 = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton2.click();
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
				mobileNumberField.sendKeys("17631732");
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
			// Click on the airtime purchase icon
			WebElement airtimeIcon = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.ImageView[contains(@content-desc,'Airtime')]")));
			airtimeIcon.click();
			System.out.println("Airtime Purchase icon clicked.");
			// Select payment method
			WebElement paymentMethodButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Payment Method']")));
			paymentMethodButton.click();
			System.out.println("Clicked on 'Payment Method'.");

			// Validation: Ensure payment method was clicked
			Assert.assertNotNull(paymentMethodButton, "Payment method button not clicked.");

			// Select B-Ngul from the dropdown
			WebElement bngulOption = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='B-Ngul']")));
			bngulOption.click();
			System.out.println("Selected 'B-Ngul' payment method.");
			// Enter phone number
			WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")));
			phoneNumberField.click();
			phoneNumberField.sendKeys("17112050");
			System.out.println("Entered phone number.");

			// Enter amount
			WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")));
			amountField.click();
			amountField.sendKeys("5000");
			System.out.println("Entered amount.");

			// Click on the Purchase button
			WebElement purchaseButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'Purchase')]")));
			purchaseButton.click();
			System.out.println("Clicked on 'Purchase' button.");
		} catch (Exception e) {
			System.err.println("An error occurred in the recharge flow: " + e.getMessage());
			Assert.fail("Recharge flow test failed due to exception: " + e.getMessage());
		}
	}

	@Test(priority = 8)
	public void cancelrecharge() throws InterruptedException, MalformedURLException {
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
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton.click();
				System.out.println("Popup handled successfully by clicking 'Cancel'.");
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
			Thread.sleep(1000); // Small delay before entering text

			// Send value to the mobile number field
			mobileNumberField.sendKeys("17445435");
			System.out.println("Value sent to mobile number field.");

			try {
				// Locate the EditText field using the provided XPath
				System.out.println("Waiting for the mobile number field to appear...");
				WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
				pwd.click();
				// Send value to the mobile number field
				Thread.sleep(1000); // Wait for 1 second before interacting
				pwd.sendKeys("2580");
				System.out.println("Value sent to pwd field.");
			} catch (Exception e) {
				System.err.println("Failed to locate the pwd field: " + e.getMessage());
			}
			try {
				System.out.println("Checking for the home screen...");
				// WebElement homeScreen =
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
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

//	 WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView")));

			// Click on "View Plans"
			WebElement viewPlansButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='View Plans']")));
			viewPlansButton.click();
			System.out.println("plan icon clicked.");
			// Validation: Check if "View Plans" button is clicked
			Assert.assertNotNull(viewPlansButton, "Failed to click on 'View Plans'.");

			// Wait for available plans popup
			WebElement availablePlanPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//android.view.View[contains(@content-desc,'Available Plan')]")));

			// Use TouchAction to tap on "+" button by coordinates (based on your
			// screenshot, X: 633, Y: 380)
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1230, 1055))).perform();
			System.out.println("Tapped on '+' button for the selected plan.");

			// Select payment method
			WebElement paymentMethodButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Payment Method']")));
			paymentMethodButton.click();
			System.out.println("Clicked on 'Payment Method'.");

			// Validation: Ensure payment method was clicked
			Assert.assertNotNull(paymentMethodButton, "Payment method button not clicked.");

			// Select B-Ngul from the dropdown
			WebElement bngulOption = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='B-Ngul']")));
			bngulOption.click();
			System.out.println("Selected 'B-Ngul' payment method.");

			// Click on the "Recharge" button to complete the process
			WebElement rechargeButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Recharge']")));
			rechargeButton.click();
			System.out.println("Clicked on 'Recharge' button.");

			// Validation: Check if recharge button was clicked
			Assert.assertNotNull(rechargeButton, "'Recharge' button not clicked.");

			// Wait for the confirmation pop-up and click on "Confirm"
			WebElement confirmButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Confirm']")));
			confirmButton.click();
			System.out.println("Clicked on 'Confirm' button.");
			try {
				WebElement insufficientBalancePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//android.view.View[@content-desc='Your available B-Ngul balance Nu.0 is less than the pack amount Nu.19, Add Nu.19 to wallet?']")));

				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Cancel']")));
				cancelButton.click();
				System.out.println("Insufficient balance popup appeared. Cancel button clicked.");

			} catch (Exception e) {
				System.out.println("No insufficient balance popup appeared.");
			}

			// Wait for the MPIN entry pop-up
			WebElement mpinField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
			mpinField.click();
			mpinField.sendKeys("2580");
			System.out.println("Entered MPIN.");

			// Validation: Ensure MPIN is entered correctly
			Assert.assertEquals(mpinField.getAttribute("text"), "2580", "MPIN not entered correctly.");

			// Click on the "Proceed" button
			WebElement proceedButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Proceed']")));
			proceedButton.click();
			System.out.println("Clicked on 'Proceed' button.");

			// Validation: Ensure proceed button was clicked
			Assert.assertNotNull(proceedButton, "'Proceed' button not clicked.");

		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@Test(priority = 9)
	public void misscallAlert() throws InterruptedException, MalformedURLException {

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
				System.out.println("hlo...!!!!!!!!!!!!");
				gettingStartedButton.click();
				System.out.println("Clicked on 'Getting Started' button.");
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton.click();
				System.out.println("Popup handled successfully by clicking 'Cancel'.");
			} catch (Exception e) {
				System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
			}

			// Enter mobile number on the login screen
			System.out.println("Waiting for the mobile number field to appear...");
			WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
			mobileNumberField.click();
			Thread.sleep(1000); // Small delay before entering text

			// Send value to the mobile number field
			mobileNumberField.sendKeys("17711482");
			System.out.println("Value sent to mobile number field.");

			// Wait for the password field to appear and interact with it
			try {
				System.out.println("Waiting for the password field to appear...");
				WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView/android.view.View[2]/android.widget.EditText[2]")));
				pwd.click();
				Thread.sleep(1000); // Wait before interacting
				pwd.sendKeys("2580");
				System.out.println("Value sent to password field.");
			} catch (Exception e) {
				System.err.println("Failed to locate the password field: " + e.getMessage());
			}

			// Wait for the home screen and click on the MCA icon
			WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
			System.out.println("Home screen appeared.");

			// Click on the MCA icon
			WebElement mcaIcon = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//android.widget.ImageView[contains(@content-desc,'Miss Call Alert')]")));
			mcaIcon.click();
			System.out.println("yes i m MCA...!...!...!");
			System.out.println("Miss Call Alert icon clicked.");

			// Wait for the pop-up and interact with the switch
			WebElement mcaSwitch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.Switch[@content-desc='Missed Call Alert Status Never miss an important call with Miss Call Alert.Enable this service to receive SMS notifications about missed calls when your phone is switched off.']")));
			mcaSwitch.click();
			System.out.println("Tapped on the 'Missed Call Alert' switch.");

			WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//android.widget.Switch[contains(@content-desc,'Missed Call Alert Status')]")));
			System.out.println("Waiting for the toggle button to be clickable...");

			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(454, 430))).perform();
			System.out.println("Tapped on toggle button.");

			// Close the popup
			WebElement closeButton = driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button"));
			closeButton.click();
			System.out.println("Closed the popup.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ticket() throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
		cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

// Initialize the AndroidDriver for Appium
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

//Use WebDriverWait to wait for elements
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		try {
			try {
				WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
				gettingStartedButton.click();
				System.out.println("Clicked on 'Getting Started' button.");
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton.click();
				System.out.println("Popup handled successfully by clicking 'Cancel'.");

			} catch (Exception e) {
				System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
			}

			try {
				WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.view.View[contains(@content-desc,'Register')]")));
				WebElement cancelButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
				cancelButton.click();
				System.out.println("Popup handled successfully by clicking 'Cancel'.");
			} catch (Exception e) {
				System.out.println("No popup appeared or it was already handled.");
			}

			// Wait for the mobile number field to appear and interact with it
			System.out.println("Waiting for the mobile number field to appear...");
			// Use a stable XPath or resource ID for mobile number field
			WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
			; // Adjusted for content-desc or use resource-id
			mobileNumberField.click();
			Thread.sleep(1000); // Small delay before entering text

			// Send value to the mobile number field
			mobileNumberField.sendKeys("17631732");
			System.out.println("Value sent to mobile number field.");
			// Thread.sleep(2000);
			try {
				// Locate the EditText field using the provided XPath
				System.out.println("Waiting for the mobile number field to appear...");
				WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
				pwd.click();
				// Send value to the mobile number field
				Thread.sleep(1000); // Wait for 1 second before interacting
				pwd.sendKeys("2580");
				System.out.println("Value sent to pwd field.");
			} catch (Exception e) {
				System.err.println("Failed to locate the pwd field: " + e.getMessage());
			}

			System.out.println("Checking for the home screen...");
			WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
			System.out.println("Home screen appeared.");
			Assert.assertNotNull(homeScreen, "Home screen not loaded.");

			// Click on the Tickets icon
			WebElement ticketIcon = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.ImageView[contains(@content-desc,'Tickets')]")));
			ticketIcon.click();
			System.out.println("Ticket icon clicked.");
			// Click on Create Complaint
			WebElement complaintcreate = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Create New Complaints']")));
			complaintcreate.click();
			System.out.println("Create New Complaints clicked.");

			// Click on Complaint Type
			WebElement complaintTypeButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Select Complaint Type']")));
			complaintTypeButton.click();
			System.out.println("Complaint Type button clicked.");

			// Select 'Mobile' from the dropdown
			WebElement mobileOption = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Mobile']")));
			mobileOption.click();
			System.out.println("'Mobile' option selected from Complaint Type dropdown.");

			// Click on Complaint Sub Type
			WebElement complaintSubTypeButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//android.widget.Button[@content-desc='Select Complaint Sub Type']")));
			complaintSubTypeButton.click();
			System.out.println("Complaint Sub Type button clicked.");

			// Select 'BWALLET' from the dropdown
			WebElement bwalletOption = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='BWALLET']")));
			bwalletOption.click();
			System.out.println("'BWALLET' option selected from Complaint Sub Type dropdown.");

			// Click on Dzongkhag Type
			WebElement dzongkhagTypeButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Select Dzongkhag Type']")));
			dzongkhagTypeButton.click();
			System.out.println("Dzongkhag Type button clicked.");

			// Select 'Gasa' from the dropdown
			WebElement gasaOption = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Gasa']")));
			gasaOption.click();
			System.out.println("'Gasa' option selected from Dzongkhag Type dropdown.");

			// Enter Location
			WebElement locationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.widget.EditText[1]")));
			locationField.click();
			locationField.sendKeys("Thimphu"); // Replace with desired location
			System.out.println("Location entered.");

			// Enter Name
			WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.widget.EditText[2]")));
			nameField.click();
			nameField.sendKeys("John Doe"); // Replace with desired name
			System.out.println("Name entered.");

			// Enter Number
			WebElement numberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.widget.EditText[3]")));
			numberField.click();
			numberField.sendKeys("1234567890"); // Replace with desired number
			System.out.println("Number entered.");

		} catch (Exception e) {
			System.err.println("An error occurred during the test: " + e.getMessage());
			Assert.fail("Test failed due to an error.");
		}
	}
}
