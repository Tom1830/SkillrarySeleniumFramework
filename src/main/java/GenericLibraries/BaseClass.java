package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPages.ContactUsPage;
import PomPages.CoreJavaForSeleniumPage;
import PomPages.CoreJavaVideoPage;
import PomPages.HomePage;
import PomPages.SeleniumTrainingPage;
import PomPages.SkillraryDemoAppPage;
import PomPages.TestingPages;

public class BaseClass 
{
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDemoAppPage demoapp;
	protected SeleniumTrainingPage selenium;
	protected TestingPages testing;
	protected CoreJavaForSeleniumPage corejava;
	protected CoreJavaVideoPage javavideo;
	protected ContactUsPage contact;
	
//@BeforeSuite
//@BeforeTest
	
    @BeforeClass
    public void ClassConfiguration()
    {
	 property = new PropertiesUtility();
	 excel = new ExcelUtility();
	 web= new WebDriverUtility();
	 
	 property.propertiesInitialization(IConstantPath.PROPERTIES_FILE_PATH);
	 excel.execelIntialization(IConstantPath.EXCEL_FILE_PATH);
    }

    
 @BeforeMethod
 public void methodConfiguration()
 {
	 long time= Long.parseLong(property.fetchProperty("timeouts"));
	driver= web.openApplication(property.fetchProperty("browser"),
			property.fetchProperty("url"),time);
	
	home = new HomePage(driver);
	
	Assert.assertTrue(home.getlogo().isDisplayed());
	
	demoapp = new SkillraryDemoAppPage(driver);
	selenium = new SeleniumTrainingPage(driver);
	testing = new TestingPages(driver);
	corejava = new CoreJavaForSeleniumPage(driver);
	javavideo = new CoreJavaVideoPage(driver);
	contact = new ContactUsPage(driver);
 }

 
   @AfterMethod
   public void methodTearDown()
   {
	   web.quitBrowser();
   }
   
   @AfterClass
    public void classTearDown()
    {
	   excel.closeexcel();
    }
//@AfterTest
//@AfterSuite

}
