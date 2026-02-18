package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class sssss {

    // Declare AndroidDriver instance
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Set desired capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
        cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

        // Initialize the AndroidDriver for Appium
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @Test
    public void testAccountBalanceMenu() throws InterruptedException {
        try {
            // Handle "Getting Started" button if it appears
            try {
                WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
                gettingStartedButton.click();
                System.out.println("Clicked on 'Getting Started' button.");
            } catch (Exception e) {
                System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
            }
            try {
            // Wait for the mobile number field to appear and interact with it
            System.out.println("Waiting for the mobile number field to appear...");
            WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
            mobileNumberField.click();
            Thread.sleep(2000);

            // Send value to the mobile number field
            mobileNumberField.sendKeys("17114003");
            System.out.println("Value sent to mobile number field.");
            Thread.sleep(2000);
            } catch (Exception e) {
                System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
            }
            // Locate and interact with the password field
            try {
                WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
                pwd.click();
                Thread.sleep(2000);
                pwd.sendKeys("2580");
                System.out.println("Value sent to pwd field.");
            } catch (Exception e) {
                System.err.println("Failed to locate the pwd field: " + e.getMessage());
            }

            // Wait for the account balance menu to be visible
            WebElement accountBalanceMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[@content-desc='ACCOUNT BALANCE Show menu']/android.view.View")));
            WebElement accountBal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[@content-desc='Validity: 01/11/2024']")));
            
            String accountBalyty = accountBal.getText();
            System.out.println("Account Balance Text: " + accountBalyty);

            // Get the text from the matching element
            String contentDesc = accountBalanceMenu.getAttribute("contentDescription");
            System.out.println("Account Balance Content Description: " + contentDesc);


            // Assert that the text is not empty
        //    Assert.assertNotNull(accountBalanceText, "Account Balance text should not be null.");

            // If there are multiple sub-elements with text, capture all the text
            List<WebElement> balanceSubElements = accountBalanceMenu.findElements(By.xpath("//android.view.View[@content-desc='ACCOUNT BALANCE Show menu']/android.view.View"));

            // Loop through and print all the text from sub-elements
            for (WebElement subElement : balanceSubElements) {
                System.out.println("Sub-element text: " + subElement.getText());
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        // Clean up and close the driver
       // if (driver != null) {
         //   driver.quit();
        }
    
}
