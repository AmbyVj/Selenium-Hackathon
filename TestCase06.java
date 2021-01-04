package TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestCase06 extends Utility{

	public static void main(String[] args) throws Exception {
		launch_Home();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		login();
		myProfile();
		editProfile();
		clickFile();
		postAndShare();
		imageLoadCrop();
		quitBrowser();
		
		
	}	
		public static void myProfile() throws InterruptedException {
		 waitExplicitly(10, driver.findElement(By.xpath("//div[@id='userNavButton']")));
		 driver.findElement(By.xpath("//div[@id='userNavButton']")).click();		
		 WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		 ele.click();
		 System.out.println("My Profile page");
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", ele);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Thread.sleep(3000);
		}
		 
		 public static void editProfile() {		 
		 
		 //************* Edit Profile -About Tab- Change Last Name *******
		 
		 driver.findElement(By.xpath("//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img")).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		 driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Th");
		 //driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("T");
		 System.out.println("updated the last name");		  
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		 
		 driver.findElement(By.xpath("//*[@id='TabPanel']/div/div[2]/form/div/input[1]")).click();
		 System.out.println("Profile page is updated");
		 }
		 
		 public static void postAndShare() throws InterruptedException {
			 
		 //******** Click-on Post Link -> Share the text entered in iFrame ******
		     
		 driver.findElement(By.xpath("//*[contains(text(),'Post')]")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		 driver.findElement(By.xpath("//html[@dir='ltr']")).click();
		 
		// driver.findElement(By.xpath("/html[1]/body[1]/p[1]")).click();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		 
		 driver.findElement(By.xpath("/html[1]/body[1]/p[1]")).sendKeys("This is selenium automation");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.switchTo().defaultContent();
		 driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 System.out.println("Posted the text & shared");
		 }
		 
		 public static void clickFile() throws InterruptedException {
			 
		 //************** Click-on File Link -> choose-> upload File *****************	 
		 
			 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 waitExplicitly(20, driver.findElement(By.id("publisherAttachContentPost")));
		 driver.findElement(By.xpath("//*[@id='publisherAttachContentPost']/span[1]")).click();	
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys("C:\\Users\\vijay\\Desktop\\testing.txt");
		 driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		 Thread.sleep(2000);
		 System.out.println("File is uploaded & shared successfully");
		 

		 }
		 
		 
		 public static void imageLoadCrop() throws InterruptedException {
		 //************ Click-on Add Photo Link -> upload a img & crop it ************
		
		 waitExplicitly(20, driver.findElement(By.xpath("//a[@id='uploadLink']")));
		 WebElement image = driver.findElement(By.xpath("//a[@id='uploadLink']"));
		 Actions action = new Actions(driver);
		 action.moveToElement(image).perform();
		 image.click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 //WebElement pic = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		 driver.switchTo().frame(driver.findElement(By.id("uploadPhotoContentId")));
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 //j_id0:uploadFileForm:uploadInputFile
		 WebElement choose = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
		 action.moveToElement(choose).perform();
		// choose.sendKeys("D:\\cat.jpg");
		 choose.sendKeys("C:\\Users\\vijay\\Desktop\\for.jpg");	 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']")).click();
		 System.out.println("Photo uploaded!");
		 Thread.sleep(4000);
		 WebElement source = driver.findElement(By.xpath("//div[@class='imgCrop_handle imgCrop_handleNW']"));
		 action.dragAndDropBy(source, 2, 4);
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']")).click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.switchTo().defaultContent();
		 Thread.sleep(2000);
		 
		 //Runtime.getRuntime().exec("‪C:\\Program Files (x86)\\AutoIt3\\starImg.exe");
		}

	

}
