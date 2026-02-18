package ryr.Akshay;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Project_main {
 
		public static WebDriver driver;

		@BeforeClass
		public void setUp() throws InterruptedException {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			ryr.Akshay.Project_main.driver = driver; 
			driver.get("https://10.0.6.20:8443/tssgui/welcome/jsp/HomePage_Main.jsp#");
			driver.manage().window();
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"passdiv\"]/div/input")).sendKeys("admin123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"subBtn\"]")).click();
		}

		//browser get closed once all the test cases are executed
//		@AfterClass
//		public void tearDown() {
//			if (driver != null) {
//				driver.quit();
//			}
//		}
		
		@Test(priority = 1)
		public void subscriber_deletion() throws InterruptedException {
			
			
				driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[5]/div/div[2]/ul/li[3]/a/b")).click();
			//sub mgmt locator
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"searchCustBox\"]")).sendKeys("24896385265");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"searchIcon\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@title='Click to Delete subscriber Profile']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(1000);
			
			//logic to verify new subscriber is deleted or not and cross verifying with expected output using assertion concept
					WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
					 String message2 = messageconfirm1.getText(); 
					 Thread.sleep(2000);
					 int index = message2.indexOf('×');// Find the index of '×'
						String ActualOutput1 = message2.substring(index + 1).trim();
						System.out.println(ActualOutput1);		
						String message1expected1 = "Delete Subs Info Success";
						Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");
						Thread.sleep(2000);
		}
			
			
		@Test(priority = 2)
		public void product_deletion() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[4]/a/b")).click();//product
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsPDDiv\"]/div/span[2]/i")).click();//refresh button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"PolicyProdTab_filter\"]/label/input")).sendKeys("GUI_AUTOMATION_DEMO");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"PolicyProdTab\"]/tbody/tr/td[6]/i")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			
			//logic to verify new product is deleted or not and cross verifying with expected output using assertion concept
			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
			 String message2 = messageconfirm1.getText(); 
			 Thread.sleep(2000);
			 int index = message2.indexOf('×');// Find the index of '×'
				String ActualOutput1 = message2.substring(index + 1).trim();
				System.out.println(ActualOutput1);		
				String message1expected1 = "Product deleted Successfully!";
				Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");	
				Thread.sleep(2000);
		}
		
//		@Test(priority = 3)
//		public void policytree_deletion() throws InterruptedException {
//			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[3]/a")).click();// policy 
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"chargeTreeTable_filter\"]/label/input")).sendKeys("GUI_AUTOMATION_DEMO");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//i[@title='Click to Delete PT']")).click();//locator for delete button
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
//			
//			//logic to verify new policy tree is deleted or not and cross verifying with expected output using assertion concept
//			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgCT\"]/div/div"));
//			 String message2 = messageconfirm1.getText(); 
//			 Thread.sleep(2000);
//			 int index = message2.indexOf('×');// Find the index of '×'
//				String ActualOutput1 = message2.substring(index + 1).trim();
//				System.out.println(ActualOutput1);
//				
//				String message1expected1 = "Policy Tree \"GUI_AUTOMATION_DEMO\" is deleted Successfully !!! ";
//				Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");
		//Thread.sleep(2000);
