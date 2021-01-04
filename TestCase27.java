package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestCase27 extends Utility {

	public static void main(String[] args) throws Exception {
		
		//launch & login
		launch_Home();
		login();
		
		//Click on Contact tab
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		System.out.println("Navigated to Contact home page");
		
		//Recently Created Contacts from right hand side drop down list
		driver.findElement(By.id("hotlist_mode")).click();
		waitExplicitly(10, driver.findElement(By.id("hotlist_mode")));
		Select sel =  new Select(driver.findElement(By.id("hotlist_mode")));
		sel.selectByVisibleText("Recently Created");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Recent contacts are selected");
		//quitBrowser();

	}

}
