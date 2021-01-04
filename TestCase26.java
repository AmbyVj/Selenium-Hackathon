package TestCases;

import org.openqa.selenium.By;

public class TestCase26 extends Utility{

	public static void main(String[] args) throws Exception {
		
				//launch & login
				launch_Home();
				login();
				
				//Click on Contact tab
				driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
				driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
				System.out.println("Navigated to Contact home page");
				
				//Click on Create new View & give Uique view name & save;
				newUniqueViewName("New ContactView");
				
				saveClick();
				
		       // quitBrowser();
		

	}

}
