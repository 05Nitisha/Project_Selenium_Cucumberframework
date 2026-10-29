package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By fromTextField=By.xpath("//*[@list='suggestions1']");
	By optionsToSelect=By.xpath("//*[@id='Delhi'][1]");
	By toTextField=By.xpath("//*[@list='suggestions2']");
	By optionsToSelectToCity=By.xpath("//*[@id='Chandigarh'][1]");
	By selectDateThroughCalendar=By.xpath("//button[text()='Tomorrow']");
	By dateElement=By.xpath("//*[@id='date']");
	By searchText=By.xpath("//*[@class='breadcrumbs_tagHeading__875CB']");
	
	public WebElement getFromTextField()
	{
		return driver.findElement(this.fromTextField);
	}
	public WebElement getOptionsToSelect()
	{
		return driver.findElement(this.optionsToSelect);
	}
	public WebElement getToTextField()
	{
		return driver.findElement(this.toTextField);
	}
	
	public WebElement getOptionsToSelectToCity()
	{
		return driver.findElement(this.optionsToSelectToCity);
	}
	public WebElement getDateElement()
	{
		return driver.findElement(this.dateElement);
	}
	public WebElement getSelectDateThroughCalendar()
	{
		return driver.findElement(this.selectDateThroughCalendar);
	}
	public WebElement getSearchText()
	{
		return driver.findElement(this.searchText);
	}
}
