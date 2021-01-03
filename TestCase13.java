package TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase13 extends Utility{

	public static void main(String[] args) throws Exception {
		//Launch & Login;
		launch_Home();
		login();
		//Click on Accounts Tab  & Merge the first two specified Accounts
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")).click();
		
		waitExplicitly(10, driver.findElement(By.id("srch")));
		driver.findElement(By.id("srch")).sendKeys("Ava");
		
		waitExplicitly(10, driver.findElement(By.xpath("//input[@value='Find Accounts']")));
		driver.findElement(By.xpath("//input[@value='Find Accounts']")).click();
		
		List<WebElement> accountsMerge = driver.findElements(By.xpath("//*[@class=' dataCell  ']"));
		accountsMerge.get(0).click();
		accountsMerge.get(3).click();
		//driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[1]"));
		driver.findElement(By.xpath("//*[@name='goNext']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		System.out.println("Two Accounts names of 'Ava' are merged successfully");
		
		//driver.close();
			
		}
		
		
		

	}
