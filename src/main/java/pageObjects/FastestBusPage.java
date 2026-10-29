package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FastestBusPage {
	WebDriver driver;
	
	public FastestBusPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By filterFastest=By.xpath("//p[text()='Fastest First']");
	By busList=By.className("dweb_desktopTripTileContainer__HJNDh");
	By timeFrame=By.xpath("(//div[@class='dweb_durationText___vEjF'])");
	By busNames=By.xpath("(//div[@class='dweb_busBrandNameText__5CJlh']");
	
	public WebElement getFilterFastest()
	{
		return driver.findElement(filterFastest);
	}
	public List<WebElement> getBusList()
	{
		return (List<WebElement>) driver.findElement(busList);
	}
	public List<WebElement>getTimeFrame()
	{
		return (List<WebElement> )driver.findElement(timeFrame);
	}
	public List<WebElement>getBusNames()
	{
		return (List<WebElement> )driver.findElement(busNames);
	
	}
}

