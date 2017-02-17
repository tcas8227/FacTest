package com.fac.web.func.logregis.regist;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//密码小于6位，注册
public class PswShort {
	
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
		driver.findElement(By.linkText("注册")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[2]/input")).sendKeys("11111");
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[3]/input")).click();
		String errormessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		Thread.sleep(4000);
		assertEquals(errormessage, "密码长度小于6位,请重新输入");
		
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