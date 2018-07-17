package automationpageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationdriver.IAutomationDriver;

public abstract class WebPage implements IWebPage
{
	protected IAutomationDriver Driver;
	protected WebDriverWait Wait;
	protected IWebPageFactory Factory;
	protected List<WebElement> PageElements = new ArrayList<>();

	public void WaitForPageToLoad() throws IndexOutOfBoundsException
	{
		final String errorMessage = "The 'PageElements' list is empty. You have to add all your web elemts "
		        + "to the list that you wish to use to check if a page has loaded.";

		if (PageElements.isEmpty())
		{
			throw new IndexOutOfBoundsException(errorMessage);
		}

		for (WebElement webElement : PageElements)
		{
			Wait.until(func -> webElement.isDisplayed() && webElement.isEnabled());
		}
	}

	public IAutomationDriver GetDriver()
	{
		return Driver;
	}

	public void SetDriver(IAutomationDriver driver)
	{
		Driver = driver;
	}

	public WebDriverWait GetWait()
	{
		return Wait;
	}

	public void SetWait(WebDriverWait wait)
	{
		Wait = wait;
	}

	public IWebPageFactory GetFactory()
	{
		return Factory;
	}

	public void SetFactory(IWebPageFactory factory)
	{
		Factory = factory;
	}

	public WebElement FindElementBy(By by)
	{
		return Driver.findElement(by);
	}

	public List<WebElement> FindElementsBy(By by)
	{
		return Driver.findElements(by);
	}

	public boolean CheckPageForText(String text)
	{
		return Driver.getPageSource().contains(text);
	}
}
