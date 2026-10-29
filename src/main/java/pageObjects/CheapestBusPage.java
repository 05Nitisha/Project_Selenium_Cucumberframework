package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheapestBusPage {
	
	WebDriver driver;
	
		public CheapestBusPage(WebDriver driver)
		{
			this.driver=driver;
		}
	
		By filterCheapest=By.xpath("//p[text()='Cheapest First']");
		By busList=By.className("dweb_desktopTripTileContainer__HJNDh");
		By priceElements=By.xpath("//div[@class='dweb_discountedPriceText__w94_U']");
		By brandElements=By.xpath("//div[@class='dweb_busBrandNameText__5CJlh']");
		
		public WebElement getFilterCheapest()
		{
			return driver.findElement(filterCheapest);
		}
		public List<WebElement> getBusList()
		{
			return (List<WebElement>) driver.findElement(busList);
		}
		public List<WebElement>getPriceElements()
		{
			return (List<WebElement> )driver.findElement(priceElements);
		}
		public List<WebElement>getBrandElements()
		{
			return (List<WebElement> )driver.findElement(brandElements);
		}
}