//		}
		
		

		@Test(priority = 4)
		public void SABB_deletion() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[2]/a")).click();//service attribute locator
			Thread.sleep(2000);
			driver.findElement(By.xpath("//i[@class='fa tss-add']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsConfigDivId\"]/div/span[2]/i")).click();// REFRESH BUTTON
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"viewConfigTable_filter\"]/label/input")).sendKeys("GUI_AUTOMATION_DEMO");// SEARCH BUTTON
																														 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"viewConfigTable\"]/tbody/tr/td[6]/i")).click();// DELETE BUTTON
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();//

			//logic to verify new SABB is deleted or not and cross verifying with expected output using assertion concept
			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgConf\"]/div/div"));
			String message2 = messageconfirm1.getText();
			int index = message2.indexOf('×');// Find the index of '×'
			String ActualOutput1 = message2.substring(index + 1).trim();
			System.out.println(ActualOutput1);
			String message1expected1 = "SABB Configuration \"GUI_AUTOMATION_DEMO\" deleted Successfully !!!";
			Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");
			Thread.sleep(2000);
		}
		
		@Test(priority = 4)
		public void PD_Deletion() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[3]/a")).click();// policy 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='policyDefButton']")).click();// policy definition
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsPDDiv\"]/div/span[2]/i")).click();//refresh button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"PDTable_filter\"]/label/input")).sendKeys("GUI_AUTOMATION_DEMO");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"PDTable\"]/tbody/tr/td[7]/i")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			
			//logic to verify new PD is deleted or not and cross verifying with expected output using assertion concept
			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
			 String message2 = messageconfirm1.getText(); 
			 Thread.sleep(2000);
			 int index = message2.indexOf('×');// Find the index of '×'
				String ActualOutput1 = message2.substring(index + 1).trim();
				System.out.println(ActualOutput1);		
				String message1expected1 = "Policy Deletion Success";
				Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");
				Thread.sleep(2000);
		}
		
		
		@Test(priority = 5)
		public void chargerule_deletion() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[3]/a")).click();// policy 
			Thread.sleep(2000);
			//*[@id="ruleButton"]
			driver.findElement(By.xpath("//*[@id=\"ruleButton\"]")).click();//charge rule button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsCTDiv\"]/div/span[2]/i")).click();//refresh button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ChargeRuleViewTable_filter\"]/label/input")).sendKeys("GUI_AUTOMATION_DEMO");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ChargeRuleViewTable\"]/tbody/tr/td[7]/i")).click();//delete button locator
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();//confirmation locator
			
			//logic to verify new charge rule is deleted or not and cross verifying with expected output using assertion concept
			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgConf\"]/div/div"));
			 String message2 = messageconfirm1.getText(); 
			 int index = message2.indexOf('×');// Find the index of '×'
				String ActualOutput1 = message2.substring(index + 1).trim();
				System.out.println(ActualOutput1);
				String message1expected1 = "SABB Configuration \"GUI_AUTOMATION_DEMO\" deleted Successfully !!!";
				Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");		
		}
		
		@Test(priority = 6)
		public void QOS_deletion() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//b[normalize-space()='Policy']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"qosButton\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"QosViewTable_filter\"]/label/input")).sendKeys("GUI_AUTOMATION_DEMO");//delete button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//i[@title='Click to Delete QOS']")).click();
			Thread.sleep(2000);
			 driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			 Thread.sleep(2000);
			 
			 //logic to verify new optput parameters are deleted or not and cross verifying with expected output using assertion concept
		 		WebElement message = driver.findElement(By.xpath("//*[@id=\"dispMsgQOS\"]/div/div"));
				String fullMessage = message.getText();
				int index = fullMessage.indexOf('×');// Find the index of '×'
				String ActualOutput = fullMessage.substring(index + 1).trim();// Extract the desired text
				System.out.println(ActualOutput);
				String ExpectedOutput = "QOS Profile Deletion Success ";
				Assert.assertTrue(ActualOutput.contains(ExpectedOutput), "Test mismatch");
				Thread.sleep(2000);
		}
		
		@Test(priority =7)
		public void output_parameter_deletion() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a/i")).click();//site map
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[1]/a/b"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsDivId\"]/div/span[1]")).click();//
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"outputServiceSB\"]")).click();
			List<WebElement> Options1 = driver.findElements(By.xpath("//*[@id=\"outputServiceSB\"]/option[4]"));
			Thread.sleep(3000);
			String option11 = "QOS Policy";
			Options1.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option11);
			
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
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//*[@id=\"deletecat\"]")).click();//delete button locator
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();//confirmation locator
	        
	      //logic to verify new optput parameters are deleted or not and cross verifying with expected output using assertion concept
	 		WebElement message = driver.findElement(By.xpath("//*[@id=\"dispMsgOP\"]/div/div"));
			String fullMessage = message.getText();
			int index = fullMessage.indexOf('×');// Find the index of '×'
			String ActualOutput = fullMessage.substring(index + 1).trim();// Extract the desired text
			System.out.println(ActualOutput);
			String ExpectedOutput = "Output Parameters added to Category \"GUI_AUTOMATION_DEMO\" Successfully !!!";
			Assert.assertTrue(ActualOutput.contains(ExpectedOutput), "Test mismatch");
			Thread.sleep(2000);
		}
		
		//code for output parameter creation
		@Test(priority =8)
		public void output_paramater_creation() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a/i")).click();//site map
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[1]/a/b")).click();//locator for configuration
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsDivId\"]/div/span[1]")).click();//locator for add output parameter
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"outputServiceSB\"]")).click();// locator for service field
			List<WebElement> Options1 = driver.findElements(By.xpath("//*[@id=\"outputServiceSB\"]/option[4]"));
			Thread.sleep(2000);
			String option11 = "QOS Policy";
			Options1.get(0).click(); // selecting QOS policy option in service dropdown list
			System.out.println(" selected: " + option11);
			
			driver.findElement(By.xpath("//*[@id=\"categoryDiv\"]/span[2]/i")).click();//locator for adding new  category name
			driver.findElement(By.xpath("//*[@id=\"newoutputServiceSB\"]")).click();//locator for new service field
			List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"newoutputServiceSB\"]/option[4]"));//locator for QOS option in servie dropdown list
			Thread.sleep(2000);
			String option22 = "QOS Policy";
			Options2.get(0).click(); 
			System.out.println(" selected: " + option22);

			driver.findElement(By.xpath("//*[@id=\"categoryName\"]")).sendKeys("GUI_AUTOMATION_DEMO");//locator for new categry name field

			driver.findElement(By.xpath("//*[@id=\"addCategoryModal\"]/div/div/div[2]/div/div[2]/button")).click();//  submit button in category name field
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(3000);
			
	         //code to select newly added category in the filed	
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
		        
		     // adding the counters(parameters) name to newly created category
		     		driver.findElement(By.xpath("//*[@id=\"paramName_0\"]")).sendKeys("CounterExhaust1");//parameter name1
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_0\"]")).sendKeys("CounterExhaust1");// description
		     		
	                driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();//locator for add parameter 
		     		driver.findElement(By.xpath("//*[@id=\"paramName_1\"]")).sendKeys("Normal1");//parameter name2
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_1\"]")).sendKeys("Normal1");//description

		     		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();
		     		driver.findElement(By.xpath("//*[@id=\"paramName_2\"]")).sendKeys("Threshold1");// ADD parameter name3
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_2\"]")).sendKeys("Threshold11");// description

		     		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();
		     		driver.findElement(By.xpath("//*[@id=\"paramName_3\"]")).sendKeys("Threshold22");// ADD parameter name4
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_3\"]")).sendKeys("Threshold22");// description

		     		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();
		     		driver.findElement(By.xpath("//*[@id=\"paramName_4\"]")).sendKeys("Threshold32");// ADD parameter name5
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_4\"]")).sendKeys("Threshold32");// description

		     		driver.findElement(By.xpath("//*[@id=\"divOutAddMain\"]/div/div[1]/div[4]/a/i")).click();
		     		driver.findElement(By.xpath("//*[@id=\"paramName_5\"]")).sendKeys("ThresholdExhaust1");// ADD parameter name6
		     		driver.findElement(By.xpath("//*[@id=\"outputParamCommentTA_5\"]")).sendKeys("ThresholdExhaust1");// description
		     		Thread.sleep(3000);
		     		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		     		Thread.sleep(3000);
		     		driver.findElement(By.xpath("(//button[normalize-space()='Yes'])[1]")).click();
		     		Thread.sleep(3000);
		     		
		     		//logic to verify new optput parameters are created or not and cross verifying with expected output using assertion concept
		     		WebElement message = driver.findElement(By.xpath("//*[@id=\"dispMsgOP\"]/div/div"));
		    		String fullMessage = message.getText();
		    		int index = fullMessage.indexOf('×');// Find the index of '×'
		    		String ActualOutput = fullMessage.substring(index + 1).trim();// Extract the desired text
		    		System.out.println(ActualOutput);
		    		String ExpectedOutput = "Output Parameters added to Category \"GUI_AUTOMATION_DEMO\" Successfully !!!";
		    		Assert.assertTrue(ActualOutput.contains(ExpectedOutput), "Test mismatch");
		    		Thread.sleep(2000);
		}
		
		//code for QOS creation
		@Test(priority = 9)
		public void QOS_creation() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// locator for sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//b[normalize-space()='Policy']")).click();// locator for policy
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"qosButton\"]")).click();//locator for QOS
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"tableBtnsCTDiv\"]/div/span[1]")).click();//locator to add new QOS
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"qosName\"]")).sendKeys("GUI_AUTOMATION_DEMO");//locator for QOS name
			driver.findElement(By.xpath("//*[@id=\"QosMBR\"]")).sendKeys("10");//locator for MBR
			
			//logic to select KB in the MBR dropdown
			driver.findElement(By.xpath("//*[@id=\"unitSB_QosMBR\"]")).click();
			List<WebElement> Options1 = driver.findElements(By.xpath("//*[@id=\"unitSB_QosMBR\"]/option[2]"));
			Thread.sleep(2000);
			String option11 = "KB";
			Options1.get(0).click(); // Click on the first option
			System.out.println(" selected: " + option11);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"addButton\"]")).click();//add button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(2000);

			//logic to verify new QOS is created or not and cross verifying with expected output using assertion concept
			WebElement message = driver.findElement(By.xpath("//*[@id=\"dispMsgQOS\"]/div/div"));
			String fullMessage = message.getText();
			int index = fullMessage.indexOf('×');// Find the index of '×'
			String ActualOutput = fullMessage.substring(index + 1).trim();// Extract the desired text
			System.out.println(ActualOutput);
			String ExpectedOutput = "QOS Profile created successfully";
			Assert.assertTrue(ActualOutput.contains(ExpectedOutput), "Test mismatch");
		}
		
		//code for charge rule creation
		@Test(priority = 10)
		public void chargerule_creation() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// locator for sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[3]/a"))//locator for policy
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ruleButton\"]")).click();//locator for charg rule
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsCTDiv\"]/div/span[1]/i")).click();// locator to add new charge rule
			Thread.sleep(2000);
			
			// logic to select static option in charg rule type field 
			driver.findElement(By.xpath("//*[@id=\"profileOption\"]")).click();
			Thread.sleep(2000);
			List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"profileOption\"]/option[1]"));//locator for static option
			Thread.sleep(1000);
			String option22 = "Static";
			Options2.get(0).click(); 
			System.out.println(" selected: " + option22);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"pdName\"]")).sendKeys("GUI_AUTOMATION_DEMO");//locator for base name field
			
			//logic to select QOS in the QOS dropdown list
			WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='qos']"));
			dropdown2.click();
			Thread.sleep(5000);
			Select select = new Select(dropdown2);
			// Partial string to match
			String partialText = "GUI_AUTOMATION_DEMO";
			// Iterate through all options and select the one containing the partial text
			for (WebElement option : select.getOptions()) {
			    if (option.getText().contains(partialText)) {
			        select.selectByVisibleText(option.getText());
			        System.out.println("Selected: " + option.getText());
			        break; // Exit the loop once the option is found
			    }
			}


			driver.findElement(By.xpath("//*[@id=\"precedence\"]")).sendKeys("20");//locator for precedence
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"addButton\"]")).click();//locator for add button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(2000);

			//logic to verify new charge rule is created or not and cross verifying with expected output using assertion concept
			WebElement messageconfirm = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
			String message1 = messageconfirm.getText();
			int index = message1.indexOf('×');// Find the index of '×'
			String ActualOutput = message1.substring(index + 1).trim();
			System.out.println(ActualOutput);
			String message1expected = "Charge Rule Added successfully! : Charging RuleInfo creation Success";
			Assert.assertTrue(ActualOutput.contains(message1expected), "Test mismatch");
		}
		
		//code for policy definition creation
		@Test(priority = 11)
		public void policyDefinition_creation() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// locator for site map
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[3]/a")).click();//locator for policy
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='policyDefButton']")).click();// locator for policy definition
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsPDDiv\"]/div/span[1]/i")).click();//locator for add new PD
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"PDName\"]")).sendKeys("GUI_AUTOMATION_DEMO");//locator for poliy definition name field
			Thread.sleep(2000);

			//logic to select QOS policy option in the service dropdown
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"PDService\"]"));
			Select select = new Select(dropdown);
			String optionText = "QOS Policy";
			select.selectByVisibleText(optionText);
			System.out.println("Selected: " + optionText);
			Thread.sleep(2000);

			//logic to select PCRF_Plus_TS option in the timeslot dropdown list
			WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"select2-timeSlot-container\"]"));
			dropdown1.click();
			String optionText1 = "PCRF_Plus_TS";
			WebElement optionElement = driver.findElement(By.xpath("//li[contains(text(), '" + optionText1 + "')]"));
			optionElement.click();
			System.out.println("Selected: " + optionText1);
			Thread.sleep(2000);

			//logic to select GUI_AUTOMATION_DEMO option in charge rule fropdown list
			WebElement dropdownContainer39 = driver.findElement(By.xpath("//*[@id=\"ChargeRuleDiv\"]/span[2]/div/button"));
			dropdownContainer39.click();
			Thread.sleep(3000);
			String chargerule = "GUI_AUTOMATION_DEMO";
			driver.findElement(By.xpath("//*[@id=\"ChargeRuleDiv\"]/span[2]/div/ul/li[59]/a/label")).click();
			System.out.println(chargerule);
			WebElement bodyElement = driver.findElement(By.tagName("body"));
			bodyElement.click();
			Thread.sleep(2000);

			// logic to select base option in product type drop down
			WebElement dropdown3 = driver.findElement(By.xpath("//*[@id=\"baseProd\"]"));
			Select select3 = new Select(dropdown3);
			String optionText3 = "Base";
			select3.selectByVisibleText(optionText3);
			System.out.println("Selected: " + optionText3);
			Thread.sleep(2000);

			//logic to select active option in status field
			WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"select2-ruleStatus-container\"]"));
			dropdown2.click();
			String optionText2 = "Active";
			By optionLocator = By.xpath("//li[@class='select2-results__option' and text()='" + optionText2 + "']");
			WebElement optionElement2 = driver.findElement(optionLocator);
			optionElement2.click();
			System.out.println("Selected: " + optionText2);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"divAddPDMain\"]/div[3]/div[1]/button")).click();//locator for add button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(2000);

			//logic to verify new policy definition is created or not and cross verifying with expected output using assertion concept
			WebElement messageconfirm = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
			String message1 = messageconfirm.getText();
			int index = message1.indexOf('×');// Find the index of '×'
			String ActualOutput = message1.substring(index + 1).trim();
			System.out.println(ActualOutput);
			String message1expected = "Policy creation Success";
			Assert.assertTrue(ActualOutput.contains(message1expected), "Test mismatch");
			Thread.sleep(3000);
		}
		
		//	//code for SABB creation
		@Test(priority = 12)
		public void SABB_creation() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// locator for site map
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[2]/a")).click();//locator for service attribute
			Thread.sleep(2000);
			driver.findElement(By.xpath("//i[@class='fa tss-add']")).click();//locator to add new SABB
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"sabbName\"]")).sendKeys("GUI_AUTOMATION_DEMO");//locator for SABB NAME

			//  logic to select QOS policy option in Service dropdown
			driver.findElement(By.xpath("//*[@id=\"serviceSB\"]")).click();
			List<WebElement> Options1 = driver.findElements(By.xpath("//div[@class='row']//option[4]"));
			Thread.sleep(2000);
			String option11 = "QOS Policy";
			Options1.get(0).click(); 
			System.out.println(" selected: " + option11);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"descCfgTA\"]")).sendKeys("GUI_AUTOMATION");//locator for Description

			// logic to clicking addruleset 5 times
			for (int i = 0; i < 4; i++) {
				driver.findElement(By.xpath("//*[@id=\"addGroup_G0\"]")).click();
				Thread.sleep(1000);
			}

			// addruleset1	
			// attribute type11
			WebElement dropdowngroup1 =	driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G1_R1\"]"));//locator for attribute type in addruleset1
			Thread.sleep(2000);
			List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G1_R1\"]/option[4]"));//locator to select grouped option
			Thread.sleep(1000);
			String option22 = "Grouped";
			Options2.get(0).click(); 
			System.out.println(" selected: " + option22);
			Thread.sleep(1000);
			
			WebElement dropdown1 = driver.findElement(By.id("groupedSB_G0_G1_R1"));
			Thread.sleep(1000);
			Select select1 = new Select(dropdown1);
			select1.selectByIndex(7);//selecting sy option using indexing

			// add rule button
			driver.findElement(By.xpath("//*[@id=\"addRule_G0_G1_G1\"]")).click();
			//] and button
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G1_G1\"]")).click();
		

			// ATTRIBUTE TYPE12
			driver.findElement(By.xpath(" //*[@id=\"categorySB_G0_G1_G1_R1\"]")).click();//locator for second attribute type in addruleset1
			Thread.sleep(1000);
			List<WebElement> Options22 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G1_G1_R1\"]/option"));//locator to select grouped option
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
			select3.selectByVisibleText("IN");//to select IN
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
			select11.selectByVisibleText("IN");//to select IN
			Thread.sleep(1000);

			WebElement dropdownContainer1 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G1_G1_R2\"]/span/div/button"));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownContainer1);
			new Actions(driver).moveToElement(dropdownContainer1).click().perform();
			String kotapack11 = "PC1 (PC1)";// selecting PC1 PC1 option using action class
			WebElement optionToSelect23 = driver
					.findElement(By.xpath("//*[@id=\"enum_G0_G1_G1_R2\"]/span/div/ul/li[4]/a/label"));
			Actions actions55 = new Actions(driver);
			actions55.moveToElement(optionToSelect23).click().build().perform();

			//  logic to select GUI_AUTOMATION_DEMO  analysed category(true)
			driver.findElement(By.id("select2-categoryVal_1-container")).click();
			String kotapack = "GUI_AUTOMATION_DEMO"; //select option
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

			
			// 2nd addruleset
			// ATTRIBUTE TYPE21
			WebElement dropdowngroup2 =driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G2_R1\"]"));
			Thread.sleep(1000);
			List<WebElement> Options71 = driver.findElements(By.xpath("//*[@id=\"categorySB_G0_G2_R1\"]/option[4]"));
			Thread.sleep(1000);
			String option71 = "Grouped";
			Options71.get(0).click();
			System.out.println(" selected: " + option71);
			Thread.sleep(1000);

			WebElement dropdown72 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G2_R1\"]"));
			Thread.sleep(2000);
			Select select72 = new Select(dropdown72);
			select72.selectByIndex(7);// to select sy option by using indexing
			Thread.sleep(1000);

			// add rule
			driver.findElement(By.xpath("//*[@id=\"addRule_G0_G2_G1\"]")).click();// add rule
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G2_G1\"]")).click();//and button
			
			WebElement dropdown74 = driver.findElement(By.xpath("//*[@id=\"groupedSB_G0_G2_G1_R1\"]"));
			Thread.sleep(2000);
			Select select74 = new Select(dropdown74);
			select74.selectByIndex(1);// to select Policy-Counter-Status
			Thread.sleep(1000);

			WebElement dropdown75 = driver.findElement(By.xpath(" //*[@id=\"enumOpSB_G0_G2_G1_R1\"]"));
			Thread.sleep(1000);
			Select select75 = new Select(dropdown75);
			select75.selectByVisibleText("IN");//to select IN
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
			select78.selectByVisibleText("IN");//to select IN
			Thread.sleep(1000);

			WebElement dropdownContainer79 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G2_G1_R2\"]/span/div/button"));
			dropdownContainer79.click();
			Thread.sleep(1000);
			String kotapack79 = "PC1 (PC1)";//select PC1 (PC1)
			WebElement optionToSelect79 = driver
					.findElement(By.xpath("//*[@id=\"enum_G0_G2_G1_R2\"]/span/div/ul/li[4]/a/label"));
			Actions actions79 = new Actions(driver);
			actions79.moveToElement(optionToSelect79).click().build().perform();

			// analysed category(true)21
			driver.findElement(By.id("select2-categoryVal_2-container")).click();
			String kotapack80 = "GUI_AUTOMATION_DEMO";
			WebElement optionToSelect80 = driver.findElement(By.xpath("//li[contains(text(), '" + kotapack80 + "')]"));
			Actions actions80 = new Actions(driver);
			actions80.moveToElement(optionToSelect80).click().build().perform();

			// analysed output22
			WebElement dropdownContainer80 = driver.findElement(By.id("select2-outputVal_2-container"));
			dropdownContainer80.click();
			// Locate and click on the specific option ("Threshold1")
			WebElement normal1Option80 = driver.findElement(By.xpath("//li[text()='Threshold1']"));
			normal1Option80.click();
			Thread.sleep(2000);

			// 3rd add rulset3
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
			select82.selectByIndex(7);//selecting sy option using indexing
			Thread.sleep(1000);

			// add rule
			driver.findElement(By.xpath("//*[@id=\"addRule_G0_G3_G1\"]")).click();// add rule
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G3_G1\"]")).click();

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
			select88.selectByVisibleText("IN");//to select IN option using visible text
			Thread.sleep(1000);

			WebElement dropdownContainer89 = driver.findElement(By.xpath("//*[@id=\"enum_G0_G3_G1_R2\"]/span/div/button"));
			dropdownContainer89.click();
			Thread.sleep(1000);
			String kotapack89 = "PC1 (PC1)";// selecting PC1 PC1 option using action class
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

			// 4th addruleset4
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
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G4_G1\"]")).click();
			
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

			// 5th addruleset5
			// ATTRIBUTE TYPE51
			WebElement dropdowngroup5 =	driver.findElement(By.xpath("//*[@id=\"categorySB_G0_G5_R1\"]"));
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
			//driver.findElement(By.xpath("//*[@id=\"and_G0_G5_G1\"]")).click();

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
			driver.findElement(By.xpath("//*[@id=\"enum_G0_G5_G1_R1\"]/span/div/ul/li[7]")).click();//to select threshold exhaust(5)
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
			
			
			//ADD BUTTON
			driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(1000);
			
			//logic to verify new policy definition is created or not and cross verifying with expected output using assertion concept
			WebElement messageconfirm = driver.findElement(By.xpath("//*[@id=\"dispMsgConf\"]/div/div"));
			 String message1 = messageconfirm.getText(); 
			 int index = message1.indexOf('×');// Find the index of '×'
				String ActualOutput = message1.substring(index + 1).trim();
				System.out.println(ActualOutput);
				
				String message1expected = "SABB Configuration \"GUI_AUTOMATION_DEMO\" added Successfully !!!";
				Assert.assertTrue(ActualOutput.contains(message1expected), "Test mismatch");
		}
		
		
