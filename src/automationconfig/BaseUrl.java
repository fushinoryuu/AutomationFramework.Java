package automationconfig;

import com.google.gson.annotations.SerializedName;

public class BaseUrl
{
	@SerializedName("EnvironmentName")
	private Environment _environmentName;

	@SerializedName("Url")
	private String _url;

	public Environment getEnvironmentName()
	{
		return _environmentName;
	}

	public String getUrl()
	{
		return _url;
	}
}
