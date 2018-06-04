package automationuitesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import automationconfig.AutomationConfig;
import automationconfig.IAutomationConfig;
import automationdriver.AutomationDriver;
import automationdriver.IAutomationDriver;

public abstract class UiTest
{
	protected IAutomationDriver Driver;
	protected static IAutomationConfig Config;
	
	@BeforeAll
	public void OneTimeSetup()
	{
		Config = AutomationConfig.deserealize("AutomationSettings.json");
	}
	
	@BeforeEach
	public void SetUp()
	{
		Driver = new AutomationDriver(Config);
	}
	
	@AfterEach
	public void TearDown()
	{
		Driver.quit();
	}
}
