package ryr.Akshay;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class IosAndAndroid {

	private static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		// Set the desired capabilities for your app and device
		DesiredCapabilities capabilities = new DesiredCapabilities();
		

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		
		capabilities.setCapability("appPackage", "com.bt.mybt");
		capabilities.setCapability("appActivity", "com.bt.mybt.MainActivity");
		// Set the Appium server URL
		URL serverURL = new URL("http://localhost:4723/wd/hub");

		// Initialize the driver based on the platform
		if (capabilities.getCapability("platformName").equals("Android")) {
			driver = new AndroidDriver<>(serverURL, capabilities);
		} else if (capabilities.getCapability("platformName").equals("iOS")) {
			driver = new IOSDriver<>(serverURL, capabilities);
		}

		// Perform the login
		performLogin();

		// driver.quit();
	}

	private static void setCapability(String platformName, String android) {
		// TODO Auto-generated method stub

	}

	private static void performLogin() {
		// Your login elements' identifiers

		MobileElement element = (MobileElement) driver.findElementByXPath("//*[@id=\"sc_homeDiv\"]/div/div[1]/label");
		
		element.sendKeys("17392651");
		MobileElement element2 = (MobileElement) driver.findElementByXPath("");
		element2.sendKeys("2580");

		// Click the login button
	}
}