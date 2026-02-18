package ryr.Akshay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AcceptCode {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID );
	
	//	 cap.setCapability("platformVersion", "12.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
		cap.setCapability("appPackage", "com.example.PDFApp");
		cap.setCapability("appActivity", "com.example.PDFApp.MainActivity");
		AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		Thread.sleep(6000);
		//   MobileElement acceptButton = driver.findElement(MobileBy.id("acceptButtonId")); // Replace with the actual ID
	 //       acceptButton.click();
	        
	        

	        // You might need to wait for some time to ensure the operation is completed
	      //  Thread.sleep(3000);
}}