package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.Dataproviderfactory;

import pages.Social_Login;

public class Verify_Social_Login
{
	WebDriver driver;
	Social_Login loginpage;
	
	@BeforeTest(description="This test case will verify Login Page")
	public void SetUp()
	{
		driver= BrowserFactory.getBrowser("Chrome");
		
		driver.manage().window().maximize();
		
		driver.get(Dataproviderfactory.getConfig().getUrl());
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		loginpage=PageFactory.initElements(driver,Social_Login.class);
		
		//for verify dashboard page to create object
	//dashpage2= new VerifyDashboardpage(driver);
		
	}
	
	@Test(priority=1)
	public void Closesubpopup()
	{
		loginpage.closeaddpoup();		
	}
	
	
	@Test(priority=2)
	public void loginlink()
	{
		loginpage.loginLink();		
	}
	
	/*@Test(priority=4)
	public void logoutlink()
	{
		loginpage.logoutLink();		
	}*/
	
	@Test(priority=3)
	public void FBlogin()
	{
		loginpage.FBlogin();
	}
/*	
	@Test(priority=5)
	public void Gmlogin()
	{
		loginpage.loginLink();		
		loginpage.Gmaillogin();	
		loginpage.logoutLink();
	}
	
	@Test(priority=6)
	public void Amazonlogin()
	{
		loginpage.loginLink();		
		loginpage.Amazonsociallogin();
		loginpage.logoutLink();
	}
	
	@Test(priority=7)
	public void Paypallogin()
	{
		loginpage.loginLink();		
		loginpage.Paypalsociallogin();
	}
	*/
	
	@Test(priority=4)
	public void Managereward_Tabs()
	{
		loginpage.Dashboard_Managerewardtab();
	}

	@Test(priority=5)
	public void Earnpoint_Tabs()
	{
		loginpage.Dashboard_Earntab();
	}

	@Test(priority=6)
	public void Activity_Tabs()
	{
		loginpage.Dashboard_Activitytab();
	}

}
