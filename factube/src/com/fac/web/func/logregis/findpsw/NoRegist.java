package com.fac.web.func.logregis.findpsw;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//输入未注册的手机号和邮箱
public class NoRegist {
	
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
	public void TestPhone()throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-link']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='formInlineName']")).sendKeys("15924466305");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[2]/span/span/button")).click();
		String errormessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		
		assertEquals(errormessage, "账号不存在");
		
		}
	
	@Test
	public void TestEmail()throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-link']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='formInlineName']")).sendKeys("1614363474@qq.com");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[2]/span/span/button")).click();
		String errormessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		
		assertEquals(errormessage, "账号不存在");
		
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
