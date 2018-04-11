package pages;

import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.Dataproviderfactory;
import utility.Library;



public class ConnectButtons 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='sa_s12_loaded_widget']") WebElement fbconnectbtn;
	@FindBy(xpath="/html/body/header/nav/div[5]/div/div/div/div/div[3]/div/div[3]/div/span/a") WebElement Rewardpagelink;
	
	//fb connect
	@FindBy(xpath="//*[@id='sa_s12_fblogin_button']") WebElement connectbtn_F;
	
	//fblogin window
	@FindBy(xpath="//input[@id='email']") WebElement fbemailaddr;
	@FindBy(xpath="//input[@id='pass']") WebElement fbpasswd;
	@FindBy(xpath="//input[@id='u_0_0']") WebElement fbloginbtn;
	
	@FindBy(xpath="//*[@id='sa_s12_fb_confirm_email']") WebElement emailconfirm_F;
	@FindBy(xpath="//*[@id='sa_s12_fb_cont_button']") WebElement continuebtn_F;
	
	@FindBy(xpath="//*[@id='sa_s12_closebtn']/img") WebElement closebtn_F;
	
	// Add popup
	@FindBy(xpath="//*[@id='popup-subcription-closes-link-267d0318-85e8-4f4d-a860-a9b1a479e2b8']") WebElement emailsubpoupclsbtn;
	
	
	public ConnectButtons(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void fbconnect()
	{
		try 
		{
			Thread.sleep(5000);
			emailsubpoupclsbtn.click();
			Thread.sleep(5000);
			
			Rewardpagelink.click();
			Thread.sleep(10000);
			
			//for scrolling page upto connectbtns
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", fbconnectbtn);
			Thread.sleep(5000);
			
			fbconnectbtn.click();
			Thread.sleep(5000);
			connectbtn_F.click();
			Thread.sleep(5000);
			
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
			
			Thread.sleep(5000);
			emailconfirm_F.clear();
			emailconfirm_F.sendKeys("Test@1234.com");
			continuebtn_F.click();
			
			Thread.sleep(5000);
			closebtn_F.click();
			
		}
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath="//*[@id='sa-s15-tf-button']") WebElement twitterbtn;
	@FindBy(xpath="//*[@id='sa_s15_twitter_button']/a") WebElement connectbtn_T;
	
	@FindBy(xpath="//input[@id='username_or_email']") WebElement tweetEmail;
	@FindBy(xpath="//input[@id='password']") WebElement tweetpass;
	@FindBy(xpath="//input[@id='allow']") WebElement tweetloginbtn;
	
	@FindBy(xpath="//*[@id='sa_s15_tw_confirm_email']") WebElement emailconfirm_T;
	@FindBy(xpath="//*[@id='sa_s15_tw_cont_button']") WebElement continuebtn_T;
	
	@FindBy(xpath="//*[@id='sa_s15_close_link']/a") WebElement closebtn_T;
	
	
	
	
	public void Twitterconnect()
	{
		try 
		{
			Thread.sleep(5000);
			
			//needed only if executed script for twitter action only
			/*emailsubpoupclsbtn.click();
			Thread.sleep(5000);
			
			Rewardpagelink.click();
			Thread.sleep(10000);
			
			//for scrolling page upto connectbtns
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", fbconnectbtn);
			Thread.sleep(5000);*/
			
			twitterbtn.click();
			Thread.sleep(5000);
			connectbtn_T.click();
			Thread.sleep(5000);
			
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
			
			emailconfirm_T.clear();
			emailconfirm_T.sendKeys("Test12@1234.com");
			Thread.sleep(5000);
			continuebtn_T.click();
			
			Thread.sleep(10000);
			closebtn_T.click();
			
			
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	@FindBy(xpath="//*[@id='sa_s22_unit_follow_btn']") WebElement instagrambtn;
	@FindBy(xpath="//*[@id='sa_s22_insta_follow_login_btn']") WebElement instagrambtn_I;
	
	@FindBy(xpath="//input[@id='id_username']") WebElement InstEmail;
	@FindBy(xpath="//input[@id='id_password']") WebElement instpass;
	@FindBy(xpath="//input[@class='button-green']") WebElement instloginbtn;
	
	@FindBy(xpath="//*[@id='sa_insta_follow_email']") WebElement emailconfirm_I;
	@FindBy(xpath="//*[@id='sa_insta_follow_submit_btn']") WebElement continuebtn_I;
	
	@FindBy(xpath="//*[@id='sa_s22_instagram_follow_close_btn']") WebElement closebtn_I;
	
	//sa_s22_instagram_follow_iframe
	//*[@id="sa_insta_follow_email"]
	
	
	
	
	public void instconnectaction()
	{
		System.out.println("Started Instagramconnectaction...............");
		try 
		{
			
			Thread.sleep(5000);
			
			//needed only if executed script for instagram action only
			/*emailsubpoupclsbtn.click();
			Thread.sleep(5000);
			
			Rewardpagelink.click();
			Thread.sleep(10000);
			
			//for scrolling page upto connectbtns
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", fbconnectbtn);*/
			Thread.sleep(5000);
			
			
			instagrambtn.click();
			Thread.sleep(5000);
			driver.switchTo().frame("sa_s22_instagram_follow_iframe");
			Thread.sleep(5000);
			instagrambtn_I.click();
			Thread.sleep(5000);
			
			String parentwindow=driver.getWindowHandle();
			Set<String> winHandles=driver.getWindowHandles();
			for(String winHandl : winHandles)
			{
				driver.switchTo().window(winHandl);
			}
			
			Thread.sleep(5000);
			
			InstEmail.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,0));
			instpass.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,3));
			instloginbtn.click();
			
			System.out.println("Instagram loggedin successful..................");
			
			
			driver.switchTo().window(parentwindow);
			Thread.sleep(5000);
			driver.switchTo().frame("sa_s22_instagram_follow_iframe");
			Thread.sleep(5000);
			
			emailconfirm_I.clear();
			emailconfirm_I.sendKeys("Test12@1234.com");
			Thread.sleep(5000);
			continuebtn_I.click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(10000);
			closebtn_I.click();
			
			
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
	

}