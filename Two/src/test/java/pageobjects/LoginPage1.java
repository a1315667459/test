package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	//使用FindBy注解，定位到需要操作的页面元素
	@FindBy(name="email")
	public WebElement userName;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(id="dologin")
	public WebElement loginButton;
	public LoginPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
