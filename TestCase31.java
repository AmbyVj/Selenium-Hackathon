package TestCases;

import org.openqa.selenium.By;

public class TestCase31 extends Utility {

	public static void main(String[] args) {
		
				//Launch & Login
				launch_Home();
				login();
				
				driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
				driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
				
				//Create new view ->View Name : ABCD & Unique Name : EFGH & Cancel it
				driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
				waitExplicitly(3, driver.findElement(By.id("fname")));
		        System.out.println("Clicked 'Create New View'");
		        driver.findElement(By.id("fname")).clear();
		        driver.findElement(By.id("fname")).sendKeys("ABCD");
		        
		        driver.findElement(By.id("devname")).click();
		        waitExplicitly(10, driver.findElement(By.id("devname")));
		        
		        driver.findElement(By.id("devname")).clear();
		        driver.findElement(By.id("devname")).sendKeys("EFGH");
		        System.out.println("Entered ViewName & Unique ViewName.");
		        
		        driver.findElement(By.xpath("//input[@value='Cancel']")).click();
		        System.out.println("Details are cancelled");
		        
		        quitBrowser();
	}

}
