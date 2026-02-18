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

	public class subscribetune {

	    public static void main(String[] args) throws MalformedURLException, InterruptedException {

	        // Set desired capabilities
	        DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	        cap.setCapability("appPackage", "com.bt.mybt");  // Replace with your app package
	        cap.setCapability("appActivity", ".MainActivity");  // Replace with your app activity

	        // Initialize the AndroidDriver for Appium
	        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	        // Use WebDriverWait to wait for elements
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	    	try {
				WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
				gettingStartedButton.click();
				System.out.println("Clicked on 'Getting Started' button.");
				  WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(
		                    By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
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
			Thread.sleep(2000); // Small delay before entering text

			// Send value to the mobile number field
			mobileNumberField.sendKeys("17631732");
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

	            // Wait for the home screen and click on the B-Tunes icon
	            try {
	                System.out.println("Checking for the home screen...");
	                WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
	                System.out.println("Home screen appeared.");
	                System.out.flush();

	                // Click on the B-Tunes icon
	                System.out.println("Waiting for the B-Tunes icon...");
	                WebElement bTunesIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                        "//android.widget.ImageView[@content-desc='B-Tunes']")));
	                bTunesIcon.click();
	                System.out.println("B-Tunes icon clicked.");
	            } catch (Exception e) {
	                System.out.println("Home screen did not appear immediately. Proceeding to click the B-Tunes button...");
	            }

	            // Wait for the full B-Tunes screen to load
	            WebElement btunesFullScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//android.view.View[contains(@content-desc,'Subscribe to B-Tunes')]")));
	            System.out.println("B-Tunes full screen loaded.");

	            // Click on the toggle to subscribe to B-Tunes
	            WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.view.View[contains(@content-desc,'Subscribe to B-Tunes')]/android.widget.Switch")));
	            toggleButton.click();
	            System.out.println("Toggled B-Tunes subscription.");

	            // Wait for the success popup and click OK
	            WebElement successPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//android.view.View[contains(@content-desc,'Success! B-Tunes registration Success')]")));
	            System.out.println("Success popup appeared.");
	        } catch (Exception e) {
	            System.out.println("success popup is not appeared ..!!!!!!!!!!!!");
	        }
	        	try {
	            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Button[contains(@content-desc,'OK')]")));
	            okButton.click();
	            System.out.println("Success popup closed.");
	    } catch (Exception e) {
	        System.out.println("success popup is not closed ..!!!!!!!!!!!!");
	        } //finally {
	           // driver.quit(); // Quit the driver after execution
	        
	    }
	}


