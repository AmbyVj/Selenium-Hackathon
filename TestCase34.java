package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class TestCase34 extends  Utility{

	public static void main(String[] args) throws Exception {
		//Launch & Login
		launch_Home();
		login();
		System.out.println("Successfully launched SalesForce Application");
		
		//Click on the FirstName LastName link in the home page
		waitExplicitly(20, driver.findElement(By.xpath("//*[@id='home_Tab']/a")));
		driver.findElement(By.xpath("//*[@id='home_Tab']/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a")).click();
		Thread.sleep(2000);
		System.out.println("User Name link is clicked from Home Page");
		
		
		
		//Click on 'Edit Profile' & on 'About' tab; enter the Last Name & saveAll;
		waitExplicitly(10,driver.findElement(By.xpath("//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img")));
		 driver.findElement(By.xpath("//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img")).click();
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 waitExplicitly(10,driver.findElement(By.xpath("//li[@id='aboutTab']")));
		 driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		 driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(System.getProperty("UserLastName"));
		 //driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("T");
		 System.out.println("updated the last name");		  
		 waitExplicitly(10,driver.findElement(By.xpath("//*[@id='TabPanel']/div/div[2]/form/div/input[1]")));	
		 driver.findElement(By.xpath("//*[@id='TabPanel']/div/div[2]/form/div/input[1]")).click();
		 
		 System.out.println("Successfully edited the last name in profile page");
		
		//quitBrowser();

	}

}
