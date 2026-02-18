package etopupapp;


	import io.appium.java_client.AppiumBy;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.options.UiAutomator2Options;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.testng.Assert;
	import org.testng.annotations.*;

	import java.lang.reflect.Method;
	import java.net.URL;
	import java.time.Duration;
	import java.util.Map;

	public class PrepaidMobileAndBroadbandPackPurchase {
		
		 private AndroidDriver driver;
		    private WebDriverWait wait;

		    @BeforeClass
		    public void setup() throws Exception {
		    	 RemoteAliasExecutor.execute("pre");
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
		    
		 // 🔥 ADDED BLOCK (No change to your test methods)
		    @BeforeMethod
		    public void handleBackendSwitch(Method method) throws Exception {
		    	UiAutomator2Options options = new UiAutomator2Options();
		        if (method.getName().equals("VerifyPostPaidMobliePackage")) {

		            driver.quit();
		            System.out.println("Executing PO before Postpaid Mobile Package");
		            RemoteAliasExecutor.execute("po");
		            Thread.sleep(10000);

		            driver = new AndroidDriver(new URL(Dealerapptestdata.APPIUM_URL), options);
		            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		        }


		    }

		    @Test(priority = 1)
		    public void VerifyMobliePackage() throws Exception {
		    	
//		        wait.until(ExpectedConditions.elementToBeClickable(
//		                By.id("com.android.permissioncontroller:id/permission_allow_button")))
//		                .click();
		        Thread.sleep(6000);
		    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Mobile Packages\"]")).click();
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"mobile-number-input\"]")).sendKeys(Dealerapptestdata.MOBILENUMBER);
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"Select Package\"])[2]")).click();
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
		    	Thread.sleep(3000);
		    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Confirm\"]")).click();
		    	Thread.sleep(5000);
		    	By successLocator = By.xpath(
		    	        "//android.widget.TextView[contains(@text,'successfully purchased')]"
		    	);
		    	
		    	Thread.sleep(1000);

		    	if (driver.findElements(successLocator).size() > 0) {

		    	    System.out.println("✅ Prepaid Mobile Package Purchase successful");
		    	    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Done\"]")).click();
		    	    
		    	} else {

		    	    System.out.println("❌ Prepaid Mobile Package Purchase Failure");
		    	    Assert.fail("Prepaid Mobile Package Purchase failed - Success message not found");
		    	}
		    driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/com.horcrux.svg.SvgView")).click();
		    Thread.sleep(2000);
		    
		    }
		    	
		        @Test(priority = 2)
		       
		        public void VerifyBroadbandPackage() throws Exception {
		        	
		        	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Broadband Packages\"]")).click();
		        	Thread.sleep(2000);
		        	driver.findElement(By.xpath("//android.widget.EditText[@text=\"e.g: john or 30654321\"]")).sendKeys(Dealerapptestdata.BROADBANDPRENUMBER);
		        	Thread.sleep(2000);
		        	driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
		        	Thread.sleep(5000);
		        	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Select Package\"]")).click();
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

			    	    System.out.println("✅ Prepaid Broadband Package Purchase successful");
			    	    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Done\"]")).click();

			    	} else {

			    	    System.out.println("❌ PrepaidBroadband Package Purchase Failure");
			    	    Assert.fail("Prepaid Broadband Package Purchase failed - Success message not found");
			    	}
			    driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/com.horcrux.svg.SvgView")).click();	        	
		        	
		        }
		        
		        @Test(priority = 3)
		        public void VerifyMobliePackageWithInvalidNumber() throws Exception {
			    	
			        Thread.sleep(1000);
			    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Mobile Packages\"]")).click();
			    	Thread.sleep(2000);
			    	driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"mobile-number-input\"]")).sendKeys(Dealerapptestdata.INVALIDMNUMBER);
			    	Thread.sleep(2000);
			    	By ValidationFailureMsg = By.xpath("//android.widget.TextView[@text=\"Number must be 7 digits and start with 25, 26\"]");
			    	if (driver.findElements(ValidationFailureMsg).size() > 0) {

			    	    System.out.println("✅ Validation Error Display Successfully");
			    	    
			    	    driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/com.horcrux.svg.SvgView")).click();

			    	} else {

			    	    System.out.println("❌ Validation Error Display Unsuccessfull");
			    	    driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/com.horcrux.svg.SvgView")).click();
			    	    Assert.fail("Validation Error Display Unsuccessfull");
			    	}		    	
			    }

	

}
