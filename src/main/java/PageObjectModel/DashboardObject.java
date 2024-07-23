package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardObject {
	WebDriver driver;
	public DashboardObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='oxd-topbar-header']")
	private WebElement verifyDashboard;
	public WebElement VerifyDashboard() {
		return verifyDashboard;
	}
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement dropDownOptionToAccessDiffSection;
	public WebElement DropDownOption() {
		return dropDownOptionToAccessDiffSection;
	}
	
	@FindBy(linkText = "About")
	private WebElement aboutOption;
	public WebElement AboutOption() {
		return aboutOption;
	}
	
	@FindBy(xpath = "//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']")
    private WebElement dismissAbout;
	public WebElement DismissAbout() {
		return dismissAbout;
	}
	
	@FindBy(xpath = "//button[@class='oxd-icon-button oxd-main-menu-button']")
	private WebElement closeDashboardOption;
	public WebElement CloseDashboardOption() {
		return closeDashboardOption;
	}
	
}
