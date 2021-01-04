package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;



public class TestCase16 extends Utility {

	public static void main(String[] args) throws Exception {
		
		launch_Home();
		login();
		
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("opp3")).sendKeys(System.getProperty("OpportunityName"));
		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Search the  Account Name & get it from available list;		
		
		driver.findElement(By.xpath("//*[@id='opp4_lkwgt']/img")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		windowHandles("Ava");
		System.out.println("Searched the account name & selected it from new window");
		Thread.sleep(2000);
		
		Select leadSource = new Select(driver.findElement(By.id("opp6")));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
		leadSource.selectByVisibleText("Partner Referral");
		
		driver.findElement(By.id("opp9")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
		//driver.findElement(By.xpath("//a[contains(text(),'Today')]")).click();
		driver.findElement(By.xpath("//td[contains(text(),'20')]")).click();
		
		Select stage = new Select(driver.findElement(By.id("opp11")));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
		stage.selectByVisibleText("Value Proposition");
		driver.findElement(By.id("opp12")).clear();
		driver.findElement(By.id("opp12")).sendKeys("75");
		
		//Search the opportunities campaign & get it;
		driver.findElement(By.xpath("//*[@id='opp17_lkwgt']/img")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		windowHandles("Automation");
		System.out.println("Searched the opportunities campaign & selected it from new window");
        
		Thread.sleep(1000); 	
		driver.findElement(By.xpath("//*[@id='topButtonRow']/input[1]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
		System.out.println("New Opportunity is created on selected account ");
		
		//quitBrowser();

	}
	
	
}
