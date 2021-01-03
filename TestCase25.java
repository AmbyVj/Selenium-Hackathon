package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class TestCase25 extends Utility{

	public static void main(String[] args) throws Exception {
		
		//launch & login
		launch_Home();
		login();
		
		//Click on Contact tab
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		System.out.println("Navigated to Contact home page");
		
		//Click on New button
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
		
		//Edit Last name;
		driver.findElement(By.xpath("//*[@id='name_lastcon2']")).sendKeys("Steve");
		
		//Search the Accounts & [Search & get it from new window];
		driver.findElement(By.xpath("//a[@id='con4_lkwgt']/img")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		windowHandles("Anna");
		
		
		System.out.println("Contact Edited with last name.");
		saveClick();

		

	}

}
