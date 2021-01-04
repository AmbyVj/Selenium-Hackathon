package TestCases;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
public static WebDriver driver;
	
	public static void launch_Home() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay\\chromedriver.exe");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		loadingPropertiesFile();
		driver.get(System.getProperty("url"));
	}
	
	public static void loadingPropertiesFile() throws Exception {
		//Load the input from property file. Set(key:Value) & get the runtime properties
		//String sPath = System.getProperty("user.dir")+"/Environment.properties";
		String sPath = "C:\\Users\\vijay\\eclipse-workspace\\SalesForce\\src\\TestCases\\Environment.properties";
		FileInputStream fileInp = new FileInputStream(sPath);
		Properties prop = new Properties();
		prop.load(fileInp);
		System.getProperties().putAll(prop);
		//System.out.println("login name : "+System.getProperty("userName"));
		
	}
	public static void waitExplicitly(int seconds, WebElement ele) {
		WebDriverWait wait =  new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void login() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Login')]")));
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		login.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loadingPropertiesFile();
		waitExplicitly(10, driver.findElement(By.xpath("//input[@id='username']")));
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.clear();		
		userName.sendKeys(System.getProperty("userName"));
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys(System.getProperty("password"));
		
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//waitExplicitly(20, driver.findElement(By.xpath("//*[@id='home_Tab']/a")));	
		System.out.println("Logged In");
		
	}
	
	public static void viewDropDown(String str) throws Exception {
				//Select view drop down & click go;
				waitExplicitly(10, driver.findElement(By.xpath("//*[@id='fcf']")));
				driver.findElement(By.xpath("//*[@id='fcf']")).click();
				Thread.sleep(2000);
				Select view =  new Select(driver.findElement(By.xpath("//*[@id='fcf']")));
				view.selectByVisibleText(str);
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@value=' Go! ']")).click();
				Thread.sleep(1000);
	}
	public static void windowHandles(String str) throws Exception {     
        
        //Get handles of the windows
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        
        // fetch the child window handle
        while (iterator.hasNext()) {
        	String childWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
            	
                driver.switchTo().window(childWindow);
                driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='searchFrame']")));
               
                driver.findElement(By.id("lksrch")).click();
                driver.findElement(By.id("lksrch")).clear();
        		driver.findElement(By.id("lksrch")).sendKeys(str);
        		driver.findElement(By.xpath("//*[@id='theForm']/div/div[2]/input[2]")).click();
        		Thread.sleep(2000);
        		driver.switchTo().defaultContent();
        		
        		
		        driver.switchTo().frame(driver.findElement(By.id("resultsFrame")));
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("//a[@href='#']")).click();
		        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
            }
        }
       
        driver.switchTo().window(mainWindow);
}
	
	
	
	public static void saveClick() {
		
	   waitExplicitly(3, driver.findElement(By.xpath("//input[@name='save'][1]")));
	   driver.findElement(By.xpath("//input[@name='save'][1]")).click();
	   System.out.println("Given Details is saved");
	}
	
	public static void newUniqueViewName(String str) {
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
        System.out.println("Clicked 'Create New View'");
        driver.findElement(By.id("fname")).clear();
        driver.findElement(By.id("fname")).sendKeys(str);
        driver.findElement(By.id("devname")).click();
        System.out.println("Entered ViewName & Unique ViewName.");
	}
	
	public static void logout() {
	//Click  on User Menu & click Logout
	 waitExplicitly(10, driver.findElement(By.xpath("//div[@id='userNavButton']")));
	 driver.findElement(By.xpath("//div[@id='userNavButton']")).click();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 waitExplicitly(10, driver.findElement(By.xpath("//a[contains(text(),'Logout')]")));
	 driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 
	 System.out.println("Logged out successfully");
	}
	
	public static void closeTab() {
		driver.close();
	}
	
	public static void quitBrowser() {
		//driver.close();
		driver.quit();
	}



}
