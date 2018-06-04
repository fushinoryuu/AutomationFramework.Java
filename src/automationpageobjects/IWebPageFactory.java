package automationpageobjects;

public interface IWebPageFactory
{
	<T extends IWebPage> T Get(Class<T> pageClass);

	<T extends IWebPage> T Get(Class<T> pageClass, long customWaitInSeconds);
}
