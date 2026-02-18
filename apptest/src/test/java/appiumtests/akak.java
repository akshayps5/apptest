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

public class akak {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Set desired capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability("appPackage", "com.bt.mybtnew");
        cap.setCapability("appActivity", "com.bt.mybtnew.MainActivity");

        // Initialize the AndroidDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        // Use WebDriverWait to wait for the mobile number field to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased wait time

        try {
            // Click on the Getting Started button
            WebElement gettingStartedButton = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']"))
            );
            gettingStartedButton.click();
            
            // Wait for 3 seconds to allow the next UI to load
            Thread.sleep(3000);

            // Locate the mobile number field
            System.out.println("Waiting for the mobile number field to appear...");
            WebElement mobileNumberField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]"
                ))
            );

            // Send value to the mobile number field
            mobileNumberField.sendKeys("9876543210");
            System.out.println("Value sent to mobile number field.");

        } catch (Exception e) {
            System.err.println("Failed to locate the mobile number field: " + e.getMessage());
        } finally {
            // Quit driver
         //   driver.quit();
        }
    }
}
