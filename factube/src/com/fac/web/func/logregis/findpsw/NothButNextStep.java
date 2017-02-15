package com.fac.web.func.logregis.findpsw;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//不输入手机号/邮箱，点击下一步重置密码
public class NothButNextStep {
	
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
		driver.findElement(By.xpath(".//*[@id='formInlineName']")).click();;
		driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/button")).click();
		String errormessage=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/label")).getText();
		
		assertEquals(errormessage, "手机/邮箱不能为空");
		
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