//		@Test(priority = 13)
//		public void policytree_creation() throws InterruptedException {
//			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[3]/a"))
//					.click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"tableBtnsCTDiv\"]/div/span[1]/i")).click();
//			Thread.sleep(2000);
	//
//			driver.findElement(By.xpath("//*[@id=\"chrgTreeName\"]")).sendKeys("GUI_AUTOMATION");// policy tree(pt) name
//			
//			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"chrgTreeServSB\"]"));// Service dropdown
//			Thread.sleep(1000);
//			Select select = new Select(dropdown);
//			String optionText = "QOS Policy";
//			select.selectByVisibleText(optionText);
//			System.out.println("Selected: " + optionText);
//			Thread.sleep(2000);
	//
//			driver.findElement(By.xpath("//*[@id=\"chrgTreeDescTA\"]")).sendKeys("GUI_AUTOMATION");// description
//			Thread.sleep(2000);
	//
//			// drag and drop operation for SABB
//			WebElement source = driver.findElement(By.xpath("//*[@id=\"linkSA-1097\"]/i"));
//			source.click();
//			WebElement target = driver.findElement(By.id("Dummy_anchor"));
//			target.click();
//			Thread.sleep(2000);
//			Actions action = new Actions(driver);
//			//action.clickAndHold(source).moveToElement(target).release().build().perform();
//			action.moveToElement(source);
//			action.clickAndHold();
//			Thread.sleep(2000);
//			action.moveToElement(target);
//			Thread.sleep(2000);
//			action.release().build().perform();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"dragTemp\"]")).click();
//			Thread.sleep(3000);
	//
