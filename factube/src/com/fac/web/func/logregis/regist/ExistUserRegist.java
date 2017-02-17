package com.fac.web.func.logregis.regist;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//已经存在的手机号/邮箱，注册
public class ExistUserRegist {
	
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
		driver.findElement(By.linkText("注册")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='formInlineName']")).sendKeys("15548485220");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[2]/input")).sendKeys("111111");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[3]/input")).sendKeys("111111");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[4]/button")).click();
		String errormessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		
		assertEquals(errormessage, "账号已存在");
		
		}
	
	@Test
	public void TestEmail()throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.linkText("注册")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='formInlineName']")).sendKeys("m15548485220@163.com");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[2]/input")).sendKeys("111111");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[3]/input")).sendKeys("111111");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[4]/button")).click();
		String errormessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		
		assertEquals(errormessage, "账号已存在");
		
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