package TestCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase07 extends Utility {

	public static void main(String[] args) throws InterruptedException  {
		launch_Home();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		login();
		mySettings();
		loginHistory();
		displayAndLayout();
		emailLink();
		calendar();
		quitBrowser();
		
	}
	
	public static void mySettings() {
		
		 waitExplicitly(10, driver.findElement(By.xpath("//div[@id='userNavButton']")));
		 driver.findElement(By.xpath("//div[@id='userNavButton']")).click();
		 waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")));
		 driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
		 System.out.println("** My Settings page **");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
	}
	
	public static void loginHistory() {
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@id=\"PersonalInfo_font\"]")).click();
		 waitExplicitly(20,  driver.findElement(By.id("LoginHistory_font")));
		 driver.findElement(By.id("LoginHistory_font")).click();
		 waitExplicitly(20,driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")));
		 driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 System.out.println("Downloaded Login History from Personal tab");
	}
	
	public static void displayAndLayout() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.id("DisplayAndLayout_font")).click();
		waitExplicitly(10, driver.findElement(By.id("CustomizeTabs_font")));
		driver.findElement(By.id("CustomizeTabs_font")).click();
		Thread.sleep(1000);
		waitExplicitly(10,driver.findElement(By.id("p4")));
		Select sel = new Select(driver.findElement(By.id("p4")));
		sel.selectByVisibleText("Salesforce Chatter");
		Thread.sleep(1000);
		System.out.println("Selected 'Salesforce Chatter from 'Customize My Tabs'");
		WebElement avTabs = driver.findElement(By.id("duel_select_0"));
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", avTabs);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"duel_select_0\"]/option[63]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img")).click();
		Thread.sleep(5000);
		System.out.println("Added 'Reports' from Available tabs to Selected tabs");
		
	}
	
	public static void  emailLink() {
		
		waitExplicitly(20, driver.findElement(By.id("EmailSetup_font")));
		driver.findElement(By.id("EmailSetup_font")).click();
		waitExplicitly(10, driver.findElement(By.id("EmailSettings_font")));
		driver.findElement(By.id("EmailSettings_font")).click();
		driver.findElement(By.id("sender_name")).clear();
		driver.findElement(By.id("sender_email")).clear();
		//driver.findElement(By.xpath("//input[@id='auto_bcc1']")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("sender_name")).sendKeys("Ava");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("sender_email")).sendKeys("ambika.thiyagar@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='auto_bcc1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//System.out.println(driver.findElement(By.xpath("//input[@id='auto_bcc1']")).getText());
		driver.findElement(By.xpath("//input[@name='save']")).click();
		System.out.println("Saved my email options");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public static void calendar() throws InterruptedException {
		
		waitExplicitly(20, driver.findElement(By.id("CalendarAndReminders_font")));
		driver.findElement(By.id("CalendarAndReminders_font")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("Reminders_font")).click();
		waitExplicitly(20, driver.findElement(By.xpath("//input[@id='testbtn']")));
		driver.findElement(By.xpath("//input[@id='testbtn']")).click();
		System.out.println("Opened a Test Reminder from Activity Reminder");
		Thread.sleep(6000);
		ArrayList<String> list = new ArrayList<>(driver.getWindowHandles());
//		WebElement popup = driver.findElement(By.xpath("//*[@id='reminder']"));		
//		WebElement popup = driver.findElement(By.id("allBox"));

		driver.switchTo().window(list.get(1));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='ids0']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("dismiss")).click();
		driver.switchTo().window(list.get(0));
		//driver.findElement(By.xpath("//input[@class='btn primary']")).click();
		driver.findElement(By.xpath("//input[@value='Cancel']")).click();
		System.out.println("Dismissed the event & saved.");
		
		
		Thread.sleep(3000);
		
		
		
	}

}
