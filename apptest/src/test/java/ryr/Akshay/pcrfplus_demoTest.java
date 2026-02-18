package ryr.Akshay;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class pcrfplus_demoTest {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriver driver = new FirefoxDriver(); // Initialize the WebDriver instance
		ryr.Akshay.pcrfplus_demoTest.driver = driver; // Set the WebDriver instance

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
	public void output_paramater_creation() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[1]/a/b"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"tableBtnsDivId\"]/div/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"outputServiceSB\"]")).click();
		List<WebElement> Options1 = driver.findElements(By.xpath("//*[@id=\"outputServiceSB\"]/option[4]"));
		Thread.sleep(3000);
		String option11 = "QOS Policy";
		Options1.get(0).click(); // Click on the first option
		System.out.println(" selected: " + option11);
		driver.findElement(By.xpath("//*[@id=\"categoryDiv\"]/span[2]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"newoutputServiceSB\"]")).click();
		List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"newoutputServiceSB\"]/option[4]"));
		Thread.sleep(3000);
		String option22 = "QOS Policy";
		Options2.get(0).click(); // Click on the first option
		System.out.println(" selected: " + option22);

		driver.findElement(By.xpath("//*[@id=\"categoryName\"]")).sendKeys("GUI_AUTOMATION_DEMO");

		driver.findElement(By.xpath("//*[@id=\"addCategoryModal\"]/div/div/div[2]/div/div[2]/button")).click();// button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"select2-categorySB-container\"]")).click();
		// Locate the options within the dropdown
		List<WebElement> districtOptions = driver.findElements(By.xpath("//ul[@id='select2-categorySB-results']/li"));

		String optionToSelect = "GUI_AUTOMATION_DEMO";
		for (WebElement option : districtOptions) {
			if (option.getText().equals(optionToSelect)) {
				option.click();
				System.out.println("Selected option: " + optionToSelect);
				break;
			}
		}
		// parameter name
		driver.findElement(By.xpath("//*[@id=\"paramName_0\"]")).sendKeys("CounterExhaust1");
		// description
		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_0\"]")).sendKeys("CounterExhaust1");

		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		driver.findElement(By.xpath("//*[@id=\"paramName_1\"]")).sendKeys("Normal1");
		// description
		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_1\"]")).sendKeys("Normal1");

		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		driver.findElement(By.xpath("//*[@id=\"paramName_2\"]")).sendKeys("Threshold1");
		// description
		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_2\"]")).sendKeys("Threshold11");

		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		driver.findElement(By.xpath("//*[@id=\"paramName_3\"]")).sendKeys("Threshold22");
		// description
		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_3\"]")).sendKeys("Threshold22");

		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		driver.findElement(By.xpath("//*[@id=\"paramName_4\"]")).sendKeys("Threshold32");
		// description
		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_4\"]")).sendKeys("Threshold32");

		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();// ADD
		driver.findElement(By.xpath("//*[@id=\"paramName_5\"]")).sendKeys("ThresholdExhaust1");
		// description
		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_5\"]")).sendKeys("ThresholdExhaust1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[normalize-space()='Yes'])[1]")).click();
		Thread.sleep(3000);

		WebElement message = driver.findElement(By.xpath("//*[@id=\"dispMsgOP\"]/div/div"));
		String fullMessage = message.getText();
		int index = fullMessage.indexOf('×');// Find the index of '×'
		String ActualOutput = fullMessage.substring(index + 1).trim();// Extract the desired text
		System.out.println(ActualOutput);
		String ExpectedOutput = "Output Parameters added to Category \"GUI_AUTOMATION_DEMO\" Successfully !!!";
		Assert.assertTrue(ActualOutput.contains(ExpectedOutput), "Test mismatch");
		Thread.sleep(2000);
	}

