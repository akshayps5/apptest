package etopupapp;


	

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;

	public class register {
		
		
		static AppiumDriver<MobileElement> driver;
	   
		public static void main(String[] args) {
			
			try {
				Dealerapp();
			}catch (Exception exp) {
				System.out.println(exp.getCause());
				System.out.println(exp.getMessage());
				exp.printStackTrace();
			}
			

		}
		
		public static void Dealerapp() throws MalformedURLException, InterruptedException {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			
			 
	        cap.setCapability("platformName", "Android");
	        cap.setCapability("appium:deviceName", "Realme C9 Pro");
	        cap.setCapability("appium:udid", "emulator-5554");
	        cap.setCapability("appium:platformVersion", "12");
	        cap.setCapability("appium:automationName", "UiAutomator2");
	        cap.setCapability("appium:appPackage", "app.tayana.etopup");
	        cap.setCapability("appium:appActivity", "app.tayana.etopup.MainActivity");
	      //  cap.setCapability("browserName", "");
	        
	     // 🔥 CRITICAL for Android 13+ real devices
	        cap.setCapability("appium:ignoreHiddenApiPolicyError", true);
	 
	        // 🛡 Stability helpers
	        cap.setCapability("appium:autoGrantPermissions", true);
	        cap.setCapability("appium:disableWindowAnimation", true);
	 
	        URL url = new URL("http://127.0.0.1:4723/");
	        
	 
	         driver = new AppiumDriver<MobileElement>(url, cap);
	 
	        System.out.println("Dealer App Started Successfully ✅");
	        
	        
	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        
	        MobileElement register= (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated
	       		 (By.xpath("//android.widget.TextView[@text=\"Register\"]")));
	       
	        register.click();
	        
	        MobileElement phoneInput = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated
	        		(By.className("android.widget.EditText") ) );
	        
	        //phoneInput.click();
	        phoneInput.sendKeys(Dataproviderapp.Login);

	        MobileElement Continue = (MobileElement) wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//android.view.ViewGroup[@content-desc='Continue']")));

	        Continue.click();

	        
	        MobileElement verifiedOtp = (MobileElement) wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//android.widget.TextView[@text='Verify OTP']")  ) );

	          verifiedOtp.click();

	         
	         
	         List<MobileElement> otpFields = driver.findElements(	
	        	        By.xpath("//android.view.ViewGroup[@resource-id='otp-input']"));
	         String msisdn = Dataproviderapp.Login;
	        	Object otp = OtpReader.getOTPFromServer(msisdn);
	        	System.out.println(otp);
	        	
	        	
		}
		
		

	}


