package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage2;

public class Test126mail2 {

	@Test
	public void testLogin() throws InterruptedException {
		String title = "add new file";
		//生成一个LoginPage对象实例
		LoginPage2 loginpage = new LoginPage2();
		//调用登录页面对象的load方法，访问被测网页
		loginpage.load();
		//调用登录页面对象的login方法，完成登录操作
		loginpage.login();
		//断言登录后的页面是否包含"收件箱"，来验证是否登录成功
		//调用登录页面对象的getDriver方法获取浏览器对象，并获取页面源码
		Assert.assertTrue(loginpage.getDirver().getPageSource().contains("收件箱"));
		//调用登录页面对象的quit方法关闭浏览器
		loginpage.quit();
	}
}
