package step_definitions;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.AmazonHomePOM;
import utils.Driver;
import utils.dataReader;

public class AmazonSearch {
	
	AmazonHomePOM home = new AmazonHomePOM();

	
	@Given("I am on the Amazon homepage")
	public void i_am_on_the_amazon_homepage() {
	   Driver.getDriver().get(dataReader.getData("amazonUrl"));
	}
	
	@When("I enter a search item {string}")
	public void i_enter_a_search_item(String item) {
	  home.homeSearchBox.sendKeys(item);
	  
	}
	
	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		home.searchBtn.click();
	}
	
	@Then("I should see the search item {string} on the results page")
	public void i_should_see_the_search_item_on_the_results_page(String item) {
		String searchedItemText= home.searchedItemText.getText().substring(1, item.length()+1);
		Assert.assertEquals(searchedItemText, item);
		
	}



}
