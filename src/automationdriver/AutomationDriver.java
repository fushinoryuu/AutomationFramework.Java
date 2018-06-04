package automationdriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import automationconfig.Browser;
import automationconfig.DriverLocation;
import automationconfig.IAutomationConfig;
import automationconfig.OperatingSystem;

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
		if (_config.getActiveDriverLocation().equals(DriverLocation.LocalDriver))
			return SetupLocalWebDriver();

		return SetupRemoteWebDriver();
	}

	private WebDriver SetupLocalWebDriver()
	{
		return null;
	}

	private WebDriver SetupRemoteWebDriver()
	{
		DesiredCapabilities capabilities = DesiredBrowser();

		capabilities.setPlatform(DesiredOperatingSystem());

		URL hub = SeleniumHubLocation();

		return new RemoteWebDriver(hub, capabilities);
	}

	private DesiredCapabilities DesiredBrowser()
	{
		Browser targetBrowser = _config.getBrowser();

		switch (targetBrowser)
		{
			case FireFox:
				return DesiredCapabilities.firefox();
			case InternetExplorer:
				return DesiredCapabilities.internetExplorer();
			case Edge:
				return DesiredCapabilities.edge();
			case Safari:
				return DesiredCapabilities.safari();
			case Chrome:
			default:
				return DesiredCapabilities.chrome();
		}
	}

	private Platform DesiredOperatingSystem()
	{
		OperatingSystem os = _config.getOperatingSystem();

		switch (os)
		{
			case Windows:
				return Platform.WINDOWS;
			case Mac:
				return Platform.MAC;
			case Linux:
				return Platform.LINUX;
			case Any:
			default:
				return Platform.ANY;
		}
	}

	private URL SeleniumHubLocation()
	{
		DriverLocation location = _config.getActiveDriverLocation();
		String url = _config.GetDriverLocation(location);

		try
		{
			return new URL(url);
		}
		catch (MalformedURLException e)
		{
			return null;
		}
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
