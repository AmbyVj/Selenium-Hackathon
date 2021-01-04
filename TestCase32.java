package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class TestCase32 extends Utility{

	public static void main(String[] args) throws Exception {
		
		//Launch & Login
		launch_Home();
		login();
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		
		//Click on New button
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
		
		//Edit -Enter(Last Name - Indian, Account Name-Global Media)
		driver.findElement(By.xpath("//*[@id='name_lastcon2']")).sendKeys(System.getProperty("ContactLastName"));
				
		//Search the Accounts & [Search & get it from new window];
		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys(System.getProperty("ContactAccount"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Click on 'save & new' button
		driver.findElement(By.xpath("//input[@value='Save & New']")).click();
		
		System.out.println("Contact edited & saved");
		
		//quitBrowser();

	}

}
