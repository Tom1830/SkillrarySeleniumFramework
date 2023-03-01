package TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class SecondTest extends BaseClass
{

	@Test
	public void secondtest()
	{
		
	SoftAssert soft = new SoftAssert();
	
	home.clickgears();
	
	home.clickSkillraryDemoApp();
	web.switchtoChildBrowser();
	
	
	soft.assertEquals(demoapp.getPageHeader(),"SkillRary-ECommerce");
	demoapp.selectCategory(web, 1);
	
	soft.assertEquals(testing.getPageHeader(),"Testing");
	web.dragAndDropElement(testing.getJavaImage(),testing.getMyCartArea());
	web.scrollToElement(testing.getfacebookicon());
	testing.clickFacebookIcon();
	
	soft.assertAll();
	
	}
}