//			// Click on the "RdTab" element to initiate the drag-and-drop operation
//			driver.findElement(By.xpath("//*[@id='RdTab']")).click();
//			// Thread.sleep(3000);
	//
//			// for normal1
//			WebElement pd1 = driver.findElement(By.xpath("//*[@id=\"linkRA-769\"]"));
//			pd1.click();
//			Thread.sleep(2000);
//			// Locate the target element (normal1)
//			WebElement normal1 = driver.findElement(By.xpath(
//					"/html/body/div[2]/div[3]/div[2]/div/section[2]/div[3]/div/form/div/div[1]/div[2]/div[5]/div[1]/div[2]/div[3]/ul/li/ul/li/ul/li[2]/a/label"));
//			normal1.click();
//			Actions action1 = new Actions(driver);
//		//action1.clickAndHold(pd1).moveToElement(normal1).release().build().perform();
//			action1.moveToElement(pd1);
//			action1.clickAndHold();
//			Thread.sleep(2000);
//			action1.moveToElement(normal1);
//			Thread.sleep(2000);
//			action1.release().build().perform();
//			Thread.sleep(4000);
//			driver.findElement(By.xpath("//*[@id='dragTemp']")).click();
//			Thread.sleep(3000);
	//
//			// for threshold1
//			WebElement pd2 = driver.findElement(By.xpath("//*[@id=\"linkRA-769\"]"));
//			pd2.click();
//			Thread.sleep(2000);
//			WebElement threshold1 = driver.findElement(By.xpath(
//					"/html/body/div[2]/div[3]/div[2]/div/section[2]/div[3]/div/form/div/div[1]/div[2]/div[5]/div[1]/div[2]/div[3]/ul/li/ul/li/ul/li[3]/a/label"));
//			threshold1.click();
//			// Create an object of Actions class
//			Actions action2 = new Actions(driver);
//			//action2.clickAndHold(pd2).moveToElement(threshold1).release().build().perform();
//			action2.moveToElement(pd2);
//			action2.clickAndHold();
//			action2.moveToElement(threshold1);
//			action2.release().build().perform();
//			Thread.sleep(4000);
//			driver.findElement(By.xpath("//*[@id='dragTemp']")).click();
//			Thread.sleep(3000);
	//
