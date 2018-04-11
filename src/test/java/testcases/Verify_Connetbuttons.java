package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.Dataproviderfactory;
import pages.ConnectButtons;
import pages.Social_Login;

public class Verify_Connetbuttons 
{

	WebDriver driver;
	Social_Login loginpage;
	ConnectButtons connectobj;
	
	
	@BeforeTest(description="This test case will verify Login Page")
	public void SetUp()
	{
		driver= BrowserFactory.getBrowser("Chrome");
		
		driver.manage().window().maximize();
		
		driver.get(Dataproviderfactory.getConfig().getUrl());
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		loginpage=PageFactory.initElements(driver,Social_Login.class);
		connectobj=PageFactory.initElements(driver,ConnectButtons.class);
				
	}
	
	@Test(priority=1)
	public void facebookconnect()
	{
		connectobj.fbconnect();
	}
	
	@Test(priority=2)
	public void Twittterconnect()
	{
		connectobj.Twitterconnect();
	}
	
	@Test(priority=3)
	public void Instagramconnect()
	{
		connectobj.instconnectaction();
	}
	
	
}
