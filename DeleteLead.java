package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*http://leaftaps.com/opentaps/control/main

Delete Lead:
1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Phone
9	Enter phone number
10	Click find leads button
11	Capture lead ID of First Resulting lead
12	Click First Resulting lead
13	Click Delete
14	Click Find leads
15	Enter captured lead ID
16	Click find leads button
17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
18	Close the browser (Do not log out)
*/

public class DeleteLead {

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

		// 8 Click on Phone
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();

		// 9 Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("310");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("765-3423");

		// 10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);
		// 11 Capture lead ID of First Resulting lead
		WebElement leadIdEle = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));

		String leadId = leadIdEle.getText();
		System.out.println("First Resulting lead ID is : " + leadId);

		// 12 Click First Resulting lead
		leadIdEle.click();

		// 13 Click Delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();

		// 14 Click Find leads
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li/a[text()='Find Leads']")).click();

		// 15 Enter captured lead ID
		driver.findElement(
				By.xpath("(//div[@class='x-form-item x-tab-item']/div/input[@class=' x-form-text x-form-field'])[1]"))
				.sendKeys(leadId);

		// 16 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// 17 Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		String deletedMsg = driver.findElement(By.id("ext-gen437")).getText();

		if (deletedMsg.equalsIgnoreCase("No records to display")) {
			System.out.println("Sucessfully Deleted the Lead ID: " + leadId);
		} else {
			System.out.println("Lead ID not Deleted: Actual Text Found " + deletedMsg);
		}

		// 18 Close the browser (Do not log out)
		driver.close();

	}
	
	//output:
//	First Resulting lead ID is : DemoLeadB
//	Sucessfully Deleted the Lead ID: DemoLeadB

}