//			// for threshold22
//			WebElement pd3 = driver.findElement(By.xpath("//*[@id=\"linkRA-769\"]"));
//			pd3.click();
//			Thread.sleep(2000);
//			WebElement threshold22 = driver.findElement(By.xpath(
//					"/html/body/div[2]/div[3]/div[2]/div/section[2]/div[3]/div/form/div/div[1]/div[2]/div[5]/div[1]/div[2]/div[3]/ul/li/ul/li/ul/li[4]/a/label"));
//			threshold22.click();
//			Actions action3 = new Actions(driver);
//			//action3.clickAndHold(pd3).moveToElement(threshold22).release().build().perform();
//			action3.moveToElement(pd3);
//			action3.clickAndHold();
//			action3.moveToElement(threshold22);
//			action3.release().build().perform();
//			Thread.sleep(4000);
//			driver.findElement(By.xpath("//*[@id='dragTemp']")).click();
//			Thread.sleep(3000);
	//
//			// for threshold32
//			WebElement pd4 = driver.findElement(By.xpath("//*[@id=\"linkRA-769\"]"));
//			pd4.click();
//			Thread.sleep(2000);
//			WebElement threshold32 = driver.findElement(By.xpath(
//					"/html/body/div[2]/div[3]/div[2]/div/section[2]/div[3]/div/form/div/div[1]/div[2]/div[5]/div[1]/div[2]/div[3]/ul/li/ul/li/ul/li[5]/a/label"));
//			threshold32.click();
//			Actions action4 = new Actions(driver);
//			//action4.clickAndHold(pd4).moveToElement(threshold32).release().build().perform();
//			action4.moveToElement(pd4);
//			action4.clickAndHold();
//			action4.moveToElement(threshold32);
//			action4.release().build().perform();
//			Thread.sleep(4000);
//			driver.findElement(By.xpath("//*[@id='dragTemp']")).click();
//			Thread.sleep(3000);
	//
