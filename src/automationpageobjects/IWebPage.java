package automationpageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationdriver.IAutomationDriver;

public interface IWebPage
{
	// Getters and Setters
	IAutomationDriver GetDriver();

	void SetDriver(IAutomationDriver driver);

	WebDriverWait GetWait();

	void SetWait(WebDriverWait wait);

	IWebPageFactory GetFactory();

	void SetFactory(IWebPageFactory factory);

	// Methods
	void WaitForPageToLoad() throws IndexOutOfBoundsException;

	WebElement FindElementBy(By by);

	List<WebElement> FindElementsBy(By by);

	boolean CheckPageForText(String text);

	void InitializePageSections();
}
