package appiumtests;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.remote.MobilePlatform;
	import io.appium.java_client.touch.TapOptions;
	import io.appium.java_client.touch.offset.PointOption;
	import io.appium.java_client.TouchAction;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;

	public class mca {

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
	            // Handle "Getting Started" button if it appears
	            try {
	                WebElement gettingStartedButton = wait.until(ExpectedConditions
	                        .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
	                System.out.println("hlo...!!!!!!!!!!!!");
	                gettingStartedButton.click();
	                System.out.println("Clicked on 'Getting Started' button.");
	            } catch (Exception e) {
	                System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
	            }

	            // Enter mobile number on the login screen
	            System.out.println("Waiting for the mobile number field to appear...");
	            WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
	            mobileNumberField.click();
	            Thread.sleep(2000); // Small delay before entering text

	            // Send value to the mobile number field
	            mobileNumberField.sendKeys("17711482");
	            System.out.println("Value sent to mobile number field.");
	            Thread.sleep(2000);

	            // Wait for the password field to appear and interact with it
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

	            // Wait for the home screen and click on the MCA icon
	            WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
	            System.out.println("Home screen appeared.");

	            // Click on the MCA icon
	            WebElement mcaIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.ImageView[contains(@content-desc,'Miss Call Alert')]")));
	            mcaIcon.click();
	            System.out.println("yes i m MCA...!...!...!");
	            System.out.println("Miss Call Alert icon clicked.");
	            
	         // Wait for the pop-up and interact with the switch
	            WebElement mcaSwitch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Switch[@content-desc='Missed Call Alert Status Never miss an important call with Miss Call Alert.Enable this service to receive SMS notifications about missed calls when your phone is switched off.']")));
	            mcaSwitch.click();
	            System.out.println("Tapped on the 'Missed Call Alert' switch.");

	            WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Switch[contains(@content-desc,'Missed Call Alert Status')]")));
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
	        } finally {
	            // Quit the driver
	            driver.quit();
	        }
	    }
	}


