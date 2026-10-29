package stepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheapestBusPage;

public class C_CheapestBus extends Base {
	
	
	String priceRange;
	List<WebElement>busList;
	
	CheapestBusPage cheapestBus;
	
	private static final Logger log=LogManager.getLogger(C_CheapestBus.class);
	
	@Given("user is on  List screen")
	public void user_is_on_bus_list_screen() {
		try {
	    
		log.debug(this.getData("searchBusURL"));
		
		getDriver().get(this.getData("searchBusURL"));
		
	    getDriver().manage().window().maximize();
	    
	    cheapestBus=new CheapestBusPage(getDriver());
	    
	  
		}
		catch(Exception ex)
		{
			log.error("exception occured" +ex.getMessage());
		}
	
	}
	
	@When("click on Cheapest First option")
	public void click_on_cheapest_first_option(){
		try {
	  
		Thread.sleep(6000);
		
		this.cheapestBus.getFilterCheapest().click();
	    
	    busList=cheapestBus.getBusList();
	    
	    log.debug("Got the List of Bus");
	    
	   
		}
		catch(Exception ex)
		{
			log.error("exception occured" +ex.getMessage());
		}
	}
	@Then("Bus list appears sorted with Cheapest First")
	public void bus_list_appears_sorted_with_cheapest_first() {
		try {
			 List<WebElement> priceElements = this.cheapestBus.getPriceElements();
			    List<WebElement> brandElements =this. cheapestBus.getBrandElements();
		
			this.cheapestBus.getPriceElements();
	    
	    this.cheapestBus.getBrandElements();
	    Assert.assertTrue(priceElements.size() > 0, "No price elements found on the screen!");

	    List<Integer> actualPricesInINR = new ArrayList<>();
	    int lowestPrice=Integer.MAX_VALUE;
	    String cheapestBusName="";

	    for (int i = 0; i < priceElements.size(); i++) {
	        String rawPriceText = priceElements.get(i).getText().trim();
	        System.out.println(rawPriceText);
	        String busName = brandElements.get(i).getText();
	        
	        log.debug("Got the Names of Bus");
	        
	        if (!rawPriceText.isEmpty()) {
	            
	            String numericPriceStr = rawPriceText.replaceAll("[^0-9]", "");
	            log.debug("getting only numeric value");
	            
	            if (!numericPriceStr.isEmpty()) {
	                int price = Integer.parseInt(numericPriceStr);
	                actualPricesInINR.add(price);
	                
	                             
					if (price < lowestPrice) {
	                    lowestPrice = price;
	                     cheapestBusName = busName;
	                }
	            }
	        }
	    }
	    
	    System.out.println("CHEAPEST BUS FOUND:");
	    System.out.println("Bus Name: " + cheapestBusName);
	    System.out.println("Price   : ₹" + lowestPrice);
	    System.out.println("----------------------------------------\n");

	    log.debug("Cheapest Bus found successfully");
	    
		}
		catch(Exception ex)
		{
			log.error("exception occured" +ex.getMessage());
		}

	
	            }
}