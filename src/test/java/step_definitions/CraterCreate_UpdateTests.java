package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import craterPagesPOM.CommonPOM;
import craterPagesPOM.ItemsPOM;
import craterPagesPOM.LoginPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserUtils;
import utils.Driver;

public class CraterCreate_UpdateTests {
	CommonPOM common = new CommonPOM();
	ItemsPOM items = new ItemsPOM();
	LoginPOM login = new LoginPOM();
	BrowserUtils utils = new BrowserUtils();
	//CREATING AN ITEM
	

	@Given("user logs in")
	public void user_logs_in() {
	   LoginPOM.craterLogin();
	}


	@Given("user navigates to Items tab")
	public void user_navigates_to_items_tab() {
	    common.itemsTab.click();
	}
	
	@When("user clicks on the Add Item button")
	public void user_clicks_on_the_add_item_button() {
	  items.addItemBtn.click();
	}
	
	@When("user should be on item input page")
	public void user_should_be_on_item_input_page() {
	  Assert.assertTrue(items.newItemHeader.isDisplayed()); 
	}
	
	@When("user provides item information “name” and “price” and “unit” and “description”")
	public void user_provides_item_information_name_and_price_and_unit_and_description() {
		
	   items.nameField.sendKeys("cleaning products");
	   items.priceField.sendKeys("15000");
	   items.unitField.click();
       items.unitFieldbox.click();
	   items.descriptionField.sendKeys("Heavy duty cleaning products");
	}
	
	@When("click Save Item button")
	public void click_save_item_button() {
	   items.saveItemBtn.click();
	}
	
	@Then("the Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
		Assert.assertEquals(items.addedItem.getText(), "cleaning products");
	}
	    

	//UPDATING AN ITEM
	

	@When("selects the item “Books”")
	public void selects_the_item_books() {
		Driver.getDriver().findElement(By.xpath("//a[text()='10']")).click();
		items.bookItem.click();
	}
	@When("user should be on item details page")
	public void user_should_be_on_item_details_page() {
		Assert.assertTrue(items.updateItemBtn.isDisplayed());
	}
	@When("user updates the item price to thirty dollars")
	public void user_updates_the_item_price_to_thirty_dollars() {
	    
	}
	@When("click Update Item button")
	public void click_update_item_button() {
		 utils.clearTextOfTheFieldWindows(items.priceField);
		items.priceField.sendKeys("3000");
		items.updateItemBtn.click();
	}
	@Then("the Item price is updated to thirty dollars")
	public void the_item_price_is_updated_to_thirty_dollars() throws InterruptedException {
		Driver.getDriver().findElement(By.xpath("//a[text()='10']")).click();
		 utils.waitUntilElementVisible(items.bookPrice);
		 Thread.sleep(5000);
		 Assert.assertEquals(items.bookPrice.getText(), "$ 30.00");
	}





}