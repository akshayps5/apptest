package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class highlight {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() throws MalformedURLException {
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

    @Test
    public void testBillPayFlow() throws InterruptedException {
        try {
            // Wait for and click the 'Getting Started' button
            WebElement gettingStartedButton = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
            Assert.assertNotNull(gettingStartedButton, "'Getting Started' button was not found.");
            gettingStartedButton.click();
            WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
            cancelButton.click();
            System.out.println("Clicked on 'Getting Started' button.");
        } catch (Exception e) {
            System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
            Assert.fail("Failed to click on 'Getting Started' button.");
            return; // Exit test to avoid further failures
        }

        try {
            // Locate and interact with the mobile number field
            WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
            Assert.assertNotNull(mobileNumberField, "Mobile number field was not found.");
            mobileNumberField.click();
            Thread.sleep(5000); // Optional: Use implicit waits instead
          //  mobileNumberField.sendKeys("17711482");
            System.out.println("Value sent to mobile number field.");
        } catch (Exception e) {
            System.err.println("Failed to locate or interact with the mobile number field: " + e.getMessage());
            Assert.fail("Mobile number field is not clickable or found.");
        }
    }


    @AfterTest
    public void tearDown() {
        //if (driver != null) {
          //  driver.quit(); // Quit the driver after execution
        }
    }

