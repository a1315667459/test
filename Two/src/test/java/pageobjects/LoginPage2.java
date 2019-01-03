package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	@FindBy(name="email")
	public WebElement userName;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(id="dologin")
	public WebElement loginButton;
	public String url="https://www.126.com/";
	public WebDriver driver;
	//构造函数，生成浏览器对象，初始化PageFactory对象
	public LoginPage2() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\AppData\\Local\\Google\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}
	
	//访问被测试网址的封装方法
	public void load() {
		driver.get(url);
	}
	
	//关闭浏览器的封装方法
	public void quit() {
		driver.quit();
	}
	
	//登录操作的封装方法
	public void login() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		userName.sendKeys("wuyn1315667459");
		password.sendKeys("goodwu");
		loginButton.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	
	public WebDriver getDirver() {
		return driver;
	}


}
