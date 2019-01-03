package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage4 extends LoadableComponent<LoginPage4>{

	@FindBy(name="email")
	public WebElement userName;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(id="dologin")
	public WebElement loginButton;
	public String url ="https://www.126.com/";
	private String title="网易邮箱";
	public WebDriver driver;
	
	//构造函数，生成浏览器对象，初始化PageFactory对象
	public LoginPage4(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//访问被测试网址的封装方法
	@Override
	public void load() {
		this.driver.get(url);
		this.driver.manage().window().maximize();
	}
	
	public void close() {
		this.driver.close();
	}

	//登录操作的封装方法，函数方法返回一个HomePage对象
	public HomePage login() throws InterruptedException {
		//调用load方法，浏览器访问126邮箱页面
		load();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe:first-child")));
		driver.switchTo().frame(0);
		//页面判断是否显示了用户名输入框
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("email")));
		//清除用户名输入框中的字符，保证用户名输入框中为空
		userName.clear();
		//输入邮箱用户名
		userName.sendKeys("wuyn1315667459");
		//输入密码
		password.sendKeys("goodwu");
		//单击登录按钮
		loginButton.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		return new HomePage(driver);
	}
	
	//获取页面源码的封装方法
	public String getPageSource() {
		return driver.getPageSource();
	}
	
	//登录失败的封装方法，函数方法返回一个LoginPage页面对象
	public LoginPage4 LoginExceptingFailure() throws InterruptedException {
		load();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe:first-child")));
		driver.switchTo().frame(0);
		userName.sendKeys("wuyn1315667459");
		password.sendKeys("goodw");
		loginButton.click();
		Thread.sleep(3000);
		//driver.switchTo().defaultContent();
		//登录失败后，页面不会发生跳转，返回一个LoginPage4对象
		return new LoginPage4(driver);
	}
	
	
	@Override
	protected void isLoaded() throws Error {
		// 断言登录后的页面标题是否包含"网易邮箱"这几个字
		Assert.assertTrue(driver.getTitle().contains(title));
		
	}

}
