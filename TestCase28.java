package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestCase28 extends Utility {

	public static void main(String[] args) throws Exception {
		//Launch & Login
		launch_Home();
		login();
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
        Thread.sleep(1000);
		viewDropDown("My Contacts");
	    
		System.out.println("'My Contacts' are listed");
		
		//quitBrowser();
		

	}

}
