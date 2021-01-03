package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class TestCase05 extends Utility {

	public static void main(String[] args) {
		//Launch & Login
		launch_Home();
		login();
		
		//Click on User Menu
		waitExplicitly(10, driver.findElement(By.xpath("//div[@id='userNavButton']")));
		driver.findElement(By.xpath("//div[@id='userNavButton']")).click();	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		System.out.println("Clicked on User Menu Dropdown.");
		//quitBrowser();

	}

}
