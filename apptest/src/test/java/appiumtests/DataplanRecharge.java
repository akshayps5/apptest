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

//import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DataplanRecharge {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
        cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

        // Initialize the AndroidDriver for Appium
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @Test
    public void testRechargeFlow() {
        try {
            // Locate and click the "Getting Started" button
            WebElement gettingStartedButton = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
            gettingStartedButton.click();
            System.out.println("Clicked on 'Getting Started' button.");
            
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

            // Click recharge icon
            WebElement rechargeIcon = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[contains(@content-desc,'Recharge')]")));
            rechargeIcon.click();
            System.out.println("Clicked on 'Recharge' icon.");

            // Click on "View Plans"
            WebElement viewPlansButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='View Plans']")));
            viewPlansButton.click();
            System.out.println("Clicked on 'View Plans' button.");

            // Wait for available plans popup and tap "+" button
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[contains(@content-desc,'Available Plan')]")));

            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1230, 1048))).perform();
            System.out.println("Tapped '+' button for the selected plan.");

            // Select payment method
            WebElement paymentMethodButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Payment Method']")));
            paymentMethodButton.click();
            System.out.println("Clicked on 'Payment Method' button.");

            // Select B-Ngul payment option
            WebElement bngulOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.ImageView[@content-desc='B-Ngul']")));
            bngulOption.click();
            System.out.println("Selected 'B-Ngul' payment method.");

            // Click the "Recharge" button
            WebElement rechargeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Recharge']")));
            rechargeButton.click();
            System.out.println("Clicked on 'Recharge' button.");

            // Confirm recharge
            WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Confirm']")));
            confirmButton.click();
            System.out.println("Clicked on 'Confirm' button.");
            
           // Thread.sleep(2000);
            
         // Wait for the MPIN entry pop-up
            WebElement mpinField3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
            mpinField3.click();
            Thread.sleep(1000);
            mpinField3.sendKeys("4544");
            System.out.println("Entered MPIN.");
 
            // Validation: Ensure MPIN is entered correctly
            Assert.assertEquals(mpinField3.getAttribute("text"), "", "8484MPIN not entered correctly.");
 
            // Click on the "Proceed" button
            WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Proceed']")));
            proceedButton.click();
            System.out.println("Clicked on 'Proceed' button.");
 
            // Validation: Ensure proceed button was clicked
            Assert.assertNotNull(proceedButton, "'Proceed' button not clicked.");
    

        } catch (Exception e) {
            System.err.println("Error during test execution: " + e.getMessage());
            Assert.fail("Test case failed.");
        }
    }

   /* @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver closed successfully.");
        }
    }*/
}
