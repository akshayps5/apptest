package etopupapp;


	
	 
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.options.UiAutomator2Options;
	 
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;
	 
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	 
	public class Dealerapp {
	 
	    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	 
	        URL url = new URL("http://127.0.0.1:4723");
	 
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("Android");
	        options.setDeviceName("emulator-5554");
	        options.setAutomationName("UiAutomator2");
	 
	        options.setAppPackage("app.tayana.etopup");
	        options.setAppActivity("app.tayana.etopup.MainActivity");
	 
	        AndroidDriver driver = new AndroidDriver(url, options);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 
	        System.out.println("App launched successfully on Emulator");
	        
	     // 1️⃣ Allow permission (system dialog)
	        WebElement allowNotification = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.id("com.android.permissioncontroller:id/permission_allow_button")));
	        allowNotification.click();
	 
	     // 2️⃣ Enter phone number (UI expects local number)
	        String localNumber = "2565896";
	 
	        WebElement enterPhoneNumber = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//android.widget.EditText[@resource-id='phone-input']")));
	        enterPhoneNumber.sendKeys(localNumber);
	 
	        System.out.println("Phone number entered");
	 
	        // 3️⃣ Click Login
	        WebElement numberSubmit = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//android.view.ViewGroup[@content-desc='Login']")));
	        numberSubmit.click();
	 
	        // 4️⃣ Build backend MSISDN (country code + local)
	        String countryCode = "248";
	        String backendMsisdn = countryCode + localNumber;
	 
	        // 5️⃣ Fetch OTP with retry
	        String otp = null;
	 
	        for (int i = 0; i < 5; i++) {
	            otp = OtpReader.getOTPFromServer(backendMsisdn);
	 
	            if (otp != null && otp.length() == 6) {
	                break;
	            }
	 
	            System.out.println("OTP not yet generated, retrying...");
	            Thread.sleep(3000);
	        }
	 
	        if (otp == null) {
	            throw new RuntimeException("OTP not generated for MSISDN: " + backendMsisdn);
	        }
	 
	        System.out.println("Fetched OTP is : " + otp);
	        
	     // 6️⃣ Safety check
	        if (otp == null || otp.length() != 6) {
	            throw new RuntimeException("Invalid OTP fetched: " + otp);
	        }
	 
	        // 7️⃣ Split OTP into individual digits
	        char[] otpDigits = otp.toCharArray();
	 
	        char d1 = otpDigits[0];
	        char d2 = otpDigits[1];
	        char d3 = otpDigits[2];
	        char d4 = otpDigits[3];
	        char d5 = otpDigits[4];
	        char d6 = otpDigits[5];
	        
	     // 6️⃣ Enter OTP digits one by one using explicit wait
	 
	        WebElement otp1 = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]")));
	        otp1.sendKeys(String.valueOf(d1));
	 
	        WebElement otp2 = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[2]")));
	        otp2.sendKeys(String.valueOf(d2));
	 
	        WebElement otp3 = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[3]")));
	        otp3.sendKeys(String.valueOf(d3));
	 
	        WebElement otp4 = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[4]")));
	        otp4.sendKeys(String.valueOf(d4));
	 
	        WebElement otp5 = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[5]")));
	        otp5.sendKeys(String.valueOf(d5));
	 
	        WebElement otp6 = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[6]")));
	        otp6.sendKeys(String.valueOf(d6));
	 
	 
	 
	        
	        
	 
	    }
	}

