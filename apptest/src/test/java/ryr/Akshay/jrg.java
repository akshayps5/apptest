package ryr.Akshay;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class jrg {
	private static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.bt.mybt");
		cap.setCapability("appActivity", "com.bt.mybt.MainActivity");

		AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub/"), cap);
Thread.sleep(2000);
		// Wait for the element to be visible before trying to interact with it
		MobileElement element = (MobileElement) driver.findElementByXPath("//*[@id=\"sc_input1\"]");
		//android.widget.TextView[@text='Preference']").click();
		element.sendKeys("17392651");

		// Update the XPath for the second element
		MobileElement element2 = (MobileElement) driver.findElementByXPath("your_updated_xpath_for_second_element");
		element2.sendKeys("2580");

	}
}
