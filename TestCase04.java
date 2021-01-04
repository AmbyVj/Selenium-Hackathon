package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase04 extends Utility{

	public static void main(String[] args) throws Exception  {
		
		//Launch Home & login with user name & click 'Forgot Password'
		launch_Home();
		
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Login')]")));
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		waitExplicitly(30, login);
		login.click();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		waitExplicitly(30, driver.findElement(By.id("forgot_password_link")));
		driver.findElement(By.id("forgot_password_link")).click();
		
		//Give user email in the 'forgot password' page & return back;
		//check for wrong user name & password;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement user = driver.findElement(By.xpath("//input[@id='un']"));
		waitExplicitly(30, user);
		user.clear();
		user.sendKeys("ava@xyz.com");
		System.out.println("Entered user name & clicked forgot password.");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Return to Login')]")).click();
		System.out.println("Return back to login page.");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		waitExplicitly(10, userName);
		userName.clear();
		userName.sendKeys("123");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys("22131");
		System.out.println("Entered invalid user name & password.");
		driver.findElement(By.id("Login")).click();
		System.out.println("Error : "+driver.findElement(By.id("error")).getText());
		
		driver.close();

	}

}
