package orangeHRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjectModel.DashboardObject;
import resources.Base;

public class DashboardTest extends Base{
	Logger logger = LogManager.getLogger(LoginTest.class.getName());
	
	@BeforeMethod
	public void set() throws IOException {
		setup();
	}
	
	@Test
	public void Dashboard() throws InterruptedException {
		LoginTest loginTest= new LoginTest(driver);
		loginTest.loginTest("Admin","admin123" ,"success");
		logger.info("User enters dashboard by entering valid username, password and prints a message whether user is valid or invalid");
		DashboardObject dashboardObject = new DashboardObject(driver);
		logger.info("User clicks on dropdown option");
		dashboardObject.DropDownOption().click();
		dashboardObject.AboutOption().click();
		logger.info("User clicks on about option");
		Thread.sleep(2000);
		dashboardObject.DismissAbout().click();
		logger.info("User clicks dismiss about button");
		Thread.sleep(2000);
		dashboardObject.CloseDashboardOption().click();
		logger.info("User clicks on hide dashboard option");
		Thread.sleep(2000);
		dashboardObject.CloseDashboardOption().click();
		logger.info("User clicks on unhide dashboard option");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void close() {
		teardown();
	}
}