//		@Test(priority = 2)
//		public void QOS_creation() throws InterruptedException {
//			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//b[normalize-space()='Policy']")).click();//policy
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"qosButton\"]")).click();//qos
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"tableBtnsCTDiv\"]/div/span[1]")).click();//add new qos
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"qosName\"]")).sendKeys("GUI_AUTOMATION_DEMO");
//			driver.findElement(By.xpath("//*[@id=\"QosMBR\"]")).sendKeys("10");
//			driver.findElement(By.xpath("//*[@id=\"unitSB_QosMBR\"]")).click();
//			List<WebElement> Options1 = driver.findElements(By.xpath("//*[@id=\"unitSB_QosMBR\"]/option[2]"));
//			Thread.sleep(2000);
//			String option11 = "KB";
//			Options1.get(0).click(); // Click on the first option
//			System.out.println(" selected: " + option11);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"addButton\"]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
//			Thread.sleep(2000);
	//
//			WebElement message = driver.findElement(By.xpath("//*[@id=\"dispMsgQOS\"]/div/div"));
//			String fullMessage = message.getText();
//			int index = fullMessage.indexOf('×');// Find the index of '×'
//			String ActualOutput = fullMessage.substring(index + 1).trim();// Extract the desired text
//			System.out.println(ActualOutput);
//			String ExpectedOutput = "QOS Profile created successfully";
//			Assert.assertTrue(ActualOutput.contains(ExpectedOutput), "Test mismatch");
//		}

	@Test(priority = 2)
	public void chargerule_creation() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[3]/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ruleButton\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tableBtnsCTDiv\"]/div/span[1]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"profileOption\"]")).click();
		Thread.sleep(2000);

		List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"profileOption\"]/option[1]"));
		Thread.sleep(1000);
		String option22 = "Static";
		Options2.get(0).click(); // Click on the first option
		System.out.println(" selected: " + option22);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"pdName\"]")).sendKeys("GUI_AUTOMATION_DEMO");
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='qos']"));
		dropdown2.click();
		Thread.sleep(5000);
		Select select = new Select(dropdown2);
		// Select by visible text
		String optionText = "GUI_AUTOMATION_DEMO(411)";
		select.selectByVisibleText(optionText);
		System.out.println("Selected: " + optionText);

		driver.findElement(By.xpath("//*[@id=\"precedence\"]")).sendKeys("20");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addButton\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		Thread.sleep(2000);

		WebElement messageconfirm = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
		String message1 = messageconfirm.getText();
		int index = message1.indexOf('×');// Find the index of '×'
		String ActualOutput = message1.substring(index + 1).trim();
		System.out.println(ActualOutput);

		String message1expected = "Charge Rule Added successfully! : Charging RuleInfo creation Success";
		Assert.assertTrue(ActualOutput.contains(message1expected), "Test mismatch");
	}

	@Test(priority = 4)
	public void policyDefinition_creation() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[3]/a"))
				.click();// policy
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='policyDefButton']")).click();// policy definition
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tableBtnsPDDiv\"]/div/span[1]/i")).click();// add new PD
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"PDName\"]")).sendKeys("GUI_AUTOMATION_DEMO");
		Thread.sleep(2000);

		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"PDService\"]"));
		Select select = new Select(dropdown);
		String optionText = "QOS Policy";
		select.selectByVisibleText(optionText);
		System.out.println("Selected: " + optionText);
		Thread.sleep(2000);

		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"select2-timeSlot-container\"]"));
		dropdown1.click();
		String optionText1 = "PCRF_Plus_TS";
		WebElement optionElement = driver.findElement(By.xpath("//li[contains(text(), '" + optionText1 + "')]"));
		optionElement.click();
		System.out.println("Selected: " + optionText1);
		Thread.sleep(3000);

		WebElement dropdownContainer39 = driver.findElement(By.xpath("//*[@id=\"ChargeRuleDiv\"]/span[2]/div/button"));
		dropdownContainer39.click();
		Thread.sleep(3000);
		String chargerule = "GUI_AUTOMATION_DEMO";
		driver.findElement(By.xpath("//*[@id=\"ChargeRuleDiv\"]/span[2]/div/ul/li[59]/a/label")).click();
		System.out.println(chargerule);
		WebElement bodyElement = driver.findElement(By.tagName("body"));
		bodyElement.click();
		Thread.sleep(2000);

		// *[@id="baseProd"]
		WebElement dropdown3 = driver.findElement(By.xpath("//*[@id=\"baseProd\"]"));
		Select select3 = new Select(dropdown3);
		String optionText3 = "Base";
		select3.selectByVisibleText(optionText3);
		System.out.println("Selected: " + optionText3);
		Thread.sleep(2000);

		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"select2-ruleStatus-container\"]"));
		dropdown2.click();
		String optionText2 = "Active";
		By optionLocator = By.xpath("//li[@class='select2-results__option' and text()='" + optionText2 + "']");
		WebElement optionElement2 = driver.findElement(optionLocator);
		optionElement2.click();
		System.out.println("Selected: " + optionText2);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"divAddPDMain\"]/div[3]/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		Thread.sleep(2000);

		WebElement messageconfirm = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
		String message1 = messageconfirm.getText();
		int index = message1.indexOf('×');// Find the index of '×'
		String ActualOutput = message1.substring(index + 1).trim();
		System.out.println(ActualOutput);

		String message1expected = "Policy creation Success";
		Assert.assertTrue(ActualOutput.contains(message1expected), "Test mismatch");
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void SABB_creation() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fa tss-add']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sabbName\"]")).sendKeys("GUI_AUTOMATION_DEMO");// SABB NAME

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
		WebElement dropdowngroup1 = driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G1_R1\"]"));
		Thread.sleep(2000);
		List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G1_R1\"]/option[4]"));
		Thread.sleep(1000);
		String option22 = "Grouped";
		Options2.get(0).click();
		System.out.println(" selected: " + option22);
		Thread.sleep(1000);

		WebElement dropdown1 = driver.findElement(By.id("groupedSB_G0_G1_R1"));
		Thread.sleep(1000);
		Select select1 = new Select(dropdown1);
		select1.selectByIndex(7);// sy

		// add rule button
		driver.findElement(By.xpath("//*[@id=\"addRule_G0_G1_G1\"]")).click();
		// *[@id="and_G0_G1_G1"] and button
		// driver.findElement(By.xpath("//*[@id=\"and_G0_G1_G1\"]")).click();

		// ATTRIBUTE TYPE12
		driver.findElement(By.xpath(" //*[@id=\"categorySB_G0_G1_G1_R1\"]")).click();
		Thread.sleep(1000);
		List<WebElement> Options22 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G1_G1_R1\"]/option"));
		Thread.sleep(1000);
		String option222 = "Grouped";
		Options22.get(0).click();
		System.out.println(" selected: " + option222);
		Thread.sleep(1000);

		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G1_G1_R1\"]"));
		Thread.sleep(2000);
		Select select2 = new Select(dropdown2);
		select2.selectByIndex(1);// to select Policy-Counter-Status
		Thread.sleep(1000);

		WebElement dropdown3 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G1_G1_R1\"]"));
		Thread.sleep(1000);
		Select select3 = new Select(dropdown3);
		select3.selectByVisibleText("IN");// to select IN
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"enum_G0_G1_G1_R1\"]/span/div")).click();
		List<WebElement> alloptions = driver.findElements(By.xpath("//*[@id=\"enum_G0_G1_G1_R1\"]/span/div/ul"));
		String option = "Normal (0)";
		for (int i = 0; i < alloptions.size(); i++) {
			alloptions.get(i).click();
			System.out.println(option);// to select Normal(0)
			break;
		}
		Thread.sleep(2000);

		// attriute type12
		WebElement dropdown10 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G1_G1_R2\"]"));
		Thread.sleep(2000);
		Select select10 = new Select(dropdown10);
		select10.selectByIndex(2);// to select Policy-Counter-Identifier
		Thread.sleep(1000);

		WebElement dropdown11 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G1_G1_R2\"]"));
		Thread.sleep(1000);
		Select select11 = new Select(dropdown11);
		select11.selectByVisibleText("IN");// to select IN
		Thread.sleep(1000);

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
		String kotapack = "GUI_AUTOMATION_DEMO";
		WebElement optionToSelect = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack + "')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(optionToSelect).click().build().perform();

		// analysed output11
		WebElement dropdownContainer = driver.findElement(By.id("select2-outputVal_1-container"));
		dropdownContainer.click();
		// Locate and click on the specific option ("Normal1")
		WebElement normal1Option = driver.findElement(By.xpath("//li[text()='Normal1']"));
		normal1Option.click();
		Thread.sleep(2000);

		// 2nd
		// ATTRIBUTE TYPE21
		WebElement dropdowngroup2 = driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G2_R1\"]"));
		Thread.sleep(1000);
		List<WebElement> Options71 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G2_R1\"]/option[4]"));
		Thread.sleep(1000);
		String option71 = "Grouped";
		Options71.get(0).click(); // Click on the first option
		System.out.println(" selected: " + option71);
		Thread.sleep(1000);

		WebElement dropdown72 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G2_R1\"]"));
		Thread.sleep(2000);
		Select select72 = new Select(dropdown72);
		select72.selectByIndex(7);
		Thread.sleep(1000);

		// add rule
		driver.findElement(By.xpath("//*[@id=\"addRule_G0_G2_G1\"]")).click();// add rule
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//*[@id=\"and_G0_G2_G1\"]")).click();//and
		// button

		WebElement dropdown74 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G2_G1_R1\"]"));
		Thread.sleep(2000);
		Select select74 = new Select(dropdown74);
		select74.selectByIndex(1);// to select Policy-Counter-Status
		Thread.sleep(1000);

		WebElement dropdown75 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G2_G1_R1\"]"));
		Thread.sleep(1000);
		Select select75 = new Select(dropdown75);
		select75.selectByVisibleText("IN");// to select IN
		Thread.sleep(1000);

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

		// attriute type22
		WebElement dropdown77 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G2_G1_R2\"]"));
		Thread.sleep(2000);
		Select select77 = new Select(dropdown77);
		select77.selectByIndex(2);// to select Policy-Counter-Identifier
		Thread.sleep(1000);

		WebElement dropdown78 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G2_G1_R2\"]"));
		Thread.sleep(1000);
		Select select78 = new Select(dropdown78);
		select78.selectByVisibleText("IN");// to select IN
		Thread.sleep(1000);

		WebElement dropdownContainer79 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G2_G1_R2\"]/span/div/button"));
		dropdownContainer79.click();
		Thread.sleep(1000);
		String kotapack79 = "PC1 (PC1)";
		WebElement optionToSelect79 = driver
				.findElement(By.xpath("//*[@id=\"enum_G0_G2_G1_R2\"]/span/div/ul/li[4]/a/label"));
		Actions actions79 = new Actions(driver);
		actions79.moveToElement(optionToSelect79).click().build().perform();

		// analysed category(true)21
		// *[@id="select2-categoryVal_2-container"]
		driver.findElement(By.id("select2-categoryVal_2-container")).click();
		String kotapack80 = "GUI_AUTOMATION_DEMO";
		WebElement optionToSelect80 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack80 + "')]"));
		Actions actions80 = new Actions(driver);
		actions80.moveToElement(optionToSelect80).click().build().perform();

		// analysed output22
		// *[@id="select2-outputVal_2-container"]
		WebElement dropdownContainer80 = driver.findElement(By.id("select2-outputVal_2-container"));
		dropdownContainer80.click();
		// Locate and click on the specific option ("Normal1")
		WebElement normal1Option80 = driver.findElement(By.xpath("//li[text()='Threshold1']"));
		normal1Option80.click();
		Thread.sleep(2000);

		// 3rd
		// ATTRIBUTE TYPE31
		WebElement dropdowngroup3 = driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G3_R1\"]"));
		Thread.sleep(1000);
		List<WebElement> Options81 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G3_R1\"]/option[4]"));
		Thread.sleep(1000);
		String option81 = "Grouped";
		Options81.get(0).click();
		System.out.println(" selected: " + option81);
		Thread.sleep(1000);

		WebElement dropdown82 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G3_R1\"]"));
		Thread.sleep(2000);
		Select select82 = new Select(dropdown82);
		select82.selectByIndex(7);
		Thread.sleep(1000);

		// add rule
		driver.findElement(By.xpath("//*[@id=\"addRule_G0_G3_G1\"]")).click();// add rule
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//*[@id=\"and_G0_G3_G1\"]")).click();

		WebElement dropdown84 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G3_G1_R1\"]"));
		dropdown84.click();
		Thread.sleep(2000);
		Select select84 = new Select(dropdown84);
		select84.selectByIndex(1);// to select Policy-Counter-Status
		Thread.sleep(1000);

		WebElement dropdown85 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G3_G1_R1\"]"));
		Thread.sleep(1000);
		Select select85 = new Select(dropdown85);
		select85.selectByVisibleText("IN");
		Thread.sleep(1000);

		WebElement dropdownContainer86 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G3_G1_R1\"]/span/div/button"));
		dropdownContainer86.click();
		List<WebElement> alloptions86 = driver.findElements(By.xpath("//*[@id=\"enum_G0_G3_G1_R1\"]/span/div/ul"));
		Thread.sleep(2000);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"enum_G0_G3_G1_R1\"]/span/div/ul/li[5]/a/label")).click();
		Thread.sleep(1000);

		// attriute type32
		WebElement dropdown87 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G3_G1_R2\"]"));
		Thread.sleep(2000);
		Select select87 = new Select(dropdown87);
		select87.selectByIndex(2);// to select Policy-Counter-Identifier
		Thread.sleep(1000);

		WebElement dropdown88 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G3_G1_R2\"]"));
		Thread.sleep(1000);
		Select select88 = new Select(dropdown88);
		select88.selectByVisibleText("IN");
		Thread.sleep(1000);

		WebElement dropdownContainer89 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G3_G1_R2\"]/span/div/button"));
		dropdownContainer89.click();
		Thread.sleep(1000);
		String kotapack89 = "PC1 (PC1)";
		WebElement optionToSelect89 = driver
				.findElement(By.xpath("//*[@id=\"enum_G0_G3_G1_R2\"]/span/div/ul/li[4]/a/label"));
		Actions actions89 = new Actions(driver);
		actions89.moveToElement(optionToSelect89).click().build().perform();

		// analysed category(true)31
		driver.findElement(By.id("select2-categoryVal_3-container")).click();
		String kotapack90 = "GUI_AUTOMATION_DEMO";
		WebElement optionToSelect90 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack80 + "')]"));
		Actions actions90 = new Actions(driver);
		actions90.moveToElement(optionToSelect90).click().build().perform();

		// analysed output32
		WebElement dropdownContainer91 = driver.findElement(By.id("select2-outputVal_3-container"));
		dropdownContainer91.click();
		// Locate and click on the specific option ("Threshold2")
		WebElement normal1Option91 = driver.findElement(By.xpath("//li[text()='Threshold22']"));
		normal1Option91.click();
		Thread.sleep(2000);

		// 4th column
		// ATTRIBUTE TYPE41
		WebElement dropdowngroup4 = driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G4_R1\"]"));
		Thread.sleep(1000);
		List<WebElement> Options61 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G4_R1\"]/option[4]"));
		Thread.sleep(1000);
		String option61 = "Grouped";
		Options61.get(0).click();
		System.out.println(" selected: " + option61);
		Thread.sleep(1000);

		WebElement dropdown62 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G4_R1\"]"));
		Thread.sleep(2000);
		Select select62 = new Select(dropdown62);
		select62.selectByIndex(7);
		Thread.sleep(1000);

		// add rule
		driver.findElement(By.xpath("//*[@id=\"addRule_G0_G4_G1\"]")).click();// add rule
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//*[@id=\"and_G0_G4_G1\"]")).click();

		WebElement dropdown64 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G4_G1_R1\"]"));
		dropdown84.click();
		Thread.sleep(2000);
		Select select64 = new Select(dropdown64);
		select64.selectByIndex(1);// to select Policy-Counter-Status
		Thread.sleep(1000);

		WebElement dropdown65 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G4_G1_R1\"]"));
		Thread.sleep(1000);
		Select select65 = new Select(dropdown65);
		select65.selectByVisibleText("IN");
		Thread.sleep(1000);

		// code to select 3rd Threshold breached (3)
		driver.findElement(By.xpath("//*[@id=\"enum_G0_G4_G1_R1\"]/span/div")).click();
		List<WebElement> alloptions51 = driver.findElements(By.xpath("//*[@id=\"enum_G0_G4_G1_R1\"]/span/div/ul"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"enum_G0_G4_G1_R1\"]/span/div/ul/li[6]")).click();
		Thread.sleep(2000);

		// attriute type42
		WebElement dropdown67 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G4_G1_R2\"]"));
		Thread.sleep(2000);
		Select select67 = new Select(dropdown67);
		select67.selectByIndex(2);// to select Policy-Counter-Identifier
		Thread.sleep(1000);

		WebElement dropdown68 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G4_G1_R2\"]"));
		Thread.sleep(1000);
		Select select68 = new Select(dropdown68);
		select68.selectByVisibleText("IN");
		Thread.sleep(1000);

		WebElement dropdownContainer69 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G4_G1_R2\"]/span/div/button"));
		dropdownContainer69.click();
		Thread.sleep(1000);
		String kotapack69 = "PC1 (PC1)";
		WebElement optionToSelect69 = driver
				.findElement(By.xpath("//*[@id=\"enum_G0_G4_G1_R2\"]/span/div/ul/li[4]/a/label"));
		Actions actions69 = new Actions(driver);
		actions69.moveToElement(optionToSelect69).click().build().perform();

		// analysed category(true)41
		driver.findElement(By.id("select2-categoryVal_4-container")).click();
		String kotapack699 = "GUI_AUTOMATION_DEMO";
		WebElement optionToSelect699 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack699 + "')]"));
		Actions actions699 = new Actions(driver);
		actions699.moveToElement(optionToSelect699).click().build().perform();

		// analysed output42
		WebElement dropdownContainer691 = driver.findElement(By.xpath("//*[@id=\"select2-outputVal_4-container\"]"));
		dropdownContainer691.click();
		WebElement normal1Option691 = driver.findElement(By.xpath("//li[text()='Threshold32']"));
		normal1Option691.click();
		Thread.sleep(1000);

		// 5th column
		// ATTRIBUTE TYPE51
		WebElement dropdowngroup5 = driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G5_R1\"]"));
		Thread.sleep(1000);
		List<WebElement> Options31 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G5_R1\"]/option[4]"));
		Thread.sleep(1000);
		String option31 = "Grouped";
		Options31.get(0).click();
		System.out.println(" selected: " + option31);
		Thread.sleep(1000);

		WebElement dropdown32 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G5_R1\"]"));
		Thread.sleep(2000);
		Select select32 = new Select(dropdown32);
		select32.selectByIndex(7);
		Thread.sleep(1000);

		// add rule
		driver.findElement(By.xpath("//*[@id=\"addRule_G0_G5_G1\"]")).click();// add rule
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//*[@id=\"and_G0_G5_G1\"]")).click();

		WebElement dropdown34 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G5_G1_R1\"]"));
		dropdown34.click();
		Thread.sleep(2000);
		Select select34 = new Select(dropdown34);
		select34.selectByIndex(1);// to select Policy-Counter-Status
		Thread.sleep(2000);

		WebElement dropdown35 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G5_G1_R1\"]"));
		Thread.sleep(1000);
		Select select35 = new Select(dropdown35);
		select35.selectByVisibleText("IN");
		Thread.sleep(1000);

		WebElement dropdownContainer36 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G5_G1_R1\"]/span/div/button"));
		dropdownContainer36.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"enum_G0_G5_G1_R1\"]/span/div/ul/li[7]")).click();// to select threshold
																								// exhaust(5)
		Thread.sleep(2000);

		// ATTRIBUTE TYPE52
		WebElement dropdown37 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G5_G1_R2\"]"));
		Thread.sleep(2000);
		Select select37 = new Select(dropdown37);
		select37.selectByIndex(2);// to select Policy-Counter-Identifier
		Thread.sleep(1000);

		WebElement dropdown38 = driver.findElement(By.xpath("//*[@id=\"enumOpSB_G0_G5_G1_R2\"]"));
		Thread.sleep(1000);
		Select select38 = new Select(dropdown38);
		select38.selectByVisibleText("IN");
		Thread.sleep(1000);

		WebElement dropdownContainer39 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G5_G1_R2\"]/span/div/button"));
		dropdownContainer39.click();
		Thread.sleep(1000);
		String kotapack39 = "PC1 (PC1)";
		WebElement optionToSelect39 = driver
				.findElement(By.xpath("//*[@id=\"enum_G0_G5_G1_R2\"]/span/div/ul/li[4]/a/label"));
		Actions actions39 = new Actions(driver);
		actions39.moveToElement(optionToSelect39).click().build().perform();

		// analysed category(true)51
		driver.findElement(By.id("select2-categoryVal_5-container")).click();
		String kotapack40 = "GUI_AUTOMATION_DEMO";
		WebElement optionToSelect400 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack40 + "')]"));
		Actions actions400 = new Actions(driver);
		actions400.moveToElement(optionToSelect400).click().build().perform();

		// analysed output52
		// *[@id="select2-outputVal_4-container"]
		WebElement dropdownContainer401 = driver.findElement(By.xpath("//*[@id=\"select2-outputVal_5-container\"]"));
		dropdownContainer401.click();
		// Locate and click on the specific option ("ThresholdExhaust1")
		WebElement normal1Option401 = driver.findElement(By.xpath("//li[text()='ThresholdExhaust1']"));
		normal1Option401.click();
		Thread.sleep(2000);

		// analysed category(true)53
		driver.findElement(By.xpath("//*[@id=\"select2-categoryVal-container\"]")).click();
		String kotapack403 = "GUI_AUTOMATION_DEMO";
		WebElement optionToSelect403 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack403 + "')]"));
		Actions actions403 = new Actions(driver);
		actions403.moveToElement(optionToSelect403).click().build().perform();

		// analysed output51
		WebElement dropdownContainer402 = driver.findElement(By.xpath("//*[@id=\"select2-outputVal-container\"]"));
		dropdownContainer402.click();

		WebElement normal1Option402 = driver.findElement(By.xpath("//li[text()='CounterExhaust1']"));
		normal1Option402.click();
		Thread.sleep(5000);

		// ADD BUTTON
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		Thread.sleep(1000);
		WebElement messageconfirm = driver.findElement(By.xpath("//*[@id=\"dispMsgConf\"]/div/div"));
		String message1 = messageconfirm.getText();
		int index = message1.indexOf('×');// Find the index of '×'
		String ActualOutput = message1.substring(index + 1).trim();
		System.out.println(ActualOutput);

		String message1expected = "SABB Configuration \"GUI_AUTOMATION_DEMO\" added Successfully !!!";
		Assert.assertTrue(ActualOutput.contains(message1expected), "Test mismatch");
	}

}