//			// for thresholdExhaust1
//			WebElement pd5 = driver.findElement(By.xpath("//*[@id=\"linkRA-769\"]"));
//			pd5.click();
//			Thread.sleep(2000);
//			WebElement thresholdExhaust1 = driver.findElement(By.xpath(
//					"/html/body/div[2]/div[3]/div[2]/div/section[2]/div[3]/div/form/div/div[1]/div[2]/div[5]/div[1]/div[2]/div[3]/ul/li/ul/li/ul/li[6]/a/i"));
//			thresholdExhaust1.click();
//			Actions action5 = new Actions(driver);
//			action5.moveToElement(pd5);
//			action5.clickAndHold();
//			action5.moveToElement(thresholdExhaust1);
//			action5.release().build().perform();
//			Thread.sleep(4000);
//			driver.findElement(By.xpath("//*[@id='dragTemp']")).click();
//			Thread.sleep(3000);
	//
//			// for counterExhaust1
//			WebElement pd6 = driver.findElement(By.xpath("//*[@id=\"linkRA-769\"]"));
//			pd6.click();
//			Thread.sleep(2000);
//			WebElement counterExhaust1 = driver.findElement(By.xpath(
//					"/html/body/div[2]/div[3]/div[2]/div/section[2]/div[3]/div/form/div/div[1]/div[2]/div[5]/div[1]/div[2]/div[3]/ul/li/ul/li/ul/li[7]/a/i"));
//			counterExhaust1.click();
//			Actions action6 = new Actions(driver);
//			action6.moveToElement(pd6);
//			action6.clickAndHold();
//			action6.moveToElement(counterExhaust1);
//			action6	.release().build().perform();
//			Thread.sleep(4000);
//			driver.findElement(By.xpath("//*[@id='dragTemp']")).click();
//			Thread.sleep(3000);
	//
//			
//			//*[@id="SaveButton"]
//			driver.findElement(By.xpath("//*[@id=\"SaveButton\"]")).click();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
	//
