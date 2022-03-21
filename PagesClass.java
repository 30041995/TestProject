package AutoMateCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagesClass {
	
	@FindBy (linkText="My Account")
	private WebElement myaccount;
	
	@FindBy (xpath="//input[@id='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement button;
	
	
	 PagesClass (WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void login1() {
		
		myaccount.click();
		username.sendKeys("rohitpharande30@gmail.com");
		
		
		password.sendKeys("  "); 
		button.click();
		
	}

}
