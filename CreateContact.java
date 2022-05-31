package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Create Contact
		 *  
		 * 7. Enter FirstName Field Using id Locator
		 * 
		 * 8. Enter LastName Field Using id Locator
		 * 
		 * 9. Enter FirstName(Local) Field Using id Locator
		 * 
		 * 10. Enter LastName(Local) Field Using id Locator
		 * 
		 * 11. Enter Department Field Using any Locator of Your Choice
		 * 
		 * 12. Enter Description Field Using any Locator of your choice 
		 * 
		 * 13. Enter your email in the E-mail address Field using the locator of your choice
		 * 
		 * 14. Select State/Province as NewYork Using Visible Text
		 * 
		 * 15. Click on Create Contact
		 * 
		 * 16. Click on edit button 
		 * 
		 * 17. Clear the Description Field using .clear
		 * 
		 * 18. Fill ImportantNote Field with Any text
		 * 
		 * 19. Click on update button using Xpath locator
		 * 
		 * 20. Get the Title of Resulting Page.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//5. Click on contacts Button
        driver.findElement(By.linkText("Contacts")).click();
        
        //6. Click on Create Contact
        driver.findElement(By.linkText("Create Contact")).click();
        
		// 7. Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Revathy");
		
		// 8. Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Srinivas");

		// 9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Revathy");

		// 10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Srinivas");

		// 11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Computer Science");

		// 12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys("Contact for Revathy");

		// 13. Enter your email in the E-mail address Field using the locator of your
		// choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("revathy@test.com");

		// 14. Select State/Province as NewYork Using Visible Text
		Select province = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		province.selectByVisibleText("New York");

		// 15. Click on Create Contact
		driver.findElement(By.name("submitButton")).click();    
		
		// 16. Click on edit button
		driver.findElement(By.linkText("Edit")).click();

		// 17. Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();

		// 18. Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("updating improtant notes");

		// 19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		// 20. Get the Title of Resulting Page
		System.out.println(driver.getTitle());

	}

}
