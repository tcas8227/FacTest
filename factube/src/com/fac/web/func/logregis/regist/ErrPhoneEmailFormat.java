package com.fac.web.func.logregis.regist;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//错误格式的手机号/邮箱，注册
public class ErrPhoneEmailFormat {
	
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
		driver.findElement(By.xpath(".//*[@id='formInlineName']")).sendKeys("2333333");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[4]/button")).click();
		String errormessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		
		assertEquals(errormessage, "手机/邮箱格式错误");
		
		}
	
	@Test
	public void TestEmail()throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.linkText("注册")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='formInlineName']")).sendKeys("m15548485220@.com");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[4]/button")).click();
		String errormessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		
		assertEquals(errormessage, "手机/邮箱格式错误");
		
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
