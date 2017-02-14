package com.fac.web.func.logregis.login;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//正确手机号/密码，登录
public class RightLogin {
	
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationException=new StringBuffer();
	
	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl="http://www.factube.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	} 
	
	//手机号
	@Test
	public void testPhone()throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.id("username")).sendKeys("15548485220");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("111111");
		driver.findElement(By.xpath("//button[@class='button-long btn btn-default']")).click();
		Thread.sleep(4000);
		String url=driver.getCurrentUrl();
		assertEquals(url, "http://www.factube.com/selectSpace");
		}

	//邮箱
	@Test
	public void testEmail()throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.id("username")).sendKeys("m15548485220@163.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("111111");
		driver.findElement(By.xpath("//button[@class='button-long btn btn-default']")).click();
		Thread.sleep(4000);
		String url=driver.getCurrentUrl();
		assertEquals(url, "http://www.factube.com/selectSpace");
		}
	
	@After
	public void tearDown() throws Exception{
		
		driver.quit();
		String verificationErrorString=verificationException.toString();
		if(!"".equals(verificationErrorString)){
			
			fail(verificationErrorString);
			
		}
	}

}
