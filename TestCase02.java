package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase02 {

	public static void main(String[] args) {
		
		//Set a Chrome Driver path & Launch URL
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.salesforce.com/");
		
		//Click Login with correct user name & password;
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		login.click();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.clear();
		userName.sendKeys("ava@xyz.com");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys("ucandoit123");
		
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Waiting for home page visibility;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"))));
		System.out.println("Logged in with correct username & password.");
		
		driver.close();
		
	}

}
