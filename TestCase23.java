package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestCase23 extends Utility {

	public static void main(String[] args) throws Exception {
		//Launch & login to home page
		launch_Home();
		login();
				
		//open Leads Tab;
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Navigated to Leads Home Page");
		
		//Click on view drop down;
		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		Select view = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		view.selectByVisibleText("Today's Leads");
		Thread.sleep(1000);
		System.out.println("Selected & entered into Today's Leads page");
		//quitBrowser();

	}

}
