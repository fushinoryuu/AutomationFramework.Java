package automationconfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class AutomationConfig implements IAutomationConfig
{
	@SerializedName("TargetBrowser")
	private Browser _targetBrowser;

	@SerializedName("TargetOperatingSystem")
	private OperatingSystem _targetOperatingSystem;

	@SerializedName("HubLocation")
	private String _hubLocation;

	public Browser getBrowser()
	{
		return _targetBrowser;
	}

	public OperatingSystem getOS()
	{
		return _targetOperatingSystem;
	}

	public String getHubLocation()
	{
		return _hubLocation;
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
