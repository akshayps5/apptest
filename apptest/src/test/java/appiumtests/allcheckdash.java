package appiumtests;



import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class allcheckdash {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set desired capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability("appPackage", "com.bt.mybt"); // Replace with your app package
        cap.setCapability("appActivity", ".MainActivity"); // Replace with your app activity

        // Initialize the AndroidDriver for Appium
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        // Use WebDriverWait to wait for elements
        wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // Increased wait time to 120 seconds
    }

    @Test
    public void testAppFunctionality() {
        try {
            // Handle "Getting Started" button if it appears
            try {
                WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
                gettingStartedButton.click();
                System.out.println("Clicked on 'Getting Started' button.");
            } catch (Exception e) {
                System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
            }

            // Wait for the mobile number field to appear and interact with it
            System.out.println("Waiting for the mobile number field to appear...");
            WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
            mobileNumberField.click();
            Thread.sleep(2000); // Small delay before entering text

            // Send value to the mobile number field
            String mobileNumber = "17711482";
            mobileNumberField.sendKeys(mobileNumber);
            System.out.println("Value sent to mobile number field: " + mobileNumber);
            Thread.sleep(2000);

            // Wait for the password field to appear and interact with it
            try {
                System.out.println("Waiting for the password field to appear...");
                WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
                pwd.click();
                Thread.sleep(2000); // Wait before interacting
                String password = "2580";
                pwd.sendKeys(password);
                System.out.println("Value sent to password field: " + password);
            } catch (Exception e) {
                System.err.println("Failed to locate the password field: " + e.getMessage());
            }

            // Locate and print the Recharge Balance element
            WebElement balanceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[@content-desc='RECHARGE BALANCE']")));
            String balanceText = balanceElement.getText();
            System.out.println("Recharge Balance: " + balanceText);

            // Locate and print "Remaining" element
            WebElement remainingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[contains(@content-desc, 'Remaining')]")));
            String remainingText = remainingElement.getAttribute("content-desc");
            System.out.println("Remaining Data Usage: " + remainingText);

            // Print Talktime
            WebElement talktimeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[@content-desc='Talktime']")));
            String talktimeText = talktimeElement.getAttribute("content-desc");
            System.out.println("Talktime: " + talktimeText);

            // Print Nu.
            WebElement nuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[@content-desc='Nu.']")));
            String nuText = nuElement.getAttribute("content-desc");
            System.out.println("Nu.: " + nuText);

            // Print "Validity: N/A"
            WebElement validityNAElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//android.view.View[@content-desc='Validity: N/A'])[1]")));
            String validityNAText = validityNAElement.getAttribute("content-desc");
            System.out.println("Validity: N/A: " + validityNAText);

            // Print "Monthly 299"
            WebElement monthly299Element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[@content-desc='Monthly 299']")));
            String monthly299Text = monthly299Element.getAttribute("content-desc");
            System.out.println("Monthly Plan: " + monthly299Text);

            // Print "Validity: 12/11/2024"
            WebElement validityDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[@content-desc='Validity: 12/11/2024']")));
            String validityDateText = validityDateElement.getAttribute("content-desc");
            System.out.println("Validity Date: " + validityDateText);

            // Log all the collected information in a structured manner
            System.out.println("Test completed successfully with the following details:");
            System.out.println("Recharge Balance: " + balanceText);
            System.out.println("Remaining Data Usage: " + remainingText);
            System.out.println("Talktime: " + talktimeText);
            System.out.println("Nu.: " + nuText);
            System.out.println("Validity: N/A: " + validityNAText);
            System.out.println("Monthly Plan: " + monthly299Text);
            System.out.println("Validity Date: " + validityDateText);

        } catch (Exception e) {
            Assert.fail("Error occurred: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the driver
        if (driver != null) {
            driver.quit();
        }
    }
}
