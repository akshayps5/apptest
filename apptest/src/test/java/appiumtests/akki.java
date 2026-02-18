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

	public class akki {

	    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	        // Set desired capabilities
	        DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	        cap.setCapability("appPackage", "com.bt.mybt");
	        cap.setCapability("appActivity", "MainActivity t254");

	        // Initialize the AndroidDriver
	        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	        // Use WebDriverWait to wait for elements to appear
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        // Locate and click "Getting Started" button
	        WebElement gettingStartedButton = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
	        Assert.assertNotNull(gettingStartedButton, "Getting Started button is not found!");
	        Assert.assertTrue(gettingStartedButton.isDisplayed(), "Getting Started button is not visible!");
	        gettingStartedButton.click();
	        
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
	            Thread.sleep(2000); 
	            mobileNumberField.sendKeys("17392651");
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
	            Thread.sleep(2000); 
	            pwd.sendKeys("1932");
	            System.out.println("Value sent to password field.");

	        } catch (Exception e) {
	            System.err.println("Failed to locate the password field: " + e.getMessage());
	            Assert.fail("Password field is not clickable or found.");
	        }
	        // XPath list of tabs to check
	        String[] tabXPaths = {
	        		"//android.widget.ImageView[@content-desc='Recharge']",
	                "//android.widget.ImageView[@content-desc='B-Tunes']",
	                "//android.widget.ImageView[@content-desc='Bill Payment']",
	                "//android.widget.ImageView[@content-desc='Miss Call Alert']",
	                "//android.widget.ImageView[@content-desc='Add Money']",
	                "//android.widget.ImageView[@content-desc='Send Money']",
	                "//android.widget.ImageView[@content-desc='Tickets']",
	                "//android.widget.ImageView[@content-desc='Airtime Purchase']",
	                "//android.widget.ImageView[@content-desc='Transaction History']"
	            };

	            // Iterate through each tab XPath to check if it's clickable
	            for (String xpath : tabXPaths) {
	                try {
	                    System.out.println("Checking tab: " + xpath);

	                    // Wait for the tab to be visible and clickable
	                    WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	                    Assert.assertNotNull(tab, "Tab is not found: " + xpath);
	                    Assert.assertTrue(tab.isDisplayed(), "Tab is not visible: " + xpath);
	                    Assert.assertTrue(tab.isEnabled(), "Tab is not clickable: " + xpath);

	                    // Interact with the tab (click it)
	                    tab.click();
	                    System.out.println("Tab clicked: " + xpath);
	                    Thread.sleep(2000);  // wait for the tab interaction

	                    // Click on the back button using its XPath
	                    WebElement backButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                        "//android.view.View[@content-desc='Recharge']/android.widget.Button[1]")));
	                    Assert.assertNotNull(backButton, "Back button is not found!");
	                    Assert.assertTrue(backButton.isDisplayed(), "Back button is not visible!");
	                    backButton.click();
	                    System.out.println("Back button clicked.");
	                    Thread.sleep(1000);  // wait after clicking the back button

	                } catch (Exception e) {
	                    System.err.println("Error while checking tab: " + xpath + " - " + e.getMessage());
	                    Assert.fail("Tab is not clickable or found: " + xpath);
	                }
	            }

	            // Optionally: Quit driver after interaction
	            driver.quit();
	        }
	    }


