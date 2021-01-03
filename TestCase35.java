package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestCase35 extends Utility {

	public static void main(String[] args) throws InterruptedException {
		
				//Launch & Login
				launch_Home();
				login();
				System.out.println("Successfully launched SalesForce Application");
		        
				//Wait for home page to be appeared & Click on '+'
				waitExplicitly(20, driver.findElement(By.xpath("//*[@id='home_Tab']/a")));
				driver.findElement(By.xpath("//*[@id='AllTab_Tab']/a/img")).click();
				
				
				//Click on 'Customize my tabs';
				waitExplicitly(10,driver.findElement(By.xpath("//input[@value='Customize My Tabs']")));
				driver.findElement(By.xpath("//input[@value='Customize My Tabs']")).click();	
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//Select any tab from the 'Selected Tabs' section and click Remove button
				Select tabToRemove = new Select(driver.findElement(By.xpath("//select[@id='duel_select_1']")));
				//tabToRemove.selectByVisibleText("Chatter");
				tabToRemove.selectByVisibleText("Assets");
				driver.findElement(By.xpath("//a[@id='duel_select_0_left']/img")).click();
				System.out.println("Clicked on 'Customize my tabs' from '+' tab;");
				Thread.sleep(2000);
				//Click on Save & Logout;  launch &login again
				driver.findElement(By.xpath("//input[@value=' Save ']")).click();
				logout();
				System.out.println("Successfully logged out");
				driver.close();
				
				launch_Home();
				login();
				System.out.println("Successfully Launched & logged in again");
				
				quitBrowser();
				
				
				
				

	}

}
