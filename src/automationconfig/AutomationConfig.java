package automationconfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;

public class AutomationConfig implements IAutomationConfig
{
	private Browser TargetBrowser;

	private OperatingSystem TargetOperatingSystem;

	private String HubLocation;

	public Browser getBrowser()
	{
		return TargetBrowser;
	}

	public OperatingSystem getOS()
	{
		return TargetOperatingSystem;
	}

	public String getHubLocation()
	{
		return HubLocation;
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
