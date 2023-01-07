package craterPagesPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;
import utils.dataReader;

public class LoginPOM {
	
	public LoginPOM() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//div[@name='email']/input")
	public WebElement userEmailField;
	
	@FindBy (xpath = "//div[@name='password']/input")
	public WebElement passwordField;
	
	@FindBy (linkText = "Forgot Password?")
	public WebElement forgotPasswordLink;
	
	@FindBy (xpath = "//button[text()='Login']")
	public WebElement loginButton;
	
	@FindBy (xpath = "//p[contains(text(), 'Copyright @')]")
	public WebElement copyRightText;
	
	@FindBy (xpath = "//h1[contains(text(), 'Simple Invoicing for')]")
	public WebElement businessTagline;
	
	@FindBy (xpath = "//p[contains(text(), 'Crater helps you track expenses')]")
	public WebElement businessSubtext;
	
	@FindBy (xpath = "//p[contains(text(), 'These credentials do not match our records.')]")
	public WebElement invalidUserErrorMessage;
	
	@FindBy (xpath = "//span[text()='Field is required']")
	public WebElement fieldRequiredMsg;
	
	//CRATER METHODS
	  
	  public static void craterLogin() {
		  LoginPOM login = new LoginPOM();
		  login.userEmailField.sendKeys(dataReader.getData("craterValidUserEmail"));
		  login.passwordField.sendKeys(dataReader.getData("craterValidPassword"));
		  login.loginButton.click();
	  }



}
