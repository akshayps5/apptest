package appiumtests;


	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	 
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.remote.MobilePlatform;
	 
	public class ticket {
	 
	    private AndroidDriver driver;
	    private WebDriverWait wait;
	 
	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	        // Set desired capabilities
	        DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	        cap.setCapability("appPackage", "com.bt.mybt");  // Replace with your app package
	        cap.setCapability("appActivity", ".MainActivity");  // Replace with your app activity
	 
	        // Initialize the AndroidDriver for Appium
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    }
	 
	    @Test
	    public void testBillPayFlow() throws InterruptedException {
	        try {
	        	try {
					WebElement gettingStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
					gettingStartedButton.click();
					System.out.println("Clicked on 'Getting Started' button.");
				} catch (Exception e) {
					System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
				}
				
				try {
	                WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//android.view.View[contains(@content-desc,'Register')]")));
	                WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(
	                        By.xpath("//android.widget.Button[contains(@content-desc,'cancel')]")));
	                cancelButton.click();
	                System.out.println("Popup handled successfully by clicking 'Cancel'.");
	            } catch (Exception e) {
	                System.out.println("No popup appeared or it was already handled.");
	            }
				
				// Wait for the mobile number field to appear and interact with it
				System.out.println("Waiting for the mobile number field to appear...");
				// Use a stable XPath or resource ID for mobile number field
				WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));
				; // Adjusted for content-desc or use resource-id
				mobileNumberField.click();
				Thread.sleep(1000); // Small delay before entering text

				// Send value to the mobile number field
				mobileNumberField.sendKeys("17631732");
				System.out.println("Value sent to mobile number field.");
				//Thread.sleep(2000);
				try {
					// Locate the EditText field using the provided XPath
					System.out.println("Waiting for the mobile number field to appear...");
					WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));
					pwd.click();
					// Send value to the mobile number field
					Thread.sleep(1000); // Wait for 1 second before interacting
					pwd.sendKeys("2580");
					System.out.println("Value sent to pwd field.");
				} catch (Exception e) {
					System.err.println("Failed to locate the pwd field: " + e.getMessage());
				}

	 
	            System.out.println("Checking for the home screen...");
	            WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
	            System.out.println("Home screen appeared.");
	            Assert.assertNotNull(homeScreen, "Home screen not loaded.");
	 
	            // Click on the Tickets icon
	            WebElement ticketIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.ImageView[contains(@content-desc,'Tickets')]")));
	            ticketIcon.click();
	            System.out.println("Ticket icon clicked.");
	         // Click on Create Complaint 
	            WebElement complaintcreate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Button[@content-desc='Create New Complaints']")));
	            complaintcreate.click();
	            System.out.println("Create New Complaints clicked.");
	 
	            // Click on Complaint Type
	            WebElement complaintTypeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Button[@content-desc='Select Complaint Type']")));
	            complaintTypeButton.click();
	            System.out.println("Complaint Type button clicked.");
	 
	            // Select 'Mobile' from the dropdown
	            WebElement mobileOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//android.view.View[@content-desc='Mobile']")));
	            mobileOption.click();
	            System.out.println("'Mobile' option selected from Complaint Type dropdown.");
	 
	            // Click on Complaint Sub Type
	            WebElement complaintSubTypeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Button[@content-desc='Select Complaint Sub Type']")));
	            complaintSubTypeButton.click();
	            System.out.println("Complaint Sub Type button clicked.");
	 
	            // Select 'BWALLET' from the dropdown
	            WebElement bwalletOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//android.view.View[@content-desc='BWALLET']")));
	            bwalletOption.click();
	            System.out.println("'BWALLET' option selected from Complaint Sub Type dropdown.");
	 
	            // Click on Dzongkhag Type
	            WebElement dzongkhagTypeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.Button[@content-desc='Select Dzongkhag Type']")));
	            dzongkhagTypeButton.click();
	            System.out.println("Dzongkhag Type button clicked.");
	 
	            // Select 'Gasa' from the dropdown
	            WebElement gasaOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//android.view.View[@content-desc='Gasa']")));
	            gasaOption.click();
	            System.out.println("'Gasa' option selected from Dzongkhag Type dropdown.");
	 
	            // Enter Location
	            WebElement locationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.widget.EditText[1]")));
	            locationField.click();
	            locationField.sendKeys("Thimphu");  // Replace with desired location
	            System.out.println("Location entered.");
	 
	            // Enter Name
	            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.widget.EditText[2]")));
	            nameField.click();
	            nameField.sendKeys("John Doe");  // Replace with desired name
	            System.out.println("Name entered.");
	 
	            // Enter Number
	            WebElement numberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.widget.EditText[3]")));
	            numberField.click();
	            numberField.sendKeys("1234567890");  // Replace with desired number
	            System.out.println("Number entered.");
	 
	        } catch (Exception e) {
	            System.err.println("An error occurred during the test: " + e.getMessage());
	            Assert.fail("Test failed due to an error.");
	        }
	    }
	 
	/*   @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	        System.out.println("Test completed and driver closed.");
	    }*/
	}
	 

