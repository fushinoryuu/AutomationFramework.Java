package automationconfig;

import java.util.List;

public interface IAutomationConfig
{
	Browser getBrowser();

	OperatingSystem getOperatingSystem();

	List<HubLocation> getHubLocations();

	List<BaseUrl> getBaseUrls();

	DriverLocation getActiveDriverLocation();

	Environment getActiveEnvironment();

	String GetBaseUrl(Environment environment);

	String GetDriverLocation(DriverLocation location);
}