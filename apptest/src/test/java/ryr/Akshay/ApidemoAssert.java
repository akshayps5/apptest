package ryr.Akshay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ApidemoAssert {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),
				cap);
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"App\"]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Notification\"]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"IncomingMessage\"]").click();
		Thread.sleep(2000);
		MobileElement textElement = driver.findElementByXPath(
				"//android.widget.TextView[@content-desc=\'Display a notification that will switch to the app in a new activity stack.']");
		String actualOutput = textElement.getText();
		System.out.println(actualOutput);
		String expectedOutput = "Display a notification that will switch to the app in a new activity stack";
		Assert.assertTrue(actualOutput.contains(expectedOutput), "Error message");
		driver.navigate().back();
	}
}
