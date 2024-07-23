package orangeHRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.DashboardObject;
import PageObjectModel.LoginPageObject;
import resources.Base;

public class LoginTest extends Base {
	
	 public WebDriver driver;
	Logger logger = LogManager.getLogger(LoginTest.class.getName());
	// Constructor to accept WebDriver instance
    public LoginTest(WebDriver driver) {
        this.driver = driver;
    }
	
	@BeforeMethod
	public void set() throws IOException {
		setup();
	}

	@Test(dataProvider = "dataForLogin",enabled = false)
	public void loginTest(String username, String password, String expectedResult) throws InterruptedException {
		
		LoginPageObject loginPageObject = new LoginPageObject(driver);
		loginPageObject.Username().sendKeys(username);
		logger.info("User entered username");
		loginPageObject.Password().sendKeys(password);
		logger.info("User entered password");
		loginPageObject.LoginButton().click();
		logger.info("User clicked on login button ");
		Thread.sleep(2000);
		DashboardObject dashboardObject = new DashboardObject(driver);
		String actualresult = null;
		try {
			if (dashboardObject.VerifyDashboard().isDisplayed()) {
				actualresult = "success";
			}
		} catch (Exception e) {
			actualresult = "failure";
		}

		Assert.assertEquals(actualresult, expectedResult);

	}

	@DataProvider
	public Object[][] dataForLogin() {
		Object[][] data = { { "Admin", "admin123", "success" }, { "Admin", "admin", "failure" } };
		return data;
	}

	@AfterMethod
	public void close() {
		teardown();
	}
}
