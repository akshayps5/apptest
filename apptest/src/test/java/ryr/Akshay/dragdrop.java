package ryr.Akshay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class dragdrop {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),
				cap);
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]").click();
		Thread.sleep(2000);
	WebElement source = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
	source.click();
	WebElement target = driver.findElementById("io.appium.android.apis:id/drag_dot_2");
	target.click();
	Thread.sleep(2000);
	Actions action = new Actions(driver);
	action.clickAndHold(source).moveToElement(target).release().build().perform();
	action.moveToElement(source);
	action.clickAndHold();
	Thread.sleep(2000);
	action.moveToElement(target);
	Thread.sleep(2000);
	action.release().build().perform();
}}
