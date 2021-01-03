package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestCase24 extends Utility{

	public static void main(String[] args) throws Exception {
				//Launch & login to home page
				launch_Home();
				login();
						
				//open Leads Tab;
				driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
				driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				System.out.println("Navigated to Leads Home Page");
				
				//click on 'new' button  in Leads Homepage
			    driver.findElement(By.xpath("//input[@value=' New ']")).click();
			    
			    //Enter Last name & Company name & select lead status;
			    waitExplicitly(10,driver.findElement(By.id("name_lastlea2")));
			    driver.findElement(By.id("name_lastlea2")).sendKeys("ABCD");
			    driver.findElement(By.id("lea3")).sendKeys("ABCD");
			    Thread.sleep(1000);

			    saveClick();
			    quitBrowser();
	}

}
