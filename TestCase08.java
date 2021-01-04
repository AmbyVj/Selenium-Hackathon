package TestCases;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;



public class TestCase08 extends Utility{

	public static void main(String[] args) throws Exception {
		//Launch url & login
		launch_Home();
		login();
		
		//Click on User Menu
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 waitExplicitly(10, driver.findElement(By.xpath("//div[@id='userNavButton']")));
		 driver.findElement(By.xpath("//div[@id='userNavButton']")).click();
		 
		 //Click on 'Developer Console' & close it
		
		 waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]")));
		 driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]")).click();
		 Thread.sleep(2000);
		 //Get handles of the windows
	        String parentWindow = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        
//	        String childWindow = iterator.next();
//	        driver.switchTo().window(childWindow);
//	        driver.close();
	        
	               
	        // fetch the child window handle
	        while (iterator.hasNext()) {
	        	String childWindow = iterator.next();
	            if (!parentWindow.equalsIgnoreCase(childWindow)) {
	            	
	                driver.switchTo().window(childWindow);
	                driver.close();
	            }
	        }
	            driver.switchTo().window(parentWindow);
		 
		 
		 System.out.println("Developer Console is opened & closed successfully");		 
		 Thread.sleep(1000);	

		 driver.close();	

	}

}
