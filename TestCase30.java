package TestCases;

import org.openqa.selenium.By;

public class TestCase30 extends Utility {

	public static void main(String[] args) throws Exception {
		//Launch & Login
		launch_Home();
		login();
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		
		//click on 'Create New View' & Enter 'Unique name'(EFGH) & save
		newUniqueViewName("EFGH");
		
		saveClick();
		
		//quitBrowser();
	}

}
