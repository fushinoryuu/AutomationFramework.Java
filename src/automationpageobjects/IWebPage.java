package automationpageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationdriver.IAutomationDriver;

public interface IWebPage
{
	IAutomationDriver GetDriver();
	void SetDriver(IAutomationDriver driver);
	WebDriverWait GetWait();
	void SetWait(WebDriverWait wait);
	void WaitForPageToLoad();
    WebElement FindElementBy(By by);
    List<WebElement> FindElementsBy(By by);
}
