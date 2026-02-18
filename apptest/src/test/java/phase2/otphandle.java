package phase2;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;
import java.util.List;
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

public class otphandle {

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
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@Test(priority = 1)
	public void gettingstarted() throws InterruptedException {
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
			WebElement mobileNumberField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[1]")));
			mobileNumberField.click();
			
			mobileNumberField.sendKeys("17317670");
			System.out.println("Value sent to mobile number field.");

			// Enter password
			WebElement pwd = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[2]")));
			pwd.click();
	
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
				System.out.println("Full OTP Response: " + response);

				otp = response.replaceAll("\\D+", "");
				Assert.assertFalse(otp.isEmpty(), "OTP was not found in the response!");
				System.out.println("Extracted OTP: " + otp);
				Thread.sleep(1000);
				
					
					
					// Assuming OTP is always 6 digits
					if (otp.length() == 6) {
						List<WebElement> otpInputs = wait.until(ExpectedConditions
							    .visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.EditText")));

					    if (otpInputs.size() >= 6) {
					        for (int i = 0; i < 6; i++) {
					            otpInputs.get(i).click();  // focus
					            otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
					            Thread.sleep(200); // small pause to ensure input registers
					        }
					        System.out.println("OTP entered across 6 fields.");
					    } else {
					        Assert.fail("Less than 6 OTP input fields found.");
					    }
					} else {
					    Assert.fail("OTP is not 6 digits: " + otp);
					}

				

				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK)); // hide keyboard

				WebElement prc = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Proceed']")));
				prc.click();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred during OTP API call: " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void btune() throws InterruptedException {
		WebElement rty = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='B-Tunes']")));
		rty.click();

		WebElement rtyf = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//android.view.View[@content-desc=' Failed! Could not fetch status']/android.widget.Button")));

		String statusText = rtyf.getText();
		System.out.println("Status message: " + statusText);
	}
}
