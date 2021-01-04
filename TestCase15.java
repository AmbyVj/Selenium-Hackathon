package TestCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase15 extends Utility{

	public static void main(String[] args) throws Exception {
		
		//Launch &Login
		launch_Home();
		login();
		
		//Click on Opportunities Tab & verify all from the drop down list;
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		ArrayList<WebElement> oppList = new ArrayList<>(driver.findElements(By.xpath("//select[@id='fcf']")));
		for(int count=0; count<oppList.size();count++) 
			System.out.println(oppList.get(count).getText());
		System.out.println("Verified 'Opportunities' drop down list.");
		
		quitBrowser();
	}

}
