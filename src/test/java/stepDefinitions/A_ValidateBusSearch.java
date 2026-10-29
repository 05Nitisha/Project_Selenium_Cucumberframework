package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchPage;

public class A_ValidateBusSearch extends Base {
	
	SearchPage searchPage;
	private static final Logger log=LogManager.getLogger(A_ValidateBusSearch.class);
	@Given("user is on Home Page")
	
	public void user_is_on_home_page() {
		try {
			
	    Thread.sleep(3000);
	    
	    log.debug(getData("url value")+this.getData("url"));
	    getDriver().get(this.getData("url"));
	    log.debug("URL Launched");
	    
	    
	    
	    getDriver().manage().window().maximize();
	    log.debug("Window is maximized");
	    
	     searchPage =new SearchPage(getDriver());
		}
		catch(Exception ex)
		{
			log.error("Exception occured " +ex.getMessage());
		}
	}
	@When("enters From, To and Date of Journey")
	public void enters_from_to_and_date_of_journey()  {
		try {
		
		this.searchPage =new SearchPage(getDriver());
		
		this.searchPage.getFromTextField().click();
       
       this.searchPage.getFromTextField().sendKeys("Delhi");
        
        log.debug("From City is entered " );
        
        
        this.searchPage.getOptionsToSelect().click();
        
        log.debug("From City is selected ");
        
        
           
	   this.searchPage.getToTextField().click();
	    
	   this.searchPage.getToTextField().sendKeys("Chandigarh");
	    
	    
	    log.debug("To  City is entered " );
	    
	   
	    this.searchPage.getOptionsToSelectToCity().click();
	    Thread.sleep(3000);
	    
	    log.debug("To  City is selected ");
	    
	  
	  this.searchPage.getDateElement().click();
	    
	    
	    
	  this.searchPage.getSelectDateThroughCalendar().click();
      
	  
	  Thread.sleep(3000);

log.debug("Date is Selecetd");
		}
		catch(Exception ex)
		{
			log.error("exception occured" +ex.getMessage());
		}


}
	@Then("bus gets searched successfully")
	public void bus_gets_searched_successfully() {
		try {
	 
	    
	    String textDetails=this.searchPage.getSearchText().getText();
	    Assert.assertTrue(textDetails.contains("Delhi to Chandigarh Bus Ticket Booking"),"search Failure");
	    	    
	    log.debug("Search is working fine ");
	   

		}
		catch(Exception ex)
		{
			log.error("exception occured" +ex.getMessage());
		}
	    
	    
	    
	}
}
