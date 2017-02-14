package com.fac.web.func.logregis.login;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//输入错误密码，登录
public class LoginErrorPassword {
	
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
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("111111111");
		driver.findElement(By.xpath("//button[@class='button-long btn btn-default']")).click();
		String errorMessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		assertEquals(errorMessage, "您输入的帐号或密码有误,请重新输入");
		}

	//邮箱
	@Test
	public void testEmail()throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.id("username")).sendKeys("m15548485220@163.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("111111111");
		driver.findElement(By.xpath("//button[@class='button-long btn btn-default']")).click();
		String errorMessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		assertEquals(errorMessage, "您输入的帐号或密码有误,请重新输入");
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
