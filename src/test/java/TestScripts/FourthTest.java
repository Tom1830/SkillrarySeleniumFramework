package TestScripts;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class FourthTest extends BaseClass
{
@Test
public void fourthtest()
{
	SoftAssert soft = new SoftAssert();
	
	home.clickgears();
	home.clickSkillraryDemoApp();
    web.switchtoChildBrowser();
    
    soft.assertEquals(demoapp.getPageHeader(),"SkillRary-ECommerce");
    
    web.scrollToElement(demoapp.getcontactus());
    demoapp.ClickContactus();
    
    soft.assertTrue(contact.getPageHeader().isDisplayed());
    List<String> datalist=excel.readDataFromExcel("sheet1");
    contact.sendContactDetails(datalist.get(0),datalist.get(1),datalist.get(2),datalist.get(3));
    
    soft.assertAll();
}
}
