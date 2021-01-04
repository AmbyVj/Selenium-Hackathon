package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase12 extends Utility{

	public static void main(String[] args) throws Exception {
		//Launch & Login
		launch_Home();
		login();
		//Click on Accounts Tab; In Edit View, specify the filter Criteria & save
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("Clicked Accounts Tab;");
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		
		waitExplicitly(5, driver.findElement(By.xpath("//*[@id='fcf']")));
		WebElement account = driver.findElement(By.xpath("//*[@id='fcf']"));
		Select sel = new Select(account);
		Thread.sleep(2000);
		sel.selectByIndex(0);
		Thread.sleep(2000);
		////*[@id='filter_element']/div/span/span[2]/a[1]
		driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[2]/a[1]")).click();
		System.out.println("Now in Edit View;");
		Thread.sleep(2000);
		
        
        driver.findElement(By.id("fname")).clear();
        driver.findElement(By.id("devname")).clear();
        driver.findElement(By.id("fname")).sendKeys(System.getProperty("AccountView"));       
        driver.findElement(By.id("devname")).click();
        
        Thread.sleep(1000);       
        Select filter1=new Select(driver.findElement(By.xpath("//*[@id=\"fcol1\"]")));
        filter1.selectByVisibleText("Account Name");
        
        Select filter2 = new Select(driver.findElement(By.xpath("//*[@id=\"fop1\"]")));
        filter2.selectByVisibleText("contains");
        driver.findElement(By.xpath("//*[@id='fval1']")).clear();
        driver.findElement(By.xpath("//*[@id='fval1']")).sendKeys(System.getProperty("AccFilterText"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value=' Save ']")).click();
        System.out.println("Gave New ViewName  & Selected Filter Criteria(Accounts/contains/a)");
        System.out.println("Saved & New viewname is listed");
        
        //driver.close();


	}

}
