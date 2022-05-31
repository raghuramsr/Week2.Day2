package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*http://leaftaps.com/opentaps/control/main

* 1	Launch the browser
* 2	Enter the username
* 3	Enter the password
* 4	Click Login
* 5	Click crm/sfa link
* 6	Click Leads link
* 7	Click Find leads
* 8	Enter first name
* 9	Click Find leads button
* 10 Click on first resulting lead
* 11 Verify title of the page
* 12 Click Edit
* 13 Change the company name
* 14 Click Update
* 15 Confirm the changed name appears
* 16 Close the browser (Do not log out)
*/

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");

		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// 6 Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		// 7 Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		// 8 Enter first name
		driver.findElement(By.xpath("//*[@id=\"ext-gen248\"]")).sendKeys("viji");

		// 9 Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);

		// 10 Click on first resulting lead
		WebElement eleLeadId = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		
		eleLeadId.click();

		// 11 Verify title of the page
		System.out.println("Title: " + driver.getTitle());
		if (driver.getTitle().contains("View Lead")) {
			System.out.println("Title Matches ");
		} else {
			System.out.println("Title Doesnt Matches ");
		}

		// 12 Click Edit
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']//a[@class='subMenuButton'][3]")).click();

		// 13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf");

		// 14 Click Update
		driver.findElement(By.name("submitButton")).click();

		// 15 Confirm the changed name appears
		String Company = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (Company.contains("TestLeaf")) {
			System.out.println("TestLead Company Name Verified");
		} else {
			System.out.println("TestLead Company Name Not Changed");
		}

		// 16 Close the browser (Do not log out)
		driver.close();

	}
	
	//output:
//	Title: View Lead | opentaps CRM
//	Title Matches 
//	TestLead Company Name Verified


}
