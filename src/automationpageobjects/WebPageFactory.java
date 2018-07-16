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
		catch (InstantiationException | IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		instance.SetDriver(_driver);
		instance.SetWait(new WebDriverWait(_driver, 30));
		instance.SetFactory(this);
		instance.WaitForPageToLoad();

		return instance;
	}

	public <T extends IWebPage> T Get(Class<T> pageClass, long customWaitInSeconds)
	{
		T instance = null;

		try
		{
			instance = pageClass.newInstance();
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		instance.SetDriver(_driver);
		instance.SetWait(new WebDriverWait(_driver, customWaitInSeconds));
		instance.WaitForPageToLoad();

		return instance;
	}
}
