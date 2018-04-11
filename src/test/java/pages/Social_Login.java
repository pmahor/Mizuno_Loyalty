package pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.Dataproviderfactory;
import utility.Library;

public class Social_Login
{
	WebDriver driver;
	// home page login link
    @FindBy(xpath="/html/body/header/nav/div[5]/div/div/div/div/div[3]/div/div[4]/div/span/span/span[1]") WebElement loginlink;
  
    @FindBy(xpath="//*[@id='popup-subcription-closes-link-267d0318-85e8-4f4d-a860-a9b1a479e2b8']") WebElement emailsubpoupclsbtn;
    
	//FB Login
	@FindBy(xpath="//*[@id='fb-login-button']") WebElement fbbutton;
	@FindBy(xpath="//input[@id='email']") WebElement fbemailaddr;
	@FindBy(xpath="//input[@id='pass']") WebElement fbpasswd;
	@FindBy(xpath="//input[@id='u_0_0']") WebElement fbloginbtn;
	
	// Logout Link
	@FindBy(xpath="/html/body/header/nav/div[5]/div/div/div/div/div[3]/div/div[4]/div/span/span[2]/a") WebElement logoutlink;
	
	public Social_Login(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void closeaddpoup()
	{
		try 
		{
			Thread.sleep(15000);
			emailsubpoupclsbtn.click();			
			
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
	
		
	}
	
	public void loginLink()
	{
		try 
		{
				
			Thread.sleep(5000);
			loginlink.click();
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
	
		
	}
	
	public void logoutLink()
	{
		try 
		{
						
			Thread.sleep(5000);
			logoutlink.click();
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
	
		
	}
	
	
	
	public void FBlogin()
	{
		
		try 
		{
			
			Thread.sleep(5000);
			
			fbbutton.click();
			
			
			String parentwindow=driver.getWindowHandle();
			Set<String> winHandles=driver.getWindowHandles();
			for(String winHandl : winHandles)
			{
				
				driver.switchTo().window(winHandl);
			}
			
			Thread.sleep(5000);
			fbemailaddr.sendKeys(Dataproviderfactory.getExceldata().getStringData(0, 0));
			fbpasswd.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,1));
			fbloginbtn.click();
			
			System.out.println("Loggedin through Facebook is successfully............");	
			Thread.sleep(8000);
			
		//	System.out.println(driver.getTitle());
			
			driver.switchTo().window(parentwindow);
			
			
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	
	@FindBy(xpath="//*[@id='sa_s13_google_image']/a/img") WebElement emailbtn; 
	@FindBy(xpath=".//*[@id='identifierId']") WebElement gmEmail; 
	@FindBy(xpath=".//*[@id='identifierNext']/content/span") WebElement gmnextbtn;
	
	@FindBy(xpath=".//*[@id='password']/div[1]/div/div[1]/input") WebElement passwd;
	@FindBy(xpath=".//*[@id='passwordNext']/content/span") WebElement gmnectbtn2;
	
	public void Gmaillogin()
	{
		
		try 
		{
			
			Thread.sleep(5000);
			
			emailbtn.click();
			
			Thread.sleep(5000);
			
			String parentwindow=driver.getWindowHandle();
			Set<String> winHandles=driver.getWindowHandles();
			for(String winHandl : winHandles)
			{
				
				driver.switchTo().window(winHandl);
			}
			
			Thread.sleep(5000);
			gmEmail.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,0));
			gmnextbtn.click();
			Thread.sleep(10000);
			
			passwd.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,3));
			gmnectbtn2.click();
			Thread.sleep(5000);
			
			System.out.println("Loggedin through Facebook is successfully............");	
			Thread.sleep(8000);
			
		//	System.out.println(driver.getTitle());
			
			driver.switchTo().window(parentwindow);
			
			
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	//Amazon Service
	@FindBy(xpath="//*[@id='a_small_image']") WebElement amazonbtn;
	@FindBy(xpath="//input[@id='ap_email']") WebElement amazEmailaddr;
	@FindBy(xpath="//input[@id='ap_password']") WebElement amazpasswd;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement amazsubmitbtn;
	
	public void Amazonsociallogin()
	{
		try 
		{
			/*Thread.sleep(10000);
			closebtn.click();*/
			Thread.sleep(5000);
			driver.switchTo().frame("sa_am_smalliframe");
			Thread.sleep(5000);
			amazonbtn.click();
			
			String parentwindow=driver.getWindowHandle();
			Set<String> winHandles=driver.getWindowHandles();
			for(String winHandl : winHandles)
			{
				
				driver.switchTo().window(winHandl);
			}
			Thread.sleep(5000);
			
			driver.manage().window().maximize();
			Thread.sleep(5000);
			amazEmailaddr.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,0));
			amazpasswd.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,2));
			Thread.sleep(5000);
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", amazsubmitbtn);
			
