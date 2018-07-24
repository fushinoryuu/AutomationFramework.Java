package automationpageobjects;

import org.openqa.selenium.support.ui.WebDriverWait;

import automationdriver.IAutomationDriver;

public class WebPageFactory implements IWebPageFactory
{
	private IAutomationDriver _driver;

	public WebPageFactory(IAutomationDriver driver)
	{
		_driver = driver;
	}

	public <T extends IWebPage> T Get(Class<T> pageClass)
	{
		T instance = null;

		try
		{
			instance = pageClass.newInstance();
		}
		catch (InstantiationException | IllegalAccessException exception)
		{
			exception.printStackTrace();
			return null;
		}

		return SetValues(instance, 30);
	}

	public <T extends IWebPage> T Get(Class<T> pageClass, long customWaitInSeconds)
	{
		T instance = null;

		try
		{
			instance = pageClass.newInstance();
		}
		catch (InstantiationException | IllegalAccessException exception)
		{
			exception.printStackTrace();
			return null;
		}

		return SetValues(instance, customWaitInSeconds);
	}

	private <T extends IWebPage> T SetValues(T instance, long customWaitInSeconds)
	{
		// Set framework values
		instance.SetDriver(_driver);
		instance.SetWait(new WebDriverWait(_driver, customWaitInSeconds));
		instance.SetFactory(this);

		// Make sure page is ready
		instance.InitializePageSections();
		instance.WaitForPageToLoad();

		return instance;
	}
}
