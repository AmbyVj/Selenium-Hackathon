package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCase10 extends Utility{

	public static void main(String[] args) throws InterruptedException {
		//Launch & Login;
		launch_Home();
		login();
		
		//Click on 'Accounts' & close the popup window;
		//Click on 'New' & give Acc name, Tech Partner type, HIGH priority & save.
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Clicked on Accounts Tab");
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		driver.findElement(By.xpath("//input[@name = 'new']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.id("acc2")).sendKeys("Ava");
		WebElement type = driver.findElement(By.id("acc6"));
		Select sel = new Select(type);
		sel.selectByVisibleText("Technology Partner");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", type);
		WebElement priority = driver.findElement(By.xpath("//*[@id='00N4x00000DXutv']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", priority);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Select sel1 = new Select(priority);
		sel1.selectByVisibleText("High");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", priority);
		driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]")).click();
		System.out.println("Entered New Account (Name,type & priority) & Saved");
		
		//quitBrowser();
		
	}
	

}
