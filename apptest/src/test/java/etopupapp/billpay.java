package etopupapp;



	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.Map;

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.springframework.util.Assert;

	import com.google.common.annotations.VisibleForTesting;

	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileBy;
	import io.appium.java_client.MobileElement;

	public class billpay {

		static AppiumDriver<MobileElement> driver;

		public static void main(String[] args) {
			try {
				Dealerapp();
			} catch (Exception exp) {
				System.out.println(exp.getCause());
				System.out.println(exp.getMessage());
				exp.printStackTrace();
			}
		}

		public static void Dealerapp() throws MalformedURLException, InterruptedException {

			System.out.println("Java runtime: " + System.getProperty("java.version")); // quick check

			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability("platformName", "Android");
			cap.setCapability("appium:deviceName", "Realme C9 Pro"); // optional
			cap.setCapability("appium:udid", "emulator-5554"); // ensure this matches your device
			cap.setCapability("appium:platformVersion", "12");
			cap.setCapability("appium:automationName", "UiAutomator2");
			cap.setCapability("appium:appPackage", "app.tayana.etopup");
			cap.setCapability("appium:appActivity", "app.tayana.etopup.MainActivity");

			// Stability helpers
			cap.setCapability("appium:ignoreHiddenApiPolicyError", true);
			cap.setCapability("appium:autoGrantPermissions", true);
			cap.setCapability("appium:disableWindowAnimation", true);

			// Start Appium with --relaxed-security for mobile: shell to work:
			// appium --allow-cors --relaxed-security
			URL url = new URL("http://127.0.0.1:4723/");
			driver = new AppiumDriver<>(url, cap);

			System.out.println("Dealer App Started Successfully ✅");

			WebDriverWait wait = new WebDriverWait(driver, 20);

			// Register
			MobileElement register = (MobileElement) wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Register']")));
			register.click();

			// Phone
			MobileElement phoneInput = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));
			phoneInput.sendKeys(dataprovider.Msisdn); // <-- make sure this exists

			// Continue
			MobileElement continueBtn = (MobileElement) wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Continue']")));
			continueBtn.click();

			// Build MSISDN
			// String countryCode = "248";
			String backendMsisdn = dataprovider.countryCode + dataprovider.Msisdn;
			String otp = null;
			for (int i = 0; i < 5; i++) {
				otp = OtpReader.getOTPFromServer(backendMsisdn); // <-- implement to return a 6-digit OTP
				if (otp != null && otp.length() == 6) {
					break;
				}
				System.out.println("OTP not yet generated, retrying...");
				Thread.sleep(3000);
			}
			if (otp == null || otp.length() != 6) {
				throw new RuntimeException("Invalid OTP fetched for MSISDN: " + backendMsisdn + ", value: " + otp);
			}
			System.out.println("Fetched OTP is: " + otp);

			// Wait for OTP screen
			// Loop through each digit (1 to 6)

			// Click first OTP box (to focus input)
			driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]")).click();

			// Send full OTP
			driver.getKeyboard().sendKeys(otp);

			MobileElement Verified = (MobileElement) wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Verify OTP\"]")));
			Verified.click();

			Thread.sleep(3000);

			driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]")).click();
			driver.getKeyboard().sendKeys(dataprovider.LoginPin);

			driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[7]")).click();
			driver.getKeyboard().sendKeys(dataprovider.LoginPin);

			MobileElement continues = (MobileElement) wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Continue']")));
			continues.click();
			System.out.println("register successfully done");

			MobileElement continuesLogin = (MobileElement) wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Continue to Login']")));
			continuesLogin.click();

			// login

			WebElement enterPhoneNumber = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='phone-input']")));
			enterPhoneNumber.sendKeys(dataprovider.Msisdn);

			System.out.println("Phone number entered");

			WebElement numberSubmit = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='Login']")));
			numberSubmit.click();

			String backendMsisdn1 = dataprovider.countryCode + dataprovider.Msisdn;
			String otp1 = null;
			for (int i = 0; i < 5; i++) {
				otp1 = OtpReader.getOTPFromServer(backendMsisdn); // <-- implement to return a 6-digit OTP
				if (otp1 != null && otp1.length() == 6) {
					break;
				}
				System.out.println("OTP not yet generated, retrying...");
				Thread.sleep(3000);
			}
			if (otp1 == null || otp1.length() != 6) {
				throw new RuntimeException("Invalid OTP fetched for MSISDN: " + backendMsisdn + ", value: " + otp1);
			}
			System.out.println("Fetched OTP is: " + otp1);

			driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]")).click();

			// Send full OTP
			driver.getKeyboard().sendKeys(otp1);

			MobileElement Verifotp = (MobileElement) wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Verify OTP\"]")));
			Verifotp.click();

			Thread.sleep(3000);

			driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]")).click();
			driver.getKeyboard().sendKeys(dataprovider.LoginPin);

			MobileElement logBtn = (MobileElement) wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Login']")));
			logBtn.click();

			// Bill pay functionality for the full payment method

			MobileElement Billpay = (MobileElement) wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Bill Pay']")));
			Billpay.click();

			if (dataprovider.accountnum.startsWith("0")) {

				throw new IllegalArgumentException("Invalid account number: It should not start with 0");

			} else {

				MobileElement Billpaytxt = (MobileElement) wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));
				Billpaytxt.sendKeys(dataprovider.accountnum);

				System.out.println("Account number enter successfully");

				MobileElement paybill = (MobileElement) wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Pay Bill']")));
				paybill.click();

				MobileElement conform = (MobileElement) wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Confirm']")));
				conform.click();

				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Enter Transaction PIN, Please enter your transaction PIN to proceed, Enter your Transaction PIN\"]/android.view.ViewGroup[2]/android.view.ViewGroup[1]")).click();
				driver.getKeyboard().sendKeys(dataprovider.Tran_Pin);

				MobileElement conformPin = (MobileElement) wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Confirm\"]")));
				conformPin.click();

				System.out.println("The full payment bill pay is getting successfully");
				
				

				// Recharge functionality for the prepid user

				if (!(dataprovider.accountnum.startsWith("25") || dataprovider.accountnum.startsWith("26"))) {

					throw new IllegalArgumentException("Invalid account number: It should not start with 25 or 26");
				}
				else {

					MobileElement recharge = (MobileElement) wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Recharge']")));
					recharge.click();

					MobileElement rechtxt = (MobileElement) wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));
					rechtxt.sendKeys(dataprovider.Mobilenum);

					System.out.println("Recharge number enter successfully");

					MobileElement Amt = (MobileElement) wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='SCR 100']")));
					Amt.click();

					MobileElement Recharge = (MobileElement) wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Recharge']")));
					Recharge.click();

					MobileElement conformrec = (MobileElement) wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Confirm']")));
					conformrec.click();

					driver.findElement(By.xpath("new UiSelector().className(\"android.view.ViewGroup\").instance(6)"))
							.click();
					driver.getKeyboard().sendKeys(dataprovider.Tran_Pin);

					MobileElement recconformPin = (MobileElement) wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Confirm\"]")));
					recconformPin.click();
					System.out.println("The recharge is done successfully");
					
					
					//profile settings
					
					MobileElement proicon = (MobileElement) wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.className("com.horcrux.svg.SvgView")));
					proicon.click();
					
					MobileElement profileSet = (MobileElement) wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Profile Settings']")));
					profileSet.click();
					
					MobileElement changepass = (MobileElement) wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Change Login PIN, Update your 6-digit login PIN']")));
					changepass.click();
					
					
					driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]")).click();
			         driver.getKeyboard().sendKeys(dataprovider.LoginPin);
			         
			         driver.findElement(By.xpath( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]")).click();
			         driver.getKeyboard().sendKeys(dataprovider.NewPass);
			         
			         driver.findElement(By.xpath( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]")).click();
			         driver.getKeyboard().sendKeys(dataprovider.NewPass);
			         
				}
			}
		}
	
}
