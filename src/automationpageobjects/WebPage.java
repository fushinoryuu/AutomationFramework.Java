package automationpageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationdriver.IAutomationDriver;

public abstract class WebPage implements IWebPage
{
	protected IAutomationDriver Driver;
	protected WebDriverWait Wait;
	
	@Override
	public IAutomationDriver GetDriver()
	{
		return Driver;
	}

	@Override
	public void SetDriver(IAutomationDriver driver)
	{
		Driver = driver;
	}

	@Override
	public WebDriverWait GetWait()
	{
		return Wait;
	}

	@Override
	public void SetWait(WebDriverWait wait)
	{
		Wait = wait;
	}

	@Override
	public WebElement FindElementBy(By by)
	{
		return Driver.findElement(by);
	}

	@Override
	public List<WebElement> FindElementsBy(By by)
	{
		return Driver.findElements(by);
	}
}
