package ryr.Akshay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class cwsmycareloginTest {

  @Test
  public void m2345Test() throws InterruptedException, MalformedURLException {
	  DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		cap.setCapability("appPackage", "com.cws.mycare");
		cap.setCapability("appActivity", "com.cws.mycare.MainActivity");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),
				cap);
		WebElement element = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.id("usrname")));
		if (element.isEnabled() && element.isDisplayed()) {
		    element.sendKeys("17151077");
		} else {
		    System.out.println("Element is not in a valid state for interaction.");
		}
	  }

  }

