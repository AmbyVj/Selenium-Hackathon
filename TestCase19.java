package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestCase19 extends Utility {

	public static void main(String[] args) throws Exception {
		//Launch & Login
		launch_Home();
		login();
		//Click on Opportunities & its pipeline Link;
		
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Select Interval & Include from Quarterly Summary
		//1. Selected Current and Next FQ &&& All Opportunities
		quarterSummary("Current and Next FQ","All Opportunities");
		System.out.println("Generated Report of 'Current and Next FQ' interval with 'All Opportunities' ");
		Thread.sleep(1000);
		
		//2. Selected Previous FY &&&  Closed Opportunities
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		quarterSummary("Previous FY","Closed Opportunities");
		System.out.println("Generated Report of 'Previous FY' interval with 'Closed Opportunities' ");
		Thread.sleep(1000);
		
		//3. Selected Next FQ &&& Open Opportunities
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		quarterSummary("Next FQ","Open Opportunities");
		System.out.println("Generated Report of ' Next FQ' interval with 'Open Opportunities' ");
		Thread.sleep(1000);
				
		
		quitBrowser();
	}
		public static void quarterSummary(String inter,String incl) {
	
		//1. Selected Current and Next FQ &&& All Opportunities
		waitExplicitly(10, driver.findElement(By.xpath("//select[@id='quarter_q']")));
		Select interval = new Select(driver.findElement(By.xpath("//select[@id='quarter_q']")));
		interval.selectByVisibleText(inter);
		Select include = new Select(driver.findElement(By.xpath("//select[@id='open']")));
		include.selectByVisibleText(incl);
		
		waitExplicitly(20, driver.findElement(By.xpath("//input[@value='Run Report']")));
		driver.findElement(By.xpath("//input[@value='Run Report']")).click();
		
		
		}

}
