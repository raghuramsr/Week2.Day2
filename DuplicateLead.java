package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*http://leaftaps.com/opentaps/control/main

1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Email
9	Enter Email
10	Click find leads button
11	Capture name of First Resulting lead
12	Click First Resulting lead
13	Click Duplicate Lead
14	Verify the title as 'Duplicate Lead'
15	Click Create Lead
16	Confirm the duplicated lead name is same as captured name
17	Close the browser (Do not log out)

*/

public class DuplicateLead {

	public static void main(String[] args) {
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

		// 8 Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();

		// 9 Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("vvk@gmail.com");

		// 10 Click find leads button

		driver.findElement(By.xpath("//ul[@class='shortcuts']/li/a[text()='Find Leads']")).click();

		// 11 Capture name of First Resulting lead
		WebElement eleFirstLead = driver
				.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		String strFirstLead = eleFirstLead.getText();

		System.out.println("Duplicate Lead: " + strFirstLead);

		// 12 Click First Resulting lead
		eleFirstLead.click();

		// 13 Click Duplicate Lead
		driver.findElement(By.xpath("(//div[@class='frameSectionExtra']/a)[1]")).click();

		// 14 Verify the title as 'Duplicate Lead'
		String strTitle = driver.getTitle();
		if (strTitle.contains("Duplicate Lead")) {
			System.out.println("Matches Title: " + strTitle);
		} else {
			System.out.println("Title FAILED to Match: " + strTitle);
		}

		// 15 Click Create Lead
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		// 16 Confirm the duplicated lead name is same as captured name
		WebElement verifyFirstName = driver.findElement(By.id("viewLead_firstName_sp"));

		if (strFirstLead.equalsIgnoreCase(verifyFirstName.getText())) {
			System.out.println("Duplicate Lead Name Verified " + strFirstLead);
		} else {
			System.out.println("Duplicate Lead Couldnt be Verified " + strFirstLead);
		}

		// 17 Close the browser (Do not log out)
		driver.close();

	}
	
//	output:
//		Duplicate Lead: Hema
//		Matches Title: Duplicate Lead | opentaps CRM
//		Duplicate Lead Name Verified Hema

}
