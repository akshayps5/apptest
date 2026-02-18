package ryr.Akshay;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class trackerTest {
	public static WebDriver driver;

	@BeforeClass
    public void setUp() {
        WebDriver driver = new FirefoxDriver(); // Initialize the WebDriver instance
        ryr.Akshay.trackerTest.driver = driver; // Set the WebDriver instance

        driver.get("https://10.0.6.20:8443/tssgui/welcome/jsp/HomePage_Main.jsp#");

        // Set implicit wait to 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Check if the "Advanced" button is present
        List<WebElement> advancedButton = driver.findElements(By.xpath("//*[@id='details-button']"));
        if (advancedButton.size() > 0) {
            // Click the "Advanced" button and then click the "Proceed" link
            driver.findElement(By.cssSelector("#details-button")).click();
            driver.findElement(By.cssSelector("#proceed-link")).click();
        }

        // Perform login steps
        try {
            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
            driver.findElement(By.xpath("//*[@id=\"passdiv\"]/div/input")).sendKeys("admin123");
            driver.findElement(By.xpath("//*[@id=\"subBtn\"]")).click();
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            e.printStackTrace();
        }
    }
 

	//@AfterClass
	//public void tearDown() {
		//if (driver != null) {
			//driver.quit();
		//}
	//}

	@Test(dataProvider = "test",priority =1)
	public void trackermob(int j) throws InterruptedException, UnsupportedEncodingException, IOException {

		driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[5]/div/div[2]/ul/li[2]/a/b"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"searchCustBox\"]")).sendKeys("24856019206");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"searchIcon\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"viewSubTable\"]/tbody/tr/td[1]")).click();
		Thread.sleep(1000);

		// subscriber details
		driver.findElement(By.xpath("//*[@id=\"viewSubsDetHeadDiv\"]")).click();
		Thread.sleep(5000);
		WebElement subdetails = driver.findElement(By.xpath("//*[@id=\"subsDetDiv\"]/div/div/fieldset"));
		String actualOutput = subdetails.getText();
		System.out.println(actualOutput);
		System.out.println();

		// package details
		driver.findElement(By.xpath("//*[@id=\"viewPackageDetHeadDiv\"]")).click();
		WebElement table = driver.findElement(By.xpath("//*[@id='viewPackTable']"));
		WebElement dataRow = table.findElement(By.xpath("//*[@id=\"viewPackTable\"]/tbody/tr"));
		List<WebElement> cells = dataRow.findElements(By.tagName("td"));

		String TimeStamp1 = cells.get(0).getText();
		System.out.println(TimeStamp1);
		String SessionId1 = cells.get(1).getText();
		System.out.println(SessionId1);
		String link = cells.get(2).getText();
		System.out.println(link);
		System.out.println();

		// Online details
		
		WebElement onlinedetails = driver.findElement(By.xpath("//*[@id=\"viewOnlineDetHeadDiv\"]"));
		onlinedetails.click();
		Thread.sleep(3000);
		
		
		// PGW Sessions
		WebElement table1 = driver.findElement(By.xpath("//*[@id=\"pgwTable\"]"));
		WebElement dataRow1 = table1.findElement(By.xpath("//*[@id=\"pgwTable\"]/tbody/tr"));
//		WebElement cell12 = driver.findElement(By.xpath("//*[@id=\"pgwTable\"]/tbody/tr/td"));
//		String cellText12 = cell12.getText();
//		System.out.println(cellText12);
//		List<WebElement> cells1 = dataRow1.findElements(By.tagName("td"));
//		String TimeStamp = cells1.get(0).getText();
//		System.out.println(TimeStamp);
//		String SessionId = cells1.get(1).getText();
//		System.out.println(SessionId);
//		String link1 = cells1.get(2).getText();
//		System.out.println(link1);
//		Thread.sleep(2000);

		WebElement cell21 = driver.findElement(By.xpath("//*[@id=\"pgwtable\"]/tbody/tr/td"));
		String cellText121 = cell21.getText();
		System.out.println(cellText121);//to print no pgw sessions are available
		Thread.sleep(3000);
		
		
		// tdf sessions
		WebElement table2 = driver.findElement(By.xpath("//*[@id=\"tdfTable\"]"));
		WebElement dataRow2 = table1.findElement(By.xpath("//*[@id=\"tdfTable\"]/tbody/tr"));
