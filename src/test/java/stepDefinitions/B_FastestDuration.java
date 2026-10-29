package stepDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
import pageObjects.FastestBusPage;

public class B_FastestDuration extends Base {
	
	FastestBusPage fastestBus;
	
	String priceRange;
	List<WebElement>busList;
	private static final Logger log=LogManager.getLogger(B_FastestDuration.class);
	
	@Given("user is on Bus List screen")
	public void user_is_on_bus_list_screen() {
		try {
		
		
    
	  getDriver().get(this.getData("searchBusURL"));
	    getDriver().manage().window().maximize();
	    
	    fastestBus=new FastestBusPage(getDriver());
	
	 
	
	log.debug("Bus list appears successfully");
	
		}
		catch(Exception ex)
		{
			log.error("exception occured" +ex.getMessage());
		}
	}
	@When("click on Fastest First option")
	public void click_on_fastest_first_option()  {
		try {
	    
		
	   this. fastestBus.getFilterFastest().click();
	    
	    busList=this.fastestBus.getBusList();
	    
	    
	    log.debug("got the size of bus " +busList);
	    
	    
	   
		}
		catch(Exception ex)
		{
			log.error("exception occured" +ex.getMessage());
		}
	}
	@Then("Bus list appears sorted with Fastest First")
	
	public void bus_list_appears_sorted_with_fastest_first() {
		try {
			List<WebElement>durationElements=this.fastestBus.getTimeFrame();
			List<WebElement>nameElements=this.fastestBus.getBusNames();
			
		int minimumTime=Integer.MAX_VALUE;
		
		String fastestBusName="";
		
		List<Integer>allTimesInMinutes=new ArrayList<>();
		
		for(int i=1;i<=busList.size();i++)
		{
		
		String timeFrame=durationElements.get(i).getText().trim();
		
		
		
		log.debug("Time details found");
		
		
		
		
		String busNames= nameElements.get(i).getText();
		log.debug("Got Bus Names");
		
		
		if(!timeFrame.isEmpty())
		{
			String[]parts=timeFrame.split(" ");
			
			int hours;
			int minutes;
			if(parts[0].contains("h"))
			{
				 hours=Integer.parseInt(parts[0].replace("h", ""));
			}
			else
			{
				 hours=0;
				
			}
			if(parts.length>1 && parts[1].contains("m"))
					{
				minutes=Integer.parseInt(parts[1].replace("m", ""));
					}
			else
			{
				minutes=0;
			}
			int totalTime=hours*60+minutes;
			
			allTimesInMinutes.add(totalTime);
			            
				
				if (totalTime < minimumTime) {
                 minimumTime = totalTime;
                  fastestBusName = busNames;
             }
         }
    
 }
 System.out.println("\n----------------------------------------");
 System.out.println("FASTEST BUS FOUND:");
 System.out.println("Bus Name: " + fastestBusName);
 System.out.println("Time   : " + minimumTime +"minutes");
 System.out.println("----------------------------------------\n");
 
 log.debug("Fatest Bus found successfully ");

		}
		catch(Exception ex)
		{
			log.error("exception occured" +ex.getMessage());
		}
		}
	}
