package TestCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase21 extends Utility {

	public static void main(String[] args) throws Exception {
		
		//Launch & login to home page
		launch_Home();
		login();
				
		//open Leads Tab;
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Navigated to Leads Home Page");
		
		//Click on view drop down
		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		System.out.println("\n***'View' drop down list from Leads Home page***");
		
		ArrayList<WebElement> viewLeads = new ArrayList<>(driver.findElements(By.xpath("//select[@id='fcf']")));
		for(int count=0; count<viewLeads.size();count++) 
			System.out.println(viewLeads.get(count).getText());
		
		quitBrowser();
		
				
		
	}

}
