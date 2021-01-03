package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class TestCase33 extends Utility {

	public static void main(String[] args) {
		
		//launch & login
				launch_Home();
				login();
				
		
		//Click on the FirstName LastName link in the home page
		//1. 'User:FirstName LastName' page should be displayed. 
		//2. This page should be same as the 'My Profile' page.
				
				waitExplicitly(20, driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a")));
				driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a")).click();
				
				System.out.println("User Name Page is displayed from Home Page");
				
				//quitBrowser();

	}

}
