package appiumtests;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.nativekey.AndroidKey;
	import io.appium.java_client.android.nativekey.KeyEvent;
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.remote.MobilePlatform;

	public class tngbase {
	    private AndroidDriver driver;
	    private WebDriverWait wait;

	    @BeforeSuite
	    public void setUp() throws MalformedURLException {
	        // Set desired capabilities
	        DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	        cap.setCapability("appPackage", "com.bt.mybt");
	        cap.setCapability("appActivity", ".MainActivity t290");

	        // Initialize the AndroidDriver
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    }

	    @Test
	    public void registrationTest() throws InterruptedException {
	        try {
	            // Step 1: Click on "Getting Started" button
	            WebElement gettingStartedButton = wait.until(ExpectedConditions
	                    .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
	            gettingStartedButton.click();
	            System.out.println("Clicked on 'Getting Started' button.");

	            // Step 2: Enter mobile number
	            WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
	            mobileNumberField.click();
	            Thread.sleep(2000);
	            mobileNumberField.sendKeys("17711478");
	            System.out.println("Mobile number entered.");

	            // Step 3: Enter password
	            WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
	            pwd.click();
	            Thread.sleep(2000);
	            pwd.sendKeys("2580");
	            System.out.println("Password entered.");

	            // Step 4: Handle registration popup
	            WebElement dismissButton = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//android.view.View[contains(@content-desc, 'Failed!')]/android.widget.Button")));
	            dismissButton.click();
	            System.out.println("Dismissed the registration popup.");

	            // Step 5: Enter registration mobile number
	            WebElement registrationMobileField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.EditText[1]")));
	            registrationMobileField.click();
	            registrationMobileField.sendKeys("17711478");
	            System.out.println("Registration mobile number entered.");

	            // Step 6: Enter create pin
	            WebElement createPinField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.EditText[2]")));
	            createPinField.click();
	            createPinField.sendKeys("1234");

	            // Simulate pressing "Next" or "Done" on the mobile keyboard
	            driver.pressKey(new KeyEvent(AndroidKey.BACK));
	            System.out.println("Create pin entered.");

	            // Step 7: Enter confirm pin
	            WebElement confirmPinField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.EditText[3]")));
	            confirmPinField.click();
	            confirmPinField.sendKeys("1234");
	            System.out.println("Confirm pin entered.");

	            // Step 8: Agree to terms and conditions and register
	            WebElement termsCheckbox = wait.until(ExpectedConditions
	                    .visibilityOfElementLocated(By.xpath("//android.widget.CheckBox[@content-desc='T&C']")));
	            termsCheckbox.click();
	            System.out.println("Agreed to T&C.");

	            WebElement registerButton = wait.until(ExpectedConditions
	                    .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Register']")));
	            registerButton.click();
	            System.out.println("Clicked on 'Register' button.");

	        } catch (Exception e) {
	            System.err.println("An error occurred: " + e.getMessage());
	        }
	    }

	    @AfterSuite
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
