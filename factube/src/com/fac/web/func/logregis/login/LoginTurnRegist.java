package com.fac.web.func.logregis.login;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//跳转注册页面
public class LoginTurnRegist {
	
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
	
	@Test
	public void Test()throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.xpath("//button[@class='regi btn btn-link']")).click();
		Thread.sleep(4000);
		String title=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[1]/h4")).getText();
		System.out.println(title);
		assertEquals(title, "注册");
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
