package phase2;



	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.nativekey.AndroidKey;
	import io.appium.java_client.android.nativekey.KeyEvent;
	import io.appium.java_client.touch.WaitOptions;
	import io.appium.java_client.touch.offset.PointOption;
	import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	// Other imports...
	import java.net.MalformedURLException;
	import java.net.URL;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.remote.MobilePlatform;

	public class sprint1 {

		private AndroidDriver driver;
		private WebDriverWait wait;

		@BeforeTest
		public void setUp() throws MalformedURLException {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			cap.setCapability("appPackage", "com.bt.mybt");
			cap.setCapability("appActivity", "MainActivity");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		}

		@Test
		public void testRechargeFlow() throws InterruptedException {
		    try {
		        // Getting Started button
		        WebElement gettingStartedButton = wait.until(ExpectedConditions
		                .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
		        gettingStartedButton.click();
		        System.out.println("Clicked on 'Getting Started' button.");

		        // Optional popup cancel
		        try {
		            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//android.view.View[contains(@content-desc,'Register')]")));
		            WebElement cancelButton = wait.until(ExpectedConditions
		                    .elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
		            cancelButton.click();
		            System.out.println("Popup handled successfully by clicking 'Cancel'.");
		        } catch (Exception e) {
		            System.out.println("No popup appeared or it was already handled.");
		        }

		        // Enter mobile number
		        WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		                "//android.widget.EditText[1]")));
		        mobileNumberField.click();
		        Thread.sleep(2000);
		        mobileNumberField.sendKeys("17317670");
		        System.out.println("Value sent to mobile number field.");

		        // Enter password
		        WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		                "//android.widget.EditText[2]")));
		        pwd.click();
		        Thread.sleep(2000);
		        pwd.sendKeys("2580");
		        System.out.println("Value sent to password field.");

		        String otp = "";
		        try {
		            URL url = new URL("http://202.144.156.10/cgi-bin/OTP?");
		            HttpURLConnection http = (HttpURLConnection) url.openConnection();
		            http.setRequestMethod("GET");
		            http.setRequestProperty("Accept", "*/*");

		            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
		            StringBuilder response1 = new StringBuilder();
		            String responseLine;
		            while ((responseLine = br.readLine()) != null) {
		                response1.append(responseLine.trim());
		            }

		            br.close();
		            http.disconnect();

		            String response = response1.toString();
		            System.out.println("Raw CGI Response = [" + response + "]");

		            // Try extracting OTP using a regex like "OTP=123456"
		            Pattern pattern = Pattern.compile("OTP\\s*=\\s*(\\d+)");
		            Matcher matcher = pattern.matcher(response);
		            if (matcher.find()) {
		                otp = matcher.group(1);
		            }

		            System.out.println("Extracted OTP = [" + otp + "]");
		            Assert.assertFalse(otp.isEmpty(), "OTP was not found in the response!");

		            WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.className("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"))); // or better locator
		            otpField.click();
		            otpField.sendKeys(otp);

		        } catch (Exception e) {
		            e.printStackTrace();
		            Assert.fail("Exception during OTP fetch or entry: " + e.getMessage());
		        }

		    } catch (Exception e) {
	            e.printStackTrace();
	            Assert.fail("Exception occurred during OTP API call: " + e.getMessage());
	        }
		    WebElement prc = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Proceed']")));
			prc.click();	

		}}



