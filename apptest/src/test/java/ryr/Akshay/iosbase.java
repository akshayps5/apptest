package ryr.Akshay;


	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.ios.IOSDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import java.net.MalformedURLException;
	import java.net.URL;

	public class iosbase {	
	    public static void main(String[] args) {
	        // Set the Appium server address
	        URL appiumServerURL;
	        try {
	            appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("Failed to initialize Appium server URL: " + e.getMessage());
	        }

	        // Set the desired capabilities for iOS simulator
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("platformName", "iOS");
	        capabilities.setCapability("platformVersion", "14.5");
	        capabilities.setCapability("deviceName", "iPhone 12");
	        capabilities.setCapability("app", "path/to/your/app.app");

	        // Create an instance of IOSDriver
	        AppiumDriver<MobileElement> driver = new IOSDriver<>(appiumServerURL, capabilities);

	        // Your automation script goes here
	        // Example: Click on an element
	        MobileElement element = driver.findElementByAccessibilityId("YourElementAccessibilityId");
	        element.click();

	        // Close the app
	        driver.closeApp();

	        // Quit the driver
	        driver.quit();
	    }
	}

}
