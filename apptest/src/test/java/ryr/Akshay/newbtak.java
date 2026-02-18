package ryr.Akshay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class newbtak {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Set the desired capabilities for the Android device and application
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

        // Set the app package and app activity of the target app
        cap.setCapability("appPackage", "com.bt.mybtnew");
        cap.setCapability("appActivity", "com.bt.mybtnew.MainActivity");

        // Initialize the AndroidDriver with Appium server URL and desired capabilities
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        // Interact with the UI element (Button) using its XPath via By.xpath
        WebElement gettingStartedButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Getting Started']"));
        gettingStartedButton.click();

        // Optional: Add a delay to observe the interaction
        Thread.sleep(2000);

        // Close the driver
        driver.quit();
    }
}
