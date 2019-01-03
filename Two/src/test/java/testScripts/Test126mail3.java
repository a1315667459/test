package testScripts;


import org.testng.annotations.Test;
import pageobjects.LoginPage3;

public class Test126mail3 {

	@Test
	public void testLogin() throws InterruptedException {
		//生成一个LoginPage对象实例
		LoginPage3 loginpage = new LoginPage3();
		loginpage.load();
		//调用登录页面对象的login方法，完成登录操作
		loginpage.login();
		//断言登录是否成功
		loginpage.isLoaded();
		//调用登录页面对象的quit方法关闭浏览器
		loginpage.quit();
	}
}
