package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage1;

public class Test126mail1 {

	
	private WebDriver driver;
	private String baseUrl = "https://www.126.com/";
	@Test
	public void testLogin() throws InterruptedException {
		String test="修改文件标记";
		String test1="测试第二�
		//访问被测试的网址
		driver.get(baseUrl);
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		//生成一个LoginPage的实�
		LoginPage1 loginPage = new LoginPage1(driver);
		//直接使用页面对象的用户元素，输入用户�
		loginPage.userName.sendKeys("wuyn1315667459");
		//直接使用页面对象的用户元素，输入密码
		loginPage.password.sendKeys("goodwu");
		//直接使用页面对象的登录按钮对象，进行单击操作
		loginPage.loginButton.click();
		//等待5�
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		//断言登录后的页面是否包含"收件�关键字，来验证是否登录成�
		Assert.assertTrue(driver.getPageSource().contains("收件�));
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\AppData\\Local\\Google\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void afterMethod() {
		/*driver.quit();*/
	}
}
