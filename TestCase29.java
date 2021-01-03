package TestCases;

import org.openqa.selenium.By;

public class TestCase29 extends Utility {

	public static void main(String[] args) {
		
				//Launch & Login
				launch_Home();
				login();
				
				driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
				driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
				
				//click on a contact name to get the details
				driver.findElement(By.xpath("//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")).click();
				
				System.out.println("Selected a contact name from recent contacts");
				//quitBrowser();

	}

}
