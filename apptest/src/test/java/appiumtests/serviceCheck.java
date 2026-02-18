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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class serviceCheck {

    private AndroidDriver driver;
    private WebDriverWait wait;
    //wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    @BeforeTest
    public void setup() throws MalformedURLException {
        // Set desired capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability("appPackage", "com.bt.mybt");
        cap.setCapability("appActivity", "MainActivity t254");

        // Initialize the AndroidDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        // Use WebDriverWait to wait for elements to appear
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void checkGettingStartedButton() {
        // Locate and click "Getting Started" button
        WebElement gettingStartedButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
        Assert.assertNotNull(gettingStartedButton, "Getting Started button is not found!");
        Assert.assertTrue(gettingStartedButton.isDisplayed(), "Getting Started button is not visible!");
        gettingStartedButton.click();
    }

    @Test(priority = 2)
    public void enterMobileNumber() throws InterruptedException {
        // Mobile Number Field
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

		
    }

   // @Test(priority = 3)
    //public void enterPassword() throws InterruptedException {
        // Password Field
	/*
	 * try { System.out.println("Waiting for the password field to appear...");
	 * WebElement pwd =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]"
	 * )));
	 * 
	 * // Assert that the password field is found and visible
	 * Assert.assertNotNull(pwd, "Password field is not found!");
	 * Assert.assertTrue(pwd.isDisplayed(), "Password field is not visible!");
	 * 
	 * // Interact with the password field pwd.click(); Thread.sleep(2000);
	 * pwd.sendKeys("1932"); System.out.println("Value sent to password field."); }
	 * catch (Exception e) {
	 * System.err.println("Failed to locate the password field: " + e.getMessage());
	 * Assert.fail("Password field is not clickable or found."); } }
	 */

    @Test(priority = 3)
    public void checkTabs() throws InterruptedException {
        // XPath list of tabs to check
        String[] tabXPaths = {
           // "//android.widget.ImageView[@content-desc='Recharge']",
           // "//android.widget.ImageView[@content-desc='B-Tunes']",
           // "//android.widget.ImageView[@content-desc='Bill Payment']",          
            "//android.widget.ImageView[@content-desc='Add Money']",
           // "//android.widget.ImageView[@content-desc='Send Money']",
           // "//android.widget.ImageView[@content-desc='Tickets']",
           // "//android.widget.ImageView[@content-desc='Airtime Purchase']",
            "//android.widget.ImageView[@content-desc='Transaction History']",
            //"//android.widget.ImageView[@content-desc='Miss Call Alert']"
        };

        // Corresponding back button XPaths for each tab
        String[] backButtonXPaths = {
            //"//android.view.View[@content-desc='Recharge']/android.widget.Button[1]",
            //"//android.view.View[@content-desc='B-Tunes']/android.widget.Button[1]",
            //"//android.view.View[@content-desc='Bill Payment']/android.widget.Button[1]",  
            //"//android.view.View[@content-desc='Add Money']/android.widget.Button[1]",
            "//android.view.View[@content-desc='Send Money']/android.widget.Button[1]",
            //"//android.widget.View[@content-desc='Tickets']/android.widget.Button[1]",
            //"//android.widget.ImageView[@content-desc='Airtime Purchase']/android.widget.Button[1]",
            "//android.widget.ImageView[@content-desc='Transaction History']/android.widget.Button[1]",
            //"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button"
        };

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
                Thread.sleep(2000);  // wait for 2 seconds after clicking the tab

                // Click on the back button using its corresponding XPath
                WebElement backButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(backButtonXPath)));
                Assert.assertNotNull(backButton, "Back button is not found!");
                Assert.assertTrue(backButton.isDisplayed(), "Back button is not visible!");
                backButton.click();
                System.out.println("Back button clicked.");
                Thread.sleep(2000);  // wait for 2 seconds after clicking the back button

            } catch (Exception e) {
                System.err.println("Error while checking tab: " + tabXPath + " - " + e.getMessage());
                Assert.fail("Tab is not clickable or found: " + tabXPath);
            }
        }
    }
    
    @Test(priority = 4)
    public void Recharge() {
    	try {
        WebElement rechmod = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='Recharge']")));
        rechmod.click();}
        catch(Exception e){
        	 System.err.println("Error while checking tab: " + " - " + e.getMessage());
        }
    }
    
    @AfterTest
    public void teardown() {
        // Optionally: Quit driver after interaction
      //  if (driver != null) {
        //    driver.quit();
     //   }
    }
}
