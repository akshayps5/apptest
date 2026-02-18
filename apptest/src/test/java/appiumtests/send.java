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
	 
	public class send {
	 
	    private AndroidDriver driver;
	    private WebDriverWait wait;
	 
	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	        DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	        cap.setCapability("appPackage", "com.bt.mybt");
	        cap.setCapability("appActivity", ".MainActivity");
	 
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	 
	    @Test
	    public void testSendMoneyFlow() throws InterruptedException {
	        try {
	            WebElement gettingStartedButton = wait.until(ExpectedConditions
	                    .visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Getting Started']")));
	            gettingStartedButton.click();
	            System.out.println("Clicked on 'Getting Started' button.");
	            Assert.assertNotNull(gettingStartedButton, "'Getting Started' button was not clicked successfully.");
	        } catch (Exception e) {
	            System.err.println("Failed to find the 'Getting Started' button: " + e.getMessage());
	            Assert.fail("Failed to click on 'Getting Started' button.");
	        }
	 
	        try {
	        	try {
					System.out.println("Waiting for the mobile number field to appear...");
					WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]")));

					// Assert that the mobile number field is found and visible
				//	Assert.assertNotNull(mobileNumberField, "Mobile number field is not found!");
			//		Assert.assertTrue(mobileNumberField.isDisplayed(), "Mobile number field is not visible!");

					// Interact with the mobile number field
					mobileNumberField.click();
					Thread.sleep(2000);
					mobileNumberField.sendKeys("17285783");
					System.out.println("Value sent to mobile number field.");

				} catch (Exception e) {
					System.err.println("Failed to locate the mobile number field: " + e.getMessage());
					Assert.fail("Mobile number field is not clickable or found.");
				}
				// Password Field
				try {
					System.out.println("Waiting for the password field to appear...");
					WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]")));

					// Assert that the password field is found and visible
					Assert.assertNotNull(pwd, "Password field is not found!");
					Assert.assertTrue(pwd.isDisplayed(), "Password field is not visible!");

					// Interact with the password field
					pwd.click();
					Thread.sleep(2000);
					pwd.sendKeys("2580");
					System.out.println("Value sent to password field.");

				} catch (Exception e) {
					System.err.println("Failed to locate the password field: " + e.getMessage());
					Assert.fail("Password field is not clickable or found.");
				}
	 
	            WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View")));
	            Assert.assertNotNull(homeScreen, "Home screen not loaded.");
	            System.out.println("Home screen appeared.");
	        } catch (Exception e) {
	            System.err.println("Failed to complete login process: " + e.getMessage());
	            Assert.fail("Login process failed.");
	        }
	 
	        try {
	            WebElement sendMoneyIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "//android.widget.ImageView[contains(@content-desc,'Send Money')]")));
	            sendMoneyIcon.click();
	            System.out.println("Send Money icon clicked.");
	        } catch (Exception e) {
	            System.err.println("Failed to click on Send Money icon: " + e.getMessage());
	            Assert.fail("Could not click Send Money icon.");
	        }

	        try {
	            WebElement enterAmountContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                "//android.view.View[contains(@content-desc, 'Enter Amount')]")));
	            
	            WebElement avlbal = enterAmountContainer.findElement(By.xpath(".//android.widget.EditText"));
	            
	            Assert.assertTrue(avlbal.isDisplayed(), "Available balance field is not displayed.");
	            Assert.assertTrue(avlbal.isEnabled(), "Available balance field is not enabled.");
	            
	            avlbal.click();
	            avlbal.sendKeys("34567");
	            System.out.println("Available balance field clicked.");
	        } catch (Exception e) {
	            System.err.println("Failed to display available balance: " + e.getMessage());
	            Assert.fail("Available balance field not displayed or clickable.");
	        }
	        Thread.sleep(2000);
	    
	        try {
	            WebElement enterAmountContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                "//android.view.View[contains(@content-desc, 'Enter Amount')]")));
	            
	           // WebElement amountField = enterAmountContainer.findElement(By.xpath(".//android.widget.EditText"));
	            
	         
	            // Click, clear, and enter the amount
	            enterAmountContainer.click();
	            enterAmountContainer.clear();  // Clear existing text if any
	            enterAmountContainer.sendKeys("25");
	            System.out.println("Amount 25 entered successfully.");
	            
	            // Additional validation to check if value was entered
	            String enteredAmount = enterAmountContainer.getAttribute("text");
	            Assert.assertEquals(enteredAmount, "25", "Amount entered is incorrect.");
	        } catch (Exception e) {
	            System.err.println("Failed to enter amount: " + e.getMessage());
	            Assert.fail("Amount field is not displayed or clickable.");
	        }
    }
	    @AfterTest
	    public void tearDown() {
	      //  if (driver != null) {
	        //    driver.quit();
	        //}
	    }
	}

