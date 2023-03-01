package TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;


public class ThirdTest extends BaseClass
{
  @Test
  public void thirdtest() throws InterruptedException
  {
	  SoftAssert soft = new SoftAssert();
	  
	  home.searchfor("core java for selenium");
	  soft.assertEquals(corejava.getPageHeader(),"CORE JAVA FOR SELENIUM");
	  
	  corejava.clickCoreJavaForSeleniumLink();
	  soft.assertEquals (javavideo.getPageHeader(),"Core Java For Selenium Training");
	  
	  
	  javavideo.clickCloseCookies();
	  web.switchToFrame();
	  
	  javavideo.clickplayButton();
	  Thread.sleep(2000);
	  javavideo.clickpauseButton();
	  
	  web.switchBackFromFrame();
	  
	  javavideo.clickAddToWishlist();
	  
	  soft.assertAll();
  }
}
