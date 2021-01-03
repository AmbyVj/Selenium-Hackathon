package TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.support.ui.Select;

public class TestCase14 extends Utility {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		//Launch & Login
		launch_Home();
		login();
		//Click on Accounts Tab; Select last activity >30 days under Reports section;
		//Choose Date field, start & end date & get all Records;
		//Save & Run Report with Report Name & Unique Name 
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
		Thread.sleep(1000);
		System.out.println("Clicked on Accounts Tab; Select last activity >30 days under Reports section;");
		//driver.switchTo().frame(driver.findElement(By.xpath("//button[contains(text(),'No Thanks')]")));
		//driver.findElement(By.xpath("//button[contains(text(),'No Thanks')]")).click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		waitExplicitly(20,driver.findElement(By.id("ext-gen20")));
		driver.findElement(By.id("ext-gen20")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Select fromDate =  new Select(driver.findElement(By.xpath("//*[@id='ext-gen152']")));
		driver.findElement(By.xpath("//*[@id='ext-gen152']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Today')]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("ext-gen154")).click();
		//driver.findElement(By.xpath("//*[@id='ext-gen303']")).click();
		driver.findElement(By.xpath("//*[@id='ext-comp-1045']")).clear();
		driver.findElement(By.xpath("//*[@id='ext-comp-1045']")).sendKeys("1/8/2021");
		Thread.sleep(2000);
		Robot rob =new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Chosen Date field, start & end date & got all the Records;");
		
		driver.findElement(By.id("ext-gen49")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Actions action =  new Actions(driver);
		action.moveToElement(driver.findElement(By.id("ext-gen49"))).perform();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	    driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']")).sendKeys("Report1");
	    driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).click();
	    //driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).sendKeys("AA");
	    driver.findElement(By.xpath("//div[@class='x-form-element']/textarea")).sendKeys("Report run");
	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//div[@class='x-tool x-tool-close']")).click();
//		
//		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		 action.moveToElement(driver.findElement(By.xpath("//div[@class='x-window-footer x-panel-btns']"))).perform();
//	
//		 driver.findElement(By.xpath("//*[@id='dlgSaveAndRun']/tbody")).click();		
		 driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]")).click(); 
			
//	     String str = "//div[@id='ext-comp-1070']/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button";
//	     driver.findElement(By.xpath(str));
//		 driver.findElement(By.xpath("//*[@id='dlgSaveAndRun']/tbody/tr[2]/td[2]/em/button")).click();
//		 driver.findElement(By.xpath("//*[@class=' x-btn-text']")).click();
	    
	    
		System.out.println("Saved & Run Report with Report Name & Unique Name ");
		
		quitBrowser();
		
		
	}

}
