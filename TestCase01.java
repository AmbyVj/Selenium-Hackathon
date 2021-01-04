package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase01 extends Utility{

	public static void main(String[] args) throws Exception {
		launch_Home();
		System.out.println("Page is launched successfully");
		//Click login();
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Login')]")));
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		waitExplicitly(20, login);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		login.click();
		//Enter user name & clear password & click login;
		loadingPropertiesFile();
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		waitExplicitly(10, userName);
		userName.clear();
		userName.sendKeys(System.getProperty("userName"));
		System.out.println("Entered user name.");
		
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		System.out.println("Password is Empty!");
		
		
		driver.findElement(By.id("Login")).click();
		System.out.println("Got a error meassage : "+driver.findElement(By.id("error")).getText());
		
		quitBrowser();


	}

	
}
