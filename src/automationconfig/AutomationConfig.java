package automationconfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class AutomationConfig implements IAutomationConfig
{
	@SerializedName("TargetBrowser")
	private Browser _targetBrowser;

	@SerializedName("TargetOperatingSystem")
	private OperatingSystem _targetOperatingSystem;

	@SerializedName("HubLocations")
	private List<HubLocation> _hubLocations;

	@SerializedName("ActiveDriverLocation")
	private DriverLocation _activeDriverLocation;

	@SerializedName("BaseUrls")
	private List<BaseUrl> _baseUrls;

	@SerializedName("ActiveEnvironment")
	private Environment _activeEnvironment;

	@Override
	public Browser getBrowser()
	{
		return _targetBrowser;
	}

	@Override
	public OperatingSystem getOperatingSystem()
	{
		return _targetOperatingSystem;
	}

	@Override
	public List<HubLocation> getHubLocations()
	{
		return _hubLocations;
	}

	@Override
	public List<BaseUrl> getBaseUrls()
	{
		return _baseUrls;
	}

	@Override
	public DriverLocation getActiveDriverLocation()
	{
		return _activeDriverLocation;
	}

	@Override
	public Environment getActiveEnvironment()
	{
		return _activeEnvironment;
	}

	@Override
	public String GetBaseUrl(Environment environment)
	{
		for (BaseUrl baseUrl : _baseUrls)
			if (baseUrl.getEnvironmentName().equals(environment))
				return baseUrl.getUrl();

		return null;
	}

	@Override
	public String GetDriverLocation(DriverLocation location)
	{
		for (HubLocation hubLocation : _hubLocations)
			if (hubLocation.getLocation().equals(location))
				return hubLocation.getUrl();

		return null;
	}

	public static IAutomationConfig deserealize(String fileName)
	{
		StringBuilder builder = new StringBuilder();

		try (Scanner fileIn = new Scanner(new File(fileName)))
		{
			while (fileIn.hasNext())
			{
				String line = fileIn.nextLine();

				builder.append(line);
			}
		}
		catch (FileNotFoundException exception)
		{
			System.err.println(exception.getMessage());

			return null;
		}

		return new Gson().fromJson(builder.toString(), AutomationConfig.class);
	}
}
