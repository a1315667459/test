package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public WebDriver driver;
	//写信
	@FindBy(id="_mail_component_59_59")
	public WebElement writeMailLink;
	//邮件发送按钮
	@FindBy(xpath="//*[contains(@id,'_mail_button_')]/span[contains(.,'发送')]")
	public WebElement sendMailButton;
	//收件人输入框
	@FindBy(xpath="//*[contains(@id,'_mail_emailtips')]")
	public WebElement receiver;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//写信的封装方法
	public SendSuccessPage writeMail(){
		WebDriverWait wait  = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_mail_component_59_59")));
		//单击登录成功后页面上的"写信"链接
		writeMailLink.click();
		//进入写信页面,等待页面中收件人输入框加载出来
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'_mail_emailinput_')]/input")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'_mail_emailtips')]")));
		
		//收件人输入框获取焦点
		receiver.click();
		//调用粘贴函数在收件人输入框中粘贴
		setAndCtrlVClipboardData("1315667459@qq.com");
		//按tab键，焦点在邮件正文
		pressTabKey();
		//输入邮件主题
		setAndCtrlVClipboardData("邮件主题");
		pressTabKey();
		//输入邮件正文
		setAndCtrlVClipboardData("邮件正文");
		//点击发送邮件按钮
		sendMailButton.click();
		return new SendSuccessPage(driver);
	}
	
	//设定剪切板病进行字符串粘贴的封装方法
	public static void setAndCtrlVClipboardData(String string) {
		//模拟Ctrl+V进行粘贴操作
		StringSelection selection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//按tab键的封装方法
	public static void pressTabKey() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}
}
