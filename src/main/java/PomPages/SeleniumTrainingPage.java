package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebDriverUtility;

public class SeleniumTrainingPage 
{
//declaration
	@FindBy(xpath="//h1[@class=\"page-header\"]")
	private WebElement pageheader;
	@FindBy(id="add")
	private WebElement plusbutton;
	@FindBy(xpath="//button[.=' Add to Cart']")
	private WebElement addtocartbutton;
	@FindBy(id="callout")
	private WebElement itemaddmessage;
	
	//initialization
	public SeleniumTrainingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String getPageHeader()
	{
		return pageheader.getText();
	}
	
	public void doubleclickplusbutton(WebDriverUtility web)
	{
		web.doubleClickonelement(plusbutton);
	}
	
	public void clickaddtocart()
	{
		addtocartbutton.click();
	}
	
	public WebElement getitemaddmessage()
	{
		return itemaddmessage;
	}
	
}