//			
//			
//			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgCT\"]/div/div"));
//			 String message2 = messageconfirm1.getText(); 
//			 Thread.sleep(2000);
//			 int index = message2.indexOf('×');// Find the index of '×'
//				String ActualOutput1 = message2.substring(index + 1).trim();
//				System.out.println(ActualOutput1);
//				
//				String message1expected1 = "Policy Tree \"GUI_AUTOMATION\" is added Successfully !!!";
//				Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");
//		}
		
		
		@Test(priority = 14)
		public void product_creation() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[4]/div/div[2]/ul/li[4]/a/b")).click();//product
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tableBtnsPDDiv\"]/div/span[1]/i")).click();//add button
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"prodName\"]")).sendKeys("GUI_AUTOMATION_DEMO");
			
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"PDService\"]"));// Service dropdown
			Thread.sleep(2000);
			Select select = new Select(dropdown);
			String optionText = "QOS Policy";
			select.selectByVisibleText(optionText);
			System.out.println("Selected: " + optionText);
			
			//*[@id="policyTreeDiv"]/span[2]/div/button
			WebElement dropdownContainer39 = driver.findElement(By.xpath("//*[@id=\"policyTreeDiv\"]/span[2]/div/button"));
			dropdownContainer39.click();
			Thread.sleep(3000);
			String policyTree = "GUI_AUTOMATION_DEMO";
			driver.findElement(By.xpath("//*[@id=\"policyTreeDiv\"]/span[2]/div/ul/li[16]/a/label")).click();
			System.out.println(policyTree);
			WebElement bodyElement = driver.findElement(By.tagName("body"));
			bodyElement.click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"descTB\"]")).sendKeys("GUI_AUTOMATION");// description
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[normalize-space()='ADD']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(2000);
			
			WebElement messageconfirm1 = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
			 String message2 = messageconfirm1.getText(); 
			 Thread.sleep(2000);
			 int index = message2.indexOf('×');// Find the index of '×'
				String ActualOutput1 = message2.substring(index + 1).trim();
				System.out.println(ActualOutput1);
				
				String message1expected1 = "Product GUI_AUTOMATION_DEMO added Successfully!";
				Assert.assertTrue(ActualOutput1.contains(message1expected1), "Test mismatch");
		}
		
		@Test(priority = 15)
		public void subscriber_creation() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[5]/div/div[2]/ul/li[3]/a/b")).click();//sub mgmt locator
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"searchCustBox\"]")).sendKeys("24896385265");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"searchIcon\"]")).click();
			Thread.sleep(1000);

			WebElement table = driver.findElement(By.xpath("//*[@id=\"viewSubsTable\"]/tbody/tr/td"));
			String actualOutput = table.getText();

			if ("No data available in table".equals(actualOutput)) {
				System.out.println(actualOutput);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a/i")).click();
				driver.findElement(
						By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[5]/div/div[2]/ul/li[3]/a/b"))
						.click();
				Thread.sleep(1000);
				// add button
				driver.findElement(By.xpath("//*[@id=\"tableBtnsSubsDiv\"]/div/span[1]/i")).click();

				// *************************subscriberprofile**********************************************//

				driver.findElement(By.xpath("//*[@id=\"Pcrf_SubsProfileRowDiv\"]/div[1]/div[1]/span[2]/span[1]/span")).click();

				// service
				List<WebElement> Options1 = driver.findElements(By.xpath("//*[@id=\"select2-serviceSB-results\"]"));
				Thread.sleep(3000);
				if (!Options1.isEmpty()) {
				    String option11 = "Mobile";
				    Options1.get(0).click(); // Click on the first option
				    System.out.println(" selected: " + option11);
				} else {
				    System.out.println("Options1 list is empty. Cannot select an option.");
				}


				driver.findElement(By.xpath("//*[@id=\"serviceNum\"]")).sendKeys("96385265");
				// subscription type
				driver.findElement(By.xpath("//*[@id=\"select2-subsTypeSB-container\"]")).click();
				List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"select2-subsTypeSB-results\"]"));
				String option22 = "Prepaid";
				Options2.get(0).click(); 
				System.out.println(" selected: " + option22);

				driver.findElement(By.xpath("//*[@id=\"language\"]")).sendKeys("hindi");
				driver.findElement(By.xpath("//*[@id=\"imeiNum\"]")).sendKeys("123456789111111");
				driver.findElement(By.xpath("//*[@id=\"homezone\"]")).sendKeys("india");
				driver.findElement(By.xpath("//*[@id=\"cosId\"]")).sendKeys("2");

				// connection profile
				driver.findElement(By.xpath("//*[@id=\"select2-connProfile-container\"]")).click();
				List<WebElement> Options3 = driver.findElements(By.xpath("//*[@id=\"select2-connProfile-results\"]"));
				String option33 = "profile_two";
				Options3.get(0).click(); 
				System.out.println(" selected: " + option33);

				// status
				driver.findElement(By.xpath("//*[@id=\"select2-status-container\"]")).click();
				List<WebElement> Options4 = driver.findElements(By.xpath("//*[@id=\"select2-status-results\"]"));
				String option44 = "Active";
				Options4.get(0).click(); 
				System.out.println("selected: " + option44);

			
				WebElement checkbox = driver
						.findElement(By.xpath("//*[@id=\"Pcrf_SubsProfileRowDiv\"]/div[3]/div[10]/div/div"));
				if (!checkbox.isSelected()) {
					checkbox.click();
				}

				// add button
				driver.findElement(By.xpath("//*[@id=\"viewSubsHeadDiv\"]")).click();

				// demography details

				driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("tayana");
				driver.findElement(By.xpath("//*[@id=\"middleName\"]")).sendKeys("mobility");
				driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("pcrfplus");
				driver.findElement(By.xpath("//*[@id=\"businessName\"]")).sendKeys("adhjd");

				// GENDER DROPDOWN
				WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"genderSB\"]"));
				Select dropdown = new Select(dropdownElement);
				dropdown.selectByVisibleText("FEMALE");

				driver.findElement(By.xpath("//*[@id=\"occupation\"]")).sendKeys("teacher");
				driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("mgroad");
				driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("trinity ");
				driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("banglore");
				driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("karnataka");
				driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("565654");

				// COUNTRY DROPDOWN
				driver.findElement(By.xpath("//*[@id=\"select2-countrySB-container\"]")).click();
				List<WebElement> Options5 = driver.findElements(By.xpath("//*[@id=\"select2-countrySB-results\"]"));
				String option55 = "Algeria";
				Options5.get(0).click(); // Click on the first option
				System.out.println(" selected: " + option55);

				// nationality DROPDOWN
				driver.findElement(By.xpath("//*[@id=\"select2-nationalitySB-container\"]")).click();
				List<WebElement> Options6 = driver.findElements(By.xpath("//*[@id=\"select2-nationalitySB-results\"]"));
				String option66 = "Angola";
				Options6.get(0).click(); // Click on the first option
				System.out.println(" selected: " + option66);

				driver.findElement(By.xpath("//*[@id=\"contactNum\"]")).sendKeys("12345678");
				driver.findElement(By.xpath("//*[@id=\"altContactNum\"]")).sendKeys("1234579");
				driver.findElement(By.xpath("//*[@id=\"mailId\"]")).sendKeys("user@example.com");
				driver.findElement(By.xpath("//*[@id=\"altMailId\"]")).sendKeys("user12@example.com");
				// driver.findElement(By.xpath("//*[@id=\"extendedInfo\"]")).sendKeys("abcd");

				driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
				Thread.sleep(3000);

				WebElement textElement = driver.findElement(By.xpath("//*[@id=\"dispMsgCust\"]/div/div"));
				String actualOutput1 = textElement.getText();
				int index = actualOutput1.indexOf('×');// Find the index of '×'
				String ActualOutput1 = actualOutput1.substring(index + 1).trim();
				System.out.println(actualOutput1);
				String expectedOutput = "Create Subscriber Profile Success";
				//Assert.assertEquals(actualOutput1.contains(expectedOutput), "Test mismatch");
				Assert.assertTrue(actualOutput1.contains(expectedOutput), "Test mismatch");
			} 
		}
		
		@Test(priority = 16)
		public void Versioning_golive() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[normalize-space()='Configure']")).click();//configure locator in versioning
			Thread.sleep(1000);
			driver.findElement(By.xpath("//i[@title='Go Live']")).click();//go live button in product
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");//sub mgmt locato
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();//confirmation 
			Thread.sleep(90000);
			
			//*[@id="mainDiv"]/div[1]/div/div
			WebElement textElement = driver.findElement(By.xpath("//*[@id=\"mainDiv\"]/div[1]/div/div"));
			String actualOutput1 = textElement.getText();
			int index = actualOutput1.indexOf('×');// Find the index of '×'
			String ActualOutput1 = actualOutput1.substring(index + 1).trim();
			System.out.println(actualOutput1);
			String expectedOutput = "Create Subscriber Profile Success";
			//Assert.assertEquals(actualOutput1.contains(expectedOutput), "Test mismatch");
			Assert.assertTrue(actualOutput1.contains(expectedOutput), "Test mismatch");
			
		}
		
		@Test(priority = 17)
		public void subscriber_pakage_provisioning() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a")).click();// sitemap
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[5]/div/div[2]/ul/li[3]/a/b")).click();//sub mgmt locator
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"searchCustBox\"]")).sendKeys("24896385265");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"searchIcon\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[normalize-space()='24896385265']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[normalize-space()='Prov/Deprov']")).click();
			Thread.sleep(1000);
			//
			driver.findElement(By.xpath("//*[@id=\"select2-prov-container\"]")).click();
			List<WebElement> Options4 = driver.findElements(By.xpath("//*[@id=\"select2-prov-results\"]"));
			String option44 = "Provisioning";
			Options4.get(0).click(); 
			System.out.println("selected: " + option44);
			
			
			driver.findElement(By.xpath("//*[@id=\"select2-product-container\"]")).click();
			List<WebElement> Options2 = driver.findElements(By.xpath("//*[@id=\"select2-product-results\"]"));
			String option22 = "GUI_AUTOMATION_DEMO(Base)";
			Options2.get(0).click(); 
			System.out.println("selected: " + option22);
			
		
			driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(1000);
			
			// Locate the WebElement using XPath
			WebElement textElement = driver.findElement(By.xpath("//*[@id=\"dispMsgPD\"]/div/div"));
			// Get the text from the WebElement
			String actualOutput1 = textElement.getText();
			// Remove unwanted characters (in this case, '×')
			actualOutput1 = actualOutput1.replace("×", "").trim();
			// Print the actual output
			System.out.println("Actual Output: " + actualOutput1);
			// Print the length of actual output
			System.out.println("Actual Output Length: " + actualOutput1.length());
			// Define the expected output
			String expectedOutput = "prodList.size PackageId:1 UpdatedPackId:1 PolicyId:224 UpdatedUpdated Successfully";
			// Print the expected output
			System.out.println("Expected Output: " + expectedOutput);
			// Print the length of expected output
			System.out.println("Expected Output Length: " + expectedOutput.length());
			// Assert that the trimmed actual output contains the trimmed expected output
			Assert.assertTrue(actualOutput1.trim().contains(expectedOutput.trim()), "Test mismatch");

		}
		
		@Test(dataProvider = "test",priority =18)
		public void trackermob(int j) throws InterruptedException, IOException {
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li/a/i")).click();//site map
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/section[2]/div[2]/div/div/div[5]/div/div[2]/ul/li[2]/a/b"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"searchCustBox\"]")).sendKeys("24896385265");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"searchIcon\"]")).click();
		
			driver.findElement(By.xpath("//td[@class='sorting_1']")).click();
			Thread.sleep(3000);

			// subscriber details
			driver.findElement(By.xpath("//div[@id='viewSubsDetHeadDiv']")).click();
			Thread.sleep(5000);
			WebElement subdetails = driver.findElement(By.xpath("//div[@id='subsDetDiv']"));
			String actualOutput = subdetails.getText();
			System.out.println(actualOutput);
			System.out.println();

			// package details
			driver.findElement(By.xpath("//*[@id=\"viewPackageDetHeadDiv\"]")).click();
			WebElement table = driver.findElement(By.xpath("//table[@id='viewPackTable']"));
			WebElement dataRow = table.findElement(By.xpath("//*[@id=\"viewPackTable\"]/tbody/tr"));
			
			driver.findElement(By.xpath("//a[normalize-space()='BasePack(1)']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"policyViewModal\"]/div/div/div[3]/button")).click();
			Thread.sleep(3000);
