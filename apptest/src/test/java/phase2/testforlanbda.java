package phase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class testforlanbda {

    private WebDriverWait wait;
    private static AppiumDriver driver;

    public static String userName = System.getenv("LT_USERNAME") == null ? "engineeringtayana" : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "LT_4W4GVH7BO5i9T2LRHrBltUm1zkF1t8FeTutalY9MlmpN0WS" : System.getenv("LT_ACCESS_KEY");

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
  
        
        
     
        
      
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Galaxy S20");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("build", "Java Vanilla - Android");
        capabilities.setCapability("name", "Sample Test Java");
        capabilities.setCapability("project", "BTAPP");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("app", "APP10160552391752667980319201");
        
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S20"); // <-- This was missing before
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        cap.setCapability("appPackage", "com.bt.mybt");
        cap.setCapability("appActivity", "MainActivity");

        cap.setCapability("build", "Java Vanilla - Android");
        cap.setCapability("name", "Sample Test Java");
        cap.setCapability("project", "BTAPP");
        
        
      /*  cap.setCapability("deviceName", "Galaxy S20");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("platformName", "Android");
        cap.setCapability("isRealMobile", true);
        cap.setCapability("app", "APP_URL");     //Enter your app url
        cap.setCapability("deviceOrientation", "PORTRAIT");
        cap.setCapability("build", "Java Vanilla - Android");
        cap.setCapability("name", "Sample Test Java");*/
        cap.setCapability("console", true);
        cap.setCapability("network", false);
        cap.setCapability("visual", true);
       cap.setCapability("devicelog", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testRechargeFlow() throws InterruptedException {
        try {
            WebElement gettingStartedButton = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
            gettingStartedButton.click();
            System.out.println("Clicked on 'Getting Started' button.");

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

            WebElement mobileNumberField = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[1]")));
            mobileNumberField.click();
            mobileNumberField.sendKeys("17317670");
            System.out.println("Value sent to mobile number field.");

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

                List<WebElement> otpFields = driver.findElements(By.className("android.widget.EditText"));
                System.out.println("EditText count on OTP screen: " + otpFields.size());

                if (otpFields.size() > 0) {
                    WebElement otpField = otpFields.get(0);
                    otpField.click();
                    Thread.sleep(500);
                    otpField.sendKeys(otp);
                    ((HidesKeyboard) driver).hideKeyboard();
                } else {
                    System.out.println("No EditText fields found on OTP screen.");
                }

                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
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
}
