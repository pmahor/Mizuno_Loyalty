package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.Dataproviderfactory;
import pages.Sharing_Actions;

public class VerifySharing_Actions
{
	WebDriver driver;
	Sharing_Actions sharingpageobj;
	
		
	@BeforeTest(description="This test case will verify Login Page")
	public void SetUp()
	{
		driver= BrowserFactory.getBrowser("Chrome");
		
		driver.manage().window().maximize();
		
		driver.get(Dataproviderfactory.getConfig().getUrl());
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		sharingpageobj=PageFactory.initElements(driver,Sharing_Actions.class);
		
		sharingpageobj.closeaddpopup();
		
		//for verify dashboard page to create object   
		//dashpage2= new VerifyDashboardpage(driver);
		
	}

	@Test(priority=1)
	public void widgetclick()
	{
		sharingpageobj.widgetclick();
	}
	
	@Test(priority=2)
	public void facebooksharing()
	{
		sharingpageobj.fbsharing();
	}
	
	@Test(priority=3)
	public void Twittersharing()
	{
		sharingpageobj.widgetclick();
		sharingpageobj.Twittersharing();
	}
	
	@Test(priority=4)
	public void Emailsharing()
	{
		sharingpageobj.widgetclick(); 
		sharingpageobj.Emailsharing();
	}
	

}
