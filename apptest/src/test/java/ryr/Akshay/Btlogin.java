package ryr.Akshay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Btlogin extends Btbase {
public static void m234() throws MalformedURLException, InterruptedException{
	//public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		cap.setCapability("appPackage", "com.bt.mybt");
		cap.setCapability("appActivity", "com.bt.mybt.MainActivity");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),
				cap);
		Thread.sleep(5000);
		//WebElement element = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]");
		WebElement element = driver.findElementByXPath("//*[@id=\"sc_input1\"]");
		if (element.isEnabled() && element.isDisplayed()) {
		    element.sendKeys("17151077");
		} else {
		    System.out.println("Element is not in a valid state for interaction.");
		}

	}
}
