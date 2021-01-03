package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class TestCase11 extends Utility{

	public static void main(String[] args) throws InterruptedException {
        //Launch & Login;
		launch_Home();
		login();
		//Click on Accounts Tab; Click on 'Create New View'
		//Enter ViewName & Unique ViewName & save;
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		
		newUniqueViewName("New AccountView");
		
		saveClick();
		
		//quitBrowser();

	}

}
