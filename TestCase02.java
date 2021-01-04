package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase02 extends Utility{

	public static void main(String[] args) throws Exception {
		
		// Launch URL
		launch_Home();
		
		//Click Login with correct user name & password;
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		login.click();
		loadingPropertiesFile();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.clear();
		userName.sendKeys(System.getProperty("userName"));
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys(System.getProperty("password"));
		
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Waiting for home page visibility;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"))));
		System.out.println("Logged in with correct username & password.");
		
		driver.close();
		
	}

}
