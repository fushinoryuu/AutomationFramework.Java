package automationpageobjects;

public interface IWebPageFactory<T extends IWebPage>
{
	T Get();

	T Get(long customTimeOut);
}
