package TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class FirstTest extends BaseClass
{
  @Test
  public void firsttest()
  {
	  SoftAssert soft = new SoftAssert();
	  
	  home.clickgears();
	  home.clickSkillraryDemoApp();
	  web.switchtoChildBrowser();
	  
	  
	  soft.assertEquals(demoapp.getPageHeader(),"SkillRary-ECommerce");
	  demoapp.mouseHoverToCourse(web);
	  demoapp.clickSeleniumtraining();
	  
	  soft.assertEquals(selenium.getPageHeader(),"Selenium Training");
	  selenium.doubleclickplusbutton(web);
	  selenium.clickaddtocart();
	   web.handleAlert();
	   
	   soft.assertTrue(selenium.getitemaddmessage().isDisplayed());
	   
	   soft.assertAll();
	  
	  
  }
}
