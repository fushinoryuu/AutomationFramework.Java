package automationpageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationdriver.IAutomationDriver;

public abstract class PageSection
{
	protected IAutomationDriver Driver;
	protected WebDriverWait Wait;
	protected IWebPageFactory Factory;
	protected List<WebElement> PageElements;
	
	public PageSection(IAutomationDriver driver, WebDriverWait wait, IWebPageFactory factory, List<WebElement> elements)
	{
		Driver = driver;
		Wait = wait;
		Factory = factory;
		PageElements = elements;
	}
}
