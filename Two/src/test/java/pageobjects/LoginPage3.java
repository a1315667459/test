package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class LoginPage3 extends LoadableComponent<LoginPage3>{

	@FindBy(name="email")
	public WebElement UserName;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(id="dologin")
	public WebElement loginButton;
	public String url ="https://www.126.com/";
	private String title="网易邮箱";
	public WebDriver driver;
	//构造函数，生成浏览器对象，初始化PageFactory对象
	public LoginPage3() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\AppData\\Local\\Google\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}
	
	//访问被测试网址的封装方法
	@Override
	public void load() {
		this.driver.get(url);
		this.driver.manage().window().maximize();
	}
	
	//关闭浏览器的封装方法
	public void quit() {
		driver.quit();
	}
	
	//登录操作的封装方法
	public void login() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		UserName.sendKeys("wuyn1315667459");
		password.sendKeys("goodwu");
		loginButton.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@Override
	public void isLoaded() throws Error {
		//断言登录后的页面title是否包含"网易邮箱"这几个关键字
		Assert.assertTrue(driver.getTitle().contains(title));
	}
	
	//增加了需要覆盖的方法load
	//访问被测试网址的封装方法
	
}
