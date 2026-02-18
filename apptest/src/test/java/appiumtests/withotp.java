package appiumtests;

import java.io.BufferedReader;
import java.io.InputStream;
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
import org.testng.Assert; // Import TestNG assertions

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class withotp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// Set desired capabilities
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
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")));

			// Assert that the mobile number field is found and visible
			Assert.assertNotNull(mobileNumberField, "Mobile number field is not found!");
			Assert.assertTrue(mobileNumberField.isDisplayed(), "Mobile number field is not visible!");
			// Interact with the mobile number field
			mobileNumberField.click();
			Thread.sleep(1000);
			//mobileNumberField.sendKeys("17392658");
			mobileNumberField.sendKeys("17317670");
						
			// mobileNumberField.sendKeys("17711482");
			System.out.println("Value sent to mobile number field.");
		} catch (Exception e) {
			System.err.println("Failed to locate the mobile number field: " + e.getMessage());
			Assert.fail("Mobile number field is not clickable or found.");
		}
		// Password Field
		try {
			System.out.println("Waiting for the password field to appear...");
			WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]\\r\\n")));

			// Assert that the password field is found and visible
			Assert.assertNotNull(pwd, "Password field is not found!");
			Assert.assertTrue(pwd.isDisplayed(), "Password field is not visible!");

			// Interact with the password field
			pwd.click();
	
			pwd.sendKeys("2580");
			System.out.println("Value sent to password field.");

		} catch (Exception e) {
			System.err.println("Failed to locate the password field: " + e.getMessage());
			Assert.fail("Password field is not clickable or found.");
		}
		 try {
	            // Construct the URL
	            URL url = new URL("http://10.0.6.42:80/cgi-bin/aklog?");
	            
	            // Open HTTP connection
	            HttpURLConnection http = (HttpURLConnection) url.openConnection();
	            http.setRequestMethod("GET");
	           http.setRequestProperty("Content-Type", "application/json");
	            http.setRequestProperty("Accept", "application/json");
	            http.setDoOutput(true);
	 
	            // Read the response
	            BufferedReader br = new BufferedReader(new InputStreamReader((InputStream) http.getContent(), "utf-8"));
	            StringBuilder response1 = new StringBuilder();
	            String responseLine = null;
	            while ((responseLine = br.readLine()) != null) {
	                response1.append(responseLine.trim());
	            }
	 
	            // Print the response
	            System.out.println("\nResponse: " + response1.toString());
	 
	            // Close the connection
	            br.close();
	            http.disconnect();
	 
	            // Assert the expected response
	            Assert.assertTrue(response1.toString().contains("Pass"), "Expected 'Pass' string not found in response");
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	            Assert.fail("Exception occurred during API call: " + e.getMessage());
	        }
	    

		try {

			WebElement otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText")));

	
			otp.click();
			// Thread.sleep(2000);
			otp.sendKeys("2580");
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			WebElement prc = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Proceed']")));
			prc.click();	


		} catch (Exception e) {
			System.err.println("Failed to locate the OTP field: " + e.getMessage());
			//Assert.fail("OTP field is not clickable or found.");
		}
	}
}
