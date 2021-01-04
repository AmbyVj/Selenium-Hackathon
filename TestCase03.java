package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase03 extends Utility  {

	public static void main(String[] args) throws Exception {
		
		//Launch & Login & Check 'Remember Me' checkbox 
		//Then logout to check for the user name to be appeared.
		launch_Home();
		loadingPropertiesFile();
				
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Login')]")));
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		login.click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		waitExplicitly(10, driver.findElement(By.xpath("//input[@id='username']")));
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.clear();
		userName.sendKeys(System.getProperty("userName"));
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys(System.getProperty("password"));
		
		driver.findElement(By.xpath("//input[@id='rememberUn']")).click();
		driver.findElement(By.id("Login")).click();
		waitExplicitly(20, driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a")));
		
		 waitExplicitly(10, driver.findElement(By.xpath("//div[@id='userNavButton']")));
		 driver.findElement(By.xpath("//div[@id='userNavButton']")).click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Logout')]")));
		 driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		 System.out.println("Logged in with 'Remember me' Option & logged out");
		//driver.close();
		

	}

}
