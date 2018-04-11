package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import pages.BitlyExecution;

public class Verify_BitlyExecution 
{

	
		WebDriver driver;
		BitlyExecution bitlyexec;

		@BeforeMethod
		public void setup()
		{
			driver=BrowserFactory.getBrowser("Chrome");
			driver.manage().window().maximize();
			
			bitlyexec=PageFactory.initElements(driver, BitlyExecution.class);
		}
		
		
		@Test(priority=1)
		public void FacebookBitlyExecution()
		{
			bitlyexec.fbbitly();
		}
	
		@Test(priority=2)
		public void TwitterBitlyexecution()
		{
	         	bitlyexec.Twitterbitly();
		}
		
		@Test(priority=3)
		public void emailBitlyexecution()
		{
			bitlyexec.Emailbitly();
		}
		
	
}
