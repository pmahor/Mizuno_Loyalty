package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Dataproviderfactory;

public class Sharing_Actions 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='s4-widget-div-inner-up']/p/img") WebElement widget;
	
	
	@FindBy(xpath="//*[@id='popup-subcription-closes-link-267d0318-85e8-4f4d-a860-a9b1a479e2b8']") WebElement emailsubpoupclsbtn;
	//Facebook Sharing
	@FindBy(xpath="//*[@id='sa-s4-facebook']/a") WebElement fbbtn;
	@FindBy(xpath="//*[@id='sa-s4-facebook']/a") WebElement fbtn;
	
	
	
	
	public Sharing_Actions(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void closeaddpopup()
	{
		try
		{
				Thread.sleep(10000);
				emailsubpoupclsbtn.click();			
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void widgetclick()
	{
		try
		{						
			Thread.sleep(10000);
			widget.click();
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@FindBy(xpath="//input[@id='email']") WebElement fbemailaddr;
	@FindBy(xpath="//input[@id='pass']") WebElement fbpasswd;
	@FindBy(xpath="//input[@id='u_0_0']") WebElement fbloginbtn;
	@FindBy(xpath="//iframe[@id='s4-main-iframe']") WebElement iframe1;
	@FindBy(xpath="//iframe[@class='FB_UI_Dialog']") WebElement iframe2;
	
	@FindBy(xpath="//*[@id='submit-reward-email']") WebElement sharetbtn;
	@FindBy(xpath="//*[@id='sa_s4_popup_close']") WebElement contsharetbtn;
	
		
	public void fbsharing()
	{
		try
		{
			Thread.sleep(5000);
			driver.switchTo().frame("s4-main-iframe");
			Thread.sleep(5000);
			
			fbbtn.click();
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
			Thread.sleep(10000);
			
			driver.switchTo().window(parentwindow);
			System.out.println("After switching : "+driver.getTitle());
			
			Thread.sleep(10000);
			driver.switchTo().frame(iframe1);
		
			WebDriverWait wait = new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("s2-main-iframe"));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".FB_UI_Dialog")));
			
			Thread.sleep(5000);
			((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.name("__CONFIRM__")));
			
			Thread.sleep(5000);
			driver.switchTo().frame(iframe1);
			sharetbtn.click();
			
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			contsharetbtn.click();
			System.out.println("Facebook Sharing successfully Completed");
			
			
			
			
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@FindBy(xpath="//*[@id='sa-s4-twitter']/a") WebElement twbtn;
	@FindBy(xpath="//input[@id='username_or_email']") WebElement tweetEmail;
	@FindBy(xpath="//input[@id='password']") WebElement tweetpass;
	@FindBy(xpath="//input[@id='allow']") WebElement tweetloginbtn;
	
	//intermediate popup
	@FindBy(xpath="//*[@id='sa_s4_first_name_share']") WebElement firstN_t;
	@FindBy(xpath="//*[@id='sa_s4_last_name_share']") WebElement lastN_t;
	@FindBy(xpath="//*[@id='sa_s4_your_email_share']") WebElement Email_t;
	@FindBy(xpath="//*[@id='tw-form']/form/div/div[5]/button") WebElement sharebtn_t;
	
	
	//*[@id="sa_s4_popup_close"]
	
	
	public void Twittersharing()
	{
		try 
		{
			
			Thread.sleep(5000);
			driver.switchTo().frame("s4-main-iframe");
			Thread.sleep(5000);
			
			twbtn.click();
			
			String parentwindow=driver.getWindowHandle();
			Set<String> winHandles=driver.getWindowHandles();
			for(String winHandl : winHandles)
			{
				
				driver.switchTo().window(winHandl);
			}
			
			Thread.sleep(5000);
			
			tweetEmail.sendKeys(Dataproviderfactory.getExceldata().getStringData(0, 0));
			tweetpass.sendKeys(Dataproviderfactory.getExceldata().getStringData(0, 2));
			Thread.sleep(5000);
			tweetloginbtn.click();
			
			driver.switchTo().window(parentwindow);
			Thread.sleep(5000);
			driver.switchTo().frame(iframe1);
			firstN_t.sendKeys("John");
			lastN_t.sendKeys("Grey");
			Email_t.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,0));
			Thread.sleep(5000);
			sharebtn_t.click();
			
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			contsharetbtn.click();
			System.out.println("Twitter Sharing successfully Completed");
			
		} 
		catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}	
	}
	
	// Email Sharing
	@FindBy(xpath="//*[@id='sa-s4-email']/a") WebElement Emailbtn;
	@FindBy(xpath="//*[@id='sa_s4_first_name_share']") WebElement firstN_E;
	@FindBy(xpath="//*[@id='sa_s4_last_name_share']") WebElement lastN_E;
	@FindBy(xpath="//*[@id='sa_s4_your_email_share']") WebElement yourEmail;
	@FindBy(xpath="//*[@id='email_to_share']") WebElement FrndsEmail;
	@FindBy(xpath="//*[@id='em-form']/form/div/div[6]/button") WebElement sharebtn_E;
	
	public void Emailsharing()
	{
		try 
		{
			Thread.sleep(5000);
			driver.switchTo().frame("s4-main-iframe");
			Thread.sleep(5000);
			Emailbtn.click();
			Thread.sleep(5000);
			
			firstN_E.sendKeys("John");
			lastN_E.sendKeys("Grey");
			yourEmail.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,0));
			FrndsEmail.sendKeys(Dataproviderfactory.getExceldata().getStringData(1,0));
			Thread.sleep(5000);
			sharebtn_E.click();
			
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			contsharetbtn.click();
			System.out.println("Email Sharing successfully Completed");
			
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
