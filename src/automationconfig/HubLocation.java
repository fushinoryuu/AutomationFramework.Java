package automationconfig;

import com.google.gson.annotations.SerializedName;

public class HubLocation
{
	@SerializedName("Location")
	private DriverLocation _location;

	@SerializedName("Url")
	private String _url;

	public DriverLocation getLocation()
	{
		return _location;
	}

	public String getUrl()
	{
		return _url;
	}
}
