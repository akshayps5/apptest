package ryr.Akshay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Apklogin {
	//public static void main(String[] args) {
	public static AndroidDriver<MobileElement> setupDesiredCapabilities() throws MalformedURLException {
		//public static void AndroidDriver<AndroidElement>  throws MalformedURLException {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID );
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			//cap.setCapability("appPackage", "io.appium.android.apis");
		//	cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
			cap.setCapability("appPackage", "io.appium.android.apis");
			cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
			
			AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		//	return null;
			return driver;
}}