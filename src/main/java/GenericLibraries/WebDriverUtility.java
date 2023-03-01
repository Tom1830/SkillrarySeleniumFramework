package GenericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class contains reusable methods of webdriver
 * @author srisr
 *
 */
public class WebDriverUtility
{
private WebDriver driver;

/**
 * this method is used to navigate to an application using user desired browser
 * @param browser
 * @param url
 * @param time
 * @return
 */
public WebDriver openApplication(String browser,String url,long time)
{
	
	switch(browser)
	{
	case "chrome":driver=new ChromeDriver(); break;
	case"edge":driver=new EdgeDriver(); break;
	
	default:System.out.println("invalid browser data");
	}
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	
	return driver;
}
/**
 * this method is used to wait untill the visibility of particular element
 * @param element
 * @param time
 * @return
 */
public WebElement explicitywait(WebElement element , long time)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
	return wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this method is used to perform mouse hover on an element
 * @param element
 */
public void mouseHover(WebElement element)
{
	Actions a = new Actions(driver);
	a.moveToElement(element).perform();
}
/**
 * this method is used to perform double click of an element
 * @param element
 */
public void doubleClickonelement(WebElement element)
{
	Actions a = new Actions(driver);
	a.doubleClick(element).perform();
}
/**
 * this method is used to perfor drag and drop of an element
 * @param source
 * @param target
 */
public void dragAndDropElement(WebElement source,WebElement target)
{
	Actions a = new Actions(driver);
	a.dragAndDrop(source, target).perform();
}
/**
 * this method is used to select an element form drop down based on visible text
 * @param element
 * @param value
 */
public void dropdown(WebElement element,String value)
{
	Select s = new Select (element);
	s.selectByValue(value);
}
/**
 * this method is used to scroll till the element
 * @param element
 */
public void scrollToElement(WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",element);
}
/**
 * this method is used to take scrrenshot of element
 */
public void screenshot()
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshot/image.png");
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
}
/**
 * this method is used to handle alertpop ups
 */
public void handleAlert()
{
	driver.switchTo().alert().accept();
}
/**
 * this method is used to switch child browser pop up
 */
public void switchtoChildBrowser() 
{
	Set<String> set = driver.getWindowHandles();
	for (String WindowID :set)
	{
		driver.switchTo().window(WindowID);
	}
}
/**
 * this method is used to switch the frame
 */
public void switchToFrame()
{
	driver.switchTo().frame(0);
	
}
/**
 * this method is used switch back from the frame
 */
public void switchBackFromFrame()
{
	driver.switchTo().defaultContent();
}
/**
 * this method is used to close the current tab
 */
public void closeCurrentWindow()
{
	driver.close();
}
/**
 * this method is used to close all the tabs and exit webdriver
 */
public void quitBrowser()
{
	driver.quit();
}
public void dropdown(WebElement element, int index) 
{
	Select s = new Select (element);
	s.selectByIndex(index);
	
}


}
