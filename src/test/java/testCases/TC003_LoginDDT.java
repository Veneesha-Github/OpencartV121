package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verifyLoginDDT(String email,String password,String exp)
	{
		logger.info("***** Started Test Case Execution *****");
		try
		{
			
		logger.info("Navigated to Home Page...");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickOnLogin();
		logger.info("Navigated to LoginPage...");
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLogin();
		logger.info("Navigated to MyAccount Page...");
		MyAccountPage accpg=new MyAccountPage(driver);
		boolean target=accpg.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(target==true)
			{
				accpg.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(target==true)
			{
				accpg.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
		}
		catch(Exception e)
		{
			Assert.fail("An Exception occured:" +e.getMessage());
		}
		
		finally
		{
			logger.info("***** Execution completed *****");
		}
				
	}

}
