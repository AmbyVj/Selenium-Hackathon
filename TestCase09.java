package TestCases;

import java.util.concurrent.TimeUnit;


public class TestCase09 extends Utility {

	public static void main(String[] args) throws Exception {
		
		//Launch ,Login & Logout;
		launch_Home();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		login();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		logout();
		
		//quitBrowser();

	}

}
