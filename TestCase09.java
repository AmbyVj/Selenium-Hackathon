package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class TestCase09 extends Utility {

	public static void main(String[] args) {
		
		//Launch ,Login & Logout;
		launch_Home();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		login();
		logout();
		
		//quitBrowser();

	}

}
