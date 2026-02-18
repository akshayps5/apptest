package etopupapp;



	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.options.UiAutomator2Options;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.*;

	import java.net.URL;
	import java.time.Duration;
	import java.util.Map;


	public class PostpaidMobileandBroadandPackPurchase {
		
		 private AndroidDriver driver;
		    private WebDriverWait wait;

		    @BeforeClass
		    public void setup() throws Exception {
		    	 RemoteAliasExecutor.execute("po");
		        UiAutomator2Options options = new UiAutomator2Options();

		        options.setPlatformName(Dealerapptestdata.PLATFORM_NAME);
		        options.setPlatformVersion(Dealerapptestdata.PLATFORM_VERSION);
		        options.setDeviceName(Dealerapptestdata.DEVICE_NAME);
		        options.setAutomationName(Dealerapptestdata.AUTOMATION_NAME);
		        options.setAppPackage(Dealerapptestdata.APP_PACKAGE);
		        options.setAppActivity(Dealerapptestdata.APP_ACTIVITY);
		        options.setNoReset(true);
		        driver = new AndroidDriver(new URL(Dealerapptestdata.APPIUM_URL), options);

		        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		        System.out.println("App launched successfully");
		        Thread.sleep(2000);
		    }
		    
		    @Test(priority = 1)
		    public void VerifyPostPaidMobliePackage() throws Exception {
		    	
		    	System.out.println("Executing VerifyPostPaidMobliePackage");
		        Thread.sleep(2000);
		    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Mobile Packages\"]")).click();
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"mobile-number-input\"]")).sendKeys(Dealerapptestdata.MOBILENUMBER);
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"Select Package\"])[1]")).click();
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Confirm\"]")).click();
		    	Thread.sleep(2000);	 
//		    	driver.findElement(
//		    		    By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]")
//		    		).click();
		    	((JavascriptExecutor) driver).executeScript(
		    	        "mobile: type",
		    	        Map.of("text", Dealerapptestdata.DEALERPIN)
		    	        
		    	 
		    	);
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Confirm\"]")).click();
		    	Thread.sleep(5000);
		    	By successLocator = By.xpath(
		    	        "//android.widget.TextView[contains(@text,'successfully purchased')]"
		    	);

		    	Thread.sleep(1000);

		    	if (driver.findElements(successLocator).size() > 0) {

		    	    System.out.println("✅ Postpaid Mobile Package Purchase successful");
		    	    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Done\"]")).click();
		    	    
		    	} else {

		    	    System.out.println("❌ Postpaid Mobile Package Purchase Failure");
		    	    Assert.fail("Postpaid Mobile Package Purchase failed - Success message not found");
		    	}
		    driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/com.horcrux.svg.SvgView")).click();
		    Thread.sleep(2000);
		    
		    }
	        
	        
	        
	        @Test(priority = 2)
		       
	        public void VerifyPostpaiBroadbandPackage() throws Exception {
	        	
	        	System.out.println("Executing VerifyPostpaiBroadbandPackage");
	        	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Broadband Packages\"]")).click();
	        	Thread.sleep(2000);
	        	driver.findElement(By.xpath("//android.widget.EditText[@text=\"e.g: john or 30654321\"]")).sendKeys(Dealerapptestdata.BROADBANDPOSNUMBER);
	        	Thread.sleep(2000);
	        	driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
	        	Thread.sleep(5000);
	        	driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"Select Package\"])[1]")).click();
	        	Thread.sleep(4000);
	        	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Confirm\"]")).click();
	        	Thread.sleep(2000);
	        	((JavascriptExecutor) driver).executeScript(
		    	        "mobile: type",
		    	        Map.of("text", Dealerapptestdata.DEALERPIN)
		    	        
		    	 
		    	);
		    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Confirm\"]")).click();
		    	Thread.sleep(5000);
		    	
		    	By successLocator = By.xpath(
		    	        "//android.widget.TextView[contains(@text,'successfully purchased')]"
		    	);

		    	Thread.sleep(1000);

		    	if (driver.findElements(successLocator).size() > 0) {

		    	    System.out.println("✅ POSTPAID Broadband Package Purchase successful");
		    	    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Done\"]")).click();

		    	} else {

		    	    System.out.println("❌ POSTPAID Broadband Package Purchase Failure");
		    	    Assert.fail("POSTPAID Broadband Package Purchase failed - Success message not found");
		    	}
		    driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/com.horcrux.svg.SvgView")).click();	        	
	        	
	        }
		    
		    

	

}
