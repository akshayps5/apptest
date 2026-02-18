package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Calcuatortest {
	
    static AppiumDriver driver;
    public static void main(String[] args) throws MalformedURLException {
    	openCalculator();
    }
	
	public static void openCalculator() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("DeviceName","RedmiNote 8 Pro" );
		cap.setCapability("udid","zxkz6d4dmfzp6dts");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","11");
		cap.setCapability("automationName","uiAutomator2");
		
		cap.setCapability("appPackage","com.example.mybt");
		cap.setCapability("appActivity","com.example.mybt.MainActivity");
		//cap.setCapability("appPackage","com.ubercab");
		//cap.setCapability("appActivity","com.ubercab.presidio.app.core.root.RootActivity");
		cap.setCapability("uiautomator2ServerInstallTimeout", 60000); // 60 seconds

		
		URL url = new URL("http://127.0.0.1:4723/");		
        driver = new AppiumDriver(url,cap);
        
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"Getting Started\")")).click();
        
        //driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(5)")).click();
        
        
        
        System.out.println("Application Mybtapp");
		
		
	}


}
