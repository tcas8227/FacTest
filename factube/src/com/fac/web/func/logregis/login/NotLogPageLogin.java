package com.fac.web.func.logregis.login;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//非登录页面，正确登录
public class NotLogPageLogin {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationException = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "http://www.factube.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// 手机号
	@Test
	public void testPhone() throws Exception {
		driver.get(baseUrl);
		String sreach = driver.getWindowHandle();

		Thread.sleep(5000);

		// 进入第一个热门库内
		driver.findElement(By.xpath(".//*[@id='index-hotbase']/div/div[2]/div/div[2]/div[1]/span[1]")).click();
		Set<String> handles = driver.getWindowHandles();
		Thread.sleep(5000);

		for (String handle : handles) {
			if (handle.equals(sreach) == false) {

				driver.switchTo().window(handle);
				Thread.sleep(5000);
				// 得到登录前的库名
				String title1 = driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div[3]/span[1]")).getText();
				System.out.println(title1);

				// 执行登录操作
				driver.findElement(By.linkText("登录")).click();
				driver.findElement(By.id("username")).sendKeys("15548485220");
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys("111111");
				driver.findElement(By.xpath("//button[@class='button-long btn btn-default']")).click();

				Thread.sleep(8000);

				// 得到登录后的库名
				String title2 = driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div[3]/span[1]")).getText();
				System.out.println(title2);

				// 判断登录前后标题名是否一样，一样则成功
				assertEquals(title1, title2);
			}
		}
	}

	// 邮箱
	@Test
	public void testEmail() throws Exception {
		driver.get(baseUrl);
		String sreach = driver.getWindowHandle();

		Thread.sleep(5000);

		// 进入第一个热门库内
		driver.findElement(By.xpath(".//*[@id='index-hotbase']/div/div[2]/div/div[2]/div[1]/span[1]")).click();
		Set<String> handles = driver.getWindowHandles();
		Thread.sleep(5000);

		for (String handle : handles) {
			if (handle.equals(sreach) == false) {

				driver.switchTo().window(handle);

				Thread.sleep(5000);

				// 获取登录前的库名
				String title1 = driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div[3]/span[1]")).getText();
				System.out.println(title1);

				// 登录操作
				driver.findElement(By.linkText("登录")).click();
				driver.findElement(By.id("username")).sendKeys("m15548485220@163.com");
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys("111111");
				driver.findElement(By.xpath("//button[@class='button-long btn btn-default']")).click();

				Thread.sleep(5000);

				// 获取登录后的库名
				String title2 = driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div[3]/span[1]")).getText();
				System.out.println(title2);

				// 判断登录前后标题名是否一样，一样则成功
				assertEquals(title1, title2);

			}
		}
	}

	@After
	public void tearDown() throws Exception {

		driver.quit();
		String verificationErrorString = verificationException.toString();
		if (!"".equals(verificationErrorString)) {

			fail(verificationErrorString);

		}
	}

}
