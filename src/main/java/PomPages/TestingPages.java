package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPages 
{
	//declaration
@FindBy(xpath="//h1[@class=\"page-header\"]")
private WebElement pageheader;
@FindBy(xpath="//img[@id=\"java\"]")
private WebElement javaimage;
@FindBy(xpath="//div[@id='cartArea']")
private WebElement mycarytarea;
@FindBy (xpath="//footer/descendant::i[@class=\"fa fa-facebook\"]")
private WebElement facebookicon;

//Initialization
	public TestingPages(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
	}
	//Utilization
	public String getPageHeader() 
	{
		return pageheader.getText();
	}
	
	public WebElement getJavaImage() 
	{
		return javaimage;
	}
	public WebElement getMyCartArea()
	{
		return mycarytarea;
		
	}
	
	public WebElement getfacebookicon()
	{
		return facebookicon;
	}
	public void clickFacebookIcon() 
	{
		facebookicon.click();
	}



}
