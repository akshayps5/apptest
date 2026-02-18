package ryr.Akshay;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class akshaydemo {
	


		public static WebDriver driver;

		@BeforeClass
		public void setUp() {
			WebDriver driver = new FirefoxDriver(); // Initialize the WebDriver instance
			ryr.Akshay.akshaydemo.driver = driver; // Set the WebDriver instance

			driver.get("https://10.0.6.20:8443/tssgui/welcome/jsp/HomePage_Main.jsp#");

			// Set implicit wait to 10 seconds
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

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

//		@AfterClass
//		public void tearDown() {
//			if (driver != null) {
//				driver.quit();
//			}
//		}

		@Test(priority = 1)
		public void f() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[2]/a"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//i[@class='fa tss-add']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"sabbName\"]")).sendKeys("GUI_AUTOMATION");// SABB NAME

			driver.findElement(By.xpath("//*[@id=\"serviceSB\"]")).click();// Service dropdown
			List<WebElement> Options1 = driver.findElements(By.xpath("//div[@class='row']//option[4]"));
			Thread.sleep(2000);
			String option11 = "QOS Policy";
			Options1.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option11);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"descCfgTA\"]")).sendKeys("GUI_AUTOMATION");// Description

			// clicking addruleset 5 times
			for (int i = 0; i < 4; i++) {
				driver.findElement(By.xpath("//*[@id=\"addGroup_G0\"]")).click();
				Thread.sleep(1000);
			}

			// first column
			
			// attribute type11
			WebElement dropdowngroup1 =	driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G1_R1\"]"));
			Thread.sleep(2000);
			List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G1_R1\"]/option[4]"));
			Thread.sleep(1000);
			String option22 = "Grouped";
			Options2.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option22);
			Thread.sleep(1000);

			
			WebElement dropdown1 = driver.findElement(By.id("groupedSB_G0_G1_R1"));
			Thread.sleep(1000);
			Select select1 = new Select(dropdown1);
			select1.selectByIndex(7);// sy

			// add rule button
			driver.findElement(By.xpath("//*[@id=\"addRule_G0_G1_G1\"]")).click();
			//*[@id="and_G0_G1_G1"] and button
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G1_G1\"]")).click();
		

			// ATTRIBUTE TYPE12
			driver.findElement(By.xpath(" //*[@id=\"categorySB_G0_G1_G1_R1\"]")).click();
			Thread.sleep(1000);
			List<WebElement> Options22 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G1_G1_R1\"]/option"));
			Thread.sleep(1000);
			String option222 = "Grouped";
			Options22.get(0).click(); 
			System.out.println(" selected: " + option222);
			Thread.sleep(1000);

			// select11
			WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G1_G1_R1\"]"));
			Thread.sleep(2000);
			Select select2 = new Select(dropdown2);
			select2.selectByIndex(1);// to select Policy-Counter-Status
			Thread.sleep(1000);

			// select12
			WebElement dropdown3 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G1_G1_R1\"]"));
			Thread.sleep(1000);
			Select select3 = new Select(dropdown3);
			// select3.selectByValue("IN");
			select3.selectByVisibleText("IN");
			Thread.sleep(1000);

			// select13
			driver.findElement(By.xpath("//*[@id=\"enum_G0_G1_G1_R1\"]/span/div")).click();
			List<WebElement> alloptions = driver.findElements(By.xpath("//*[@id=\"enum_G0_G1_G1_R1\"]/span/div/ul"));
			String option = "Normal (0)";
			for (int i = 0; i < alloptions.size(); i++) {
				alloptions.get(i).click();
				System.out.println(option);// to select Normal(0)
				break;
			}
			Thread.sleep(2000);

			// attriute type2
			WebElement dropdown10 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G1_G1_R2\"]"));
			Thread.sleep(2000);
			Select select10 = new Select(dropdown10);
			select10.selectByIndex(2);// to select Policy-Counter-Identifier
			Thread.sleep(1000);

			// select21
			WebElement dropdown11 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G1_G1_R2\"]"));
			Thread.sleep(1000);
			Select select11 = new Select(dropdown11);
			// select3.selectByValue("IN");
			select11.selectByVisibleText("IN");
			Thread.sleep(1000);

			// select22
			WebElement dropdownContainer1 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G1_G1_R2\"]/span/div/button"));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownContainer1);
			new Actions(driver).moveToElement(dropdownContainer1).click().perform();
			String kotapack11 = "PC1 (PC1)";
			WebElement optionToSelect23 = driver
					.findElement(By.xpath("//*[@id=\"enum_G0_G1_G1_R2\"]/span/div/ul/li[4]/a/label"));
			Actions actions55 = new Actions(driver);
			actions55.moveToElement(optionToSelect23).click().build().perform();

			// analysed category(true)11
			driver.findElement(By.id("select2-categoryVal_1-container")).click();
			String kotapack = "GUI_AUTOMATION1";
			WebElement optionToSelect = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack + "')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(optionToSelect).click().build().perform();

			// analysed output12
			WebElement dropdownContainer = driver.findElement(By.id("select2-outputVal_1-container"));
			dropdownContainer.click();
			// Locate and click on the specific option ("Normal1")
			WebElement normal1Option = driver.findElement(By.xpath("//li[text()='Normal1']"));
			normal1Option.click();
			Thread.sleep(2000);

			
			// 2nd
			// ATTRIBUTE TYPE
			WebElement dropdowngroup2 =driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G2_R1\"]"));
			Thread.sleep(1000);
			List<WebElement> Options71 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G2_R1\"]/option[4]"));
			Thread.sleep(1000);
			String option71 = "Grouped";
			Options71.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option71);
			Thread.sleep(1000);

			// select11
			WebElement dropdown72 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G2_R1\"]"));
			Thread.sleep(2000);
			Select select72 = new Select(dropdown72);
			select72.selectByIndex(7);
			Thread.sleep(1000);

			// add rule
			driver.findElement(By.xpath("//*[@id=\"addRule_G0_G2_G1\"]")).click();// add rule
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G2_G1\"]")).click();//and button
			
	        // select11
			WebElement dropdown74 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G2_G1_R1\"]"));
			Thread.sleep(2000);
			Select select74 = new Select(dropdown74);
			select74.selectByIndex(1);// to select Policy-Counter-Status
			Thread.sleep(1000);

			// select12
			WebElement dropdown75 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G2_G1_R1\"]"));
			Thread.sleep(1000);
			Select select75 = new Select(dropdown75);
			// select3.selectByValue("IN");
			select75.selectByVisibleText("IN");
			Thread.sleep(1000);

			// select13
			WebElement dropdownContainer76 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G2_G1_R1\"]/span/div/button"));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownContainer76);
			new Actions(driver).moveToElement(dropdownContainer76).click().perform();
			String kotapack76 = "1st Threshold Breached (1)";// to select 1st Threshold Breached (1)
			WebElement optionToSelect76 = driver
					.findElement(By.xpath("//*[@id=\"enum_G0_G2_G1_R1\"]/span/div/ul/li[4]/a/label"));
			Actions actions76 = new Actions(driver);
			actions76.moveToElement(optionToSelect76).click().build().perform();
			Thread.sleep(2000);

			// attriute type2
			// *[@id="groupedSB_G0_G2_G1_R2"]
			WebElement dropdown77 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G2_G1_R2\"]"));
			Thread.sleep(2000);
			Select select77 = new Select(dropdown77);
			select77.selectByIndex(2);// to select Policy-Counter-Identifier
			Thread.sleep(1000);

			// select21
			WebElement dropdown78 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G2_G1_R2\"]"));
			Thread.sleep(1000);
			Select select78 = new Select(dropdown78);
			// select3.selectByValue("IN");
			select78.selectByVisibleText("IN");
			Thread.sleep(1000);

			// select22
			// *[@id="enum_G0_G2_G1_R2"]/span/div/button
			WebElement dropdownContainer79 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G2_G1_R2\"]/span/div/button"));
			dropdownContainer79.click();
			Thread.sleep(1000);
			String kotapack79 = "PC1 (PC1)";
			WebElement optionToSelect79 = driver
					.findElement(By.xpath("//*[@id=\"enum_G0_G2_G1_R2\"]/span/div/ul/li[4]/a/label"));
			Actions actions79 = new Actions(driver);
			actions79.moveToElement(optionToSelect79).click().build().perform();

			// analysed category(true)
			// *[@id="select2-categoryVal_2-container"]
			driver.findElement(By.id("select2-categoryVal_2-container")).click();
			String kotapack80 = "GUI_AUTOMATION1";
			WebElement optionToSelect80 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack80 + "')]"));
			Actions actions80 = new Actions(driver);
			actions80.moveToElement(optionToSelect80).click().build().perform();

			// analysed output
			// *[@id="select2-outputVal_2-container"]
			WebElement dropdownContainer80 = driver.findElement(By.id("select2-outputVal_2-container"));
			dropdownContainer80.click();
			// Locate and click on the specific option ("Normal1")
			WebElement normal1Option80 = driver.findElement(By.xpath("//li[text()='Threshold1']"));
			normal1Option80.click();
			Thread.sleep(2000);

			// 3rd
			// ATTRIBUTE TYPE
			WebElement dropdowngroup3 = driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G3_R1\"]"));
			Thread.sleep(1000);
			List<WebElement> Options81 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G3_R1\"]/option[4]"));
			Thread.sleep(1000);
			String option81 = "Grouped";
			Options81.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option81);
			Thread.sleep(1000);

			// select11
			// *[@id="groupedSB_G0_G3_R1"]
			WebElement dropdown82 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G3_R1\"]"));
			Thread.sleep(2000);
			Select select82 = new Select(dropdown82);
			select82.selectByIndex(7);
			Thread.sleep(1000);

			// add rule
			driver.findElement(By.xpath("//*[@id=\"addRule_G0_G3_G1\"]")).click();// add rule
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G3_G1\"]")).click();

			// select11
			// *[@id="groupedSB_G0_G3_G1_R1"]
			WebElement dropdown84 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G3_G1_R1\"]"));
			dropdown84.click();
			Thread.sleep(2000);
			Select select84 = new Select(dropdown84);
			select84.selectByIndex(1);// to select Policy-Counter-Status
			Thread.sleep(1000);

			// select12
			// *[@id="enumOpSB_G0_G3_G1_R1"]
			WebElement dropdown85 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G3_G1_R1\"]"));
			Thread.sleep(1000);
			Select select85 = new Select(dropdown85);
			// select85.selectByValue("IN");
			select85.selectByVisibleText("IN");
			Thread.sleep(1000);
			
			WebElement dropdownContainer86 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G3_G1_R1\"]/span/div/button"));
			dropdownContainer86.click();
			List<WebElement> alloptions86 = driver.findElements(By.xpath("//*[@id=\"enum_G0_G3_G1_R1\"]/span/div/ul"));
			Thread.sleep(2000);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"enum_G0_G3_G1_R1\"]/span/div/ul/li[5]/a/label")).click();
			Thread.sleep(1000);
			
			// attriute type2
			// *[@id="groupedSB_G0_G3_G1_R2"]
			WebElement dropdown87 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G3_G1_R2\"]"));
			Thread.sleep(2000);
			Select select87 = new Select(dropdown87);
			select87.selectByIndex(2);// to select Policy-Counter-Identifier
			Thread.sleep(1000);

			// select21
			// *[@id="enumOpSB_G0_G3_G1_R2"]
			WebElement dropdown88 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G3_G1_R2\"]"));
			Thread.sleep(1000);
			Select select88 = new Select(dropdown88);
			// select88.selectByValue("IN");
			select88.selectByVisibleText("IN");
			Thread.sleep(1000);

			// select22
			// *[@id="enum_G0_G3_G1_R2"]/span/div/button
			WebElement dropdownContainer89 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G3_G1_R2\"]/span/div/button"));
			dropdownContainer89.click();
			Thread.sleep(1000);
			String kotapack89 = "PC1 (PC1)";
			WebElement optionToSelect89 = driver
					.findElement(By.xpath("//*[@id=\"enum_G0_G3_G1_R2\"]/span/div/ul/li[4]/a/label"));
			Actions actions89 = new Actions(driver);
			actions89.moveToElement(optionToSelect89).click().build().perform();

			// analysed category(true)
			// *[@id="select2-categoryVal_3-container"]
			driver.findElement(By.id("select2-categoryVal_3-container")).click();
			String kotapack90 = "GUI_AUTOMATION1";
			WebElement optionToSelect90 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack80 + "')]"));
			Actions actions90 = new Actions(driver);
			actions90.moveToElement(optionToSelect90).click().build().perform();

			// analysed output
			// *[@id="select2-outputVal_3-container"]
			WebElement dropdownContainer91 = driver.findElement(By.id("select2-outputVal_3-container"));
			dropdownContainer91.click();
			// Locate and click on the specific option ("Threshold2")
			WebElement normal1Option91 = driver.findElement(By.xpath("//li[text()='Threshold22']"));
			normal1Option91.click();
			Thread.sleep(2000);

			// 4th column
			// ATTRIBUTE TYPE
			// *[@id="categorySB_G0_G4_R1"]
			WebElement dropdowngroup4 = driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G4_R1\"]"));
			Thread.sleep(1000);
			List<WebElement> Options61 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G4_R1\"]/option[4]"));
			Thread.sleep(1000);
			String option61 = "Grouped";
			Options61.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option61);
			Thread.sleep(1000);

			// select11
			// *[@id="groupedSB_G0_G3_R1"]
			WebElement dropdown62 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G4_R1\"]"));
			Thread.sleep(2000);
			Select select62 = new Select(dropdown62);
			select62.selectByIndex(7);
			Thread.sleep(1000);

			// add rule
			driver.findElement(By.xpath("//*[@id=\"addRule_G0_G4_G1\"]")).click();// add rule
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G4_G1\"]")).click();
			
			// select11
			WebElement dropdown64 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G4_G1_R1\"]"));
			dropdown84.click();
			Thread.sleep(2000);
			Select select64 = new Select(dropdown64);
			select64.selectByIndex(1);// to select Policy-Counter-Status
			Thread.sleep(1000);

			// select12
			WebElement dropdown65 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G4_G1_R1\"]"));
			Thread.sleep(1000);
			Select select65 = new Select(dropdown65);
			// select85.selectByValue("IN");
			select65.selectByVisibleText("IN");
			Thread.sleep(1000);

			// code to select 3rd Threshold breached (3)
			// select13
			driver.findElement(By.xpath("//*[@id=\"enum_G0_G4_G1_R1\"]/span/div")).click();
			List<WebElement> alloptions51 = driver.findElements(By.xpath("//*[@id=\"enum_G0_G4_G1_R1\"]/span/div/ul"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"enum_G0_G4_G1_R1\"]/span/div/ul/li[6]")).click();
			Thread.sleep(2000);

			// attriute type2
			WebElement dropdown67 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G4_G1_R2\"]"));
			Thread.sleep(2000);
			Select select67 = new Select(dropdown67);
			select67.selectByIndex(2);// to select Policy-Counter-Identifier
			Thread.sleep(1000);

			// select21
			WebElement dropdown68 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G4_G1_R2\"]"));
			Thread.sleep(1000);
			Select select68 = new Select(dropdown68);	
			select68.selectByVisibleText("IN");
			Thread.sleep(1000);

			// select22
			WebElement dropdownContainer69 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G4_G1_R2\"]/span/div/button"));
			dropdownContainer69.click();
			Thread.sleep(1000);
			String kotapack69 = "PC1 (PC1)";
			WebElement optionToSelect69 = driver
					.findElement(By.xpath("//*[@id=\"enum_G0_G4_G1_R2\"]/span/div/ul/li[4]/a/label"));
			Actions actions69 = new Actions(driver);
			actions69.moveToElement(optionToSelect69).click().build().perform();

			// analysed category(true)
			driver.findElement(By.id("select2-categoryVal_4-container")).click();
			String kotapack699 = "GUI_AUTOMATION1";
			WebElement optionToSelect699 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack699 + "')]"));
			Actions actions699 = new Actions(driver);
			actions699.moveToElement(optionToSelect699).click().build().perform();

			// analysed output
			WebElement dropdownContainer691 = driver.findElement(By.xpath("//*[@id=\"select2-outputVal_4-container\"]"));
			dropdownContainer691.click();
			WebElement normal1Option691 = driver.findElement(By.xpath("//li[text()='Threshold32']"));
			normal1Option691.click();
			Thread.sleep(1000);

			// 5th column
			// ATTRIBUTE TYPE
			WebElement dropdowngroup5 =	driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G5_R1\"]"));
			Thread.sleep(1000);
			List<WebElement> Options31 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G5_R1\"]/option[4]"));
			Thread.sleep(1000);
			String option31 = "Grouped";
			Options31.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option31);
			Thread.sleep(1000);

			// select11
			WebElement dropdown32 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G5_R1\"]"));
			Thread.sleep(2000);
			Select select32 = new Select(dropdown32);
			select32.selectByIndex(7);
			Thread.sleep(1000);

			// add rule
			driver.findElement(By.xpath("//*[@id=\"addRule_G0_G5_G1\"]")).click();// add rule
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G5_G1\"]")).click();

			// select11
			WebElement dropdown34 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G5_G1_R1\"]"));
			dropdown34.click();
			Thread.sleep(2000);
			Select select34 = new Select(dropdown34);
			select34.selectByIndex(1);// to select Policy-Counter-Status
			Thread.sleep(2000);

			// select12
			WebElement dropdown35 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G5_G1_R1\"]"));
			Thread.sleep(1000);
			Select select35 = new Select(dropdown35);
			select35.selectByVisibleText("IN");
			Thread.sleep(1000);

			// select13
			// *[@id="enum_G0_G3_G1_R1"]/span/div/button
			WebElement dropdownContainer36 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G5_G1_R1\"]/span/div/button"));
			dropdownContainer36.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"enum_G0_G5_G1_R1\"]/span/div/ul/li[7]")).click();//to select threshold exhaust(5)
			Thread.sleep(2000);

			// attriute type2
			WebElement dropdown37 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G5_G1_R2\"]"));
			Thread.sleep(2000);
			Select select37 = new Select(dropdown37);
			select37.selectByIndex(2);// to select Policy-Counter-Identifier
			Thread.sleep(1000);

			// select21
			WebElement dropdown38 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G5_G1_R2\"]"));
			Thread.sleep(1000);
			Select select38 = new Select(dropdown38);
			select38.selectByVisibleText("IN");
			Thread.sleep(1000);

			// select22
			WebElement dropdownContainer39 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G5_G1_R2\"]/span/div/button"));
			dropdownContainer39.click();
			Thread.sleep(1000);
			String kotapack39 = "PC1 (PC1)";
			WebElement optionToSelect39 = driver
					.findElement(By.xpath("//*[@id=\"enum_G0_G5_G1_R2\"]/span/div/ul/li[4]/a/label"));
			Actions actions39 = new Actions(driver);
			actions39.moveToElement(optionToSelect39).click().build().perform();

			// analysed category(true)
			driver.findElement(By.id("select2-categoryVal_5-container")).click();
			String kotapack40 = "GUI_AUTOMATION1";
			WebElement optionToSelect400 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack40 + "')]"));
			Actions actions400 = new Actions(driver);
			actions400.moveToElement(optionToSelect400).click().build().perform();

			// analysed output
			// *[@id="select2-outputVal_4-container"]
			WebElement dropdownContainer401 = driver.findElement(By.xpath("//*[@id=\"select2-outputVal_5-container\"]"));
			dropdownContainer401.click();
			// Locate and click on the specific option ("ThresholdExhaust1")
			WebElement normal1Option401 = driver.findElement(By.xpath("//li[text()='ThresholdExhaust1']"));
			normal1Option401.click();
			Thread.sleep(2000);

			// analysed category(true)
			driver.findElement(By.xpath("//*[@id=\"select2-categoryVal-container\"]")).click();
			String kotapack403 = "GUI_AUTOMATION1";
			WebElement optionToSelect403 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack403 + "')]"));
			Actions actions403 = new Actions(driver);
			actions403.moveToElement(optionToSelect403).click().build().perform();

			// analysed output
			WebElement dropdownContainer402 = driver.findElement(By.xpath("//*[@id=\"select2-outputVal-container\"]"));
			dropdownContainer402.click();

			WebElement normal1Option402 = driver.findElement(By.xpath("//li[text()='CounterExhaust1']"));
			normal1Option402.click();
			Thread.sleep(5000);
			
			
			//ADD BUTTON
			driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(1000);
			WebElement messageconfirm = driver.findElement(By.xpath("//*[@id=\"dispMsgConf\"]/div/div"));
			 String message1 = messageconfirm.getText(); 
			 int index = message1.indexOf('×');// Find the index of '×'
				String ActualOutput = message1.substring(index + 1).trim();
				System.out.println(ActualOutput);
				
				String message1expected = "SABB Configuration \"GUI_AUTOMATION\" added Successfully !!!";
				Assert.assertTrue(ActualOutput.contains(message1expected), "Test mismatch");

		}
		
		@Test(priority = 2)
		public void f1() throws InterruptedException {
		
			driver.findElement(By.xpath("//*[@id=\"tableBtnsConfigDivId\"]/div/span[2]/i")).click();//REFRESH BUTTON
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"viewConfigTable_filter\"]/label/input")).sendKeys("GUI_AUTOMATION");//SEARCH BUTTON
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"viewConfigTable\"]/tbody/tr/td[6]/i")).click();//DELETE BUTTON
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();//
			
			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgConf\"]/div/div"));
			 String message2 = messageconfirm1.getText(); 
			 int index = message2.indexOf('×');// Find the index of '×'
				String ActualOutput1 = message2.substring(index + 1).trim();
				System.out.println(ActualOutput1);
				
				String message1expected1 = "SABB Configuration \"GUI_AUTOMATION\" deleted Successfully !!!";
				Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");

			
		}
	}


