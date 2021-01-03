package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase22 extends Utility{

	public static void main(String[] args) throws Exception {
		
				//Launch & login to home page
				launch_Home();
				login();
						
				//open Leads Tab;
				driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
				driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				System.out.println("Navigated to Leads Home Page");
				
				//Click on view drop down;
				driver.findElement(By.xpath("//select[@id='fcf']")).click();
				Select view = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
				view.selectByVisibleText("Today's Leads");
				System.out.println("Selected Today's Leads page");
				Thread.sleep(1000);
				
				view.selectByVisibleText("My Unread Leads");
				System.out.println("My Unread Leads page");
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				logout();
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				loginHere();
				System.out.println("Logged in Again");
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@value=' Go! ']")).click();
				Thread.sleep(2000);
				System.out.println("Clicked 'Go' & entered into default selected page");
				//quitBrowser();
	}
	
	public static void loginHere() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		waitExplicitly(10, driver.findElement(By.xpath("//input[@id='username']")));
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.clear();
		userName.sendKeys("ava@xyz.com");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys("ucandoit123");
		
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