//			List<WebElement> cells = dataRow.findElements(By.tagName("td"));
	//
//			String TimeStamp1 = cells.get(0).getText();
//			System.out.println(TimeStamp1);
//			String SessionId1 = cells.get(1).getText();
//			System.out.println(SessionId1);
//			String link = cells.get(2).getText();
//			System.out.println(link);
//			System.out.println();

			
			// Online details
			WebElement onlinedetails = driver.findElement(By.xpath("//*[@id=\"viewOnlineDetHeadDiv\"]"));
			onlinedetails.click();
			Thread.sleep(3000);
			
			
			// PGW Sessions
			//WebElement table1 = driver.findElement(By.xpath("//table[@id='pgwTable']"));
			//WebElement dataRow1 = table1.findElement(By.xpath("//*[@id=\"pgwTable\"]/tbody/tr"));
//			WebElement cell12 = driver.findElement(By.xpath("//*[@id=\"pgwTable\"]/tbody/tr/td"));
//			String cellText12 = cell12.getText();
//			System.out.println(cellText12);
//			List<WebElement> cells1 = dataRow1.findElements(By.tagName("td"));
//			String TimeStamp = cells1.get(0).getText();
//			System.out.println(TimeStamp);
//			String SessionId = cells1.get(1).getText();
//			System.out.println(SessionId);
//			String link1 = cells1.get(2).getText();
//			System.out.println(link1);
//			Thread.sleep(2000);
			
			WebElement table1 = driver.findElement(By.xpath("//table[@id='pgwTable']"));
			WebElement dataRow1 = table1.findElement(By.xpath("//*[@id=\"pgwTable\"]/tbody/tr"));
			WebElement cell21 = driver.findElement(By.xpath("//*[@id=\"pgwTable\"]/tbody/tr/td"));
			String cellText121 = cell21.getText();
			System.out.println(cellText121);//to print no pgw sessions are available
			Thread.sleep(3000);
			
			
			// tdf sessions
			//WebElement table2 = driver.findElement(By.xpath("//table[@id='tdftable']"));
			//WebElement dataRow2 = table1.findElement(By.xpath("//*[@id=\"tdftable\"]/tbody/tr"));
//			WebElement cell12 = driver.findElement(By.xpath("//*[@id=\"pgwTable\"]/tbody/tr/td"));
//			String cellText12 = cell12.getText();
//			System.out.println(cellText12);
//			List<WebElement> cells1 = dataRow1.findElements(By.tagName("td"));
//			String TimeStamp = cells1.get(0).getText();
//			System.out.println(TimeStamp);
//			String SessionId = cells1.get(1).getText();
//			System.out.println(SessionId);
//			String link1 = cells1.get(2).getText();
//			System.out.println(link1);
//			Thread.sleep(2000);
			
			WebElement table2 = driver.findElement(By.xpath("//table[@id='tdftable']"));
			WebElement dataRow2 = table1.findElement(By.xpath("//*[@id=\"tdftable\"]/tbody/tr"));
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
		

	}


