package ryr.Akshay;
import java.net.MalformedURLException;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Start extends Apklogin {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// Setup Desired Capabilities and initiate the session to Appium Server. 
		AndroidDriver<MobileElement> driver = setupDesiredCapabilities();

		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
	//	Thread.sleep(3000);
		// 2.2 Find an element of class 'android.widget.TextView' with the attribute 'text' valued '1. Preferences from XML'
		//	   and then click
		driver.findElementByXPath("//android.widget.TextView[@text='1. Preferences from XML']").click();
	//	Thread.sleep(3000);		
		// 3 Find all elements of class android.widget.CheckBox.
		List<MobileElement> elementList = driver.findElementsByClassName("android.widget.CheckBox");
	//	Thread.sleep(3000);
		// 4 Click on the second element from the list
		elementList.get(1).click();
		//Thread.sleep(3000);
		// 5 Click on the third element from the list
//		elementList.get(2).click();		
	}
		
}


