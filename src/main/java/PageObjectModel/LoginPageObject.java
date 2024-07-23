package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
     WebDriver driver;
     public LoginPageObject(WebDriver driver) {
    	 this.driver=driver;
    	PageFactory.initElements(driver, this);
     }
     
     @FindBy(name = "username")
     private WebElement usernamePlaceholder;
     public WebElement Username() {
    	 return usernamePlaceholder;
     }
     
     @FindBy(name = "password")
     private WebElement passwordPlaceholder;
     public WebElement Password() {
    	 return passwordPlaceholder;
     }
     
     @FindBy(xpath = "//button[@type='submit']")
     private WebElement loginButton;
     public WebElement LoginButton() {
    	 return loginButton;
     }
}
