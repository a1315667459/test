package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SendSuccessPage {
	public WebDriver driver;

	public SendSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageSource() {
		return driver.getPageSource();
	}
	
	public void close() {
		this.driver.close();
	}

}
