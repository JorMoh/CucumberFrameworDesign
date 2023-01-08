package step_definitions;

import org.junit.Assert;
import craterPagesPOM.DashboardPOM;
import craterPagesPOM.LoginPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserUtils;
import utils.Driver;
import utils.dataReader;

public class UserManagementSteps {
	DashboardPOM dash = new DashboardPOM();
	BrowserUtils utils = new BrowserUtils();
	LoginPOM login = new LoginPOM();
			
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    Driver.getDriver().get(dataReader.getData("craterUrl"));
	}
	
	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
	    utils.sendKeysWithActionsClass(login.userEmailField, username);
	    utils.sendKeysWithActionsClass(login.passwordField, password);
	}
	
	@When("clicks login button")
	public void click_login_button() {
	    login.loginButton.click();
	}
	
	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
	  utils.waitUntilElementVisible(dash.amountDueText);
	  Assert.assertTrue(dash.amountDueText.isDisplayed()); 
	}
	
	@Then("user quits the browser")
	public void user_quits_the_browser() {
	    Driver.quitDriver();
	}
//  INVALID LOGIN STEPS:
	
	@When("user enters invalid {string} and {string}")
	public void user_enters_invalid_and(String username, String password) {
	    utils.sendKeysWithActionsClass(login.userEmailField, username);
	    utils.sendKeysWithActionsClass(login.passwordField, password);
	}

	@Then("an error message appears")
	public void an_error_message_appears() {
	  utils.waitUntilElementVisible(login.invalidUserErrorMessage);
	  Assert.assertTrue(login.invalidUserErrorMessage.isDisplayed());
	}

	@Then("user is not logged in")
	public void user_is_not_logged_in() {
	    Assert.assertTrue(login.loginButton.isDisplayed());
	}
	
	
//  INVALID LOGIN SCENARIO OUTLINE
	boolean usernameIsEmpty;
	boolean passwordIsEmpty;
	@When("user enters invalid username {string} and password {string}")
	public void user_enters_invalid_username_and_password(String username, String password) {
		usernameIsEmpty = username.isEmpty();
		passwordIsEmpty = password.isEmpty();
		
	    utils.sendKeysWithActionsClass(login.userEmailField, username);
	    utils.sendKeysWithActionsClass(login.passwordField, password);
	}
	
	
	@Then("error messages appears")
	public void error_messages_appears() {
		
		  BrowserUtils utils = new BrowserUtils();
		  
	  if(usernameIsEmpty || passwordIsEmpty) {
			  utils.waitUntilElementVisible(login.fieldRequiredMsg);
			  Assert.assertTrue(login.fieldRequiredMsg.isDisplayed());
		  }
	 
	  else {
		  utils.waitUntilElementVisible(login.invalidUserErrorMessage); 
		  Assert.assertTrue(login.invalidUserErrorMessage.isDisplayed());
		  Assert.assertTrue(login.loginButton.isDisplayed());
		  }
	}

}
