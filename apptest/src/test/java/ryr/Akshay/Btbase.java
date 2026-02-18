package ryr.Akshay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Btbase {
//	public static AndroidDriver<MobileElement> setupDesiredCapabilities() throws MalformedURLException {
		// public static void AndroidDriver<AndroidElement> throws MalformedURLException
		// {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		cap.setCapability("appPackage", "com.bt.mybtnew");
		cap.setCapability("appActivity", "com.bt.mybtnew.MainActivity");

	//	AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),
				cap);
driver.findElementByXPath("//android.widget.Button[@content-desc=\"Getting Started\"]");
	}
}