//		WebElement cell12 = driver.findElement(By.xpath("//*[@id=\"pgwTable\"]/tbody/tr/td"));
//		String cellText12 = cell12.getText();
//		System.out.println(cellText12);
//		List<WebElement> cells1 = dataRow1.findElements(By.tagName("td"));
//		String TimeStamp = cells1.get(0).getText();
//		System.out.println(TimeStamp);
//		String SessionId = cells1.get(1).getText();
//		System.out.println(SessionId);
//		String link1 = cells1.get(2).getText();
//		System.out.println(link1);
//		Thread.sleep(2000);
		
		
		WebElement cell11 = driver.findElement(By.xpath("//*[@id=\"tdftable\"]/tbody/tr/td"));
		String cellText11 = cell11.getText();
		System.out.println(cellText11);//to print no tdf sessions are available
		Thread.sleep(3000);
		
		// data validation
				@SuppressWarnings("deprecation")
				// URL url = new URL("10.0.6.20:80/cgi-bin/tracker?tcno=" + j);
				URL url = new URL("http://10.0.6.20:80/cgi-bin/tracker?tcno=20452" + j);
				HttpURLConnection http = (HttpURLConnection) url.openConnection();
				http.setRequestMethod("GET");
				http.setRequestProperty("Content-Type", "application/json");
				http.setRequestProperty("Accept", "application/json");
				http.setDoOutput(true);

				BufferedReader br = new BufferedReader(new InputStreamReader((InputStream) http.getContent(), "utf-8"));
				StringBuilder response1 = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response1.append(responseLine.trim());
				}
				System.out.println("\n Response: " + response1.toString());
				System.out.println("result");
				Assert.assertTrue(response1.toString().contains("Pass"), "Expected string not found in response");
			}

			@DataProvider(name = "test")
			public Object[][] testData1() {
				return new Object[][] { { 20449 },
						// Add more test data if needed
				};
	}
	
	@Test(dataProvider = "test1", priority =2)
	public void trackerBB(int j) throws InterruptedException, UnsupportedEncodingException, IOException {
		driver.findElement(By.xpath("//a[@title='SiteMap']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[5]/div/div[2]/ul/li[2]/a/b"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"searchCustBox\"]")).sendKeys("24899999234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"searchIcon\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"viewSubTable\"]/tbody/tr/td[1]")).click();
		Thread.sleep(3000);

		// subscriber detailsid="viewSubsDetHeadDiv //*[@id="searchCust"]
		driver.findElement(By.xpath(" //*[@id=\"searchCust\"]")).click();
		Thread.sleep(1000);
		WebElement subdetails = driver.findElement(By.xpath("//*[@id=\"subsDetDiv\"]/div/div/fieldset"));
		String actualOutput = subdetails.getText();
		System.out.println(actualOutput);
		System.out.println();
		WebElement bbdetails = driver.findElement(By.xpath("//*[@id=\"subsDetDiv\"]/div/div/fieldset[2]"));
		String actualOutput1 = bbdetails.getText();
		System.out.println(actualOutput1);
		System.out.println();
	
		
		
		// package details
		driver.findElement(By.xpath("//*[@id=\"viewPackageDetHeadDiv\"]")).click();
		WebElement table = driver.findElement(By.xpath("//*[@id='viewPackTable']"));
		WebElement dataRow = table.findElement(By.xpath("//*[@id=\"viewPackTable\"]/tbody/tr"));
		List<WebElement> cells = dataRow.findElements(By.tagName("td"));

		String TimeStamp1 = cells.get(0).getText();
		System.out.println(TimeStamp1);
		String SessionId1 = cells.get(1).getText();
		System.out.println(SessionId1);
		String link = cells.get(2).getText();
		System.out.println(link);
		System.out.println();

//		Thread.sleep(3000);
//		// Creating JavascriptExecutor interface
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		// Scroll down by 500 pixels
//		js.executeScript("window.scrollBy(0,800)");
//		Thread.sleep(3000);

		// Online details
		WebElement onlinedetails = driver.findElement(By.xpath("//*[@id=\"viewOnlineDetHeadDiv\"]"));
		onlinedetails.click();
		
		// Online details
		// PGW Sessions
		 
		Thread.sleep(3000);
		WebElement table1 = driver.findElement(By.xpath("//*[@id=\"pgwTable\"]"));
		WebElement dataRow1 = table1.findElement(By.xpath("//*[@id=\"pgwTable\"]/tbody/tr"));
//		driver.findElement(By.xpath("//*[@id=\"pgwtable\"]/tbody/tr[26]/td[3]")).click();//locator for resent pgw session in the table
//		driver.findElement(By.xpath("//*[@id=\"rootPLccr\"]/i")).click();
//		driver.findElement(By.xpath("//*[@id=\"node_9\"]/i")).click();
//		WebElement message  = driver.findElement(By.xpath("//*[@id=\"node_9\"]/ul"));
//		message.click();
//		String actualOutput11 = message.getText();
//		System.out.println(actualOutput11);
//		System.out.println();

		WebElement cell21 = driver.findElement(By.xpath("//*[@id=\"pgwtable\"]/tbody/tr/td"));
		String cellText121 = cell21.getText();
		System.out.println(cellText121);//to print no pgw sessions are available
		Thread.sleep(3000);
		
		// tdf
		WebElement table2 = driver.findElement(By.xpath("//*[@id=\"tdftable\"]"));
		WebElement dataRow2 = table2.findElement(By.xpath("//*[@id=\"tdftable\"]/tbody/tr"));
//		List<WebElement> cells2 = dataRow2.findElements(By.tagName("td"));//locator for resent tdf session in the table
//		String TimeStamp2 = cells2.get(0).getText();
//		System.out.println(TimeStamp2);
//		String SessionId2 = cells2.get(1).getText();
//		System.out.println(SessionId2);
//		String link2 = cells2.get(2).getText();
//		System.out.println(link2);
//		Thread.sleep(2000);
		
		
		WebElement cell22 = driver.findElement(By.xpath("//*[@id=\"pgwtable\"]/tbody/tr/td"));
		String cellText22 = cell22.getText();
		System.out.println(cellText22);//to print no pgw sessions are available
		Thread.sleep(3000);
		
		
		// data validation
		@SuppressWarnings("deprecation")
		// URL url = new URL("10.0.6.20:80/cgi-bin/tracker?tcno=" + j);
		URL url = new URL("http://10.0.6.20:80/cgi-bin/tracker?tcno=20452" + j);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Content-Type", "application/json");
		http.setRequestProperty("Accept", "application/json");
		http.setDoOutput(true);

		BufferedReader br = new BufferedReader(new InputStreamReader((InputStream) http.getContent(), "utf-8"));
		StringBuilder response1 = new StringBuilder();
		String responseLine = null;
		while ((responseLine = br.readLine()) != null) {
			response1.append(responseLine.trim());
		}
		System.out.println("\n Response: " + response1.toString());
		System.out.println("result");
		Assert.assertTrue(response1.toString().contains("Pass"), "Expected string not found in response");
	}

	@DataProvider(name = "test1")
	public Object[][] testData2() {
		return new Object[][] { { 20452 },
				
		};
	}
}