			System.out.println("Amazon Loggedin successfully");
			driver.switchTo().window(parentwindow);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	//PAypal
	@FindBy(xpath="//*[@id='show_provider']/span[4]/a/img") WebElement paypalbtn;
	@FindBy(xpath="//input[@id='email']") WebElement paypalmailaddr;
	@FindBy(xpath="//button[@id='btnNext']") WebElement paypalnextbtn1;
	@FindBy(xpath="//input[@id='password']") WebElement paypalpasswd;
	@FindBy(xpath="//button[@id='btnLogin']") WebElement Paypalloginbtn;
	
	public void Paypalsociallogin()
	{
		try 
		{
			
			Thread.sleep(5000);
			paypalbtn.click();
			
			String parentwindow=driver.getWindowHandle();
			Set<String> winHandles=driver.getWindowHandles();
			for(String winHandl : winHandles)
			{
				
				driver.switchTo().window(winHandl);
			}
			Thread.sleep(5000);
			
			Thread.sleep(5000);
			paypalmailaddr.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,0));
			
			Thread.sleep(5000);
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", paypalnextbtn1);
			
			paypalpasswd.sendKeys(Dataproviderfactory.getExceldata().getStringData(0, 4));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click()", Paypalloginbtn);
			
			System.out.println("Paypal Loggedin successfully");
			driver.switchTo().window(parentwindow);
			

			Thread.sleep(10000);
			
			
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	@FindBy(xpath="/html/body/header/nav/div[5]/div/div/div/div/div[3]/div/div[4]/div/span/span[1]/a") WebElement Myaccountlink;
	@FindBy(xpath="/html/body/header/nav/div[5]/div/div/div/div/div[3]/div/div[4]/div/span/span[1]/ul/li[6]/a") WebElement dashboardlink;
	@FindBy(xpath="/html/body/main/div/div/div/div[1]/div[2]") WebElement dashboardtitle;
	//s15-dashboard-iframe
	@FindBy(xpath="//*[@id='earn']/a") WebElement EarnTab;
	@FindBy(xpath="//*[@id='activestyle']/a") WebElement ActivityTab;
	@FindBy(xpath="//*[@id='m_rewardstyle']/a") WebElement ManagerewardTab;
	
	public void Dashboard_Managerewardtab()
	{
		try 
		{			
			Thread.sleep(5000);
			Myaccountlink.click();
			Thread.sleep(5000);
			dashboardlink.click();
			Thread.sleep(5000);
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",dashboardtitle);
			Thread.sleep(5000);
			Library.takescreensnap(driver, "ManageReward_Tab");
			
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	public void Dashboard_Earntab()
	{
		try 
		{			
			Thread.sleep(5000);
			
			driver.switchTo().frame("s15-dashboard-iframe");
			
			Thread.sleep(5000);
			EarnTab.click();
			Thread.sleep(5000);
			Library.takescreensnap(driver, "Earn_Tab");
	
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}	
	
	public void Dashboard_Activitytab()
	{
		try 
		{			
			
			Thread.sleep(5000);
			ActivityTab.click();
			Thread.sleep(5000);
			Library.takescreensnap(driver, "Activity_Tab");
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}	
	
	

}
