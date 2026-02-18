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
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.remote.MobilePlatform;

	public class buytune {

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
			} catch (Exception e) {
				System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
			}

			// Wait for the mobile number field to appear and interact with it
			System.out.println("Waiting for the mobile number field to appear...");
			// Use a stable XPath or resource ID for mobile number field
			WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView/android.view.View[2]/android.widget.EditText[1]")));
			; // Adjusted for content-desc or use resource-id
			mobileNumberField.click();
			Thread.sleep(1000); // Small delay before entering text

			// Send value to the mobile number field
			mobileNumberField.sendKeys("17112050	");
			System.out.println("Value sent to mobile number field.");
			Thread.sleep(1000);
			try {
                System.out.println("Waiting for the password field to appear...");
                WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView/android.view.View[2]/android.widget.EditText[2]")));	                pwd.click();
                Thread.sleep(2000); // Wait before interacting
                pwd.sendKeys("2580");
                System.out.println("Value sent to password field.");
            } catch (Exception e) {
                System.err.println("Failed to locate the password field: " + e.getMessage());
            }


	            // Wait for the home screen and click on the B-Tunes icon
	            try {
	                System.out.println("Checking for the home screen...");
	                WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
	                Assert.assertTrue(homeScreen.isDisplayed(), "Home screen is not displayed.");
	                System.out.println("Home screen appeared.");
	                System.out.flush();

	                // Click on the B-Tunes icon
	                System.out.println("Waiting for the B-Tunes icon...");
	                WebElement bTunesIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                        "//android.widget.ImageView[@content-desc='B-Tunes']")));
	                Assert.assertTrue(bTunesIcon.isDisplayed(), "B-Tunes icon is not displayed.");
	                bTunesIcon.click();
	                System.out.println("B-Tunes icon clicked.");
	            } catch (Exception e) {
	                System.out.println("Home screen did not appear immediately. Proceeding to click the B-Tunes button...");
	            }

	            // Wait for the full B-Tunes screen to load
	            WebElement btunesFullScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//android.view.View[contains(@content-desc,'Subscribe to B-Tunes')]")));
	            Assert.assertTrue(btunesFullScreen.isDisplayed(), "B-Tunes full screen is not displayed.");
	            System.out.println("B-Tunes full screen loaded.");

	            // Select the 'Top Tunes' tab
	            WebElement topTunesTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.view.View[contains(@content-desc,'Latest Tunes')]")));
	            Assert.assertTrue(topTunesTab.isDisplayed(), "'Top Tunes' tab is not displayed.");
	            topTunesTab.click();
	            System.out.println("Top Tunes tab clicked.");

	            // Select a song from the list
	            WebElement selectSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.view.View[contains(@content-desc,'Bnb')]")));
	            Assert.assertTrue(selectSong.isDisplayed(), "Song is not displayed in the list.");
	            selectSong.click();
	            System.out.println("Song selected.");

	            // Play the selected song
	            WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.view.View[contains(@content-desc,'Bnb')]/android.widget.Button[1]")));
	            Assert.assertTrue(playButton.isDisplayed(), "Play button is not displayed.");
	            playButton.click();
	            System.out.println("Song is playing.");
	            Thread.sleep(2000);  // Let the song play for 2 seconds

	            // Handle the popup after clicking the play button
	          //  WebElement playPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	            //        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")));
	            //Assert.assertTrue(playPopup.isDisplayed(), "Play popup is not displayed.");
	           // System.out.println("Play popup appeared.");

	            // Click the play button inside the popup
	            WebElement popupPlayButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]")));
	            Assert.assertTrue(popupPlayButton.isDisplayed(), "Play button inside popup is not displayed.");
	            popupPlayButton.click();
	            System.out.println("Popup play button clicked. Song will continue playing.");
	            Thread.sleep(5000);  // Wait for the song to play for a while

	            // Buy the selected song
	            WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "(//android.widget.Button[contains(@content-desc,'Buy')])[1]")));
	            Assert.assertTrue(buyButton.isDisplayed(), "Buy button is not displayed.");
	            buyButton.click();
	            System.out.println("Buy button clicked for the song.");

	      
	    }
	}
