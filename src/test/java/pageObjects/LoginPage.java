package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
		
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement BtnLogin;
	
	public void enterEmail(String email) {
		
		txtemail.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		BtnLogin.click();
	}
	
	

}
