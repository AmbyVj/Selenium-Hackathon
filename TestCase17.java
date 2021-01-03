package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class TestCase17 extends Utility {

	public static void main(String[] args) {
		//Launch & Login
		launch_Home();
		login();
		//Click on Opportunities & its pipeline Link;
		
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Listed the 'Opportunity Pipeline'.");
		
		//driver.close();
	}

}
