package TestCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestCase37 extends Utility {

	public static void main(String[] args) throws Exception {
		
		//Launch & Login
		launch_Home();
		login();
		System.out.println("Successfully launched SalesForce Application");
		
		//Click on current date link from home tab
		waitExplicitly(20, driver.findElement(By.xpath("//*[@id='home_Tab']/a")));
		driver.findElement(By.xpath("//*[@id='home_Tab']/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Current Date link;
		driver.findElement(By.xpath("//*[@id='ptBody']/div/div[2]/span[2]/a")).click();				
		System.out.println("Clicked on 'Current-Date' displayed link from home tab");
		
		//Click on 4PM link & 'Subject Combo' &Click 'Other' from combo box;
		WebElement time4PM =driver.findElement(By.xpath("//*[@id='p:f:j_id25:j_id61:20:j_id64']/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", time4PM);
		waitExplicitly(10,time4PM);
		time4PM.click();
		
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		WebElement subject = driver.findElement(By.xpath("//div[@class='requiredInput']/a/img"));
		waitExplicitly(10,subject);
		subject.click();
		System.out.println("Clicked on 8PM link & 'Other' from combo box present in  in 'Subject' field;");
		//Get window handles
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        
        // fetch the child window handle
        while (iterator.hasNext()) {
        	String childWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
            	
                driver.switchTo().window(childWindow);   	   
                WebElement otherCombo = driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a"));
                waitExplicitly(5, otherCombo);
                otherCombo.click();
            }
        }
        driver.switchTo().window(mainWindow);
        
      //Click End Time -Select 7PM & save
        driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).clear();
        
        WebElement endTime = driver.findElement(By.xpath("//div[@id='timePickerItem_38']"));
        
        //EndTime is select <Input> Drop down 
        Actions action = new Actions(driver);
        do {
        	action.sendKeys(Keys.ARROW_DOWN).perform();
        	
        }while(!endTime.isDisplayed());
        endTime.click();
        
        WebElement eventPage = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()",eventPage);
        waitExplicitly(5, eventPage);
        driver.findElement(By.xpath("//input[@id='IsRecurrence']")).click();
        
        waitExplicitly(5, driver.findElement(By.xpath("//input[@id='rectypeftw']")));
        driver.findElement(By.xpath("//input[@id='rectypeftw']")).click();
        waitExplicitly(5,driver.findElement(By.id("RecurrenceEndDateOnly")));
        driver.findElement(By.id("RecurrenceEndDateOnly")).click();
        driver.findElement(By.xpath("//*[@id='calRow5']/td[1]")).click();
        
        //Click save;
        waitExplicitly(10,driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]")));
        driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]")).click();
        
        //Click Monthly View
        waitExplicitly(10, driver.findElement(By.xpath("//*[@id='bCalDiv']/div/div[2]/span[2]/a[3]/img")));
        driver.findElement(By.xpath("//*[@id='bCalDiv']/div/div[2]/span[2]/a[3]/img")).click();
        
        System.out.println("Successfully displayed saved event in monthly view");
        
        //quitBrowser();
	
	}

}
