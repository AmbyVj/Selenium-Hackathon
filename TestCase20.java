package TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;


public class TestCase20 extends Utility {

	public static void main(String[] args) throws Exception {
		//Launch & login to home page
		launch_Home();
		login();
		
		//open Leads Tab;
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		Thread.sleep(2000);
		Robot rob= new Robot();
		rob.keyPress(KeyEvent.VK_ESCAPE);
		rob.keyRelease(KeyEvent.VK_ESCAPE);
		
		//driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Navigated to Leads Home Page");
		quitBrowser();
	}

	
	
/*
	public static void run reports on specified dates() {
			//Run Reports by choosing the  dates (start date & end date);
	
			//Directly clicking today's date;
			waitExplicitly(20, driver.findElement(By.xpath("//input[@id='sdate']"))); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='lead_summary']/table/tbody/tr[1]/td[2]/span/span/a")).click();
			Thread.sleep(2000);
			
	        driver.findElement(By.xpath("//a[contains(text(),'Today')]")).click();
			
			driver.findElement(By.xpath("//input[@id='edate']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//td[contains(text(),'21')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@id='scope']")).click();
			Select view= new Select(driver.findElement(By.xpath("//select[@id='scope']")));
			view.selectByVisibleText("All leads");
			driver.findElement(By.xpath("//input[@value='Run Report']")).click();
			

		}
*/
	
}
