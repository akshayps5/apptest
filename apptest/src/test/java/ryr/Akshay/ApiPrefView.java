package ryr.Akshay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ApiPrefView {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "automator2");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),
				cap);
		Thread.sleep(2000);
		driver.findElementById("android:id/text1").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc='Custom View']").click();
		Thread.sleep(2000);
		driver.navigate().back();
	//	driver.findElementByXPath("//android.widget.TextView[@text='1. Preferences from XML']").click();

		// 3 Find all elements of class android.widget.CheckBox.
//		List<MobileElement> elementList = driver.findElementsByClassName("android.widget.CheckBox");
//
//		// 4 Click on the second element from the list   android:id/text1
//		elementList.get(1).click();
	}
}
