package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.server.Authentication.SendSuccess;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage4;
import pageobjects.SendSuccessPage;

public class Test126mail4 {

	public WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\AppData\\Local\\Google\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	//测试用例登录失败的测试用例
	@Test
	public void testLoginFail() throws InterruptedException {
		//生成一个LoginPage对象
		LoginPage4 loginPage = new LoginPage4(driver);
		//继承LoadableCompinent类后，只要实现覆盖的load方法
		//及时在没有定义get方法的情况下，也可以进行get方法的调用
		//get方法会默认调用页面对象类中的load方法
		//loginPage.get();
		//调用LoginPage类中的登录失败方法
		loginPage.LoginExceptingFailure();
		//断言登录失败后的源代码中是否包含了'账号或密码错误'的关键字，调用LoginPage类中的getPageSource方法
		//(注意：如果内容是在frame里，得切换到frame，才能通过PageSource获取到)
		Assert.assertTrue(loginPage.getPageSource().contains("帐号或密码错误"));
		//调用LoginPage对象中的close方法关闭浏览器
		
	}
	
	//测试登录成功的测试用例
	@Test
	public void testLoginSuccess() throws InterruptedException {
		LoginPage4 loginPage = new LoginPage4(driver);
		//loginPage.get(); //loginPage.login()方法中已经访问了126网页，这边无需再重新访问
		//调用LoginPage类中的login方法，登录成功后会跳转到邮箱登录后主页
		//login函数会返回一个HomePage对象，以此来实现页面跳转到登录后主页
		//以便实现在HomePage对象中进行相关的方法调用
		HomePage homePage = loginPage.login();
		//等待5秒，等待从登录页面跳转到邮箱登录后主页
		
		Thread.sleep(5000);
		
		//断言登录成功后的源代码是否包含了“收件箱”的关键字，来验证是否登录成功
		Assert.assertTrue(homePage.getPageSource().contains("收件箱"));
		
		loginPage.close();
	}
	
	//测试发送邮件成功的测试用例
	@Test
	public void testwriteMail() throws InterruptedException {
		LoginPage4 loginPage = new LoginPage4(driver);
		HomePage homePage = loginPage.login();
		//等待5秒，等待邮件发送完成
		Thread.sleep(5000);
		//调用写邮件方法，完成在页面上的发送邮件操作
		SendSuccessPage successPage = homePage.writeMail();
		
		//等到五秒，等待邮件发送成功
		Thread.sleep(5000);
		//断言邮件发送后，是否出二线"发送成功"4个字，以此验证邮件是否发送成功
		Assert.assertTrue(successPage.getPageSource().contains("发送成功"));
		
		successPage.close();
		
	}
}
