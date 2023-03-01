package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebDriverUtility;

public class SkillraryDemoAppPage 
{
	
//Declaration
	@FindBy(xpath="//div[@class=\"navbar-header\"]")
	private WebElement pageHeader;
	@FindBy(id="course")
	private WebElement courseTab;
	@FindBy(xpath="//span[@class=\"wrappers\"]/a[text()=\"Selenium Training\"]")
	private WebElement seleniumTrainingLink;
	@FindBy(xpath="//select[@name=\"addresstype\"]")
	private WebElement categoryDropdown;
	@FindBy(xpath="//a[text()=\"Contact Us\"]")
	private WebElement contactUsLink;
	
	
	//initialization
	public SkillraryDemoAppPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utillization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public  void mouseHoverToCourse(WebDriverUtility web)
	{
		web.mouseHover(courseTab);
	}
	
	public void clickSeleniumtraining()
	
	{
		seleniumTrainingLink.click();
	}
	
	public void selectCategory(WebDriverUtility web, int index)
	{
		web.dropdown(categoryDropdown, index);
	}
	
	public WebElement getcontactus()
	{
		return contactUsLink;
	}
	                        
	public void ClickContactus()
	{
		contactUsLink.click();
	}
}
