package automationdriver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationconfig.IAutomationConfig;

public class AutomationDriver implements IAutomationDriver
{
	private WebDriver _driver;
	private IAutomationConfig _config;

	public AutomationDriver(IAutomationConfig config)
	{
		_config = config;
		_driver = SetupWebDriver();
		
		_driver.manage().window().maximize();
	}
	
	private WebDriver SetupWebDriver()
	{
		return null;
	}

	@Override
	public void close()
	{
		_driver.close();
	}

	@Override
	public WebElement findElement(By by)
	{
		return _driver.findElement(by);
	}

	@Override
	public List<WebElement> findElements(By by)
	{
		return _driver.findElements(by);
	}

	@Override
	public void get(String url)
	{
		_driver.get(url);
	}

	@Override
	public String getCurrentUrl()
	{
		return _driver.getCurrentUrl();
	}

	@Override
	public String getPageSource()
	{
		return _driver.getPageSource();
	}

	@Override
	public String getTitle()
	{
		return _driver.getTitle();
	}

	@Override
	public String getWindowHandle()
	{
		return _driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles()
	{
		return _driver.getWindowHandles();
	}

	@Override
	public Options manage()
	{
		return _driver.manage();
	}

	@Override
	public Navigation navigate()
	{
		return _driver.navigate();
	}

	@Override
	public void quit()
	{
		_driver.quit();
	}

	@Override
	public TargetLocator switchTo()
	{
		return _driver.switchTo();
	}
}
